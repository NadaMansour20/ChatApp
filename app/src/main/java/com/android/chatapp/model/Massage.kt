package com.android.chatapp.model

data class Massage(
    var id: String? = null,
    var content: String? = null,
    var date: Long? = null,
    var sender_name: String? = null,
    var sender_id: String? = null,
    var room_id: String? = null

)