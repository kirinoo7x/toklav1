package com.tiwlynaja.admin.konklav1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import com.tiwlynaja.admin.konklav1.chemical.L_chemical
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_item_multi__users.view.*
import kotlinx.android.synthetic.main.activity_item_rice.view.*
import kotlinx.android.synthetic.main.activity_item_rice.view.imageView23
import kotlinx.android.synthetic.main.activity_lise_rice.*
import kotlinx.android.synthetic.main.activity_list_fertilizer.*
import kotlinx.android.synthetic.main.activity_list_fertilizer.address
import kotlinx.android.synthetic.main.activity_list_fertilizer.imageView44

class list_fertilizer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_fertilizer)

        val addressl = intent.getStringExtra(L_chemical.Address)
        val ffs = intent.getStringExtra(L_chemical.Fformula)
        ff.setText(ffs)
        address.setText(addressl)

        if(ffs == "เคมี"){
            var nametable ="fertilizer"
            multifertilizer(addressl,nametable)
        }else{
            var nametable ="manure"
            multifertilizer(addressl,nametable)
        }


        imageView44.setOnClickListener {
            finish()
        }

    }

    private fun multifertilizer(add: String,nametable:String) {
        val ref = FirebaseDatabase.getInstance().getReference("$nametable/$add")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()
                p0.children.forEach {
                    Log.d("list", it.toString())
                    val re_fertilizer = it.getValue(select_rice::class.java)
                    if (re_fertilizer != null) {
                        adapter.add(multiItemultifertilizer(re_fertilizer))
                    }
                }

                listff.adapter = adapter
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })


    }
}
    class multiItemultifertilizer(val re_Rice: select_rice): Item<ViewHolder>(){
        override fun bind(viewHolder: ViewHolder, position: Int) {
            viewHolder.itemView.nameshop.text = re_Rice.nameshop
            viewHolder.itemView.address.text=re_Rice.address
            viewHolder.itemView.cell.text=re_Rice.call

        }

        override fun getLayout(): Int {
            return R.layout.activity_item_fertilizer
        }

    }