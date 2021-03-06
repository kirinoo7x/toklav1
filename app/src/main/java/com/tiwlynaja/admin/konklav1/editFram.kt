package com.tiwlynaja.admin.konklav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.tiwlynaja.admin.konklav1.chemical.Calendar_Noti
import com.tiwlynaja.admin.konklav1.chemical.Calendar_Noti2
import kotlinx.android.synthetic.main.activity_edit_fram.*
import kotlinx.android.synthetic.main.activity_edit_fram.Cultivation
import kotlinx.android.synthetic.main.activity_edit_fram.Farmland
import kotlinx.android.synthetic.main.activity_edit_fram.Name_Field
import kotlinx.android.synthetic.main.activity_edit_fram.Rice
import kotlinx.android.synthetic.main.activity_edit_fram.Type
import kotlinx.android.synthetic.main.activity_edit_fram.address_Farm
import kotlinx.android.synthetic.main.activity_edit_fram.day
import kotlinx.android.synthetic.main.activity_edit_fram.month
import kotlinx.android.synthetic.main.activity_edit_fram.year

class editFram : AppCompatActivity() {

    lateinit var option_address_Farm:Spinner
    lateinit var option_Rice : Spinner // chooseStatus Rice
    lateinit var option_Cultivation : Spinner // choose Cultivation
    lateinit var option_Type :Spinner //choose Type
    lateinit var option_day  :Spinner
    lateinit var option_month : Spinner
    lateinit var option_year : Spinner
    lateinit var option_Fformula1 : Spinner
    lateinit var option_Fformula2 : Spinner
    lateinit var option_Fformula3: Spinner


    lateinit var nameFarm : EditText
    lateinit var area : EditText

    lateinit var quantity_rice:EditText

    lateinit var mf1:EditText // ปริมาณ
    lateinit var mf2:EditText
    lateinit var mf3:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_fram)


        val name_frem = intent.getStringExtra(Plan.namefram)
        val addressF = intent.getStringExtra(Plan.addressfram)
        val ariaF = intent.getStringExtra(Plan.ariafram)
        val riceF = intent.getStringExtra(Plan.Ricef)
        val typef = intent.getStringExtra(Plan.Typef)
        val attributef = intent.getStringExtra(Plan.attributef)
        val dayF = intent.getStringExtra(Plan.Dayf)
        val monthF = intent.getStringExtra(Plan.Monthf)
        val yearF = intent.getStringExtra(Plan.Yearf)
        val Rice_quanF = intent.getStringExtra(Plan.Rice_quantityf)
        val Ff1 = intent.getStringExtra(Plan.Fformula1)
        val Ff2 = intent.getStringExtra(Plan.Fformula2)
        val Ff3 = intent.getStringExtra(Plan.Fformula3)
        val Mf1 = intent.getStringExtra(Plan.Mfertilizer1)
        val Mf2 = intent.getStringExtra(Plan.Mfertilizer2)
        val Mf3 = intent.getStringExtra(Plan.Mfertilizer3)


        Name_Field.setText(name_frem)
        Farmland.setText(ariaF)
        Quantity_rice.setText(Rice_quanF)
        Mfertilizer1.setText(Mf1)
        Mfertilizer2.setText(Mf2)
        Mfertilizer3.setText(Mf3)

        nameFarm = findViewById(R.id.Name_Field)
        area = findViewById(R.id.Farmland)
        quantity_rice = findViewById(R.id.Quantity_rice)
        mf1 = findViewById(R.id.Mfertilizer1)
        mf2 = findViewById(R.id.Mfertilizer2)
        mf3 = findViewById(R.id.Mfertilizer3)

        option_address_Farm = findViewById(R.id.address_Farm) as Spinner
        val option_address_Farms = arrayListOf("กรุณาเลือกอำเภอ", "อำเภอกันทรลักษ์", "อำเภอกันทรารมย์", "อำเภอขุขันธ์", "อำเภอขุนหาญ", "อำเภอโนนคูณ", "อำเภอน้ำเกลี้ยง", "อำเภอบึงบูรพ์", "อำเภอเบญจลักษ์", "อำเภอปรางค์กู่", "อำเภอโพธิ์ศรีสุวรรณ", "อำเภอพยุห์", "อำเภอไพรบึง", "อำเภอภูสิงห์", "อำเภอเมืองศรีสะเกษ", "อำเภอเมืองจันทร์", "อำเภอยางชุมน้อย", "อำเภอราษีไศล", "อำเภอวังหิน", "อำเภอศรีรัตนะ", "อำเภอศิลาลาด", "อำเภอห้วยทับทัน", "อำเภออุทุมพรพิสัย")
        option_address_Farm.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_address_Farms)
        option_address_Farm.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }




        option_Rice = findViewById(R.id.Rice) as Spinner

        val option_Rices =
            arrayListOf("กรุณาเลือกพันธุ์ข้าว", "หอมมะลิ 105 ", "กข. 15 ", "กข. 8", "กข. 6 ")
        option_Rice.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_Rices)
        option_Rice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

        // choose Cultivation
        option_Cultivation = findViewById(R.id.Cultivation) as Spinner

        val option_Cultivations = arrayListOf("กรุณาเลือกวิธีการปลูก", "นาดำ", "นาหว่าน")
        option_Cultivation.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_Cultivations)
        option_Cultivation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

        //choose Type
        option_Type = findViewById(R.id.Type) as Spinner

        val option_Types = arrayListOf("กรุณาเลือกลักษณะเพาะปลูก", "ใช้สารเคมี")
        option_Type.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_Types)
        option_Type.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
        option_day = findViewById(R.id.day) as Spinner

        val option_days = arrayListOf("วันที่", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31")
        option_day.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_days)
        option_day.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

        //choose month
        option_month = findViewById(R.id.month) as Spinner
        val option_months = arrayListOf("เดือน", "มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม")
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
        option_year.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_years)
        option_year.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

        // Fertilizer No. 1
        option_Fformula1 = findViewById(R.id.Fformula1) as Spinner
        val option_Fformula1s =
            arrayListOf("กรณาเลือกสูตรปุ๋ย", "46-0-0", "16-20-0", "18-22-0", "20-20-0")
        option_Fformula1.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_Fformula1s)
        option_Fformula1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
        // Fertilizer No. 2
        option_Fformula2 = findViewById(R.id.Fformula2) as Spinner
        val option_Fformula2s =
            arrayListOf("กรณาเลือกสูตรปุ๋ย", "46-0-0", "16-20-0", "16-8-8", "16-16-40", "15-15-15")
        option_Fformula2.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_Fformula2s)
        option_Fformula2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }
        // Fertilizer No. 3
        option_Fformula3 = findViewById(R.id.Fformula3) as Spinner
        val option_Fformula3s = arrayListOf("กรณาเลือกสูตรปุ๋ย", "15-15-15")
        option_Fformula3.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_Fformula3s)
        option_Fformula3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }


        if (addressF != null) {
            for (i in 0..option_address_Farms.count() - 1) {
                if (option_address_Farms[i] == addressF) {
                    address_Farm.setSelection(i)
                }
            }
        }
        if (riceF != null) {
            for (i in 0..option_Rices.count() - 1) {
                if (option_Rices[i] == riceF) {
                    Rice.setSelection(i)
                }
            }
        }
        if (attributef != null) {
            for (i in 0..option_Types.count() - 1) {
                if (option_Types[i] == attributef) {
                    Type.setSelection(i)
                }
            }
        }
        if (typef != null) {
            for (i in 0..option_Cultivations.count() - 1) {
                if (option_Cultivations[i] == typef) {
                    Cultivation.setSelection(i)
                }
            }
        }
        if (dayF != null) {
            for (i in 0..option_days.count() - 1) {
                if (option_days[i] == dayF) {
                    day.setSelection(i)
                }
            }
        }
        if (monthF != null) {
            for (i in 0..option_months.count() - 1) {
                if (option_months[i] == monthF) {
                    month.setSelection(i)
                }
            }
        }
        if (yearF != null) {
            for (i in 0..option_years.count() - 1) {
                if (option_years[i] == yearF) {
                    year.setSelection(i)
                }
            }
        }

        if (Ff1 != null) {
            for (i in 0..option_Fformula1s.count() - 1) {
                if (option_Fformula1s[i] == Ff1) {
                    Fformula1.setSelection(i)
                }
            }
        }
        if (Ff2 != null) {
            for (i in 0..option_Fformula2s.count() - 1) {
                if (option_Fformula2s[i] == Ff2) {
                    Fformula2.setSelection(i)
                }
            }
        }
        if (Ff3 != null) {
            for (i in 0..option_Fformula3s.count() - 1) {
                if (option_Fformula3s[i] == Ff3) {
                    Fformula3.setSelection(i)
                }
            }
        }else{
            Fformula3.setSelection(0)
        }

        Netx.setOnClickListener{
            checkblank()
        }

    }

    private fun checkblank() {
        var create_name = nameFarm.text.toString()
        var creare_area = area.text.toString()
        var create_address = option_address_Farm.selectedItem.toString()
        var create_Rice = option_Rice.selectedItem.toString()
        var create_Cultivation = option_Cultivation.selectedItem.toString()
        var create_Type = option_Type.selectedItem.toString()
        var create_DayS = option_day.selectedItem.toString()
        var create_MonthS = option_month.selectedItem.toString()
        var create_YearS = option_year.selectedItem.toString()

        val qRice = quantity_rice.text.toString()
        val ff1 = option_Fformula1.selectedItem.toString()
        val ff2 = option_Fformula2.selectedItem.toString()
        val ff3 = option_Fformula3.selectedItem.toString()

        val mf1 = mf1.text.toString()
        val mf2 = mf2.text.toString()
        val mf3 = mf3.text.toString()


        if (create_Cultivation.equals("นาหว่าน")){
            println(ff3+mf3)
            if(ff3.equals("15-15-15") || mf3 != ""){
                Toast.makeText(this, "ระบบไม่นำแนะให้ใช้ปุ๋ยครั้ง 3 ในแผนเพาระปลูกนาหว่าน", Toast.LENGTH_SHORT).show()
                return
            }
            else if (create_name.isEmpty() || creare_area == null || create_address.equals("กรุณาพื้นที่เเพาะปลูก") || create_Rice.equals("กรุณาเลือกพันธุ์ข้าว") || create_Cultivation.equals("กรุณาเลือกวิธีการปลูก") ||
                create_Type.equals("กรุณาเลือกลักษณะเพาะปลูก") || create_DayS.equals("วันที่") || create_MonthS.equals("เดือน") || create_YearS.equals("ปี") ||
                ff1.equals("กรณาเลือกสูตรปุ๋ย") || ff2.equals("กรณาเลือกสูตรปุ๋ย")|| mf1 == null || mf2 == null)
            {
                Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบ.", Toast.LENGTH_SHORT).show()
                return
            }else{
                var d ="no"
                var product = "อยู่ระหว่างดำเนินการ"
                var dmye = ""
                val userId = FirebaseAuth.getInstance().uid
                val ref = FirebaseDatabase.getInstance().getReference("/plan/$userId")

                val Idplan = ref.push().key
                val plan = sentToCreateplan(Idplan.toString(), create_name,create_address,creare_area,create_Rice,create_Cultivation,create_Type,qRice,
                    ff1,ff2,dmye,mf1,mf2,mf3,create_DayS,create_MonthS,create_YearS,product,dmye,dmye,dmye)
                ref.child(Idplan.toString()).setValue(plan).addOnCompleteListener {
                    Log.d("Detail_input","Upload All DATA SS")
                    Toast.makeText(this,"บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                    Log.d("Detail_input","$Idplan")

                    val ref2 = FirebaseDatabase.getInstance().getReference("plan_all")
                    val plan1 = sentToCreateplan(Idplan.toString(),create_name,create_address,creare_area,create_Rice,create_Cultivation,create_Type,qRice,
                        ff1,ff2,dmye,mf1,mf2,mf3,create_DayS,create_MonthS,create_YearS,product,dmye,dmye,dmye)
                    ref2.child(Idplan.toString()).setValue(plan1).addOnCompleteListener {
                        val ref3 = FirebaseDatabase.getInstance().getReference("/activity/$Idplan/activity0")
                        val plan0 = sentToactivity(Idplan.toString(),create_DayS,create_MonthS,create_YearS,d)
                        ref3.child(Idplan.toString()).setValue(plan0).addOnCompleteListener {
                            Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                            if (create_Cultivation == "นาดำ"){
                                val intent = Intent(this, Calendar_Noti::class.java)
                                intent.putExtra(Plan.idFram,Idplan)
                                intent.putExtra(Plan.addressfram,create_address)
                                intent.putExtra(Plan.namefram,create_name)

                                intent.putExtra(Plan.ariafram,creare_area)
                                intent.putExtra(Plan.Ricef,create_Rice)
                                intent.putExtra(Plan.Typef,create_Type)
                                intent.putExtra(Plan.attributef,create_Cultivation)
                                intent.putExtra(Plan.Dayf,create_DayS)
                                intent.putExtra(Plan.Monthf,create_MonthS)
                                intent.putExtra(Plan.Yearf,create_YearS)
                                intent.putExtra(Plan.Rice_quantityf,qRice)
                                intent.putExtra(Plan.Fformula1,ff1)
                                intent.putExtra(Plan.Fformula2,ff2)
                                intent.putExtra(Plan.Fformula3,ff3)
                                intent.putExtra(Plan.Mfertilizer1,mf1)
                                intent.putExtra(Plan.Mfertilizer2,mf2)
                                intent.putExtra(Plan.Mfertilizer3,mf3)
                                startActivity(intent)
                            }else{
                                val intent = Intent(this, Calendar_Noti2::class.java)
                                intent.putExtra(Plan.idFram,Idplan)
                                intent.putExtra(Plan.addressfram,create_address)
                                intent.putExtra(Plan.namefram,create_name)


                                intent.putExtra(Plan.ariafram,creare_area)
                                intent.putExtra(Plan.Ricef,create_Rice)
                                intent.putExtra(Plan.Typef,create_Type)
                                intent.putExtra(Plan.attributef,create_Cultivation)
                                intent.putExtra(Plan.Dayf,create_DayS)
                                intent.putExtra(Plan.Monthf,create_MonthS)
                                intent.putExtra(Plan.Yearf,create_YearS)
                                intent.putExtra(Plan.Rice_quantityf,qRice)
                                intent.putExtra(Plan.Fformula1,ff1)
                                intent.putExtra(Plan.Fformula2,ff2)
                                intent.putExtra(Plan.Fformula3,ff3)
                                intent.putExtra(Plan.Mfertilizer1,mf1)
                                intent.putExtra(Plan.Mfertilizer2,mf2)
                                intent.putExtra(Plan.Mfertilizer3,mf3)
                                startActivity(intent)
                            }

                        }
                    }
                }
            }
        }else{
            if (create_name.isEmpty() || creare_area == null || create_address.equals("กรุณาพื้นที่เเพาะปลูก") || create_Rice.equals("กรุณาเลือกพันธุ์ข้าว") || create_Cultivation.equals("กรุณาเลือกวิธีการปลูก") ||
                create_Type.equals("กรุณาเลือกลักษณะเพาะปลูก") || create_DayS.equals("วันที่") || create_MonthS.equals("เดือน") || create_YearS.equals("ปี") ||
                ff1.equals("กรณาเลือกสูตรปุ๋ย") || ff2.equals("กรณาเลือกสูตรปุ๋ย") || ff3.equals("กรณาเลือกสูตรปุ๋ย") || mf1 == null || mf2 == null || mf3 == null)
            {
                Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบ.", Toast.LENGTH_SHORT).show()
                return
            }
            else{
                var d ="no"
                var product = "อยู่ระหว่างดำเนินการ"
                var dmye = ""
                val userId = FirebaseAuth.getInstance().uid
                val ref = FirebaseDatabase.getInstance().getReference("/plan/$userId")

                val Idplan = ref.push().key
                val plan = sentToCreateplan(Idplan.toString(), create_name,create_address,creare_area,create_Rice,create_Cultivation,create_Type,qRice,
                    ff1,ff2,ff3,mf1,mf2,mf3,create_DayS,create_MonthS,create_YearS,product,dmye,dmye,dmye)
                ref.child(Idplan.toString()).setValue(plan).addOnCompleteListener {
                    Log.d("Detail_input","Upload All DATA SS")
                    Toast.makeText(this,"บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                    Log.d("Detail_input","$Idplan")

                    val ref2 = FirebaseDatabase.getInstance().getReference("plan_all")
                    val plan1 = sentToCreateplan(Idplan.toString(),create_name,create_address,creare_area,create_Rice,create_Cultivation,create_Type,qRice,
                        ff1,ff2,ff3,mf1,mf2,mf3,create_DayS,create_MonthS,create_YearS,product,dmye,dmye,dmye)
                    ref2.child(Idplan.toString()).setValue(plan1).addOnCompleteListener {
                        val ref3 = FirebaseDatabase.getInstance().getReference("/activity/$Idplan/activity0")
                        val plan0 = sentToactivity(Idplan.toString(),create_DayS,create_MonthS,create_YearS,d)
                        ref3.child(Idplan.toString()).setValue(plan0).addOnCompleteListener {
                            Toast.makeText(this, "บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                            if (create_Cultivation == "นาดำ"){
                                val intent = Intent(this, Calendar_Noti::class.java)
                                intent.putExtra(Plan.idFram,Idplan)
                                intent.putExtra(Plan.addressfram,create_address)
                                intent.putExtra(Plan.namefram,create_name)
                                intent.putExtra(Plan.ariafram,creare_area)
                                intent.putExtra(Plan.Ricef,create_Rice)
                                intent.putExtra(Plan.Typef,create_Type)
                                intent.putExtra(Plan.attributef,create_Cultivation)
                                intent.putExtra(Plan.Dayf,create_DayS)
                                intent.putExtra(Plan.Monthf,create_MonthS)
                                intent.putExtra(Plan.Yearf,create_YearS)
                                intent.putExtra(Plan.Rice_quantityf,qRice)
                                intent.putExtra(Plan.Fformula1,ff1)
                                intent.putExtra(Plan.Fformula2,ff2)
                                intent.putExtra(Plan.Fformula3,ff3)
                                intent.putExtra(Plan.Mfertilizer1,mf1)
                                intent.putExtra(Plan.Mfertilizer2,mf2)
                                intent.putExtra(Plan.Mfertilizer3,mf3)
                                startActivity(intent)
                            }else{
                                val intent = Intent(this, Calendar_Noti2::class.java)
                                intent.putExtra(Plan.idFram,Idplan)
                                intent.putExtra(Plan.addressfram,create_address)
                                intent.putExtra(Plan.namefram,create_name)
                                intent.putExtra(Plan.ariafram,creare_area)
                                intent.putExtra(Plan.Ricef,create_Rice)
                                intent.putExtra(Plan.Typef,create_Type)
                                intent.putExtra(Plan.attributef,create_Cultivation)
                                intent.putExtra(Plan.Dayf,create_DayS)
                                intent.putExtra(Plan.Monthf,create_MonthS)
                                intent.putExtra(Plan.Yearf,create_YearS)
                                intent.putExtra(Plan.Rice_quantityf,qRice)
                                intent.putExtra(Plan.Fformula1,ff1)
                                intent.putExtra(Plan.Fformula2,ff2)
                                intent.putExtra(Plan.Fformula3,ff3)
                                intent.putExtra(Plan.Mfertilizer1,mf1)
                                intent.putExtra(Plan.Mfertilizer2,mf2)
                                intent.putExtra(Plan.Mfertilizer3,mf3)
                                startActivity(intent)
                            }

                        }
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
}