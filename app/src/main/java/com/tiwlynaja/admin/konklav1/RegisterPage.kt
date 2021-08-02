package com.tiwlynaja.admin.konklav1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_login_page.*
import kotlinx.android.synthetic.main.activity_register_page.*
import kotlinx.android.synthetic.main.activity_register_page.imageView2
import java.util.*

class RegisterPage : AppCompatActivity() {
    lateinit var REname:EditText
    lateinit var REemail: EditText
    lateinit var REPass: EditText
    lateinit var REaddress : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        REemail = findViewById(R.id.eamilRE)
        REPass = findViewById(R.id.passRE)
        REname = findViewById(R.id.nameRE)
        REaddress = findViewById(R.id.addressRE)

        imageView2.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }


        imageView20.setOnClickListener{

            val Email = eamilRE.text.toString()
            val Pass = passRE.text.toString()
            val name = nameRE.text.toString()
            val address = addressRE.text.toString()

            if (Email.isEmpty() || Pass.isEmpty() || name.isEmpty() || address.isEmpty()){
                Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบ.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
                }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(Email, Pass)
                .addOnCompleteListener {
                    if (!it.isSuccessful) {
                        return@addOnCompleteListener
                    }
                    startActivity(Intent(this,loading::class.java))
                    imageUpload()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "สร้างบัญชีไม่สำเร็จ", Toast.LENGTH_SHORT).show()
                    return@addOnFailureListener
                }
            }
        }

    var selectedPhotoUri: Uri? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 0 && resultCode == Activity.RESULT_OK && data != null){
            Log.d("Detail_input","Photo Select")

            selectedPhotoUri = data.data
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhotoUri)
            image_1.setImageBitmap(bitmap)
            imageView2.alpha = 0f

        }
    }

    private fun imageUpload() {
        if (selectedPhotoUri == null){
            Log.d("Detail_input","I AM HERE")
            return
        }
        val filename = UUID.randomUUID().toString()
        val ref = FirebaseStorage.getInstance().getReference("/images/$filename")
        ref.putFile(selectedPhotoUri!!)
            .addOnSuccessListener {
                Log.d("Detail_input","Upload SS : ${it.metadata?.path}")

                ref.downloadUrl.addOnSuccessListener {
                    Log.d("Detail_input","Location: $it")
                    sentDb(it.toString())
                }

            }
            .addOnFailureListener{

            }

    }
    private fun sentDb(imageuurl: String) {
        val emilRE = REemail.text.toString().trim()
        val  passRE= REPass.text.toString().trim()
        val nameRE = REname.text.toString().trim()
        val addressRE = REaddress.text.toString().trim()

        val userId = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("user/$userId")
        val user = sentToDBRE(userId.toString(), emilRE, passRE, nameRE, addressRE, imageuurl)
        ref.child(userId.toString()).setValue(user)
            .addOnCompleteListener {
                val ref = FirebaseDatabase.getInstance().getReference("user_all")
                val user = sentToDBRE(userId.toString(), emilRE, passRE, nameRE, addressRE,imageuurl)
                ref.child(userId.toString()).setValue(user)
                    .addOnCompleteListener {
                        Toast.makeText(this, "สร้างบัญชีผู้ใช้สําเร็จ", Toast.LENGTH_SHORT).show()
                    }
            }
            .addOnFailureListener{
                Toast.makeText(this, " สร้างบัญชีผู้ใช้ไม่สำเร็จ โปรดรออีกครั้ง ", Toast.LENGTH_SHORT).show()
            }
    }
}
