package com.android.chatapp.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<N> : ViewModel() {

    // live data used to store data that is found in view model
    val massegeLiveData = MutableLiveData<String>()
    val show_load_LiveData = MutableLiveData<Boolean>()


    // to navigate from activity to anther activity
    var navigator: N? = null


}