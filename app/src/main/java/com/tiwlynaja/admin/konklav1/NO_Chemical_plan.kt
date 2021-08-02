package com.tiwlynaja.admin.konklav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.tiwlynaja.admin.konklav1.NOchemical.Calendar_Noti_chemical
import com.tiwlynaja.admin.konklav1.NOchemical.Calendar_Noti_chemical2
import kotlinx.android.synthetic.main.activity_plan.*

class NO_Chemical_plan : AppCompatActivity() {


    lateinit var riceq :TextView
    lateinit var fertilizer:TextView
    lateinit var mfertilizer:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chemical_plan)

        riceq = findViewById(R.id.quantity_rice)
        fertilizer = findViewById(R.id.formula_fertilizer_1)
        mfertilizer = findViewById(R.id.fertilizer_1)
        val name_Farm = intent.getStringExtra(choose_plan.name)
        var aria = intent.getStringExtra(choose_plan.Framland)
        val address = intent.getStringExtra(choose_plan.Address)
        val rice = intent.getStringExtra(choose_plan.Rice)
        val type = intent.getStringExtra(choose_plan.cultivation)
        val Attribute = intent.getStringExtra(choose_plan.Type)
        var day = intent.getStringExtra(choose_plan.Day)
        var month = intent.getStringExtra(choose_plan.Month)
        var year =intent.getStringExtra(choose_plan.Year)
        ///////  header ///
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

        var area = aria.toInt()

        var af = area*650
        val ff = "ปุ๋ยคอก"
        formula_fertilizer_1.setText(ff)
        fertilizer_1.setText(af.toString())

        if (rice == "นำดำ"){
            a01(area)
        }else {
            a02(area)
        }
        val riceqq = riceq.text.toString()
        val ff1 = fertilizer.text.toString()
        val mf1 = mfertilizer.text.toString()


       calender_all.setOnClickListener {
            settoDB(name_Farm,address,aria,rice,type,Attribute,riceqq,ff1,mf1,day,month,year)
        }

        edit.setOnClickListener {
        val intent = Intent(this, edit_noChemical_plan::class.java)
            intent.putExtra(namefram,name_Farm)
            intent.putExtra(addressfram,address)
            intent.putExtra(areafram,aria)
            intent.putExtra(Ricef,rice)
            intent.putExtra(Typef,type)
            intent.putExtra(attributef,Attribute)
            intent.putExtra(Dayf,day)
            intent.putExtra(Monthf,month)
            intent.putExtra(Yearf,year)
            intent.putExtra(Rice_quantityf,riceqq)
            intent.putExtra(Fformula1,ff)
            intent.putExtra(Mfertilizer1,mf1)
            startActivity(intent)
        }
        button4.setOnClickListener {
            startActivity(Intent(this,MainPageApp::class.java))
        }

    }
    companion object{
        val namefram = "nameFram"
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
        val Mfertilizer1 = "Mfertilizer1" // ปริมาณปุ๋ย
        val idFram = "idfram"
        val ida00 = "ida00"
    }
    private fun a02(area: Int) {
        var a = 30*area
        quantity_rice.setText(a.toString())
    }

    private fun a01(area: Int) {
        var a = (70/20)*area
        quantity_rice.setText(a.toString())
    }

    private fun settoDB(nameFarm: String, address: String, aria: String, rice: String, type: String, attribute: String, riceqq: String, ff1: String, mf1: String, day: String, month: String, year: String) {
        var d ="no"
        var ff2 = ""
        var ff3 = ""
        var mf2 = ""
        var mf3 = ""
        var product = "อยู่ระหว่างดำเนินการ"
        var dmye=""
        val userId = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/plan/$userId")
        val Idplan = ref.push().key
        val idplan = Idplan.toString()
        val plan = sentToCreateplan(Idplan.toString(),nameFarm,address,aria,rice,type,attribute,riceqq,ff1,ff2,ff3,mf1,mf2,mf3,day,month,year,product,dmye,dmye,dmye)
        ref.child(Idplan.toString()).setValue(plan).addOnCompleteListener {
            Toast.makeText(this,"บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
            Log.d("id_input","$Idplan")
            val ref2 = FirebaseDatabase.getInstance().getReference("plan_all")
            val plan1 = sentToCreateplan(Idplan.toString(),nameFarm,address,aria,rice,type,attribute,riceqq,ff1,ff2,ff3,mf1,mf2,mf3,day,month,year,product,dmye,dmye,dmye)
            ref2.child(Idplan.toString()).setValue(plan1).addOnCompleteListener {
                val ref3 = FirebaseDatabase.getInstance().getReference("/activity/$Idplan/")
                val statusID = ref3.push().key
                val ida000 = statusID.toString()
                val plan0 = sentToactivity(statusID.toString(),day,month,year,d)
                ref3.child("activity0/$statusID").setValue(plan0).addOnCompleteListener {

                    if (type == "นาดำ"){
                        val intent = Intent(this, Calendar_Noti_chemical::class.java)
                        intent.putExtra(idFram,Idplan)
                        intent.putExtra(namefram,nameFarm)
                        intent.putExtra(addressfram,address)
                        intent.putExtra(ida00,ida000)

                        intent.putExtra(areafram,aria)
                        intent.putExtra(Ricef,rice)
                        intent.putExtra(Typef,type)
                        intent.putExtra(attributef,attribute)
                        intent.putExtra(Dayf,day)
                        intent.putExtra(Monthf,month)
                        intent.putExtra(Yearf,year)
                        intent.putExtra(Rice_quantityf,riceqq)
                        intent.putExtra(Fformula1,ff1)
                        intent.putExtra(Mfertilizer1,mf1)
                        startActivity(intent)
                    }else{
                        val intent = Intent(this, Calendar_Noti_chemical2::class.java)
                        intent.putExtra(idFram,Idplan)
                        intent.putExtra(namefram,nameFarm)
                        intent.putExtra(addressfram,address)
                        intent.putExtra(ida00,ida000)

                        intent.putExtra(areafram,aria)
                        intent.putExtra(Ricef,rice)
                        intent.putExtra(Typef,type)
                        intent.putExtra(attributef,attribute)
                        intent.putExtra(Dayf,day)
                        intent.putExtra(Monthf,month)
                        intent.putExtra(Yearf,year)
                        intent.putExtra(Rice_quantityf,riceqq)
                        intent.putExtra(Fformula1,ff1)
                        intent.putExtra(Mfertilizer1,mf1)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}
