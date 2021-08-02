package com.tiwlynaja.admin.konklav1.Noti_check_Rice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.tiwlynaja.admin.konklav1.*
import com.tiwlynaja.admin.konklav1.check.checkRice
import kotlinx.android.synthetic.main.activity_check_rice.*
import kotlinx.android.synthetic.main.activity_check_rice.activity
import kotlinx.android.synthetic.main.activity_check_rice.addressfarm
import kotlinx.android.synthetic.main.activity_check_rice.name_activity
import kotlinx.android.synthetic.main.activity_check_rice.past
import kotlinx.android.synthetic.main.activity_planting_activities.namefarm
import java.util.*

class ResultActivity_CKR : AppCompatActivity(){
    lateinit var option_day  : Spinner
    lateinit var option_month : Spinner
    lateinit var option_year : Spinner
    lateinit var option_RiceCK:Spinner
    lateinit var ch_water: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_rice)
        ch_water = findViewById(R.id.ck)

        if (intent.getBooleanExtra("notification", false)) { //Just for confirmation
            name_activity.text = intent.getStringExtra("title")
            activity.text = intent.getStringExtra("message")

        }
        val ida = intent.getStringExtra("id")
        val idf = intent.getStringExtra("idf")
        val a = intent.getStringExtra("aty")
        val nettx = intent.getStringExtra("netx")


        setname(idf)
        //sender.setImageResource(R.drawable.but26)
        sender2.setImageResource(R.drawable.but26)
        past.setImageResource(R.drawable.but27)


        if (a == "14" || a =="12" || a=="16") {
            ckRice.setText("ข้าวแตกหรือไม่ ::")
        } else if (a == "15" || a=="13" || a=="18") {
            ckRice.setText("ข้าวตั้งท้องหรือไม่ ::")
        }
        past.setOnClickListener {
            val nexttt = "1"
            past_fram(idf, a, ida, nexttt.toInt())
        }

        var ck2 = 0
        sender2.setOnClickListener {
           ck2++
            println(ck2)
            if (ck2 >= 2){
                setDB2(idf, a, ida, nettx.toInt())
            }
            else{
                setDB(idf, a, ida, nettx.toInt())
            }
        }
        option_RiceCK = findViewById(R.id.riceck) as Spinner
        val option_RiceCKs = arrayListOf("ข้าว","ใช่","ไม่")
        option_RiceCK.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_RiceCKs)
        option_RiceCK.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

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
    companion object{
        val ckkk = "ck"
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


    private fun setDB(id: String, a: String, ida:String,net:Int) {
        val aa = "activity"+a
        var create_DayS = option_day.selectedItem.toString()
        var create_MonthS = option_month.selectedItem.toString()
        var create_YearS = option_year.selectedItem.toString()
        var create_ck_water = ch_water.text.toString()
        var create_checkRice = option_RiceCK.selectedItem.toString()
        if (create_DayS.equals("วันที่") || create_MonthS.equals("เดือน") || create_YearS.equals("ปี") || create_ck_water == null||create_checkRice.equals("ข้าว")) {
            Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบ.", Toast.LENGTH_SHORT).show()
            return
        } else {
            var d =""
            when(create_checkRice){
                "ใช่"->d="yes"
                "ไม่"->d="no"
            }
            if (create_ck_water.toInt() >= 7 && create_ck_water.toInt() <= 15){
                val ref = FirebaseDatabase.getInstance().getReference("activity/$id/")
                val plan = sentToactivity(ida, create_DayS, create_MonthS, create_YearS, d)
                ref.child("/$aa/$ida").setValue(plan).addOnCompleteListener {
                    Log.d("Detail_input", "Upload All DATA SS")
                    Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                    Log.d("Detail_input", "$id")
                    calculate_Date(id,a,create_DayS.toInt(),create_MonthS,create_YearS.toInt(),net,ida,d)
                }
            }else{
                val i = Intent(this,water_else::class.java)
                i.putExtra(checkRice.cka,create_ck_water)
                startActivity(i)
            }

        }

    }
    private fun setDB2(id: String, a: String, ida:String,net:Int) {
        val aa = "activity" + a
        var create_DayS = option_day.selectedItem.toString()
        var create_MonthS = option_month.selectedItem.toString()
        var create_YearS = option_year.selectedItem.toString()
        var create_ck_water = ch_water.text.toString()
        var create_checkRice = option_RiceCK.selectedItem.toString()
        if (create_DayS.equals("วันที่") || create_MonthS.equals("เดือน") || create_YearS.equals("ปี") || create_ck_water == null ||create_checkRice.equals("ข้าว") ) {
            Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบ.", Toast.LENGTH_SHORT).show()
            return
        } else {
            var d =""
            when(create_checkRice){
                "ใช่"->d="yes"
                "ไม่"->d="no"
            }
            val ref = FirebaseDatabase.getInstance().getReference("activity/$id/")
            val plan = sentToactivity(ida, create_DayS, create_MonthS, create_YearS, d)
            ref.child("/$aa/$ida").setValue(plan).addOnCompleteListener {
                Log.d("Detail_input", "Upload All DATA SS")
                Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                Log.d("Detail_input", "$id")
                calculate_Date(id, a, create_DayS.toInt(), create_MonthS, create_YearS.toInt(), net, ida,d)
            }


        }
    }

    private fun calculate_Date(id: String, a: String,create_DayS:Int,create_MonthS:String,create_YearS:Int,net:Int,ida: String,d:String){
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
            settime(id,a,monthCK, dd, months, create_YearS,ida,d)
        }
        else if (months == 2){
            if (create_YearS%4==0){
                var monthCK = 29
                settime(id,a,monthCK, dd, months, create_YearS,ida,d)
            }
            else{
                var monthCK = 28
                settime(id,a,monthCK, dd, months, create_YearS,ida,d)
            }
        }
        else if(months % 4 == 0){
            var monthCK = 29
            settime(id,a,monthCK, dd, months, create_YearS,ida,d)
        }
        else{
            var monthCK = 31
            settime(id,a,monthCK, dd, months, create_YearS,ida,d)
        }
    }
    private fun settime(id: String,a: String,monthCK: Int, d: Int, months: Int, y: Int,ida: String,ckd:String){
        if (d <= monthCK){
            setnoti(id,a,d.toString(),months.toString(),y.toString(),ida,ckd)
        }else{
            val m =months + 1
            if (m <= 12 ){
                var dd = (d+monthCK)-monthCK*2
                setnoti(id,a,dd.toString(),m.toString(),y.toString(),ida,ckd)
            }else{
                val yy=y + 1
                var mm = m - 12
                var dd = (d+monthCK)-monthCK*2
                setnoti(id,a,dd.toString(),mm.toString(),yy.toString(),ida,ckd)
            }
        }
    }

    private fun setnoti(id: String, a: String,create_DayS:String, create_Month:String, create_YearS:String,ida: String,ckd:String) {
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

        if (ckd=="yes"){
            var cout = a.toInt()
            val cout1 = cout+1
            val aa ="activity"+cout1.toString()
            val d = "no"
            val ref = FirebaseDatabase.getInstance().getReference("activity/$id/")
            val Ida = ref.push().key
            val plan = sentToactivity(Ida.toString(), create_DayS, create_MonthS, create_YearS, d)
            ref.child("/$aa/$Ida").setValue(plan).addOnCompleteListener {
                Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                finish()
            }

        }else{
            val nexttt = "1"
            past_fram(id, a, ida, nexttt.toInt())
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