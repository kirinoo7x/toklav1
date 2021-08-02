package com.tiwlynaja.admin.konklav1.NOchemical

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.tiwlynaja.admin.konklav1.LiseFramUser
import com.tiwlynaja.admin.konklav1.R
import com.tiwlynaja.admin.konklav1.sentToCreateplan
import kotlinx.android.synthetic.main.activity_edit_no_chemical_plan.*

class L_edit_NOchemical : AppCompatActivity() {
    lateinit var option_day  : Spinner
    lateinit var option_month : Spinner
    lateinit var option_year : Spinner
    lateinit var option_Cultivation : Spinner // choose Cultivation
    lateinit var option_Rice : Spinner // chooseStatus Rice
    lateinit var option_address_Farm: Spinner

    lateinit var namefram_Nochemi : TextView
    lateinit var areafram_NOchemi: TextView
    lateinit var qrice_Nochemi: TextView
    lateinit var ff_NOchemi : TextView
    lateinit var type_Nochemi: TextView
    lateinit var mf_NOchemi : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_no_chemical_plan)

        val idfeu = intent.getStringExtra(L_NOchemical.idfu)
        val name_frem = intent.getStringExtra(L_NOchemical.namefram)
        val addressF = intent.getStringExtra(L_NOchemical.Address)
        val ariaF = intent.getStringExtra(L_NOchemical.Framland)
        val riceF = intent.getStringExtra(L_NOchemical.Ricelf)
        val typef = intent.getStringExtra(L_NOchemical.typelf)
        val attributef = intent.getStringExtra(L_NOchemical.cultivation)
        val dayF = intent.getStringExtra(L_NOchemical.Daylf)
        val monthF = intent.getStringExtra(L_NOchemical.Monthlf)
        val yearF = intent.getStringExtra(L_NOchemical.Yearlf)
        val Rice_quanF = intent.getStringExtra(L_NOchemical.Rice_quantitylf)
        val Ff1 = intent.getStringExtra(L_NOchemical.Fformula1lf)
        val Mf1 = intent.getStringExtra(L_NOchemical.Mfertilizer1lf)



        Name_Field.setText(name_frem)
        Farmland.setText(ariaF)
        Quantity_rice.setText(Rice_quanF)
        TypeNC.setText(attributef)

        Fformula11.setText(Ff1)
        Mfertilizer1.setText(Mf1)

        namefram_Nochemi =findViewById(R.id.Name_Field)
        areafram_NOchemi = findViewById(R.id.Farmland)
        qrice_Nochemi = findViewById(R.id.Quantity_rice)
        type_Nochemi = findViewById(R.id.TypeNC)
        ff_NOchemi = findViewById(R.id.Fformula11)
        mf_NOchemi = findViewById(R.id.Mfertilizer1)


        option_address_Farm = findViewById(R.id.address_FarmNC) as Spinner
        val option_address_Farms = arrayListOf("กรุณาเลือกอำเภอ", "อำเภอกันทรลักษ์", "อำเภอกันทรารมย์", "อำเภอขุขันธ์", "อำเภอขุนหาญ", "อำเภอโนนคูณ", "อำเภอน้ำเกลี้ยง", "อำเภอบึงบูรพ์", "อำเภอเบญจลักษ์", "อำเภอปรางค์กู่", "อำเภอโพธิ์ศรีสุวรรณ", "อำเภอพยุห์", "อำเภอไพรบึง", "อำเภอภูสิงห์", "อำเภอเมืองศรีสะเกษ", "อำเภอเมืองจันทร์", "อำเภอยางชุมน้อย", "อำเภอราษีไศล", "อำเภอวังหิน", "อำเภอศรีรัตนะ", "อำเภอศิลาลาด", "อำเภอห้วยทับทัน", "อำเภออุทุมพรพิสัย")
        option_address_Farm.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_address_Farms)
        option_address_Farm.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
        option_year.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_years)
        option_year.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

        option_Cultivation = findViewById(R.id.CultivationNC) as Spinner
        val option_Cultivations = arrayListOf("กรุณาเลือกวิธีการปลูก", "นาดำ", "นาหว่าน")
        option_Cultivation.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_Cultivations)
        option_Cultivation.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

        option_Rice = findViewById(R.id.RiceNC) as Spinner

        val option_Rices = arrayListOf("กรุณาเลือกพันธุ์ข้าว", "หอมมะลิ 105 ", "กข. 15 ", "กข. 8", "กข. 6 ")
        option_Rice.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, option_Rices)
        option_Rice.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }
        }

        if (addressF != null) {
            for (i in 0..option_address_Farms.count() - 1) {
                if (option_address_Farms[i] == addressF) {
                    address_FarmNC.setSelection(i)
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

        if (typef != null) {
            for (i in 0..option_Cultivations.count() - 1) {
                if (option_Cultivations[i] == typef) {
                    CultivationNC.setSelection(i)
                }
            }
        }
        if (riceF != null) {
            for (i in 0..option_Rices.count() - 1) {
                if (option_Rices[i] == riceF) {
                    RiceNC.setSelection(i)
                }
            }
        }

        netx_noChemical.setOnClickListener {
            checkblank(idfeu)
        }


    }

    private fun checkblank(idfeU:String) {
        var create_name = namefram_Nochemi.text.toString()
        var creare_area = areafram_NOchemi.text.toString()
        var create_address = option_address_Farm.selectedItem.toString()
        var create_Rice = option_Rice.selectedItem.toString()
        var create_Cultivation = type_Nochemi.text.toString()
        var qRice = qrice_Nochemi.text.toString()
        var create_DayS = option_day.selectedItem.toString()
        var create_MonthS = option_month.selectedItem.toString()
        var create_YearS = option_year.selectedItem.toString()
        var create_Type = option_Cultivation.selectedItem.toString()
        var ff1 = ff_NOchemi.text.toString()
        var mf1 = mf_NOchemi.text.toString()
        if (create_name.isEmpty() || creare_area.isEmpty() || create_address.equals("กรุณาพื้นที่เเพาะปลูก") || create_Rice.equals("กรุณาเลือกพันธุ์ข้าว") || create_Cultivation.equals("กรุณาเลือกวิธีการปลูก") ||
            create_Type.isEmpty() || create_DayS.equals("วันที่") || create_MonthS.equals("เดือน") || create_YearS.equals("ปี") || ff1.isEmpty() || mf1.isEmpty())
        {
            Toast.makeText(this, "กรุณากรอกข้อมูลให้ครบ.", Toast.LENGTH_SHORT).show()
            return
        } else{
            val ff2 = ""
            val ff3 = ""
            var mf2 = ""
            var mf3 = ""
            var dmye =""
            var product = "อยู่ระหว่างดำเนิดการ"
            val userId = FirebaseAuth.getInstance().uid
            val ref = FirebaseDatabase.getInstance().getReference("/plan/$userId")
            val plan = sentToCreateplan(idfeU, create_name,create_address,creare_area,create_Rice,create_Type,create_Cultivation,qRice,
                ff1,ff2,ff3,mf1,mf2,mf3,create_DayS,create_MonthS,create_YearS,product,dmye,dmye,dmye)
            ref.child(idfeU).setValue(plan).addOnCompleteListener {
                val ref2 = FirebaseDatabase.getInstance().getReference("plan_all")
                val plan1 = sentToCreateplan(idfeU,create_name,create_address,creare_area,create_Rice,create_Type,create_Cultivation,qRice,
                    ff1,ff2,ff3,mf1,mf2,mf3,create_DayS,create_MonthS,create_YearS,product,dmye,dmye,dmye)
                ref2.child(idfeU).setValue(plan1).addOnCompleteListener {
                    Log.d("Detail_input","Upload All DATA SS")
                    Toast.makeText(this,"บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
                    Log.d("Detail_input","$idfeU")
                    startActivity(Intent(this,LiseFramUser::class.java))
                }
            }
        }

    }
}
