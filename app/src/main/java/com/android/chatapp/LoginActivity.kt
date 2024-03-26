package com.android.chatapp

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.chatapp.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>(), NavigatorLog {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // connect data binding to view model

    }

    override fun get_layout_id(): Int {
        return R.layout.activity_login
    }

    override fun get_view_model(): LoginViewModel {
        //initial to view model
        return ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun openHomeActivity() {
        var intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    override fun openRegisterActivity() {
        var intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }
}