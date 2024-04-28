package com.android.chatapp.ui.add_chat

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.chatapp.R
import com.android.chatapp.base.BaseActivity
import com.android.chatapp.databinding.ActivityChatAddBinding
import com.android.chatapp.ui.home.HomeActivity

class AddChatActivity : BaseActivity<AddChatViewModel, ActivityChatAddBinding>(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.vmC = viewModel

        viewModel.navigator = this


        viewModel.room_added.observe(this, Observer {
            // show dialog
        })
    }

    override fun get_layout_id(): Int {
        return R.layout.activity_chat_add
    }

    override fun get_view_model(): AddChatViewModel {
        return ViewModelProvider(this).get(AddChatViewModel::class.java)
    }

    override fun openHomeActivity() {
        val intent = Intent(this, HomeActivity()::class.java)
        startActivity(intent)
    }
}