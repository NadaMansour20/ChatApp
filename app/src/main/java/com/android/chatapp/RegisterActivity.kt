package com.android.chatapp


import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.chatapp.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<RegisterViewModel, ActivityRegisterBinding>(), NavigationReg {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // connect data binding to view model
        dataBinding.vmR = viewModel


    }

    override fun get_layout_id(): Int {
        return R.layout.activity_register
    }

    override fun get_view_model(): RegisterViewModel {

        //initial to view model
        return ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun openLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}