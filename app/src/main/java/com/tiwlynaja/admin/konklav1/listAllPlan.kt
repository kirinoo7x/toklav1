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
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_list_all_plan.*
import kotlinx.android.synthetic.main.patien_c_patien.view.*

class listAllPlan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_all_plan)

        val name_userf = intent.getStringExtra(choose_plan.name)
        val area_userf = intent.getStringExtra(choose_plan.Framland)
        val address_userf = intent.getStringExtra(choose_plan.Address)
        val rice_userf = intent.getStringExtra(choose_plan.Rice)
        val type_userf = intent.getStringExtra(choose_plan.cultivation)
        val attribute_userf = intent.getStringExtra(choose_plan.Type)
        val Day_userf = intent.getStringExtra(choose_plan.Day)
        val Month_userf = intent.getStringExtra(choose_plan.Month)
        val Year_userf = intent.getStringExtra(choose_plan.Year)

        println("-----------------"+name_userf)
        plan(name_userf,area_userf,address_userf,rice_userf,type_userf,attribute_userf,Day_userf,Month_userf,Year_userf)

        imageView49.setOnClickListener {
            finish()
        }
    }
    companion object{
        ///////////////////////// group all list /////////////////////////
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

        ////////////////    group user  selset  ///////////////////////
        val name_userS = "name_userS"
        val area_userS = "area_userS"
        val address_userS = "address_userS"
        val rice_userS = "rice_userS"
        val type_userS = "type_userS"
        val attribute_userS = "attribute_userS"
        val Day_userS = "Day_userS"
        val Month_userS = "Month_userS"
        val Year_userS = "Year_userS"
    }

    private fun plan(nameUserf: String?, areaUserf: String?, addressUserf: String?, riceUserf: String?, typeUserf: String?, attributeUserf: String?, dayUserf: String?, monthUserf: String?, yearUserf: String?) {

        val ref1 = FirebaseDatabase.getInstance().getReference("plan_all")
        ref1.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()
                p0.children.forEach {
                    Log.d("list",it.toString())
                    val re_plan = it.getValue(sentToCreateplan::class.java)
                    if (re_plan != null ){
                        var pp = re_plan.product
                        if (pp != "อยู่ระหว่างดำเนินการ" && pp!="อยู่ระหว่างดำเนิดการ"){
                            adapter.add(planItem(re_plan))
                        }

                    }
                }
                adapter.setOnItemClickListener{ item, view ->
                    val ItemPlan = item as planItem
                    val intent = Intent(view.context, ConcludePlan::class.java)
                    ///////////////////////        group all list               ///////////////////
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
                    ///////////////////////      group user  selset          //////////////////////////////////
                    intent.putExtra(name_userS,nameUserf)
                    intent.putExtra(area_userS,areaUserf)
                    intent.putExtra(address_userS,addressUserf)

                    intent.putExtra(Day_userS,dayUserf)
                    intent.putExtra(Month_userS,monthUserf)
                    intent.putExtra(Year_userS,yearUserf)

                    startActivity(intent)
                    finish()
                }


                yourFarm.adapter = adapter
            }

            override fun onCancelled(p0: DatabaseError) {

            }
        })
    }
}

class planItem(val re_plan: sentToCreateplan): Item<ViewHolder>(){
    override fun bind(viewHolder: ViewHolder, position: Int) {
        val pp = re_plan.product
        viewHolder.itemView.nameF.text = re_plan.nameFram
        viewHolder.itemView.riceF.text = re_plan.rice
        viewHolder.itemView.typeF.text = re_plan.attributes
        if (pp == "อยู่ระหว่างดำเนิดการ"){
            viewHolder.itemView.textView15.text = re_plan.product
        }else{
            viewHolder.itemView.t8.text = re_plan.product+" kg"
        }


        //Picasso.get().load(user.image).into(viewHolder.itemView.image_list)
    }

    override fun getLayout(): Int {
        return R.layout.patien_c_patien
    }

}
