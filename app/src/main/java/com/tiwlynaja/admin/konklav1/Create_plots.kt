package com.tiwlynaja.admin.konklav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_choose_status.*
import kotlinx.android.synthetic.main.activity_create_plots.*

class Create_plots : AppCompatActivity() {

    lateinit var option_address_Farm:Spinner  // chaoose address_Farm
    lateinit var option_Rice : Spinner // chooseStatus Rice
    lateinit var option_Cultivation : Spinner // choose Cultivation
    lateinit var option_Type :Spinner //choose Type
    lateinit var nameFarm : EditText
    lateinit var area : EditText
    lateinit var option_day  :Spinner
    lateinit var option_month : Spinner
    lateinit var option_year : Spinner


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_plots)


        nameFarm = findViewById(R.id.Name_Field)
        area = findViewById(R.id.Farmland)



        // chaoose address_Farm
        option_address_Farm  = findViewById(R.id.address_Farm)as Spinner
        val option_address_Farms = arrayListOf("กรุณาเลือกอำเภอ","อำเภอกันทรลักษ์","อำเภอกันทรารมย์","อำเภอขุขันธ์","อำเภอขุนหาญ",
        "อำเภอโนนคูณ","อำเภอน้ำเกลี้ยง","อำเภอบึงบูรพ์","อำเภอเบญจลักษ์","อำเภอปรางค์กู่","อำเภอโพธิ์ศรีสุวรรณ","อำเภอพยุห์","อำเภอไพรบึง","อำเภอภูสิงห์","อำเภอเมืองศรีสะเกษ","อำเภอเมืองจันทร์",
        "อำเภอยางชุมน้อย","อำเภอราษีไศล","อำเภอวังหิน","อำเภอศรีรัตนะ","อำเภอศิลาลาด","อำเภอห้วยทับทัน","อำเภออุทุมพรพิสัย")
        option_address_Farm.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,option_address_Farms)
        option_address_Farm.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

        // chooseStatus Rice
        option_Rice = findViewById(R.id.Rice) as Spinner

       val option_Rices = arrayListOf("กรุณาเลือกพันธุ์ข้าว","หอมมะลิ 105 ","กข. 15 ","กข. 8","กข. 6 ")
        option_Rice.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,option_Rices)
        option_Rice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

        // choose Cultivation
        option_Cultivation = findViewById(R.id.Cultivation) as Spinner

        val option_Cultivations = arrayListOf("กรุณาเลือกวิธีการปลูก","นาดำ","นาหว่าน")
        option_Cultivation.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,option_Cultivations)
        option_Cultivation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

    //choose Type
        option_Type = findViewById(R.id.Type) as Spinner

        val option_Types = arrayListOf("กรุณาเลือกลักษณะเพาะปลูก","ใช้สารเคมี","ไม่ใช้สารเคมี")
        option_Type.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,option_Types)
        option_Type.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

    //choose DAY
        option_day = findViewById(R.id.day) as Spinner

        val option_days = arrayListOf("วันที่","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15",
        "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31")
        option_day.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,option_days)
        option_day.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

        //choose month
        option_month = findViewById(R.id.month) as Spinner
        val option_months = arrayListOf("เดือน","มกราคม","กุมภาพันธ์","มีนาคม","เมษายน","พฤษภาคม","มิถุนายน","กรกฎาคม","สิงหาคม","กันยายน","ตุลาคม","พฤศจิกายน","ธันวาคม")
        option_month.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,option_months)
        option_month.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
        // choose year
        option_year = findViewById(R.id.year) as Spinner
        val option_years = arrayListOf("ปี","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030",
            "2031","2032","2033","2034","2035","2036","2037","2038","2039","2040")
        option_year.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,option_years)
        option_year.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

        netx.setOnClickListener {
            checkblank()
        }
        imageView52.setOnClickListener {
            finish()
        }


    }

    companion object{
        var NameFarm = "namefram"
        var Framland = "Fraland"
        var address = "address_Farm"
        var rice = "Rice"
        var cultivation = "Cultivation"
        var type = "Type"
        var Day = "day"
        var Month = "month"
        var Year = "year"

    }
    private fun checkblank(){
        var create_name = nameFarm.text.toString()
        var creare_area = area.text.toString()
        var create_address = option_address_Farm.selectedItem.toString()
        var create_Rice = option_Rice.selectedItem.toString()
        var create_Cultivation = option_Cultivation.selectedItem.toString()
        var create_Type = option_Type.selectedItem.toString()
        var create_Day = option_day.selectedItem.toString()
        var create_Month = option_month.selectedItem.toString()
        var create_Year = option_year.selectedItem.toString()

        if (create_name.isEmpty()|| creare_area == null || create_address.equals("กรุณาพื้นที่เเพาะปลูก")|| create_Rice.equals("กรุณาเลือกพันธุ์ข้าว")||create_Cultivation.equals("กรุณาเลือกวิธีการปลูก")||
            create_Type.equals("กรุณาเลือกลักษณะเพาะปลูก")|| create_Day.equals("วันที่") || create_Month.equals("เดือน") || create_Year.equals("ปี")){
            Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบ.", Toast.LENGTH_SHORT).show()
            return
        }else{
            val intent = Intent(this, choose_plan::class.java)
            intent.putExtra(NameFarm, create_name)
            intent.putExtra(Framland, creare_area)
            intent.putExtra(address, create_address)
            intent.putExtra(rice, create_Rice)
            intent.putExtra(cultivation, create_Cultivation)
            intent.putExtra(type, create_Type)
            intent.putExtra(Day,create_Day)
            intent.putExtra(Month,create_Month)
            intent.putExtra(Year,create_Year)
            startActivity(intent)

        }

    }
}
