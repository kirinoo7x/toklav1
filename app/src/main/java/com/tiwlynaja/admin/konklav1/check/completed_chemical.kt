package com.tiwlynaja.admin.konklav1.check

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.tiwlynaja.admin.konklav1.*
import com.tiwlynaja.admin.konklav1.chemical.Calendar_Noti
import kotlinx.android.synthetic.main.activity_completed.activity
import kotlinx.android.synthetic.main.activity_completed.addressfarm
import kotlinx.android.synthetic.main.activity_completed.name_activity
import kotlinx.android.synthetic.main.activity_completed.namefarm
import kotlinx.android.synthetic.main.activity_completed.sender

class completed_chemical : AppCompatActivity() {
    lateinit var option_day: Spinner
    lateinit var option_month: Spinner
    lateinit var option_year: Spinner
    lateinit var pp : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completed)

        pp = findViewById(R.id.completed)


        val nf = intent.getStringExtra(Calendar_Noti.name_ff)
        val addf = intent.getStringExtra(Calendar_Noti.address_ff)
        val id = intent.getStringExtra(Calendar_Noti.idAf)
        val a = intent.getStringExtra(Calendar_Noti.activityf)
        val an = intent.getStringExtra(Calendar_Noti.intro)
        val an_i = intent.getStringExtra(Calendar_Noti.intro_i)
        val coutt = intent.getStringExtra(Calendar_Noti.coutA)
        val ida = intent.getStringExtra(Calendar_Noti.ida00)
        val nettx = intent.getStringExtra(Calendar_Noti.netxx)
        namefarm.setText(nf)
        addressfarm.setText(addf)

        name_activity.setText(an)
        activity.setText(an_i)

        sender.setOnClickListener {
            setDB(id, a, ida, nettx.toInt(),nf,addf)
        }

        sender.setImageResource(R.drawable.but26)
        option_day = findViewById(R.id.day) as Spinner
        val option_days = arrayListOf("วันที่", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31")
        option_day.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_days)
        option_day.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

        //choose month
        option_month = findViewById(R.id.month) as Spinner
        val option_months = arrayListOf("เดือน", "มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม")
        option_month.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_months)
        option_month.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
        // choose year
        option_year = findViewById(R.id.year) as Spinner
        val option_years = arrayListOf("ปี", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040")
        option_year.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_years)
        option_year.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

    }
    private fun setDB(id: String, a: String, ida:String,net:Int,nf:String,addf:String) {
        val aa = "activity"+a
        var create_DayS = option_day.selectedItem.toString()
        var create_MonthS = option_month.selectedItem.toString()
        var create_YearS = option_year.selectedItem.toString()
        var create_pp = pp.text.toString()
        if (create_DayS.equals("วันที่") || create_MonthS.equals("เดือน") || create_YearS.equals("ปี")|| create_pp.isEmpty()) {
            Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบ.", Toast.LENGTH_SHORT).show()
            return
        } else {
            val d = "yes"
            val ref = FirebaseDatabase.getInstance().getReference("activity/$id/")
            val plan = sentToactivity(
                ida,
                create_DayS,
                create_MonthS,
                create_YearS,
                d
            )
            ref.child("/$aa/$ida").setValue(plan).addOnCompleteListener {
                Log.d("Detail_input", "Upload All DATA SS")
                Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                Log.d("Detail_input", "$id")
                comple(id,a,create_DayS.toInt(),create_MonthS,create_YearS.toInt(),create_pp,nf,addf)
            }
        }

    }
    private fun comple(id: String, a: String,create_DayS:Int,create_MonthS:String,create_YearS:Int,PP:String,nf:String,addf:String) {
        var areaF = intent.getStringExtra(Calendar_Noti.areafram)
        var riceF = intent.getStringExtra(Calendar_Noti.Ricef)
        var typef = intent.getStringExtra(Calendar_Noti.Typef)
        var attributef = intent.getStringExtra(Calendar_Noti.Attributef)
        var dayF = intent.getStringExtra(Calendar_Noti.Dayf)
        var monthF = intent.getStringExtra(Calendar_Noti.Monthf)
        var yearF = intent.getStringExtra(Calendar_Noti.Yearf)
        var Rice_quanF = intent.getStringExtra(Calendar_Noti.Rice_quantityf)
        var Ff1 = intent.getStringExtra(Calendar_Noti.Fformula1)
        var Ff2 = intent.getStringExtra(Calendar_Noti.Fformula2)
        var Ff3 = intent.getStringExtra(Calendar_Noti.Fformula3)
        var Mf1 = intent.getStringExtra(Calendar_Noti.Mfertilizer1)
        var Mf2 = intent.getStringExtra(Calendar_Noti.Mfertilizer2)
        var Mf3 = intent.getStringExtra(Calendar_Noti.Mfertilizer3)


        var userId = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("plan/$userId/")
        val plan = sentToCreateplan(
            id,
            nf,
            addf,
            areaF,
            riceF,
            attributef,
            typef,
            Rice_quanF,
            Ff1,
            Ff2,
            Ff3,
            Mf1,
            Mf2,
            Mf3,
            dayF,
            monthF,
            yearF,
            PP,
            create_DayS.toString(),
            create_MonthS,
            create_YearS.toString()
        )
        ref.child(id).setValue(plan).addOnCompleteListener {

            val ref2 = FirebaseDatabase.getInstance().getReference("plan_all/")
            val plan = sentToCreateplan(
                id,
                nf,
                addf,
                areaF,
                riceF,
                attributef,
                typef,
                Rice_quanF,
                Ff1,
                Ff2,
                Ff3,
                Mf1,
                Mf2,
                Mf3,
                dayF,
                monthF,
                yearF,
                PP,
                create_DayS.toString(),
                create_MonthS,
                create_YearS.toString()
            )
            ref2.child(id).setValue(plan).addOnCompleteListener {
                Log.d("Detail_input", "Upload All DATA SS")
                Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                finish()
            }

        }


    }

}


