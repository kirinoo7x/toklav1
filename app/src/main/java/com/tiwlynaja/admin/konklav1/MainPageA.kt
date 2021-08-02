package com.tiwlynaja.admin.konklav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_page.*
import kotlinx.android.synthetic.main.activity_main_page_app.*
import kotlinx.android.synthetic.main.activity_main_page_app.Viewaddress
import kotlinx.android.synthetic.main.activity_main_page_app.Viewname
import kotlinx.android.synthetic.main.activity_main_page_app.image_detail

class MainPageA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        var userId = FirebaseAuth.getInstance().uid
        var ref = FirebaseDatabase.getInstance().getReference("user/$userId")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach{
                        val sympp:String = it.child("name").getValue().toString()
                        val actionn:String = it.child("address").getValue().toString()
                        val imge:String = it.child("image").getValue().toString()
                        val id = it.child("id").getValue().toString()
                        println(imge)
                        Viewname.setText(sympp)
                        Viewaddress.setText(actionn)
                        Picasso.get().load(imge).into(image_detail)

                    }

            }


        })


        imageView8.setOnClickListener {
            startActivity(Intent(this,Create_plots::class.java))
        }

    }
}
