package com.android.chatapp.base

import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
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
        viewModel.massegeLiveData.observe(this, Observer {message->
            showDialog(message,"OK")

        })
        viewModel.show_load_LiveData.observe(this, Observer {show->

            if(show)
                showLoading()
            else
                hideProgressLoading()
        })
    }


    // Show Dialog during Login or Registration to show fail or successfully
    var alterDialog:AlertDialog?=null
    fun showDialog(message:String,posActionName:String?=null
                   ,posAction:DialogInterface.OnClickListener?=null,
                   negActionName:String?=null,
                   negAction:DialogInterface.OnClickListener?=null,
                   cancellable:Boolean=true) {

        var Dialog=AlertDialog.Builder(this)

        Dialog.setMessage(message)

        if(posActionName!=null)
            Dialog.setPositiveButton(posActionName,posAction)

        if(negActionName!=null)
            Dialog.setNegativeButton(negActionName,negAction)

        Dialog.setCancelable(cancellable)

        alterDialog=Dialog.show()


    }

    fun hideAlterDialog(){
        alterDialog?.dismiss()
        alterDialog=null
    }

    var progress:ProgressDialog?=null
    fun showLoading(){
        progress= ProgressDialog(this)
        progress?.setMessage("Loading...")
        progress?.setCancelable(false)
        progress?.show()

    }

    fun hideProgressLoading(){
        progress?.dismiss()
        progress=null

    }


}