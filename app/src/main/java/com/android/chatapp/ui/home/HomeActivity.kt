package com.android.chatapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.android.chatapp.R
import com.android.chatapp.base.BaseActivity
import com.android.chatapp.database.get_Room
import com.android.chatapp.databinding.ActivityHomeBinding
import com.android.chatapp.model.Room
import com.android.chatapp.ui.chat.ChatActivity
import com.android.chatapp.ui.chat.ChatAdapter

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>(), Navigator {

    var adapter: ChatAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding.vmH = viewModel

        viewModel.navigator = this


        dataBinding.recyclerview.adapter = adapter
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

    override fun onStart() {
        super.onStart()
        get_Room({
            val RoomList = it.toObjects(Room::class.java)
            adapter?.chande_data(RoomList)

        }, {
            Toast.makeText(this, "can't fetch Room", Toast.LENGTH_LONG).show()
        })
    }
}