package com.tiwlynaja.admin.konklav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login_page.*

class LoginPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        login.setOnClickListener {
            val email = email.text.toString()
            val pass = Pass.text.toString()

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener
                    val intent = Intent(this,MainPageApp::class.java)
                    startActivity(intent)
                }

                .addOnFailureListener{
                    Toast.makeText(this,"Email or Pass ไม่ถูกต้อง", Toast.LENGTH_SHORT).show()
                    return@addOnFailureListener
                }
        }
    }
}
