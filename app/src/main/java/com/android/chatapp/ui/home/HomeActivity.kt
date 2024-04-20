package com.android.chatapp.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.chatapp.R
import com.android.chatapp.base.BaseActivity
import com.android.chatapp.databinding.ActivityHomeBinding
import com.android.chatapp.ui.chat.ChatActivity

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>(), Navigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.vmH = viewModel

        viewModel.navigator = this


    }

    override fun get_layout_id(): Int {
        return R.layout.activity_home
    }

    override fun get_view_model(): HomeViewModel {
        return ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun add_Chat() {
        val intent = Intent(this, ChatActivity::class.java)
        startActivity(intent)
    }
}