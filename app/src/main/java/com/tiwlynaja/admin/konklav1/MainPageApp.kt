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
import com.tiwlynaja.admin.konklav1.NOchemical.L_NOchemical
import com.tiwlynaja.admin.konklav1.Noti_check_completed.NotificationUtils_CKC
import com.tiwlynaja.admin.konklav1.chemical.L_chemical
import com.tiwlynaja.admin.konklav1.chemical.Noti_chemical
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main_page_app.*
import kotlinx.android.synthetic.main.activity_water_else.*
import kotlinx.android.synthetic.main.patien_c_patien.view.*


class MainPageApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page_app)

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
        imageView9.setOnClickListener {
            startActivity(Intent(this,Create_plots::class.java))
        }
        fram_completed.setOnClickListener {
            startActivity(Intent(this,LiseFramUser::class.java))
        }
        lisefram()
    }


    companion object{
        var idfu = "idfu"
        var namefram = "namefram"
        var Framland = "Fraland"
        var Address = "address_Farm"
        var Rice = "Rice"
        var cultivation = "Cultivation"
        var Type = "Type"
        var Day = "day"
        var Month = "month"
        var Year = "year"
        var Rice_quantityf = "Rice_quantityf"
        var Fformula1 = "Fformula1"
        var Fformula2 = "Fformula2"
        var Fformula3 = "Fformula3"
        var Mfertilizer1 = "Mfertilizer1"
        var Mfertilizer2 = "Mfertilizer2"
        var Mfertilizer3 = "Mfertilizer3"

    }
    private fun lisefram() {
        var userId = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("plan/$userId")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()
                p0.children.forEach {
                    Log.d("list",it.toString())
                    val re_plan = it.getValue(sentToCreateplan::class.java)
                    if (re_plan != null ){

                        var pp = re_plan.product
                        if (pp == "อยู่ระหว่างดำเนินการ" || pp=="อยู่ระหว่างดำเนิดการ"){
                            adapter.add(planItemusers(re_plan))
                        }
                    }
                }
                adapter.setOnItemClickListener{ item, view ->
                    val ItemPlanUser = item as planItemusers
                    val att = ItemPlanUser.re_plan.attributes

                    if (att== "ไม่ใช้สารเคมี"){
                        val intent = Intent(view.context, L_NOchemical::class.java)
                        intent.putExtra(idfu,ItemPlanUser.re_plan.id)
                        intent.putExtra(namefram,ItemPlanUser.re_plan.nameFram)
                        intent.putExtra(Address,ItemPlanUser.re_plan.addressFram)
                        intent.putExtra(Framland,ItemPlanUser.re_plan.area)
                        intent.putExtra(Rice,ItemPlanUser.re_plan.rice)
                        intent.putExtra(Type,ItemPlanUser.re_plan.type)
                        intent.putExtra(cultivation,ItemPlanUser.re_plan.attributes)
                        intent.putExtra(Day,ItemPlanUser.re_plan.days)
                        intent.putExtra(Month,ItemPlanUser.re_plan.months)
                        intent.putExtra(Year,ItemPlanUser.re_plan.years)
                        intent.putExtra(Rice_quantityf,ItemPlanUser.re_plan.quantity) //  quantity rice in plan
                        intent.putExtra(Fformula1,ItemPlanUser.re_plan.ff1)
                        intent.putExtra(Mfertilizer1,ItemPlanUser.re_plan.mf1)
                        startActivity(intent)
                        finish()
                    }else{
                        val intent = Intent(view.context, L_chemical::class.java)
                        intent.putExtra(idfu,ItemPlanUser.re_plan.id)
                        intent.putExtra(namefram,ItemPlanUser.re_plan.nameFram)
                        intent.putExtra(Address,ItemPlanUser.re_plan.addressFram)
                        intent.putExtra(Framland,ItemPlanUser.re_plan.area)
                        intent.putExtra(Rice,ItemPlanUser.re_plan.rice)
                        intent.putExtra(Type,ItemPlanUser.re_plan.type)
                        intent.putExtra(cultivation,ItemPlanUser.re_plan.attributes)
                        intent.putExtra(Day,ItemPlanUser.re_plan.days)
                        intent.putExtra(Month,ItemPlanUser.re_plan.months)
                        intent.putExtra(Year,ItemPlanUser.re_plan.years)
                        intent.putExtra(Rice_quantityf,ItemPlanUser.re_plan.quantity) //  quantity rice in plan
                        intent.putExtra(Fformula1,ItemPlanUser.re_plan.ff1)
                        intent.putExtra(Fformula2,ItemPlanUser.re_plan.ff2)
                        intent.putExtra(Fformula3,ItemPlanUser.re_plan.ff3)
                        intent.putExtra(Mfertilizer1,ItemPlanUser.re_plan.mf1)
                        intent.putExtra(Mfertilizer2,ItemPlanUser.re_plan.mf2)
                        intent.putExtra(Mfertilizer3,ItemPlanUser.re_plan.mf3)
                        startActivity(intent)
                        finish()
                    }



                }


                listriceMain.adapter = adapter
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })

    }
}

class planItemusers(val re_plan: sentToCreateplan): Item<ViewHolder>(){
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.nameF.text = re_plan.nameFram
        viewHolder.itemView.riceF.text = re_plan.rice
        viewHolder.itemView.typeF.text = re_plan.attributes
        viewHolder.itemView.textView15.text=re_plan.product
        //Picasso.get().load(user.image).into(viewHolder.itemView.image_list)
    }

    override fun getLayout(): Int {
        return R.layout.activity_itemframuser
    }

}

