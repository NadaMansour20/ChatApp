package com.android.chatapp.base

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


//I use it when I want to handel specific attribute in xml and the attribute is not found
@BindingAdapter("app:error")
fun setError(TextInput: TextInputLayout, error: String?) {
    TextInput.error = error

}