package com.tiwlynaja.admin.konklav1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.tiwlynaja.admin.konklav1.chemical.Calendar_Noti
import com.tiwlynaja.admin.konklav1.chemical.Calendar_Noti2
import kotlinx.android.synthetic.main.activity_plan.*
import kotlinx.android.synthetic.main.activity_plan.Rice
import kotlinx.android.synthetic.main.activity_plan.Type

class Plan : AppCompatActivity() {

    lateinit var nameff :TextView
    lateinit var addressff:TextView
    lateinit var areaff:TextView
    lateinit var Riceff:TextView
    lateinit var Typeff:TextView
    lateinit var attributeff:TextView
    lateinit var qRice:TextView
    lateinit var dayff:TextView
    lateinit var monthff:TextView
    lateinit var yearff:TextView
    lateinit var ff1:TextView
    lateinit var ff2:TextView
    lateinit var ff3:TextView
    lateinit var mf1:TextView
    lateinit var mf2:TextView
    lateinit var mf3:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan)

        val name_Farm = intent.getStringExtra(choose_plan.name)
        var aria = intent.getStringExtra(choose_plan.Framland)
        val address = intent.getStringExtra(choose_plan.Address)
        val rice = intent.getStringExtra(choose_plan.Rice)
        val type = intent.getStringExtra(choose_plan.cultivation)
        val Attribute = intent.getStringExtra(choose_plan.Type)
        var day = intent.getStringExtra(choose_plan.Day)
        var year =intent.getStringExtra(choose_plan.Year)
        var month = intent.getStringExtra(choose_plan.Month)

        val araiInt = aria.toIntOrNull()
        namefarm.setText(name_Farm)
        nameFarm.setText(name_Farm)
        addressfarm.setText(address)
        addressFarm.setText(address)
        areaFarm.setText(aria)
        Rice.setText(rice)
        Type.setText(type)
        attribute.setText(Attribute)
        Day.setText(day)
        Month.setText(month)
        Year.setText(year)

        var sum:Float

        if (type.equals("นาดำ") && araiInt != null){
            sum = ((70.0/20.0)*araiInt).toFloat()
            quantity_rice.setText(sum.toString())
            Rice_1(araiInt)
        }
        else{
            sum = (30* araiInt!!).toFloat()
            quantity_rice.setText(sum.toString())
            Rice_2(araiInt)
        }

        calender_all.setOnClickListener {
            createplan()
        }

        qRice = findViewById(R.id.quantity_rice)

        ff1 = findViewById(R.id.formula_fertilizer_1) // สูตร
        ff2 = findViewById(R.id.formula_fertilizer_2)
        ff3 = findViewById(R.id.formula_fertilizer_3)

        mf1 = findViewById(R.id.fertilizer_1) // ปรืมาณ
        mf2 = findViewById(R.id.fertilizer_2)
        mf3 = findViewById(R.id.fertilizer_3)


        var qqRice = qRice.text.toString()
        var ff11 = ff1.text.toString()
        var ff22 = ff2.text.toString()
        var ff33 = ff3.text.toString()

        var mf11 = mf1.text.toString()
        var mf22 = mf2.text.toString()
        var mf33 = mf3.text.toString()


        edit.setOnClickListener{
            val intent = Intent(this, editFram::class.java)
                intent.putExtra(namefram,name_Farm)
                intent.putExtra(addressfram,address)
                intent.putExtra(ariafram,aria)
                intent.putExtra(Ricef,rice)
                intent.putExtra(Typef,type)
                intent.putExtra(attributef,Attribute)
                intent.putExtra(Dayf,day)
                intent.putExtra(Monthf,month)
                intent.putExtra(Yearf,year)
                intent.putExtra(Rice_quantityf,qqRice)
                intent.putExtra(Fformula1,ff11)
                intent.putExtra(Fformula2,ff22)
                intent.putExtra(Fformula3,ff33)

                intent.putExtra(Mfertilizer1,mf11)
                intent.putExtra(Mfertilizer2,mf22)
                intent.putExtra(Mfertilizer3,mf33)
            startActivity(intent)
        }
        button4.setOnClickListener {
            startActivity(Intent(this,MainPageApp::class.java))
        }

        nameff = findViewById(R.id.nameFarm)
        addressff = findViewById(R.id.addressFarm)
        areaff= findViewById(R.id.areaFarm)
        Riceff= findViewById(R.id.Rice)
        Typeff = findViewById(R.id.Type)
        attributeff = findViewById(R.id.attribute)
        dayff = findViewById(R.id.Day)
        monthff = findViewById(R.id.Month)
        yearff = findViewById(R.id.Year)

    }

     ///// @plan ลง firebase 
    private fun createplan() {
        val namefff = nameff.text.toString()
        val addressfff = addressff.text.toString()
        val areafff = areaff.text.toString()
        val Ricefff = Riceff.text.toString()
        val Typefff = Typeff.text.toString()
        val attributeff = attributeff.text.toString()
        val daySF = dayff.text.toString()
         var monthSF = monthff.text.toString()
         val yearSF = yearff.text.toString()

         var qqRice = qRice.text.toString()

        var ff11 = ff1.text.toString()
        var ff22 = ff2.text.toString()
        var ff33 = ff3.text.toString()

        var mf11 = mf1.text.toString()
        var mf22 = mf2.text.toString()
        var mf33 = mf3.text.toString()
        var d ="no"
        var product = "อยู่ระหว่างดำเนินการ"
        var dmye=""
        val userId = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/plan/$userId")
        val Idplan = ref.push().key
        val idplan = Idplan.toString()
        val plan = sentToCreateplan(Idplan.toString(),namefff,addressfff,areafff,Ricefff,Typefff,attributeff,qqRice,ff11,ff22,ff33,mf11,mf22,mf33,daySF,monthSF,yearSF,product,dmye,dmye,dmye)
        ref.child(Idplan.toString()).setValue(plan).addOnCompleteListener {
            Toast.makeText(this,"บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
            Log.d("id_input","$Idplan")

            val ref2 = FirebaseDatabase.getInstance().getReference("plan_all")
            val plan1 = sentToCreateplan(Idplan.toString(),namefff,addressfff,areafff,Ricefff,Typefff,attributeff,qqRice,ff11,ff22,ff33,mf11,mf22,mf33,daySF,monthSF,yearSF,product,dmye,dmye,dmye)
        ref2.child(Idplan.toString()).setValue(plan1).addOnCompleteListener {
            val ref3 = FirebaseDatabase.getInstance().getReference("/activity/$Idplan/")
            val statusID = ref3.push().key
            val plan0 = sentToactivity(statusID.toString(),daySF,monthSF,yearSF,d)
        ref3.child("activity0/$statusID").setValue(plan0).addOnCompleteListener {
                Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
               if (Typefff == "นาดำ"){
                   val intent = Intent(this, Calendar_Noti::class.java)
                   intent.putExtra(idFram,idplan)
                   intent.putExtra(addressfram,addressfff)
                   intent.putExtra(namefram,namefff)
                   intent.putExtra(ariafram,areafff)
                   intent.putExtra(Ricef,Ricefff)
                   intent.putExtra(Typef,Typefff)
                   intent.putExtra(attributef,attributeff)
                   intent.putExtra(Dayf,daySF)
                   intent.putExtra(Monthf,monthSF)
                   intent.putExtra(Yearf,yearSF)
                   intent.putExtra(Rice_quantityf,qqRice)
                   intent.putExtra(Fformula1,ff11)
                   intent.putExtra(Fformula2,ff22)
                   intent.putExtra(Fformula3,ff33)
                   intent.putExtra(Mfertilizer1,mf11)
                   intent.putExtra(Mfertilizer2,mf22)
                   intent.putExtra(Mfertilizer3,mf33)
                   startActivity(intent)
               }else{
                   val intent = Intent(this, Calendar_Noti2::class.java)
                   intent.putExtra(idFram,idplan)
                   intent.putExtra(addressfram,addressfff)
                   intent.putExtra(namefram,namefff)
                   intent.putExtra(ariafram,areafff)
                   intent.putExtra(Ricef,Ricefff)
                   intent.putExtra(Typef,Typefff)
                   intent.putExtra(attributef,attributeff)
                   intent.putExtra(Dayf,daySF)
                   intent.putExtra(Monthf,monthSF)
                   intent.putExtra(Yearf,yearSF)
                   intent.putExtra(Rice_quantityf,qqRice)
                   intent.putExtra(Fformula1,ff11)
                   intent.putExtra(Fformula2,ff22)
                   intent.putExtra(Fformula3,ff33)
                   intent.putExtra(Mfertilizer1,mf11)
                   intent.putExtra(Mfertilizer2,mf22)
                   intent.putExtra(Mfertilizer3,mf33)
                   startActivity(intent)
               }
                }
            }
        }
    }

    companion object{
        val sID = "id"
        val namefram = "nameFram"
        val addressfram = "addressFram"

        val ariafram = "ariafram"
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

    private fun Rice_2(araiInt: Int?) {
        var sum_f1:Float
        var sum_f2:Float
        var sum_f3:Float

        val sum_f1_1 = "46-0-0"
        val sum_f2_2 = "15-15-15"

        sum_f1 = (30.0* araiInt!!).toFloat()
        sum_f2 = (10.0* araiInt !!).toFloat()

        fertilizer_1.setText(sum_f1.toString())
        fertilizer_2.setText(sum_f2.toString())


        formula_fertilizer_1.setText(sum_f1_1)
        formula_fertilizer_2.setText(sum_f2_2)



    }

    private fun Rice_1(araiInt:Int){
        var sum_f1:Float
        var sum_f2:Float
        var sum_f3:Float
        val sum_f1_1 = "46-0-0"
        val sum_f2_2 = "16-20-0"
        val sum_f3_3 = "15-15-15"

        sum_f1 = (10.0* araiInt!!).toFloat()
        sum_f2 = (25.0* araiInt !!).toFloat()
        sum_f3 = (10.0* araiInt !!).toFloat()

        fertilizer_1.setText(sum_f1.toString())
        fertilizer_2.setText(sum_f2.toString())
        fertilizer_3.setText(sum_f3.toString())

        formula_fertilizer_1.setText(sum_f1_1)
        formula_fertilizer_2.setText(sum_f2_2)
        formula_fertilizer_3.setText(sum_f3_3)
    }


}
