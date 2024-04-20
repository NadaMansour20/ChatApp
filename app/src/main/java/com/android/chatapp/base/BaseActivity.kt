package com.android.chatapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer

abstract class BaseActivity<VM : BaseViewModel<*>, DB : ViewDataBinding> : AppCompatActivity() {

    lateinit var viewModel: VM
    lateinit var dataBinding: DB

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        //dataBinding initial
        dataBinding = DataBindingUtil.setContentView(this, get_layout_id())

        viewModel = get_view_model()

        subscribe_viewModel()


    }

    abstract fun get_layout_id(): Int
    abstract fun get_view_model(): VM

    fun subscribe_viewModel() {
        viewModel.massegeLiveData.observe(this, Observer {

        })
        viewModel.show_load_LiveData.observe(this, Observer {

        })
    }


}