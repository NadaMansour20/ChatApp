package com.android.chatapp.ui.chat_now

import androidx.databinding.ObservableField
import com.android.chatapp.Uses.DataUtils
import com.android.chatapp.base.BaseViewModel
import com.android.chatapp.model.Massage
import com.android.chatapp.model.Room
import java.util.Date

class ChatNowViewModel : BaseViewModel<Navigator>() {

    var massage_send = ObservableField<String>("")

    var room: Room? = null
    fun send() {

        var massage = Massage(
            content = massage_send.get(),
            date = Date().time,
            sender_id = DataUtils.use?.id,
            sender_name = DataUtils.use?.firstname + DataUtils.use?.lastname,
            room_id = room?.id

        )

        //save massage to firebase


    }

}