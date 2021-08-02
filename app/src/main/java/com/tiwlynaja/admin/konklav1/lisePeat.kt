package com.tiwlynaja.admin.konklav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_lise_paet.*
import kotlinx.android.synthetic.main.itempaet.view.*

class lisePaet : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lise_paet)
        lisepaet()

        imageView55.setOnClickListener {
            finish()
        }
    }
    companion object{
        val id = "id"
        val namepest = "namepest"
        val killi = "kill"
        val imge = "imge"
    }
    private fun lisepaet() {
        val ref = FirebaseDatabase.getInstance().getReference("pest")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()
                p0.children.forEach {
                    Log.d("list",it.toString())
                    val re_paet = it.getValue(sentodbpaet::class.java)
                    if (re_paet != null ){
                        adapter.add(paetItemuser(re_paet))
                    }
                }
                adapter.setOnItemClickListener{ item, view ->
                    val ItempestUser = item as paetItemuser
                    val intent = Intent(view.context, Pest::class.java)
                    intent.putExtra(id,ItempestUser.re_paet.id)
                    intent.putExtra(namepest,ItempestUser.re_paet.name)
                    intent.putExtra(killi,ItempestUser.re_paet.kill)
                    intent.putExtra(imge,ItempestUser.re_paet.imge)
                    startActivity(intent)
                    finish()
                }


                listpaet.adapter= adapter
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })

    }
}

class paetItemuser(val re_paet: sentodbpaet): Item<ViewHolder>(){
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.namep.text = re_paet.name
        Picasso.get().load(re_paet.imge).rotate(90f).into(viewHolder.itemView.imageView23)
    }

    override fun getLayout(): Int {
        return R.layout.itempaet
    }

}