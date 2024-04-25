package com.android.chatapp.ui.add_chat

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.android.chatapp.base.BaseViewModel
import com.android.chatapp.database.add_Room
import com.android.chatapp.model.Room

class AddChatViewModel : BaseViewModel<Navigator>() {

    var RoomName = ObservableField<String>("")
    var RoomNameError = ObservableField<String>("")

    var Description = ObservableField<String>("")
    var DescriptionError = ObservableField<String>("")

    var room_added = MutableLiveData<Boolean>()
    fun createChat() {
        if (validate()) {
            add_Room()
            Log.e("clickkkkkkkkkkk", "click")
        }
    }

    fun add_Room() {
        val room = Room(
            name = RoomName.get(),
            description = Description.get()
        )

        add_Room(room, onSuccessListener = {
            room_added.value = true
            navigator?.openHomeActivity()


        }, onFailureListener = {

            massegeLiveData.value = it.localizedMessage
        })

    }


    fun validate(): Boolean {
        var flag = true

        if (RoomName.get().isNullOrBlank()) {
            RoomNameError.set("Please enter Room Name")
            flag = false
        } else {
            RoomNameError.set(null)
        }
        if (Description.get().isNullOrBlank()) {
            DescriptionError.set("Please enter Description")
            flag = false
        } else {
            DescriptionError.set(null)
        }
        return flag
    }


}