package com.tiwlynaja.admin.konklav1

import android.app.Activity
import android.app.AlarmManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import java.util.*
import java.util.jar.JarEntry

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val intent = Intent(this,ChooseStatus::class.java) // Go to Choose status
            startActivity(intent)},3000)
    }
}
