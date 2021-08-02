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
import kotlinx.android.synthetic.main.activity_listfram_multi.*
import kotlinx.android.synthetic.main.patien_c_patien.view.*

class listfram_multi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listfram_multi)
        val id = intent.getStringExtra(listmultiUser.idf)
        val name = intent.getStringExtra(listmultiUser.name)
        val address = intent.getStringExtra(listmultiUser.address)
        val imge = intent.getStringExtra(listmultiUser.imge)
        Picasso.get().load(imge).into(image_detail)

        namefarm.setText(name)
        addressfarm.setText(address)
        lisefram(id,name,address,imge)

        imageView51.setOnClickListener {
            finish()
        }
    }
companion object{
    val idf = "idf"
    val namee = "name"
    val addresss ="address"
    val imgee = "imge"
    val namefram = "nameFram"
    val addressfram = "addressFram"
    val ariafram = "ariafram"
    val Ricef = "rice" // พันธุ์ข้าว
    val Typef = "type" // วิธีการเพาะปลูก
    val attributef = "Attribute" // ปลูกแบบ ใช้สาารเคมี
    val Dayf = "day"
    val Monthf = "month"
    val Yearf = "year"
    val Rice_quantityf = "quantity_rice" // ปริมาณพันธุ์ข้าวที่ต้องใช้
    val Fformula1 = "formula1"  //สูตรปุ๋ย
    val Fformula2 = "formula2"
    val Fformula3 = "formula3"
    val Mfertilizer1 = "Mfertilizer1" // ปริมาณปุ๋ย
    val Mfertilizer2 = "Mfertilizer2"
    val Mfertilizer3 = "Mfertilizer3"
    val Productf = "productf"

}
    private fun lisefram(id:String,name:String,address:String,imge:String) {
        val ref = FirebaseDatabase.getInstance().getReference("plan/$id")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()
                p0.children.forEach {
                    Log.d("list",it.toString())
                    val re_plan = it.getValue(sentToCreateplan::class.java)
                    if (re_plan != null ){
                        adapter.add(multiItemuser2(re_plan))
                    }
                }
                adapter.setOnItemClickListener{ item, view ->
                    val ItemPlan = item as multiItemuser2
                        val intent = Intent(view.context, multiplan::class.java)
                    intent.putExtra(namefram,ItemPlan.re_plan.nameFram)
                    intent.putExtra(addressfram,ItemPlan.re_plan.addressFram)
                    intent.putExtra(ariafram,ItemPlan.re_plan.area)
                    intent.putExtra(Ricef,ItemPlan.re_plan.rice)
                    intent.putExtra(Typef,ItemPlan.re_plan.type)
                    intent.putExtra(attributef,ItemPlan.re_plan.attributes)

                    intent.putExtra(Dayf,ItemPlan.re_plan.days)
                    intent.putExtra(Monthf,ItemPlan.re_plan.months)
                    intent.putExtra(Yearf,ItemPlan.re_plan.years)

                    intent.putExtra(Rice_quantityf,ItemPlan.re_plan.quantity) //  quantity rice in plan

                    intent.putExtra(Fformula1,ItemPlan.re_plan.ff1)
                    intent.putExtra(Fformula2,ItemPlan.re_plan.ff2)
                    intent.putExtra(Fformula3,ItemPlan.re_plan.ff3)


                    intent.putExtra(Mfertilizer1,ItemPlan.re_plan.mf1)
                    intent.putExtra(Mfertilizer2,ItemPlan.re_plan.mf2)
                    intent.putExtra(Mfertilizer3,ItemPlan.re_plan.mf3)

                    intent.putExtra(Productf,ItemPlan.re_plan.product)

                    intent.putExtra(idf,ItemPlan.re_plan.id)
                    intent.putExtra(addresss,address)
                    intent.putExtra(namee,name)
                    intent.putExtra(imgee,imge)

                        startActivity(intent)
                        finish()

                }


                listmulti.adapter= adapter
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })

    }
}

class multiItemuser2(val re_plan: sentToCreateplan): Item<ViewHolder>(){
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val pp = re_plan.product
        viewHolder.itemView.nameF.text = re_plan.nameFram
        viewHolder.itemView.riceF.text = re_plan.rice
        viewHolder.itemView.typeF.text = re_plan.attributes

        if (pp == "อยู่ระหว่างดำเนิดการ"){
            viewHolder.itemView.textView15.text = re_plan.product
        }else{
            viewHolder.itemView.t8.text = re_plan.product
        }

    }

    override fun getLayout(): Int {
        return R.layout.patien_c_patien
    }

}

