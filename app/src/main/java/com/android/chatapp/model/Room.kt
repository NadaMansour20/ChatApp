package com.android.chatapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


// Parcelize equal serializable to transfer object by Intent --> use any of them
@Parcelize
data class Room(
    var id: String? = null,
    val name: String? = null,
    val description: String? = null
) : Parcelable {
    companion object {
        const val collection_nameRoom = "Rooms"
    }
}
