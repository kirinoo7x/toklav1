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
import kotlinx.android.synthetic.main.activity_item_multi__users.view.*
import kotlinx.android.synthetic.main.activity_listmulti_user.*
import kotlinx.android.synthetic.main.activity_listmulti_user.view.*


class listmultiUser : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listmulti_user)

        multiUser()
        back.setOnClickListener {
            startActivity(Intent(this,MainPageApp::class.java))
        }
    }
companion object{
    val name = "name"
    val address = "address"
    val imge = "imge"
    val idf = "idf"
}
    private fun multiUser() {
        var userId = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("user_all")
        ref.orderByChild("id").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()
                p0.children.forEach {
                    Log.d("list",it.toString())
                    val re_user = it.getValue(sentToDBRE::class.java)
                    if (re_user != null ){
                        val i = re_user.id
                        if (i != userId){
                            adapter.add(multiItemuser(re_user))
                        }
                    }
                }
                adapter.setOnItemClickListener{ item, view ->
                    val ItemUser = item as multiItemuser
                    val id =ItemUser.re_user.id
                    var userId = FirebaseAuth.getInstance().uid
                    if (id != userId){
                        val intent = Intent(view.context, listfram_multi::class.java)
                        intent.putExtra(idf,ItemUser.re_user.id)
                        intent.putExtra(name,ItemUser.re_user.name)
                        intent.putExtra(address,ItemUser.re_user.address)
                        intent.putExtra(imge,ItemUser.re_user.image)
                        startActivity(intent)
                        finish()
                    }

                }


                listmultiUsers.adapter= adapter
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })

    }
}

class multiItemuser(val re_user: sentToDBRE): Item<ViewHolder>(){
    override fun bind(viewHolder: ViewHolder, position: Int) {


            viewHolder.itemView.textView10.text = "ชื่อ ::"
            viewHolder.itemView.textView6.text="ที่อยู่ ::"
            viewHolder.itemView.nameUsers.text = re_user.name
            viewHolder.itemView.addressMulti.text=re_user.address
            Picasso.get().load(re_user.image).into(viewHolder.itemView.imageView23)

    }

    override fun getLayout(): Int {
        return R.layout.activity_item_multi__users
    }

}