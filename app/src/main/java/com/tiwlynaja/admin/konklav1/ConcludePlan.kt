package com.tiwlynaja.admin.konklav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_choose_plan.*
import kotlinx.android.synthetic.main.activity_conclude_plan.*

class ConcludePlan : AppCompatActivity() {
    lateinit var nameff : TextView
    lateinit var addressff: TextView
    lateinit var areaff: TextView
    lateinit var Riceff: TextView
    lateinit var Typeff: TextView
    lateinit var attributeff: TextView
    lateinit var qRice: TextView
    lateinit var productff:TextView
    lateinit var dayff: TextView
    lateinit var monthff: TextView
    lateinit var yearff: TextView

    lateinit var ff1: TextView
    lateinit var ff2: TextView
    lateinit var ff3: TextView

    lateinit var mf1: TextView
    lateinit var mf2: TextView
    lateinit var mf3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conclude_plan)

        var all_namef = intent.getStringExtra(listAllPlan.namefram)
        var all_addressf = intent.getStringExtra(listAllPlan.addressfram)
        var all_ariaf = intent.getStringExtra(listAllPlan.ariafram)
        var all_Typef = intent.getStringExtra(listAllPlan.Typef)
        var all_attributef = intent.getStringExtra(listAllPlan.attributef)
        var all_Rice = intent.getStringExtra(listAllPlan.Ricef)

        var all_day = intent.getStringExtra(listAllPlan.Dayf)
        var all_Month = intent.getStringExtra(listAllPlan.Monthf)
        var all_year = intent.getStringExtra(listAllPlan.Yearf)

        var all_rice_quantity  = intent.getStringExtra(listAllPlan.Rice_quantityf)

        var all_formula1 = intent.getStringExtra(listAllPlan.Fformula1)
        var all_formula2 = intent.getStringExtra(listAllPlan.Fformula2)
        var all_formula3 = intent.getStringExtra(listAllPlan.Fformula3)

        var all_Mfertilizer1 = intent.getStringExtra(listAllPlan.Mfertilizer1)
        var all_Mfertilizer2 = intent.getStringExtra(listAllPlan.Mfertilizer2)
        var all_Mfertilizer3 = intent.getStringExtra(listAllPlan.Mfertilizer3)

        var productf = intent.getStringExtra(listAllPlan.Productf)

/////////////////////////////////////infomation user /////////////////////////////////////

        val User_namef = intent.getStringExtra(listAllPlan.name_userS)
        val User_addressf = intent.getStringExtra(listAllPlan.address_userS)
        val User_area = intent.getStringExtra(listAllPlan.area_userS)

        val User_day = intent.getStringExtra(listAllPlan.Day_userS)
        val User_month = intent.getStringExtra(listAllPlan.Month_userS)
        val User_year = intent.getStringExtra(listAllPlan.Year_userS)


        val u_namef = User_namef
        val u_address = User_addressf
        val u_area = User_area
////////////////////////////////////////////////////////////////////////////////
    //-------------top--------------/
        namefarm_all.setText(all_namef)
        nameff = findViewById(R.id.namefarm_all)

        addressfarm_all.setText(all_addressf)
        addressff = findViewById(R.id.addressfarm_all)
        product_all.setText(productf)
        productff = findViewById(R.id.product_all)
    //--------------min------------/
        nameFarm_all.setText(all_namef)
        addressFarm_all.setText(all_addressf)
        areaFarm_all.setText(all_ariaf)
        areaff = findViewById(R.id.areaFarm_all)

        Rice_all.setText(all_Rice)
        Riceff = findViewById(R.id.Rice_all)

        Type_all.setText(all_Typef)
        Typeff = findViewById(R.id.Type_all)

        attribute_all.setText(all_attributef)
        attributeff = findViewById(R.id.attribute_all)

        Day_all.setText(all_day)
        Month_all.setText(all_Month)
        Year_all.setText(all_year)

        quantity_rice_all.setText(all_rice_quantity)
        qRice = findViewById(R.id.quantity_rice_all)
        formula_fertilizer_1.setText(all_formula1)
        fertilizer_1.setText(all_Mfertilizer1)

        formula_fertilizer_2.setText(all_formula2)
        fertilizer_2.setText(all_Mfertilizer2)

        formula_fertilizer_3.setText(all_formula3)
        fertilizer_3.setText(all_Mfertilizer3)

        ff1 = findViewById(R.id.formula_fertilizer_1)
        ff2 = findViewById(R.id.formula_fertilizer_2)
        ff3 = findViewById(R.id.formula_fertilizer_3)

        mf1 = findViewById(R.id.fertilizer_1)
        mf2 = findViewById(R.id.fertilizer_2)
        mf3 = findViewById(R.id.fertilizer_3)

        imageView50.setOnClickListener {
            finish()
        }


        cludePlan.setOnClickListener {
            if (productf == "อยู่ระหว่างดำเนิดการ"){
                Toast.makeText(this, "แปลงนี้อยู่ระหว่างเพราะปลูกระบบไม่แนะนำ\nให้สร้างการเพาะปลูกจากแปลงนี้", Toast.LENGTH_SHORT).show()
            }else{
                val rice_all = Riceff.text.toString()
                val qrice_all = qRice.text.toString()
                val Type_all = Typeff.text.toString()
                val attribute_all = attributeff.text.toString()
                val ff1_all = ff1.text.toString()
                val ff2_all = ff2.text.toString()
                val ff3_all = ff3.text.toString()
                val mf1_all = mf1.text.toString()
                val mf2_all = mf2.text.toString()
                val mf3_all = mf3.text.toString()
                setToPlan(u_namef, u_address, u_area, rice_all, Type_all, attribute_all, qrice_all, User_day, User_month, User_year, ff1_all, ff2_all, ff3_all, mf1_all, mf2_all, mf3_all)
            }
        }

    }
    companion object{
        val sID = "id"
        val nameframf = "nameFram"
        val addressfram = "addressFram"
        val areafram = "ariafram"
        val Ricef = "rice" // พันธุ์ข้าว
        val Typef = "cultivation rice" // วิธีการเพาะปลูก
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
        val idFram = "idFram"
    }
    private fun setToPlan(User_namef:String?, User_addressf:String?, User_area:String?, all_Rice:String?, all_Typef:String?, all_attributef:String?, all_rice_quantity:String?, User_day:String, User_month:String, User_year:String, all_formula1:String?, all_formula2:String?, all_formula3:String?, all_Mfertilizer1:String?, all_Mfertilizer2:String?, all_Mfertilizer3:String?){
        println(User_namef)
        println(User_day)
        println(User_month)
        println(User_year)

        val i = Intent(this,Plan_all::class.java)
        i.putExtra(nameframf,User_namef)
        i.putExtra(addressfram,User_addressf)
        i.putExtra(areafram,User_area)

        i.putExtra(Ricef,all_Rice)
        i.putExtra(Typef,all_Typef)
        i.putExtra(attributef,all_attributef)
        i.putExtra(Rice_quantityf,all_rice_quantity)

        i.putExtra(Dayf,User_day)
        i.putExtra(Monthf,User_month)
        i.putExtra(Yearf,User_year)

        i.putExtra(Fformula1,all_formula1)
        i.putExtra(Fformula2,all_formula2)
        i.putExtra(Fformula3,all_formula3)

        i.putExtra(Mfertilizer1,all_Mfertilizer1)
        i.putExtra(Mfertilizer2,all_Mfertilizer2)
        i.putExtra(Mfertilizer3,all_Mfertilizer3)
        startActivity(i)
    }
}
