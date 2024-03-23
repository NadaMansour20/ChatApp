package com.android.chatapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val massegeLiveData = MutableLiveData<String>()
    val show_load_LiveData = MutableLiveData<Boolean>()


}