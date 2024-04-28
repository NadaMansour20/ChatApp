package com.android.chatapp.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Message(
    var id: String? = null,
    var content: String? = null,
    var date: Long? = null,
    var sender_name: String? = null,
    var sender_id: String? = null,
    var room_id: String? = null

) {
    companion object {
        const val CollectionNameMessage = "message"
    }

    fun formate_date(): String {
        val date = Date(date!!)
        val dateFormate = SimpleDateFormat("hh:mm a", Locale.getDefault())
        return dateFormate.format(date)

    }
}