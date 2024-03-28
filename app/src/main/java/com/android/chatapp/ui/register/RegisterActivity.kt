package com.android.chatapp.register


import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.android.chatapp.R
import com.android.chatapp.base.BaseActivity
import com.android.chatapp.databinding.ActivityRegisterBinding
import com.android.chatapp.ui.home.HomeActivity

class RegisterActivity : BaseActivity<RegisterViewModel, ActivityRegisterBinding>(), Navigator {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // connect data binding to view model
        dataBinding.vmR = viewModel

        //set navigator in order to know the navigator, this activity is the one that will use the navigator
        viewModel.navigator = this


    }

    override fun get_layout_id(): Int {
        return R.layout.activity_register
    }

    override fun get_view_model(): RegisterViewModel {

        //initial to view model
        return ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    override fun openHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

}