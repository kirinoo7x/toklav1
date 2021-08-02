package com.tiwlynaja.admin.konklav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.tiwlynaja.admin.konklav1.chemical.Calendar_Noti

class Planting_activities : AppCompatActivity() {
    lateinit var option_day  : Spinner
    lateinit var option_month : Spinner
    lateinit var option_year : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planting_activities)




        option_day = findViewById(R.id.day) as Spinner

        val option_days = arrayListOf("วันที่", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31")
        option_day.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_days)
        option_day.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }
        }

        //choose month
        option_month = findViewById(R.id.month) as Spinner
        val option_months = arrayListOf(
            "เดือน",
            "มกราคม",
            "กุมภาพันธ์",
            "มีนาคม",
            "เมษายน",
            "พฤษภาคม",
            "มิถุนายน",
            "กรกฎาคม",
            "สิงหาคม",
            "กันยายน",
            "ตุลาคม",
            "พฤศจิกายน",
            "ธันวาคม"
        )
        option_month.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_months)
        option_month.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
        // choose year
        option_year = findViewById(R.id.year) as Spinner
        val option_years = arrayListOf("ปี", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040")
        option_year.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_years)
        option_year.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

    }

    private fun SenderAToFB() {
        var create_DayS = option_day.selectedItem.toString()
        var create_MonthS = option_month.selectedItem.toString()
        var create_YearS = option_year.selectedItem.toString()
        if ( create_DayS.equals("วันที่") || create_MonthS.equals("เดือน") || create_YearS.equals("ปี") ){
            Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบ.", Toast.LENGTH_SHORT).show()
            return
        }else{
            var userId = FirebaseAuth.getInstance().uid
            var ref1 = FirebaseDatabase.getInstance().getReference("plan/$userId")
            ref1.addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
                override fun onDataChange(p0: DataSnapshot) {
                    p0.children
                        .forEach{
                            val id:String = it.child("id").getValue().toString()
                            idto(id, create_DayS,create_MonthS,create_YearS)

                        }

                }


            })
        }
    }
    private fun idto(id:String, create_DayS:String,create_MonthS:String,create_YearS:String){
        var idFram = id
        val d = "yes"
        val ref = FirebaseDatabase.getInstance().getReference("activity/$idFram/activity1/")
        val plan = sentToactivity(idFram,create_DayS,create_MonthS,create_YearS,d)
        ref.child(idFram).setValue(plan).addOnCompleteListener {
            Log.d("Detail_input","Upload All DATA SS")
            Toast.makeText(this,"บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
            Log.d("Detail_input","$idFram")
            val intent = Intent(this, Calendar_Noti::class.java)
            startActivity(intent)

            /*val ref2 = FirebaseDatabase.getInstance().getReference("activity/$idFram/activity2/")
            val a2 = sentToactivity(idFram,d,d,d)
            ref2.child(idFram).setValue(a2).addOnCompleteListener {
                Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Calendar_Noti::class.java)
                startActivity(intent)
            }*/
        }
    }

}
