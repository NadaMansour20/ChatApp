package com.android.chatapp


import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.chatapp.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<RegisterViewModel, ActivityRegisterBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.vm = viewModel


    }

    override fun get_layout_id(): Int {
        return R.layout.activity_register
    }

    override fun get_view_model(): RegisterViewModel {
        return ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

}