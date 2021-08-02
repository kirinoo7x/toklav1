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
import com.tiwlynaja.admin.konklav1.chemical.L_chemical
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_item_rice.view.*
import kotlinx.android.synthetic.main.activity_lise_rice.*
import kotlinx.android.synthetic.main.activity_listmulti_user.*

class liseRice : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lise_rice)
        val add = intent.getStringExtra(L_chemical.Address)
        address.setText(add)
        multiRice(add)

        imageView44.setOnClickListener {
            finish()
        }
    }
    private fun multiRice(add:String) {
        val ref = FirebaseDatabase.getInstance().getReference("shoprice/$add")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()
                p0.children.forEach {
                    Log.d("list",it.toString())
                    val re_Rice = it.getValue(select_rice::class.java)
                    println(re_Rice)
                    if (re_Rice != null ){
                        adapter.add(multiItemultirice(re_Rice))
                    }
                }

                listrice.adapter= adapter
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })

    }
}
class multiItemultirice(val re_Rice: select_rice): Item<ViewHolder>(){
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.nameshop.text = re_Rice.nameshop
        viewHolder.itemView.address.text=re_Rice.address
        viewHolder.itemView.cell.text=re_Rice.call
    }

    override fun getLayout(): Int {
        return R.layout.activity_item_rice
    }

}
