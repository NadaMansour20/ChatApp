package com.android.chatapp.ui.home

import com.android.chatapp.base.BaseViewModel

class HomeViewModel : BaseViewModel<Navigator>() {

    fun addChat() {
        navigator?.add_Chat()
    }
}