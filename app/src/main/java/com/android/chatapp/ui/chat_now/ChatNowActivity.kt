package com.android.chatapp.ui.chat_now

import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.android.chatapp.R
import com.android.chatapp.Uses.Constent
import com.android.chatapp.base.BaseActivity
import com.android.chatapp.databinding.ActivityChatNowBinding
import com.android.chatapp.model.Room

class ChatNowActivity : BaseActivity<ChatNowViewModel, ActivityChatNowBinding>(), Navigator {

    lateinit var room: Room
    lateinit var room_name_text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigator = this
        dataBinding.vmCN = viewModel

        room = intent.getParcelableExtra(Constent.constent)!!


        //set room that from home
        viewModel.room = room

        room_name_text = findViewById(R.id.room_name_text)
        room_name_text.text = room.name


    }

    override fun get_layout_id(): Int {
        return R.layout.activity_chat_now
    }

    override fun get_view_model(): ChatNowViewModel {
        return ViewModelProvider(this).get(ChatNowViewModel::class.java)
    }
}