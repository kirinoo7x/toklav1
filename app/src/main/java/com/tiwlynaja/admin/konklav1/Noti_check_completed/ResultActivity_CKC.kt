package com.tiwlynaja.admin.konklav1.Noti_check_completed

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.tiwlynaja.admin.konklav1.LiseFramUser
import com.tiwlynaja.admin.konklav1.NOchemical.Calendar_Noti_chemical
import com.tiwlynaja.admin.konklav1.R
import com.tiwlynaja.admin.konklav1.sentToCreateplan
import com.tiwlynaja.admin.konklav1.sentToactivity
import kotlinx.android.synthetic.main.activity_check_rice.*
import kotlinx.android.synthetic.main.activity_check_rice.addressfarm
import kotlinx.android.synthetic.main.activity_check_rice.past
import kotlinx.android.synthetic.main.activity_check_rice.sender
import kotlinx.android.synthetic.main.activity_completed.*
import kotlinx.android.synthetic.main.activity_planting_activities.*
import kotlinx.android.synthetic.main.activity_planting_activities.activity
import kotlinx.android.synthetic.main.activity_planting_activities.name_activity
import kotlinx.android.synthetic.main.activity_planting_activities.namefarm
import java.util.*
import android.widget.Toast.makeText as makeText1
import kotlinx.android.synthetic.main.activity_check_rice.namefarm as namefarm1
import kotlinx.android.synthetic.main.activity_completed.sender2 as sender21
import kotlinx.android.synthetic.main.activity_planting_activities.addressfarm as addressfarm1

class ResultActivity_CKC: AppCompatActivity() {
    lateinit var option_day  : Spinner
    lateinit var option_month : Spinner
    lateinit var option_year : Spinner
    lateinit var pp2 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completed)
        pp2 = findViewById(R.id.completed)

        if (intent.getBooleanExtra("notification", false)) { //Just for confirmation
            name_activity.text = intent.getStringExtra("title")
            activity.text = intent.getStringExtra("message")

        }
        val ida = intent.getStringExtra("id")
        val idf = intent.getStringExtra("idf")
        val a = intent.getStringExtra("aty")
        val nettx = intent.getStringExtra("netx")

        sender.setImageResource(R.drawable.but32)
        sender2.setImageResource(R.drawable.but26)
        past.setImageResource(R.drawable.but27)

        past.setOnClickListener {
            val nexttt = "1"
            past_fram(idf, a, ida, nexttt.toInt())
        }
        sender.setOnClickListener {
            val nexttt = "1"
            past_fram(idf, a, ida, nexttt.toInt())
        }

        setname(idf)

        var cout =0
        sender2.setOnClickListener {
            cout++
            if (cout == 1){
                setDB(idf, a, ida)
            }else{
                comple(idf)
                makeText1(this, "กดอีกครั้งเพื่อยืนยัน", Toast.LENGTH_SHORT).show()
            }

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



    private fun setname(idf: String) {
        var ref = FirebaseDatabase.getInstance().getReference("plan_all/")
        ref.orderByChild("/id/").equalTo(idf).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children.forEach{
                    val namefram:String = it.child("nameFram").getValue().toString()
                    val address:String = it.child("addressFram").getValue().toString()

                    namefarm.setText(namefram)
                    addressfarm.setText(address)
                    println(namefram)
                    println(address)
                }

            }


        })

    }
    private fun setDB(id: String, a: String, ida:String) {
        val aa = "activity"+a
        var create_DayS = option_day.selectedItem.toString()
        var create_MonthS = option_month.selectedItem.toString()
        var create_YearS = option_year.selectedItem.toString()
        var create_pp = pp2.text.toString()
        if (create_DayS.equals("วันที่") || create_MonthS.equals("เดือน") || create_YearS.equals("ปี")|| create_pp.isEmpty()) {
            makeText1(this, "กรุณากรอกข้อมูลให้ครบ.", Toast.LENGTH_SHORT).show()
            return
        } else {
            val d = "yes"
            val ref = FirebaseDatabase.getInstance().getReference("activity/$id/")
            val plan = sentToactivity(ida, create_DayS, create_MonthS, create_YearS, d)
            ref.child("/$aa/$ida").setValue(plan).addOnCompleteListener {
                Log.d("Detail_input", "Upload All DATA SS")
                makeText1(this, "กดอีกครั้งเพื่อยืนยัน", Toast.LENGTH_SHORT).show()
                Log.d("Detail_input", "$id")
            }
        }

    }
    private fun comple(id: String) {
        var ref1 = FirebaseDatabase.getInstance().getReference("plan_all/")
        ref1.orderByChild("/id").equalTo(id).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children.forEach{
                        val namef:String = it.child("nameFram").getValue().toString()
                        val addressff:String = it.child("addressFram").getValue().toString()
                        val areaf:String = it.child("area").getValue().toString()
                        val type :String = it.child("type").getValue().toString()
                        val attributes:String = it.child("attributes").getValue().toString()
                        val rice :String = it.child("rice").getValue().toString()
                        val riceq :String = it.child("quantity").getValue().toString()
                        val fff :String = it.child("ff1").getValue().toString()
                        val ff2 :String = it.child("ff2").getValue().toString()
                        val ff3 :String = it.child("ff3").getValue().toString()
                        val mff :String = it.child("mf1").getValue().toString()
                        val mf2 :String = it.child("mf2").getValue().toString()
                        val mf3 :String = it.child("mf3").getValue().toString()

                        val day :String = it.child("days").getValue().toString()
                        val monthf :String = it.child("months").getValue().toString()
                        val year :String = it.child("years").getValue().toString()

                    sender2.setOnClickListener {
                        setBDcomple(id,namef,addressff,areaf,rice,type,attributes,riceq,fff,ff2,ff3,mff,mf2,mf3,day,monthf,year)
                    }

                    }


            }


        })
    }

    private fun setBDcomple(id: String, namef: String, addressff: String, areaf: String, rice: String, type: String, attributes: String, riceq: String, fff: String, t: String, t1: String, mff: String, t2: String, t3: String, day: String, monthf: String, year: String) {
        var create_DayS = option_day.selectedItem.toString()
        var create_MonthS = option_month.selectedItem.toString()
        var create_YearS = option_year.selectedItem.toString()
        var create_pp = pp2.text.toString()
        if (create_DayS.equals("วันที่") || create_MonthS.equals("เดือน") || create_YearS.equals("ปี")|| create_pp.isEmpty()) {
            makeText1(this, "กรุณากรอกข้อมูลให้ครบ.", Toast.LENGTH_SHORT).show()
            return
        } else {
            create_pp+"kg"
        var userId = FirebaseAuth.getInstance().uid

        val ref = FirebaseDatabase.getInstance().getReference("plan/$userId/")
        val plan = sentToCreateplan(id,namef,addressff,areaf,rice,type,attributes,riceq,fff,t,t1,mff,t2,t3,day,monthf,year,create_pp,create_DayS.toString(),create_MonthS,create_YearS.toString())
        ref.child(id).setValue(plan).addOnCompleteListener {
            val ref2 = FirebaseDatabase.getInstance().getReference("plan_all/")
            val plan = sentToCreateplan(id,namef,addressff,areaf,rice,type,attributes,riceq,fff,t,t1,mff,t2,t3,day,monthf,year,create_pp,create_DayS.toString(),create_MonthS,create_YearS.toString())
            ref2.child(id).setValue(plan).addOnCompleteListener {
                Log.d("Detail_input", "Upload All DATA SS")
                Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                finish()
            }
            }

        }

    }

    private fun past_fram(idf: String, a: String, ida: String, net: Int) {
        val aa = "activity"+a
        val calendar = Calendar.getInstance()
        val create_DayS =calendar.get(Calendar.DAY_OF_MONTH)+1
        val m =calendar.get(Calendar.MONTH)
        val create_YearS =calendar.get(Calendar.YEAR)

        var months = ""
        when(m.toString()){
            "0" -> months = "มกราคม"
            "1"-> months = "กุมภาพันธ์"
            "2" -> months = "มีนาคม"
            "3" -> months = "เมษายน"
            "4" -> months = "พฤษภาคม"
            "5" -> months = "มิถุนายน"
            "6" -> months = "กรกฎาคม"
            "7" -> months = "สิงหาคม"
            "8" -> months = "กันยายน"
            "9" -> months = "ตุลาคม"
            "10" -> months = "พฤศจิกายน"
            "11" -> months = "ธันวาคม"
        }
        var create_MonthS =months

        val d = "no"
        val ref = FirebaseDatabase.getInstance().getReference("activity/$idf/")
        val plan = sentToactivity(ida, create_DayS.toString(), create_MonthS, create_YearS.toString(), d)
        ref.child("/$aa/$ida").setValue(plan).addOnCompleteListener {
            Log.d("Detail_input", "Upload All DATA SS")
            Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
            Log.d("Detail_input", "$idf")
            calculate_Date2(idf,a,create_DayS,create_MonthS,create_YearS,net,ida)
        }

    }
    private fun calculate_Date2(id: String, a: String,create_DayS:Int,create_MonthS:String,create_YearS:Int,net:Int,ida: String){
        var months = 0
        when(create_MonthS){
            "มกราคม" -> months = 1
            "กุมภาพันธ์"-> months = 2
            "มีนาคม" -> months = 3
            "เมษายน" -> months = 4
            "พฤษภาคม" -> months = 5
            "มิถุนายน" -> months = 6
            "กรกฎาคม" -> months = 7
            "สิงหาคม" -> months = 8
            "กันยายน" -> months = 9
            "ตุลาคม" -> months = 10
            "พฤศจิกายน" -> months = 11
            "ธันวาคม" -> months = 12
        }

        var dd = create_DayS +net


        if (months == 4 || months == 6 || months == 9 || months == 11){
            var monthCK = 30
            settime2(id,a,monthCK, dd, months, create_YearS,ida)
        }
        else if (months == 2){
            if (create_YearS%4==0){
                var monthCK = 29
                settime2(id,a,monthCK, dd, months, create_YearS,ida)
            }
            else{
                var monthCK = 28
                settime2(id,a,monthCK, dd, months, create_YearS,ida)
            }
        }
        else if(months % 4 == 0){
            var monthCK = 29
            settime2(id,a,monthCK, dd, months, create_YearS,ida)
        }
        else{
            var monthCK = 31
            settime2(id,a,monthCK, dd, months, create_YearS,ida)
        }
    }
    private fun settime2(id: String,a: String,monthCK: Int, d: Int, months: Int, y: Int,ida: String){
        if (d <= monthCK){
            setnoti2(id,a,d.toString(),months.toString(),y.toString(),ida)
        }else{
            val m =months + 1
            if (m <= 12 ){
                var dd = (d+monthCK)-monthCK*2
                setnoti2(id,a,dd.toString(),m.toString(),y.toString(),ida)
            }else{
                val yy=y + 1
                var mm = m - 12
                var dd = (d+monthCK)-monthCK*2
                setnoti2(id,a,dd.toString(),mm.toString(),yy.toString(),ida)
            }
        }
    }

    private fun setnoti2(id: String, a: String,create_DayS:String, create_Month:String, create_YearS:String,ida: String) {
        var create_MonthS = ""
        when(create_Month){
            "1" -> create_MonthS = "มกราคม"
            "2"-> create_MonthS = "กุมภาพันธ์"
            "3" -> create_MonthS = "มีนาคม"
            "4" -> create_MonthS = "เมษายน"
            "5" -> create_MonthS = "พฤษภาคม"
            "6" -> create_MonthS = "มิถุนายน"
            "7" -> create_MonthS = "กรกฎาคม"
            "8" -> create_MonthS = "สิงหาคม"
            "9" -> create_MonthS = "กันยายน"
            "10" -> create_MonthS= "ตุลาคม"
            "11" -> create_MonthS = "พฤศจิกายน"
            "12" -> create_MonthS = "ธันวาคม"
        }

        println(create_DayS)
        println(create_MonthS)
        println(create_YearS)


        val aa ="activity"+a
        val d = "no"
        val ref = FirebaseDatabase.getInstance().getReference("activity/$id/")

        if (ida == ""){
            val plan = sentToactivity(ida, create_DayS, create_MonthS, create_YearS, d)
            ref.child("/$aa/$ida").setValue(plan).addOnCompleteListener {
                Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()

            }
        }
        finish()
    }
}