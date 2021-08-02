package com.tiwlynaja.admin.konklav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.tiwlynaja.admin.konklav1.NOchemical.Calendar_Noti_chemical
import com.tiwlynaja.admin.konklav1.NOchemical.Calendar_Noti_chemical2
import com.tiwlynaja.admin.konklav1.chemical.Calendar_Noti
import com.tiwlynaja.admin.konklav1.chemical.Calendar_Noti2
import kotlinx.android.synthetic.main.activity_plan.Day
import kotlinx.android.synthetic.main.activity_plan.Month
import kotlinx.android.synthetic.main.activity_plan.Rice
import kotlinx.android.synthetic.main.activity_plan.Type
import kotlinx.android.synthetic.main.activity_plan.Year
import kotlinx.android.synthetic.main.activity_plan.addressFarm
import kotlinx.android.synthetic.main.activity_plan.addressfarm
import kotlinx.android.synthetic.main.activity_plan.areaFarm
import kotlinx.android.synthetic.main.activity_plan.attribute
import kotlinx.android.synthetic.main.activity_plan.edit
import kotlinx.android.synthetic.main.activity_plan.fertilizer_1
import kotlinx.android.synthetic.main.activity_plan.fertilizer_2
import kotlinx.android.synthetic.main.activity_plan.fertilizer_3
import kotlinx.android.synthetic.main.activity_plan.formula_fertilizer_1
import kotlinx.android.synthetic.main.activity_plan.formula_fertilizer_2
import kotlinx.android.synthetic.main.activity_plan.formula_fertilizer_3
import kotlinx.android.synthetic.main.activity_plan.nameFarm
import kotlinx.android.synthetic.main.activity_plan.namefarm
import kotlinx.android.synthetic.main.activity_plan.quantity_rice
import kotlinx.android.synthetic.main.activity_plan_all.*

class Plan_all : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan_all)

        val all_user_fram = intent.getStringExtra(ConcludePlan.nameframf)
        var all_address_fram = intent.getStringExtra(ConcludePlan.addressfram)
        var all_area_fram = intent.getStringExtra(ConcludePlan.areafram)
        var all_Type_fram = intent.getStringExtra(ConcludePlan.Typef)
        var all_Attribute_fram = intent.getStringExtra(ConcludePlan.attributef)
        var all_rice_fram = intent.getStringExtra(ConcludePlan.Ricef)
        var all_riceq_fram = intent.getStringExtra(ConcludePlan.Rice_quantityf)

        var all_day_fram = intent.getStringExtra(ConcludePlan.Dayf)
        var all_month_fram = intent.getStringExtra(ConcludePlan.Monthf)
        var all_year_fram = intent.getStringExtra(ConcludePlan.Yearf)

        var all_ff1 = intent.getStringExtra(ConcludePlan.Fformula1)
        var all_ff2 = intent.getStringExtra(ConcludePlan.Fformula2)
        var all_ff3 = intent.getStringExtra(ConcludePlan.Fformula3)

        var all_mf1 = intent.getStringExtra(ConcludePlan.Mfertilizer1)
        var all_mf2 = intent.getStringExtra(ConcludePlan.Mfertilizer2)
        var all_mf3 = intent.getStringExtra(ConcludePlan.Mfertilizer3)


        namefarm.setText(all_user_fram)
        nameFarm.setText(all_user_fram)

        addressfarm.setText(all_address_fram)
        addressFarm.setText(all_address_fram)

        areaFarm.setText(all_area_fram)
        Rice.setText(all_rice_fram)
        Type.setText(all_Type_fram)
        attribute.setText(all_Attribute_fram)
        Day.setText(all_day_fram)
        Month.setText(all_month_fram)
        Year.setText(all_year_fram)
        quantity_rice.setText(all_riceq_fram)

        formula_fertilizer_1.setText(all_ff1)
        formula_fertilizer_2.setText(all_ff2)
        formula_fertilizer_3.setText(all_ff3)

        fertilizer_1.setText(all_mf1)
        fertilizer_2.setText(all_mf2)
        fertilizer_3.setText(all_mf3)

        button4.setOnClickListener {
            finish()
        }

        calender_all.setOnClickListener{
            createPlan_all(all_user_fram, all_address_fram, all_area_fram ,all_Type_fram, all_Attribute_fram, all_rice_fram, all_riceq_fram, all_day_fram, all_month_fram, all_year_fram, all_ff1, all_ff2, all_ff3, all_mf1, all_mf2, all_mf3)
        }

        edit.setOnClickListener {
            if (all_Attribute_fram == "ใช้สารเคมี"){
                val i = Intent(this,editFram::class.java)
                i.putExtra(Plan.namefram,all_user_fram)
                i.putExtra(Plan.addressfram,all_address_fram)
                i.putExtra(Plan.ariafram,all_area_fram)
                i.putExtra(Plan.Typef,all_Type_fram)
                i.putExtra(Plan.attributef, all_Attribute_fram)
                i.putExtra(Plan.Ricef,all_rice_fram)
                i.putExtra(Plan.Rice_quantityf,all_riceq_fram)
                i.putExtra(Plan.Dayf,all_day_fram)
                i.putExtra(Plan.Monthf,all_month_fram)
                i.putExtra(Plan.Yearf,all_year_fram)
                i.putExtra(Plan.Fformula1,all_ff1)
                i.putExtra(Plan.Fformula2,all_ff2)
                i.putExtra(Plan.Fformula3,all_ff3)
                i.putExtra(Plan.Mfertilizer1,all_mf1)
                i.putExtra(Plan.Mfertilizer2,all_mf2)
                i.putExtra(Plan.Mfertilizer3,all_mf3)
                startActivity(i)
            }else{
                val i = Intent(this,edit_noChemical_plan::class.java)
                i.putExtra(NO_Chemical_plan.namefram,all_user_fram)
                i.putExtra(NO_Chemical_plan.addressfram,all_address_fram)
                i.putExtra(NO_Chemical_plan.areafram,all_area_fram)
                i.putExtra(NO_Chemical_plan.Typef,all_Type_fram)
                i.putExtra(NO_Chemical_plan.attributef, all_Attribute_fram)
                i.putExtra(NO_Chemical_plan.Ricef,all_rice_fram)
                i.putExtra(NO_Chemical_plan.Rice_quantityf,all_riceq_fram)
                i.putExtra(NO_Chemical_plan.Dayf,all_day_fram)
                i.putExtra(NO_Chemical_plan.Monthf,all_month_fram)
                i.putExtra(NO_Chemical_plan.Yearf,all_year_fram)
                i.putExtra(NO_Chemical_plan.Fformula1,all_ff1)
                i.putExtra(NO_Chemical_plan.Mfertilizer1,all_mf1)
                startActivity(i)
            }

        }
    }
companion object{
    val name_fram = "nameFram"
    val addressfram = "addressFram"
    val ariafram = "ariafram"
    val Ricef = "rice" // พันธุ์ข้าว
    val Typef = "type" // วิธีการเพาะปลูก
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
    val Productf = "productf"

}
    private fun createPlan_all(allUserFram: String, allAddressFram: String, allAreaFram: String, allTypeFram: String, allAttributeFram: String, allRiceFram: String, allRiceqFram: String, allDayFram: String, allMonthFram: String, allYearFram: String, allFf1: String, allFf2: String, allFf3: String, allMf1: String, allMf2: String, allMf3: String) {
        var d ="no"
        var product = "อยู่ระหว่างดำเนินการ"
        var dmye= ""
        val userId = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/plan/$userId")
        val Idplan = ref.push().key
        val idplan = Idplan.toString()
        val plan = sentToCreateplan(Idplan.toString(),allUserFram,allAddressFram,allAreaFram,allRiceFram,allTypeFram,allAttributeFram,allRiceqFram,allFf1,allFf2,allFf3,allMf1,allMf2,allMf3,allDayFram,allMonthFram,allYearFram,product,dmye,dmye,dmye)
        ref.child(Idplan.toString()).setValue(plan).addOnCompleteListener {
            Toast.makeText(this,"บันทึกสำเร็จ", Toast.LENGTH_SHORT).show()
            Log.d("id_input","$Idplan")

            val ref2 = FirebaseDatabase.getInstance().getReference("plan_all")
            val plan1 = sentToCreateplan(Idplan.toString(),allUserFram,allAddressFram,allAreaFram,allRiceFram,allTypeFram,allAttributeFram,allRiceqFram,allFf1,allFf2,allFf3,allMf1,allMf2,allMf3,allDayFram,allMonthFram,allYearFram,product,dmye,dmye,dmye)
            ref2.child(Idplan.toString()).setValue(plan1).addOnCompleteListener {
                val ref3 = FirebaseDatabase.getInstance().getReference("/activity/$Idplan/")
                val statusID = ref3.push().key
                val plan0 = sentToactivity(statusID.toString(),allDayFram,allMonthFram,allYearFram,d)
                ref3.child("activity0/$statusID").setValue(plan0).addOnCompleteListener {
                    if (allAttributeFram == "ใช้สารเคมี"){
                        if (allRiceFram  == "นาดำ"){
                            val intent = Intent(this, Calendar_Noti::class.java)
                            intent.putExtra(Plan.idFram,idplan)
                            intent.putExtra(Plan.addressfram,allAddressFram)
                            intent.putExtra(Plan.namefram,allUserFram)
                            intent.putExtra(Plan.ariafram,allAreaFram)
                            intent.putExtra(Plan.Ricef,allRiceFram)
                            intent.putExtra(Plan.Typef,allTypeFram)
                            intent.putExtra(Plan.attributef,allAttributeFram)
                            intent.putExtra(Plan.Dayf,allDayFram)
                            intent.putExtra(Plan.Monthf,allMonthFram)
                            intent.putExtra(Plan.Yearf,allYearFram)
                            intent.putExtra(Plan.Rice_quantityf,allRiceqFram)
                            intent.putExtra(Plan.Fformula1,allFf1)
                            intent.putExtra(Plan.Fformula2,allFf2)
                            intent.putExtra(Plan.Fformula3,allFf3)
                            intent.putExtra(Plan.Mfertilizer1,allMf1)
                            intent.putExtra(Plan.Mfertilizer2,allMf2)
                            intent.putExtra(Plan.Mfertilizer3,allMf3)
                            startActivity(intent)
                        }else{
                            val intent = Intent(this, Calendar_Noti2::class.java)
                            intent.putExtra(Plan.idFram,idplan)
                            intent.putExtra(Plan.addressfram,allAddressFram)
                            intent.putExtra(Plan.namefram,allUserFram)
                            intent.putExtra(Plan.ariafram,allAreaFram)
                            intent.putExtra(Plan.Ricef,allRiceFram)
                            intent.putExtra(Plan.Typef,allTypeFram)
                            intent.putExtra(Plan.attributef,allAttributeFram)
                            intent.putExtra(Plan.Dayf,allDayFram)
                            intent.putExtra(Plan.Monthf,allMonthFram)
                            intent.putExtra(Plan.Yearf,allYearFram)
                            intent.putExtra(Plan.Rice_quantityf,allRiceqFram)
                            intent.putExtra(Plan.Fformula1,allFf1)
                            intent.putExtra(Plan.Fformula2,allFf2)
                            intent.putExtra(Plan.Fformula3,allFf3)
                            intent.putExtra(Plan.Mfertilizer1,allMf1)
                            intent.putExtra(Plan.Mfertilizer2,allMf2)
                            intent.putExtra(Plan.Mfertilizer3,allMf3)
                            startActivity(intent)
                        }
                    }else{
                        if (allRiceFram  == "นาดำ"){
                            val intent = Intent(this, Calendar_Noti_chemical::class.java)
                            intent.putExtra(NO_Chemical_plan.idFram,idplan)
                            intent.putExtra(NO_Chemical_plan.addressfram,allAddressFram)
                            intent.putExtra(NO_Chemical_plan.namefram,allUserFram)
                            intent.putExtra(NO_Chemical_plan.areafram,allAreaFram)
                            intent.putExtra(NO_Chemical_plan.Ricef,allRiceFram)
                            intent.putExtra(NO_Chemical_plan.Typef,allTypeFram)
                            intent.putExtra(NO_Chemical_plan.attributef,allAttributeFram)
                            intent.putExtra(NO_Chemical_plan.Dayf,allDayFram)
                            intent.putExtra(NO_Chemical_plan.Monthf,allMonthFram)
                            intent.putExtra(NO_Chemical_plan.Yearf,allYearFram)
                            intent.putExtra(NO_Chemical_plan.Rice_quantityf,allRiceqFram)
                            intent.putExtra(NO_Chemical_plan.Fformula1,allFf1)
                            intent.putExtra(NO_Chemical_plan.Mfertilizer1,allMf1)
                            startActivity(intent)
                        }else{
                            val intent = Intent(this, Calendar_Noti_chemical2::class.java)
                            intent.putExtra(NO_Chemical_plan.idFram,idplan)
                            intent.putExtra(NO_Chemical_plan.addressfram,allAddressFram)
                            intent.putExtra(NO_Chemical_plan.namefram,allUserFram)
                            intent.putExtra(NO_Chemical_plan.areafram,allAreaFram)
                            intent.putExtra(NO_Chemical_plan.Ricef,allRiceFram)
                            intent.putExtra(NO_Chemical_plan.Typef,allTypeFram)
                            intent.putExtra(NO_Chemical_plan.attributef,allAttributeFram)
                            intent.putExtra(NO_Chemical_plan.Dayf,allDayFram)
                            intent.putExtra(NO_Chemical_plan.Monthf,allMonthFram)
                            intent.putExtra(NO_Chemical_plan.Yearf,allYearFram)
                            intent.putExtra(NO_Chemical_plan.Rice_quantityf,allRiceqFram)
                            intent.putExtra(NO_Chemical_plan.Fformula1,allFf1)
                            intent.putExtra(NO_Chemical_plan.Mfertilizer1,allMf1)
                            startActivity(intent)
                        }
                    }
                }
            }
        }

    }

}
