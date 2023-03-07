package com.ab.dev.shoesly.data.repository.stock

import com.ab.dev.shoesly.app.mappers.*
import com.ab.dev.shoesly.data.model.entities.color.ColorEntity
import com.ab.dev.shoesly.data.model.entities.color.ColorStockItemEntity
import com.ab.dev.shoesly.data.model.entities.size.SizeEntity
import com.ab.dev.shoesly.data.model.entities.size.SizeStockItemEntity
import com.ab.dev.shoesly.data.model.response.success.StockItemResponse
import com.ab.dev.shoesly.data.source.local.source.stockItems.StockItemsLocalDataSource
import com.ab.dev.shoesly.data.source.remote.dataSource.stock.StockRemoteDataSource
import com.ab.dev.shoesly.domain.models.data.Color
import com.ab.dev.shoesly.domain.models.data.Shoe
import com.ab.dev.shoesly.domain.models.data.Size
import com.ab.dev.shoesly.domain.models.data.StockItem
import com.ab.dev.shoesly.domain.repository.color.ColorRepository
import com.ab.dev.shoesly.domain.repository.shoe.ShoeRepository
import com.ab.dev.shoesly.domain.repository.size.SizeRepository
import com.ab.dev.shoesly.domain.repository.stock.StockRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class StockRepositoryImpl(
    private val stockRemoteDataSource: StockRemoteDataSource,
    private val stockItemsLocalDataSource: StockItemsLocalDataSource,
    private val shoeRepository: ShoeRepository,
    private val colorRepository: ColorRepository,
    private val sizeRepository: SizeRepository
) : StockRepository {

    override suspend fun listStockItemsFromRemoteAndInsertInLocalByBrandId(brandId: Int) {
        // list all stock items from the remote datasource by shoe brand id
        val responseList = stockRemoteDataSource.listShoesByBrandId(brandId)
        // insert the many to many relation db table between the color and stockItem Entities
        responseList.map { item ->
            item.colorsList.forEach { colorResponse ->
                // make a unique id for the record to avoid duplicated records
                val id = "${item.shoe.title}_${colorResponse.color}"
                val colorStockItem = ColorStockItemEntity(id=id, stockItemId=item.id, colorId=colorResponse.id)
                colorRepository.insertColorStockItemEntity(colorStockItem)
            }

            item.sizesList.forEach { sizeResponse ->
                // make a unique id for the record to avoid duplicated records
                val id = "${item.shoe.title}_${sizeResponse.size}"
                val sizeStockItem = SizeStockItemEntity(id=id, stockItemId=item.id, sizeId = sizeResponse.id)
                sizeRepository.insertSizeStockItemEntity(sizeStockItem)
            }
        }
        // get the shoe data mode from the StockItems Response
        val shoeItemsList = responseList.map(StockItemResponse::getShoe)
        // then convert shoe data items to shoe entity records
        val shoeEntityItems = shoeItemsList.map(Shoe::asShoeEntity)
        // insert shoe Entity Items in the DB
        shoeRepository.insertShoes(shoeEntityItems)
        // convert stock items response to stock item entity
        val stockEntityItems = responseList.map(StockItemResponse::asStockItemEntity)
        // then store it in the db
        stockItemsLocalDataSource.insertStockItems(stockEntityItems)
    }

    override suspend fun listStockItemsByBrandIdFlow(brandId: Int): Flow<List<StockItem>> = flow {
        listStockItemsFromRemoteAndInsertInLocalByBrandId(brandId)
        val stockItemsWithShoeAndColorsEntityList = stockItemsLocalDataSource.listStockItemsByBrandId(brandId)
        val stockItems = stockItemsWithShoeAndColorsEntityList.map { item ->
            val shoeWithBrand = shoeRepository.getShoeWithBrandById(item.shoeEntity.id)
            // Colors
            val stockItemColorsEntity: List<ColorEntity> = colorRepository.listColorsEntityListByStockItemId(item.stockItemEntity.id)
            val stockItemColors: List<Color> = stockItemColorsEntity.map(ColorEntity::asColor)
            // Sizes
            val stockItemSizesEntity:  List<SizeEntity> = sizeRepository.listSizesEntityListByStockItemId(item.stockItemEntity.id)
            val stockItemSizes:  List<Size> = stockItemSizesEntity.map(SizeEntity::asSize)
            StockItem(item.stockItemEntity.id, shoeWithBrand.asShoe(), item.stockItemEntity.quantityInStock, stockItemColors, stockItemSizes)
        }
        emit(stockItems)
    }.flowOn(Dispatchers.IO)
}