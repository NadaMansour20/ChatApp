package com.android.chatapp.model

data class Room(
    var id: String? = null,
    val name: String? = null,
    val description: String? = null
) {
    companion object {
        const val collection_name = "Rooms"
    }
}
