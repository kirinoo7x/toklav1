package com.tiwlynaja.admin.konklav1.check


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import com.tiwlynaja.admin.konklav1.NOchemical.Calendar_Noti_chemical
import com.tiwlynaja.admin.konklav1.R
import com.tiwlynaja.admin.konklav1.sentToactivity
import kotlinx.android.synthetic.main.activity_planting_activities.activity
import kotlinx.android.synthetic.main.activity_planting_activities.addressfarm
import kotlinx.android.synthetic.main.activity_planting_activities.name_activity
import kotlinx.android.synthetic.main.activity_planting_activities.namefarm
import kotlinx.android.synthetic.main.no_chemical_n1.*

class NO_chemical_N1 : AppCompatActivity() {
    lateinit var option_day: Spinner
    lateinit var option_month: Spinner
    lateinit var option_year: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.no_chemical_n1)

        val nf = intent.getStringExtra(Calendar_Noti_chemical.name_ff)
        val addf = intent.getStringExtra(Calendar_Noti_chemical.address_ff)
        val id = intent.getStringExtra(Calendar_Noti_chemical.idAf)
        val a = intent.getStringExtra(Calendar_Noti_chemical.activityf)
        val an = intent.getStringExtra(Calendar_Noti_chemical.intro)
        val an_i = intent.getStringExtra(Calendar_Noti_chemical.intro_i)
        val coutt = intent.getStringExtra(Calendar_Noti_chemical.coutA)
        val ida = intent.getStringExtra(Calendar_Noti_chemical.ida00)
        val nettx =intent.getStringExtra(Calendar_Noti_chemical.netxx)

        namefarm.setText(nf)
        addressfarm.setText(addf)

        name_activity.setText(an)
        activity.setText(an_i)
        println(coutt)

        sender.setImageResource(R.drawable.but26)

        sender.setOnClickListener {
            if (ida != null){
                if (coutt == "no"){
                    setDB(id, a,ida,nettx.toInt())
                }else{
                    setDB_Edit(id, a,ida,nettx.toInt())
                }
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

    private fun setDB_Edit(id: String, a: String, ida: String,nex:Int) {
        val aa = "activity"+a
        var create_DayS = option_day.selectedItem.toString()
        var create_MonthS = option_month.selectedItem.toString()
        var create_YearS = option_year.selectedItem.toString()
        if (create_DayS.equals("วันที่") || create_MonthS.equals("เดือน") || create_YearS.equals("ปี")) {
            Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบ.", Toast.LENGTH_SHORT).show()
            return
        } else {
            val d = "yes"
            val ref = FirebaseDatabase.getInstance().getReference("activity/$id")
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
                Log.d("Detail_input", "$ida")
                Dle(id,a,create_DayS.toInt(),create_MonthS,create_YearS.toInt(),nex,ida)
            }
        }

    }

    private fun Dle(id: String, a: String,create_DayS:Int,create_MonthS:String,create_YearS:Int,net:Int,ida: String) {
        var cout = a.toInt()
        val cout1 = cout+1
        val aaa ="activity"+cout1.toString()
        println("+++++++++++++++++++++++++++++++++++++++++++++++"+aaa)
        val del_DB = FirebaseDatabase.getInstance().getReference("activity/$id")
        del_DB.child("/$aaa/").removeValue()
        calculate_Date(id,a,create_DayS,create_MonthS,create_YearS,net,ida)
    }

    private fun setDB(id: String, a: String, ida:String,net:Int) {
        val aa = "activity"+a
        var create_DayS = option_day.selectedItem.toString()
        var create_MonthS = option_month.selectedItem.toString()
        var create_YearS = option_year.selectedItem.toString()
        if (create_DayS.equals("วันที่") || create_MonthS.equals("เดือน") || create_YearS.equals("ปี")) {
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
                calculate_Date(id,a,create_DayS.toInt(),create_MonthS,create_YearS.toInt(),net,ida)
            }
        }

    }

    private fun calculate_Date(id: String, a: String,create_DayS:Int,create_MonthS:String,create_YearS:Int,net:Int,ida: String){
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
            settime(id,a,monthCK, dd, months, create_YearS,ida)
        }
        else if (months == 2){
            if (create_YearS%4==0){
                var monthCK = 29
                settime(id,a,monthCK, dd, months, create_YearS,ida)
            }
            else{
                var monthCK = 28
                settime(id,a,monthCK, dd, months, create_YearS,ida)
            }
        }
        else if(months % 4 == 0){
            var monthCK = 29
            settime(id,a,monthCK, dd, months, create_YearS,ida)
        }
        else{
            var monthCK = 31
            settime(id,a,monthCK, dd, months, create_YearS,ida)
        }
    }
    private fun settime(id: String,a: String,monthCK: Int, d: Int, months: Int, y: Int,ida: String){
        println("-----------------------"+d+"----------------------"+monthCK)
        if (d <= monthCK){
            setnoti(id,a,d.toString(),months.toString(),y.toString(),ida)
        }else{
            val m =months + 1
            if (m <= 12 ){
                var dd = (d+monthCK)-monthCK*2
                setnoti(id,a,dd.toString(),m.toString(),y.toString(),ida)
            }else{
                val yy=y + 1
                var mm = m - 12
                var dd = (d+monthCK)-monthCK*2
                setnoti(id,a,dd.toString(),mm.toString(),yy.toString(),ida)
            }
        }
    }

    private fun setnoti(id: String, a: String,create_DayS:String, create_Month:String, create_YearS:String,ida: String) {
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


        var cout = a.toInt()
        val cout1 = cout+1
        val aa ="activity"+cout1.toString()
        val d = "no"
        val ref = FirebaseDatabase.getInstance().getReference("activity/$id/")

        if (ida == ""){
            val Ida = ref.push().key
            val plan = sentToactivity(
                Ida.toString(),
                create_DayS,
                create_MonthS,
                create_YearS,
                d
            )
            ref.child("/$aa/$Ida").setValue(plan).addOnCompleteListener {
                Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                finish()
            }
        }else{
            val Ida = ref.push().key
            val plan = sentToactivity(
                Ida.toString(),
                create_DayS,
                create_MonthS,
                create_YearS,
                d
            )
            ref.child("/$aa/$Ida").setValue(plan).addOnCompleteListener {
                Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                finish()
            }
        }


    }
}


