package com.tiwlynaja.admin.konklav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose_plan.*

class choose_plan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_plan)

        val name_Farm = intent.getStringExtra(Create_plots.NameFarm)
        var aria = intent.getStringExtra(Create_plots.Framland)
        val address = intent.getStringExtra(Create_plots.address)
        val rice = intent.getStringExtra(Create_plots.rice)
        val type = intent.getStringExtra(Create_plots.cultivation)
        val Attribute = intent.getStringExtra(Create_plots.type)
        var day = intent.getStringExtra(Create_plots.Day)
        var year =intent.getStringExtra(Create_plots.Year)
        var month = intent.getStringExtra(Create_plots.Month)



        introduce.setOnClickListener {
            if (Attribute == "ไม่ใช้สารเคมี"){
                NO_Chemical_plan(name_Farm, aria, address, rice,type, Attribute, day, year, month)
            }else{
                Master_plan(name_Farm, aria, address, rice, type, Attribute, day, year, month)
            }

        }

        introduce_all.setOnClickListener {
           all_Plan_User(name_Farm, aria, address, rice, type, Attribute, day, year, month)
        }

    }

    companion object{
        var name = "namefram"
        var Framland = "Fraland"
        var Address = "address_Farm"
        var Rice = "Rice"
        var cultivation = "Cultivation"
        var Type = "Type"
        var Day = "day"
        var Month = "month"
        var Year = "year"

    }
    private fun Master_plan(nameFarm: String?, aria: String?, address: String?, rice: String?, type: String?, attribute: String?, day: String?, year: String?, month: String?) {
        val intent = Intent(this, Plan::class.java)
            intent.putExtra(name,nameFarm)
            intent.putExtra(Framland,aria)
            intent.putExtra(Address,address)
            intent.putExtra(Rice,rice)
            intent.putExtra(cultivation,type)
            intent.putExtra(Type,attribute)
            intent.putExtra(Day,day)
            intent.putExtra(Month,month)
            intent.putExtra(Year,year)
        startActivity(intent)
    }
    private fun all_Plan_User(nameFarm: String?, aria: String?, address: String?, rice: String?, type: String?, attribute: String?, day: String?, year: String?, month: String?) {
        val intent = Intent(this, listAllPlan::class.java)
        intent.putExtra(name,nameFarm)
        intent.putExtra(Framland,aria)
        intent.putExtra(Address,address)
        intent.putExtra(Rice,rice)
        intent.putExtra(cultivation,type)
        intent.putExtra(Type,attribute)
        intent.putExtra(Day,day)
        intent.putExtra(Month,month)
        intent.putExtra(Year,year)
        startActivity(intent)
    }

    private fun NO_Chemical_plan(nameFarm: String, aria: String, address: String, rice: String, type: String, attribute: String, day: String, year: String, month: String) {
        val intent = Intent(this, NO_Chemical_plan::class.java)
        intent.putExtra(name,nameFarm)
        intent.putExtra(Framland,aria)
        intent.putExtra(Address,address)
        intent.putExtra(Rice,rice)
        intent.putExtra(cultivation,type)
        intent.putExtra(Type,attribute)
        intent.putExtra(Day,day)
        intent.putExtra(Month,month)
        intent.putExtra(Year,year)
        startActivity(intent)
    }

}
