package com.android.chatapp.Uses

import com.android.chatapp.model.Room

interface OnItemListener {
    fun On_item_click(position: Int, room: Room)
}