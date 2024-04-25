package com.android.chatapp.ui.chat_now

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.chatapp.R
import com.android.chatapp.Uses.Constent
import com.android.chatapp.base.BaseActivity
import com.android.chatapp.databinding.ActivityChatNowBinding
import com.android.chatapp.model.Room

class ChatNowActivity : BaseActivity<ChatNowViewModel, ActivityChatNowBinding>(), Navigator {

    lateinit var room: Room
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigator = this
        dataBinding.vmCN = viewModel

        room = intent.getParcelableExtra(Constent.constent)!!

    }

    override fun get_layout_id(): Int {
        return R.layout.activity_chat_now
    }

    override fun get_view_model(): ChatNowViewModel {
        return ViewModelProvider(this).get(ChatNowViewModel::class.java)
    }
}