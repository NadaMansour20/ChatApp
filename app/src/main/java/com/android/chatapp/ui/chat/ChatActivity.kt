package com.android.chatapp.ui.chat

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.chatapp.R
import com.android.chatapp.base.BaseActivity
import com.android.chatapp.databinding.ActivityChatBinding
import com.android.chatapp.ui.home.HomeActivity

class ChatActivity : BaseActivity<ChatViewModel, ActivityChatBinding>(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        dataBinding.vmC = viewModel

        viewModel.navigator = this


        viewModel.room_added.observe(this, Observer {
            // show dialog
        })
    }

    override fun get_layout_id(): Int {
        return R.layout.activity_chat
    }

    override fun get_view_model(): ChatViewModel {
        return ViewModelProvider(this).get(ChatViewModel::class.java)
    }

    override fun openHomeActivity() {
        val intent = Intent(this, HomeActivity()::class.java)
        startActivity(intent)
    }
}