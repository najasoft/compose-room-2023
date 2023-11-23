package com.itformation.compose_room_2023

import android.app.Application
import android.content.Context

class ContactApplication: Application() {
    init {
        app=this
    }
    companion object{
        private  lateinit var app:ContactApplication

        fun getContext(): Context =app.applicationContext

    }
}