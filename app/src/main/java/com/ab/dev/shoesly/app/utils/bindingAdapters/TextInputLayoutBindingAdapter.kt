package com.ab.dev.shoesly.app.utils.bindingAdapters

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


fun TextInputLayout.setResError(resError: Int?) {
    error = if(resError != null)  context.getString(resError)
    else null
}

@BindingAdapter("errorRes")
fun setErrorMessage(view: TextInputLayout, resError: Int?) {
    view.setResError(resError)
}

@BindingAdapter("textError")
fun setTextErrorMessage(view: TextInputLayout, error: String?) {
    view.error = error
}