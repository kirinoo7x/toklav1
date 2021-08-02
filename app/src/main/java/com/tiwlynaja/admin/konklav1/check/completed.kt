package com.tiwlynaja.admin.konklav1.check

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.tiwlynaja.admin.konklav1.LiseFramUser
import com.tiwlynaja.admin.konklav1.NOchemical.Calendar_Noti_chemical
import com.tiwlynaja.admin.konklav1.NOchemical.Noti_nochemical
import com.tiwlynaja.admin.konklav1.R
import com.tiwlynaja.admin.konklav1.sentToCreateplan
import com.tiwlynaja.admin.konklav1.sentToactivity
import kotlinx.android.synthetic.main.activity_check_rice.sender
import kotlinx.android.synthetic.main.activity_planting_activities.activity
import kotlinx.android.synthetic.main.activity_planting_activities.addressfarm
import kotlinx.android.synthetic.main.activity_planting_activities.name_activity
import kotlinx.android.synthetic.main.activity_planting_activities.namefarm

class completed : AppCompatActivity() {
    lateinit var option_day: Spinner
    lateinit var option_month: Spinner
    lateinit var option_year: Spinner
    lateinit var pp :TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completed)
        pp = findViewById(R.id.completed)

        val id_ck = intent.getStringExtra(Calendar_Noti_chemical.idAf)

        sender.setImageResource(R.drawable.but26)
        if (id_ck != null) {
            val nf = intent.getStringExtra(Calendar_Noti_chemical.name_ff)
            val addf = intent.getStringExtra(Calendar_Noti_chemical.address_ff)
            val id = intent.getStringExtra(Calendar_Noti_chemical.idAf)
            val a = intent.getStringExtra(Calendar_Noti_chemical.activityf)
            val an = intent.getStringExtra(Calendar_Noti_chemical.intro)
            val an_i = intent.getStringExtra(Calendar_Noti_chemical.intro_i)
            val coutt = intent.getStringExtra(Calendar_Noti_chemical.coutA)
            val ida = intent.getStringExtra(Calendar_Noti_chemical.ida00)
            val nettx = intent.getStringExtra(Calendar_Noti_chemical.netxx)
            namefarm.setText(nf)
            addressfarm.setText(addf)

            name_activity.setText(an)
            activity.setText(an_i)

            sender.setOnClickListener {
                setDB(id, a, ida, nettx.toInt(),nf,addf)
            }

        }else{
            val nf = intent.getStringExtra(Noti_nochemical.name_ff)
            val addf = intent.getStringExtra(Noti_nochemical.address_ff)
            val id = intent.getStringExtra(Noti_nochemical.idAf)
            val a = intent.getStringExtra(Noti_nochemical.activityf)
            val an = intent.getStringExtra(Noti_nochemical.intro)
            val an_i = intent.getStringExtra(Noti_nochemical.intro_i)
            val coutt = intent.getStringExtra(Noti_nochemical.coutA)
            val ida = intent.getStringExtra(Noti_nochemical.ida00)
            val nettx = intent.getStringExtra(Noti_nochemical.netxx)
            namefarm.setText(nf)
            addressfarm.setText(addf)

            name_activity.setText(an)
            activity.setText(an_i)

        }

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
        var areaF = intent.getStringExtra(Calendar_Noti_chemical.areafram)
        var riceF = intent.getStringExtra(Calendar_Noti_chemical.Ricef)
        var typef = intent.getStringExtra(Calendar_Noti_chemical.Typef)
        var attributef = intent.getStringExtra(Calendar_Noti_chemical.Attributef)
        var dayF = intent.getStringExtra(Calendar_Noti_chemical.Dayf)
        var monthF = intent.getStringExtra(Calendar_Noti_chemical.Monthf)
        var yearF = intent.getStringExtra(Calendar_Noti_chemical.Yearf)
        var Rice_quanF = intent.getStringExtra(Calendar_Noti_chemical.Rice_quantityf)
        var Ff1 = intent.getStringExtra(Calendar_Noti_chemical.Fformula1)
        var Mf1 = intent.getStringExtra(Calendar_Noti_chemical.Mfertilizer1)
        var t=""
        PP+"kg"
        if (areaF == null){
            comple2(id,create_DayS,create_MonthS,create_YearS,PP,nf,addf)
        }else{
            var userId = FirebaseAuth.getInstance().uid
            val ref = FirebaseDatabase.getInstance().getReference("plan/$userId/")
            val plan = sentToCreateplan(id, nf, addf, areaF, riceF, typef, attributef, Rice_quanF, Ff1, t, t, Mf1, t, t, dayF, monthF, yearF, PP, create_DayS.toString(), create_MonthS, create_YearS.toString())
            ref.child(id).setValue(plan).addOnCompleteListener {

                val ref2 = FirebaseDatabase.getInstance().getReference("plan_all/")
                val plan = sentToCreateplan(id, nf, addf, areaF, riceF, typef, attributef, Rice_quanF, Ff1, t, t, Mf1, t, t, dayF, monthF, yearF, PP, create_DayS.toString(), create_MonthS, create_YearS.toString())
                ref2.child(id).setValue(plan).addOnCompleteListener {
                    Log.d("Detail_input", "Upload All DATA SS")
                    Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, LiseFramUser::class.java)
                    startActivity(intent)
                }

            }
        }

    }

    private fun comple2(id:String,create_DayS: Int,create_MonthS: String,create_YearS: Int,PP: String,nf:String,addf:String) {
        var areaF = intent.getStringExtra(Noti_nochemical.areafram)
        var riceF = intent.getStringExtra(Noti_nochemical.Ricef)
        var typef = intent.getStringExtra(Noti_nochemical.Typef)
        var attributef = intent.getStringExtra(Noti_nochemical.Attributef)
        var dayF = intent.getStringExtra(Noti_nochemical.Dayf)
        var monthF = intent.getStringExtra(Noti_nochemical.Monthf)
        var yearF = intent.getStringExtra(Noti_nochemical.Yearf)
        var Rice_quanF = intent.getStringExtra(Noti_nochemical.Rice_quantityf)
        var Ff1 = intent.getStringExtra(Noti_nochemical.Fformula1)
        var Mf1 = intent.getStringExtra(Noti_nochemical.Mfertilizer1)
        var t=""
        PP+"kg"
        println(areaF+riceF+typef)
        var userId = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("plan/$userId/")
        val plan = sentToCreateplan(id, nf, addf, areaF, riceF, typef, attributef, Rice_quanF, Ff1, t, t, Mf1, t, t, dayF, monthF, yearF, PP, create_DayS.toString(), create_MonthS, create_YearS.toString())
        ref.child(id).setValue(plan).addOnCompleteListener {

            val ref2 = FirebaseDatabase.getInstance().getReference("plan_all/")
            val plan = sentToCreateplan(id, nf, addf, areaF, riceF, typef, attributef, Rice_quanF, Ff1, t, t, Mf1, t, t, dayF, monthF, yearF, PP, create_DayS.toString(), create_MonthS, create_YearS.toString())
            ref2.child(id).setValue(plan).addOnCompleteListener {
                Log.d("Detail_input", "Upload All DATA SS")
                Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LiseFramUser::class.java)
                startActivity(intent)
            }

        }
    }

}
