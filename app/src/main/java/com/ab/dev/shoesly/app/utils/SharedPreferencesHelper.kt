package com.ab.dev.shoesly.app.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.ab.dev.shoesly.app.constants.SharedPreferencesConstants

class SharedPreferencesHelper(
    private val context: Context
) {
    private val sharedPreferences: SharedPreferences
        get() = context.getSharedPreferences(SharedPreferencesConstants.APP, Context.MODE_PRIVATE)


    fun addString(key: String, value: String) {
        sharedPreferences.edit {
            putString(key, value)
            apply()
        }
    }

    fun addBoolean(key: String, value: Boolean) {
        sharedPreferences.edit {
            putBoolean(key, value)
            apply()
        }
    }

    fun removeString(key: String) {
        sharedPreferences.edit {
            remove(key)
            apply()
        }
    }

    fun removeAll() {
        sharedPreferences.edit {
            removeAll()
            apply()
        }
    }
    fun getString(key: String) : String? = sharedPreferences.getString(key, null)
    fun getBoolean(key: String) : Boolean = sharedPreferences.getBoolean(key, false)
}