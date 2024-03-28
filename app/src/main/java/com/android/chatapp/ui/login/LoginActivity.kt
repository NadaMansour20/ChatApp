package com.android.chatapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.chatapp.R
import com.android.chatapp.base.BaseActivity
import com.android.chatapp.databinding.ActivityLoginBinding
import com.android.chatapp.register.RegisterActivity
import com.android.chatapp.ui.home.HomeActivity

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>(), Navigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // connect data binding to view model
        dataBinding.vmL = viewModel

        //set navigator in order to know the navigator, this activity is the one that will use the navigator
        viewModel.navigator = this

    }

    override fun get_layout_id(): Int {
        return R.layout.activity_login
    }

    override fun get_view_model(): LoginViewModel {
        //initial to view model
        return ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun openHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    override fun openRegisterActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}