package com.tiwlynaja.admin.konklav1.NOchemical

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.tiwlynaja.admin.konklav1.*
import com.tiwlynaja.admin.konklav1.chemical.L_chemical
import kotlinx.android.synthetic.main.activity_l__nochemical.*
import kotlinx.android.synthetic.main.activity_l__nochemical.imageView15
import kotlinx.android.synthetic.main.activity_plan.Day
import kotlinx.android.synthetic.main.activity_plan.Month
import kotlinx.android.synthetic.main.activity_plan.Rice
import kotlinx.android.synthetic.main.activity_plan.Type
import kotlinx.android.synthetic.main.activity_plan.Year
import kotlinx.android.synthetic.main.activity_plan.addressFarm
import kotlinx.android.synthetic.main.activity_plan.addressfarm
import kotlinx.android.synthetic.main.activity_plan.areaFarm
import kotlinx.android.synthetic.main.activity_plan.attribute
import kotlinx.android.synthetic.main.activity_plan.fertilizer_1
import kotlinx.android.synthetic.main.activity_plan.formula_fertilizer_1
import kotlinx.android.synthetic.main.activity_plan.nameFarm
import kotlinx.android.synthetic.main.activity_plan.namefarm
import kotlinx.android.synthetic.main.activity_plan.quantity_rice

class L_NOchemical : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_l__nochemical)


        val idfuu = intent.getStringExtra(LiseFramUser.idfu)
        val name_Farm = intent.getStringExtra(LiseFramUser.namefram)
        var aria = intent.getStringExtra(LiseFramUser.Framland)
        val address = intent.getStringExtra(LiseFramUser.Address)
        val rice = intent.getStringExtra(LiseFramUser.Rice)
        val type = intent.getStringExtra(LiseFramUser.cultivation)
        val Attribute = intent.getStringExtra(LiseFramUser.Type)
        var day = intent.getStringExtra(LiseFramUser.Day)
        var month = intent.getStringExtra(LiseFramUser.Month)
        var year =intent.getStringExtra(LiseFramUser.Year)
        var ff1 = intent.getStringExtra(LiseFramUser.Fformula1)
        var mf1 = intent.getStringExtra(LiseFramUser.Mfertilizer1)
        var riceq = intent.getStringExtra(LiseFramUser.Rice_quantityf)
        namefarm.setText(name_Farm)
        nameFarm.setText(name_Farm)
        ////     boby       /////////
        addressfarm.setText(address)
        addressFarm.setText(address)
        areaFarm.setText(aria)
        Rice.setText(rice)
        Type.setText(type)
        attribute.setText(Attribute)
        Day.setText(day)
        Month.setText(month)
        Year.setText(year)
        quantity_rice.setText(riceq)
        formula_fertilizer_1.setText(ff1)
        fertilizer_1.setText(mf1)

        imageView10.setOnClickListener {
            startActivity(Intent(this,MainPageApp::class.java))
        }

        imageView13.setOnClickListener {
            val  intent=Intent(this, L_edit_NOchemical::class.java)
            intent.putExtra(idfu,idfuu)
            intent.putExtra(namefram,name_Farm)
            intent.putExtra(Framland,aria)
            intent.putExtra(Address,address)
            intent.putExtra(cultivation,type)
            intent.putExtra(typelf,Attribute)
            intent.putExtra(Daylf,day)
            intent.putExtra(Monthlf,month)
            intent.putExtra(Yearlf,year)
            intent.putExtra(Rice_quantitylf,riceq)
            intent.putExtra(Ricelf,rice)
            intent.putExtra(Fformula1lf,ff1)
            intent.putExtra(Mfertilizer1lf,mf1)
            startActivity(intent)
        }
        imageView46.setOnClickListener {
            if(Attribute == "นาดำ"){
                val  intent=Intent(this, Noti_nochemical::class.java)
                intent.putExtra(idfu,idfuu)
                intent.putExtra(namefram,name_Farm)
                intent.putExtra(Framland,aria)
                intent.putExtra(Address,address)
                intent.putExtra(cultivation,type)
                intent.putExtra(typelf,Attribute)
                intent.putExtra(Daylf,day)
                intent.putExtra(Monthlf,month)
                intent.putExtra(Yearlf,year)
                intent.putExtra(Rice_quantitylf,riceq)
                intent.putExtra(Ricelf,rice)
                intent.putExtra(Fformula1lf,ff1)
                intent.putExtra(Mfertilizer1lf,mf1)
                startActivity(intent)
            }else{
                val  intent=Intent(this, Noti_nochemical2::class.java)
                intent.putExtra(idfu,idfuu)
                intent.putExtra(namefram,name_Farm)
                intent.putExtra(Framland,aria)
                intent.putExtra(Address,address)
                intent.putExtra(cultivation,type)
                intent.putExtra(typelf,Attribute)
                intent.putExtra(Daylf,day)
                intent.putExtra(Monthlf,month)
                intent.putExtra(Yearlf,year)
                intent.putExtra(Rice_quantitylf,riceq)
                intent.putExtra(Ricelf,rice)
                intent.putExtra(Fformula1lf,ff1)
                intent.putExtra(Mfertilizer1lf,mf1)
                startActivity(intent)
            }

        }
        imageView15.setOnClickListener {
            var userId = FirebaseAuth.getInstance().uid
            val del_DB_plan = FirebaseDatabase.getInstance().getReference("plan/$userId")
            del_DB_plan.child("$idfuu").removeValue()
            val all_del_DB = FirebaseDatabase.getInstance().getReference("plan_all")
            all_del_DB.child("$idfuu").removeValue()
            val activity_dal =FirebaseDatabase.getInstance().getReference("activity")
            activity_dal.child("$idfuu").removeValue()
            Toast.makeText(this,"Del", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainPageApp::class.java)
            startActivity(intent)
        }
        kill.setOnClickListener {
            startActivity(Intent(this, lisePaet::class.java))
        }

        imageView47.setOnClickListener {
            val i =Intent(this,liseRice::class.java)
            i.putExtra(L_chemical.Address,address)
            startActivity(i)
        }

        println(type +"----"+ Attribute)
        imageView48.setOnClickListener {
           if (type == "ใช้สารเคมี"){
               val fs = "เคมี"
               val i =Intent(this,list_fertilizer::class.java)
               i.putExtra(L_chemical.Fformula,fs)
               i.putExtra(L_chemical.Address,address)
               startActivity(i)
           }else{
               val fs = "คอก"
               val i =Intent(this,list_fertilizer::class.java)
               i.putExtra(L_chemical.Fformula,fs)
               i.putExtra(L_chemical.Address,address)
               startActivity(i)
           }
        }
    }
    companion object{
        var idfu = "idfu"
        var namefram = "namefram"
        var Framland = "Fraland"
        var Address = "address_Farm"
        var Ricelf = "Rice"
        var cultivation = "Cultivation"
        var typelf = "Type"
        var Daylf = "day"
        var Monthlf = "month"
        var Yearlf = "year"
        var Rice_quantitylf = "Rice_quantityf"
        var Fformula1lf = "Fformula1"
        var Mfertilizer1lf = "Mfertilizer1"
    }
}
