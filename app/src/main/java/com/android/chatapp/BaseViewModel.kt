package com.android.chatapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<N> : ViewModel() {

    val massegeLiveData = MutableLiveData<String>()
    val show_load_LiveData = MutableLiveData<Boolean>()

    var navigator: N? = null


}