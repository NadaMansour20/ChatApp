package com.android.chatapp

import android.app.Application
import com.google.firebase.Firebase
import com.google.firebase.initialize


//class application in android extent context
//The application class starts first when I turn on the application, before the context start

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Firebase.initialize(this)
    }
}