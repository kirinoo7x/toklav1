package com.tiwlynaja.admin.konklav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class loading : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        Handler().postDelayed({
            val intent = Intent(this,MainPageApp::class.java) //MainActivity NotificateActivity
            startActivity(intent)
        },5000)

    }
}
