package com.tiwlynaja.admin.konklav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import com.tiwlynaja.admin.konklav1.view.view_nochemical01
import com.tiwlynaja.admin.konklav1.view.view_nochemical02
import com.tiwlynaja.admin.konklav1.view.viewchemical01
import com.tiwlynaja.admin.konklav1.view.viewchemical02
import kotlinx.android.synthetic.main.activity_conclude_plan.fertilizer_1
import kotlinx.android.synthetic.main.activity_conclude_plan.fertilizer_2
import kotlinx.android.synthetic.main.activity_conclude_plan.fertilizer_3
import kotlinx.android.synthetic.main.activity_conclude_plan.formula_fertilizer_1
import kotlinx.android.synthetic.main.activity_conclude_plan.formula_fertilizer_2
import kotlinx.android.synthetic.main.activity_conclude_plan.formula_fertilizer_3
import kotlinx.android.synthetic.main.activity_listfram_multi.addressfarm
import kotlinx.android.synthetic.main.activity_listfram_multi.image_detail
import kotlinx.android.synthetic.main.activity_listfram_multi.namefarm
import kotlinx.android.synthetic.main.activity_multiplan.*

class multiplan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplan)

        var all_namef = intent.getStringExtra(listfram_multi.namefram)
        var all_addressf = intent.getStringExtra(listfram_multi.addressfram)
        var all_ariaf = intent.getStringExtra(listfram_multi.ariafram)
        var all_Typef = intent.getStringExtra(listfram_multi.Typef)
        var all_attributef = intent.getStringExtra(listfram_multi.attributef)
        var all_Rice = intent.getStringExtra(listAllPlan.Ricef)

        var all_day = intent.getStringExtra(listfram_multi.Dayf)
        var all_Month = intent.getStringExtra(listfram_multi.Monthf)
        var all_year = intent.getStringExtra(listfram_multi.Yearf)

        var all_rice_quantity  = intent.getStringExtra(listfram_multi.Rice_quantityf)

        var all_formula1 = intent.getStringExtra(listfram_multi.Fformula1)
        var all_formula2 = intent.getStringExtra(listfram_multi.Fformula2)
        var all_formula3 = intent.getStringExtra(listfram_multi.Fformula3)

        var all_Mfertilizer1 = intent.getStringExtra(listfram_multi.Mfertilizer1)
        var all_Mfertilizer2 = intent.getStringExtra(listfram_multi.Mfertilizer2)
        var all_Mfertilizer3 = intent.getStringExtra(listfram_multi.Mfertilizer3)

        var productf = intent.getStringExtra(listfram_multi.Productf)

        val nameUser =intent.getStringExtra(listfram_multi.namee)
        val addressUser =intent.getStringExtra(listfram_multi.addresss)
        val image =intent.getStringExtra(listfram_multi.imgee)

        val idf = intent.getStringExtra(listfram_multi.idf)
        Picasso.get().load(image).into(image_detail)
        namefarm.setText(nameUser)
        addressfarm.setText(addressUser)

        println(all_namef)
        nameFarm.setText(all_namef)
        addressFarm.setText(all_addressf)
        areaFarm.setText(all_ariaf)
        Rice.setText(all_Rice)
        Type.setText(all_Typef)
        attribute.setText(all_attributef)
        Day.setText(all_day)
        Month.setText(all_Month)
        Year.setText(all_year)
        quantity_rice.setText(all_rice_quantity)
        formula_fertilizer_1.setText(all_formula1)
        fertilizer_1.setText(all_Mfertilizer1)
        formula_fertilizer_2.setText(all_formula2)
        fertilizer_2.setText(all_Mfertilizer2)
        formula_fertilizer_3.setText(all_formula3)
        fertilizer_3.setText(all_Mfertilizer3)

        println(all_attributef)
        println(all_Typef)

        imageView54.setOnClickListener {
            finish()
        }
        calender.setOnClickListener {
            println("hi")
            if (all_attributef == "ใช้สารเคมี"){
                if (all_Typef=="นาดำ"){
                    val i = Intent(this, viewchemical01::class.java)
                    i.putExtra(name,all_namef)
                    i.putExtra(address,all_addressf)
                    i.putExtra(idff,idf)
                    startActivity(i)
                }else{
                    val i = Intent(this, viewchemical02::class.java)
                    i.putExtra(name,all_namef)
                    i.putExtra(address,all_addressf)
                    i.putExtra(idff,idf)
                    startActivity(i)
                }
            }else{
                if (all_Typef=="นาดำ"){
                    val i = Intent(this, view_nochemical01::class.java)
                    i.putExtra(name,all_namef)
                    i.putExtra(address,all_addressf)
                    i.putExtra(idff,idf)
                    startActivity(i)
                }else{
                    val i = Intent(this, view_nochemical02::class.java)
                    i.putExtra(name,all_namef)
                    i.putExtra(address,all_addressf)
                    i.putExtra(idff,idf)
                    startActivity(i)
                }
            }
        }




    }
    companion object{
        val name = "name"
        val address = "address"
        val idff = "idf"
    }
}
