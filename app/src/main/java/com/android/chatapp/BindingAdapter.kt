package com.android.chatapp

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:error")
fun setError(TextInput: TextInputLayout, error: String?) {
    TextInput.error = error

}