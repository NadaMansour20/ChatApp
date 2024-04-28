package com.android.chatapp.model

data class AppUser(
    var id: String? = null,
    var firstname: String? = null,
    var lastname: String? = null,
    var email: String? = null,

    ) {
    companion object {
        const val CollectionNameAppUser = "users"


    }
}