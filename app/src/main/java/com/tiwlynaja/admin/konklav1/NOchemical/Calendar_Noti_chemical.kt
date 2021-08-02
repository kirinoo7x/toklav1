package com.tiwlynaja.admin.konklav1.NOchemical

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.tiwlynaja.admin.konklav1.*
import com.tiwlynaja.admin.konklav1.check.Check_water
import com.tiwlynaja.admin.konklav1.check.NO_chemical_N1
import com.tiwlynaja.admin.konklav1.check.checkRice
import com.tiwlynaja.admin.konklav1.check.completed
import kotlinx.android.synthetic.main.activity_calendar__noti_chemical.*

class Calendar_Noti_chemical : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar__noti_chemical)

        var idf = intent.getStringExtra(NO_Chemical_plan.idFram) // idf fram
        var name_f = intent.getStringExtra(NO_Chemical_plan.namefram)
        var address_f= intent.getStringExtra(NO_Chemical_plan.addressfram)
        var ida0000 =intent.getStringExtra(NO_Chemical_plan.ida00)






        var sid = intent.getStringExtra(edit_noChemical_plan.idFram)
        var ida000 = intent.getStringExtra(edit_noChemical_plan.ida00)
        var name_ff = intent.getStringExtra(edit_noChemical_plan.namefram)
        var address_ff= intent.getStringExtra(edit_noChemical_plan.addressfram)






        val ss = "รอดำเนินการ"
        val sl = "ดำเนินการเสร้จสิ้น"
        val no = "วันที่ดำเนินการ"
        save1.setImageResource(R.drawable.but23)
        backtomain.setImageResource(R.drawable.but18)
        println("------------------------h1--------------------------------"+idf)
        println("------------------------h2--------------------------------"+sid)
        imageView15.setImageResource(R.mipmap.trasho)
        if (idf == null){
            a0(sid,ss,sl,name_ff,address_ff,ida000,no)
            addressfarm.setText(address_ff)
            namefarm.setText(name_ff)


            imageView15.setOnClickListener {
                var userId = FirebaseAuth.getInstance().uid
                val del_DB_plan = FirebaseDatabase.getInstance().getReference("plan/$userId")
                del_DB_plan.child("$sid").removeValue()
                val all_del_DB = FirebaseDatabase.getInstance().getReference("plan_all")
                all_del_DB.child("$sid").removeValue()
                val activity_dal =FirebaseDatabase.getInstance().getReference("activity")
                activity_dal.child("$sid").removeValue()
                Toast.makeText(this,"Del", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainPageApp::class.java)
                startActivity(intent)
            }
            backtomain.setOnClickListener {
                var userId = FirebaseAuth.getInstance().uid
                val del_DB_plan = FirebaseDatabase.getInstance().getReference("plan/$userId")
                del_DB_plan.child("$sid").removeValue()
                val all_del_DB = FirebaseDatabase.getInstance().getReference("plan_all")
                all_del_DB.child("$sid").removeValue()
                val activity_dal =FirebaseDatabase.getInstance().getReference("activity")
                activity_dal.child("$sid").removeValue()
                Toast.makeText(this,"Del", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainPageApp::class.java))
            }

        }else{
            a0(idf,ss,sl,name_f,address_f,ida0000,no) // แก้
            addressfarm.setText(address_f)
            namefarm.setText(name_f)


            imageView15.setOnClickListener {
                var userId = FirebaseAuth.getInstance().uid
                val del_DB_plan = FirebaseDatabase.getInstance().getReference("plan/$userId")
                del_DB_plan.child("$idf").removeValue()
                val all_del_DB = FirebaseDatabase.getInstance().getReference("plan_all")
                all_del_DB.child("$idf").removeValue()
                val activity_dal =FirebaseDatabase.getInstance().getReference("activity")
                activity_dal.child("$idf").removeValue()
                Toast.makeText(this,"Del", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Create_plots::class.java)
                startActivity(intent)
            }
            backtomain.setOnClickListener {
                var userId = FirebaseAuth.getInstance().uid
                val del_DB_plan = FirebaseDatabase.getInstance().getReference("plan/$userId")
                del_DB_plan.child("$idf").removeValue()
                val all_del_DB = FirebaseDatabase.getInstance().getReference("plan_all")
                all_del_DB.child("$idf").removeValue()
                val activity_dal =FirebaseDatabase.getInstance().getReference("activity")
                activity_dal.child("$idf").removeValue()
                Toast.makeText(this,"Del", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainPageApp::class.java))
            }


        }
    }
    companion object{
        var name_fff = "name_ffff"
        var address_fff ="address_fff"
        var name_ff = "name_ff"
        var address_ff = "address_ff"
        var activityf = "a"
        var idAf = "idFrame"
        var intro = "intro"
        var intro_i = "intro_i"
        var ida00 = "ida0"
        var netxx = "netx"
        var coutA= "couteA"
        val areafram = "ariafram"
        val Ricef = "rice" // พันธุ์ข้าว
        val Typef = "cultivation rice" // วิธีการเพาะปลูก
        val Attributef = "Attribute" // ปลูกแบบ ใช้สาารเคมี
        val Dayf = "day"
        val Monthf = "month"
        val Yearf = "year"
        val Rice_quantityf = "quantity_rice" // ปริมาณพันธุ์ข้าวที่ต้องใช้
        val Fformula1 = "formula1"  //สูตรปุ๋ย
        val Mfertilizer1 = "Mfertilizer1" // ปริมาณปุ๋ย
        val idFram = "idfram"
        val idff ="idf"
    }

    private fun a0(idf:String, ss:String, sl:String,name_f:String,address_f:String,ida0:String,no:String){

        save1.setOnClickListener {
            val intent = Intent(this, Noti_nochemical::class.java)
            intent.putExtra(idff,idf)
            intent.putExtra(name_fff,name_f)
            intent.putExtra(address_fff,address_f)
            startActivity(intent)
        }
        val intro1 = "1.ไถกลบตอชัง"
        val intro11 = "ให้ทำการเตรียมดินพร้อมกับการไถกลบตอซังและฟางข้าว"
        val Aty_1 = "0"
        val nex = "0"
        introduce1.setText(intro1)

        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity0")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()

                        day.setText(d)
                        month.setText(m)
                        yy.setText(y)
                        if(s == "no"){
                            status1.setText(ss)

                        }else{
                            status1.setText(sl)
                            no1.setText(no)
                        }

                        a1(idf,ss,sl,name_f,address_f,no)
                        imageView11.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_1,intro1,intro11,ida0,nex,s)

                        }

                    }

            }


        })
    }

    private fun a1(idf: String,ss: String,sl: String,name_f:String,address_f:String,no: String){
        val intro2 = "2.ปลูกพืชปุ๋ยสด"
        val intro22 = "ปลูกพืชปุ๋ยสด เช่น ถั่วพร้า ปอเทือง 7 กิโลกรัมต่อไร"
        val Aty_2 = "1"
        val nex = "30"
        introduce2.setText(intro2)
        status2.setText(ss)
        a3(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity1")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd2.setText(d)
                        mm2.setText(m)
                        yy2.setText(y)
                        val id1 = id
                        println("+++++++++++++++++++++++++++++++++++++++++++"+id1)

                        if(s == "no"){
                            status2.setText(ss)
                        }else{
                            status2.setText(sl)
                            no2.setText(no)

                        }
                        imageView16.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_2,intro2,intro22,id1,nex,s)
                        }

                    }

            }


        })
    }

    private fun a3(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro3 = "3. ไถดะครั้งที่1"
        val intro33 = "เพื่อกระตุ้นให้วัชพืชงอก ทิ้งไว 14 วัน"
        val Aty_3 = "2"
        val nex = "14"
        introduce3.setText(intro3)
        status3.setText(ss)
        a4(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity2")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd3.setText(d)
                        mm3.setText(m)
                        yy3.setText(y)
                        val id1 = id

                        if(s == "no"){
                            status3.setText(ss)
                        }else{
                            status3.setText(sl)
                            no3.setText(no)

                        }
                        imageView25.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_3,intro3,intro33,id1,nex,s)
                        }
                    }
            }
        })
    }
    private fun a4(idf: String,ss: String,sl: String,name_f:String,address_f:String,no: String){
        val intro3 = "4.ไถดะครั้งที่2"
        val intro33 = "ไถดะเพื่อตากดินไว้อีก 7 วัน"
        val Aty_3 = "3"
        val nex = "7"

        introduce4.setText(intro3)
        status4.setText(ss)
        a5(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity3")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd4.setText(d)
                        mm4.setText(m)
                        yy4.setText(y)
                        val id1 = id
                        if(s == "no"){
                            status4.setText(ss)
                        }else{
                            status4.setText(sl)
                            no4.setText(no)

                        }
                        imageView26.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_3,intro3,intro33,id1,nex,s)
                        }

                    }

            }


        })
    }
    private fun a5(idf: String,ss: String,sl: String,name_f:String,address_f:String,no: String){
        val intro4 = "5.คัดเมล็ดพันธุ์"
        val intro44 = "คัดเมล็ดและนำเมล็ดพันธุ์ที่ได้จากการคัดไปแช่น้ำ"
        val Aty_4 = "4"
        val nex = "1"
        introduce5.setText(intro4)
        status5.setText(ss)
        a6(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity4")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd5.setText(d)
                        mm5.setText(m)
                        yy5.setText(y)
                        val id1 = id
                        if(s == "no"){
                            status5.setText(ss)
                        }else{
                            status5.setText(sl)
                            no5.setText(no)

                        }
                        imageView27.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_4,intro4,intro44,id1,nex,s)
                        }

                    }

            }


        })
    }

    private fun a6(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro6 = "6.คัดเมล็ดพันธุ์"
        val intro66 = "นำเมล็ดพันธุ์ที่แช่น้ำขึ้นมากตากทิ้งไว"
        val Aty_6 = "5"
        val nex = "1"

        introduce6.setText(intro6)
        status6.setText(ss)
        a7(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity5")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd6.setText(d)
                        mm6.setText(m)
                        yy6.setText(y)
                        val id1 = id
                        if(s == "no"){
                            status6.setText(ss)
                        }else{
                            status6.setText(sl)
                            no6.setText(no)

                        }
                        imageView28.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_6,intro6,intro66,id1,nex,s)
                        }

                    }

            }

        })
    }
    private fun a7(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        var intro7 = "\t\t\t7.ตรวจสอบเมล็ดพันธุ์"
        val intro77 = "ตรวจสอบเมล็ดพันธุ์หากพบเมล็ดพันธุ์งอกเป็นตาตุ่ม \n 'กรุณากรอบวันที่' "
        val Aty_7 = "6"
        val nex = "0"

        introduce7.setText(intro7)
        status7.setText(ss)
        a8(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity6")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd7.setText(d)
                        mm7.setText(m)
                        yy7.setText(y)
                        val id1 = id
                        if(s == "no"){
                            status7.setText(ss)
                        }else{
                            status7.setText(sl)
                            no7.setText(no)

                        }
                        imageView29.setOnClickListener {
                            var intro = "7.ตรวจสอบเมล็ดพันธุ์"
                            toA_no_chemical(idf,name_f,address_f,Aty_7,intro,intro77,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a8(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro8 ="8.ใส่ปุ๋ยคอก"
        val intro88 = "ใส่ปุ๋ยคอกแปลงกล้าและแปลงปักดำ"
        val Aty_8 = "7"
        val nex = "0"
        introduce8.setText(intro8)
        status8.setText(ss)
        a9(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity7")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd8.setText(d)
                        mm8.setText(m)
                        yy8.setText(y)
                        val id1 = id
                        if(s == "no"){
                            status8.setText(ss)
                        }else{
                            status8.setText(sl)
                            no8.setText(no)

                        }
                        imageView30.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_8,intro8,intro88,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a9(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro9 = "\t\t\t\t\t\t\t\t\t\t9.ตรวจสอบปริมาณน้ำบริเวณแปลงกล้า"
        val intro99 = "ตรวจสอบปริมาณน้ำที่ใช้ในแปลงกล้า จะต้องมีน้ำอยู่ที่ 7-15 ซม"
        val Aty_9 = "8"
        val nex = "0"
        introduce9.setText(intro9)
        status9.setText(ss)
        a10(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity8")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd9.setText(d)
                        mm9.setText(m)
                        yy9.setText(y)
                        val id1 = id
                        if(s == "no"){
                            status9.setText(ss)
                        }else{
                            status9.setText(sl)
                            no9.setText(no)

                        }
                        imageView31.setOnClickListener {
                            var intro="9.ตรวจสอบปริมาณน้ำบริเวณแปลงกล้า"
                            toA_no_check_water(idf,name_f,address_f,Aty_9,intro,intro99,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a10(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro10 = "\t\t\t\t\t10.ทำการไถดะและไถคราด"
        val intro100 = "ทำการไถดะและไถคราด บริเวณแปลงนากล้า"
        val Aty_10 = "9"
        val nex = "0"

        introduce10.setText(intro10)
        status10.setText(ss)
        a11(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity9")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd10.setText(d)
                        mm10.setText(m)
                        yy10.setText(y)
                        val id1 = id
                        if(s == "no"){
                            status10.setText(ss)
                        }else{
                            status10.setText(sl)
                            no10.setText(no)

                        }
                        imageView32.setOnClickListener {
                            var intro = "10.ทำการไถดะและไถคราด"
                            toA_no_chemical(idf,name_f,address_f,Aty_10,intro,intro100,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a11(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro11 = "11.การตกกล้า"
        val intro111 = "หว่านงอกลงบนแปลงกล้าให้กระจายทั่วแปลงในอัตรา 50 กรัมต่อ\nตารางเมตร หรือ 1 กิโลกรัมต่อ 20 ตารางเมตร\n ปริมาณข้าวที่ต้อง 'หน้าหลัก'"
        val Aty_11 = "10"
        val nex = "23"

        introduce11.setText(intro11)
        status11.setText(ss)
        a12(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity10")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd11.setText(d)
                        mm11.setText(m)
                        yy11.setText(y)
                        val id1 = id
                        if(s == "no"){
                            status11.setText(ss)
                        }else{
                            status11.setText(sl)
                            no11.setText(no)

                        }
                        imageView33.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_11,intro11,intro111,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a12(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro12 = "\t\t\t\t\t\t\t\t12.ตรวจสอบน้ำบริเวณแปลงปักดำ"
        val intro122 = "ตรวจสอบปริมาณน้ำที่ใช้ในแปลงกล้า จะต้องมีน้ำอยู่ที่ 7-15 ซม"
        val Aty_12 = "11"
        val nex = "0"

        introduce12.setText(intro12)
        status12.setText(ss)
        a13(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity11")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd12.setText(d)
                        mm12.setText(m)
                        yy12.setText(y)
                        val id1 = id
                        var intro="12.ตรวจสอบน้ำบริเวณแปลงปักดำ"
                        if(s == "no"){
                            status12.setText(ss)
                        }else{
                            status12.setText(sl)
                            no12.setText(no)

                        }
                        imageView34.setOnClickListener {
                            toA_no_check_water(idf,name_f,address_f,Aty_12,intro,intro122,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a13(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro13 = "\t\t\t13.ไถดะและไถคราด"
        val intro133 = "ไถดะและไถคราด บริเวณแปลงนาดำ"
        val Aty_13 = "12"
        val nex = "0"

        introduce13.setText(intro13)
        status13.setText(ss)
        a14(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity12")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd13.setText(d)
                        mm13.setText(m)
                        yy13.setText(y)
                        val id1 = id
                        val intro = "13.ไถดะและไถคราด"
                        if(s == "no"){
                            status13.setText(ss)
                        }else{
                            status13.setText(sl)
                            no13.setText(no)

                        }
                        imageView35.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_13,intro,intro133,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a14(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro14 ="14.ปักดำ"
        val intro144 = "การปักดำต้นกล้าจะต้องห่างกัน 20 ซม.โดยใช้กล้า 3 ต้นต่อจับ"
        val Aty_14 = "13"
        val nex = "0"

        introduce14.setText(intro14)
        status14.setText(ss)
        a15(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity13")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd14.setText(d)
                        mm14.setText(m)
                        yy14.setText(y)
                        val id1 = id
                        if(s == "no"){
                            status14.setText(ss)
                        }else{
                            status14.setText(sl)
                            no14.setText(no)

                        }
                        imageView36.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_14,intro14,intro144,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a15(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro16 = "\t\t\t\t15.ตรวจสอบระดับน้ำ "
        val intro166 = "ตรวจสอบระดับน้ำ พร้อมกับตรวจสอบข้าวแตกก่อ"
        val Aty_16 = "14"
        val nex = "1"

        introduce16.setText(intro16)
        status16.setText(ss)
        a16(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity14")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd16.setText(d)
                        mm16.setText(m)
                        yy16.setText(y)
                        var intro = "15.ตรวจสอบระดับน้ำ "
                        val id1 = id
                        if(s == "no"){
                            status16.setText(ss)
                        }else{
                            status16.setText(sl)
                            no16.setText(no)

                        }
                        imageView38.setOnClickListener {
                            toA_no_check_rice(idf,name_f,address_f,Aty_16,intro,intro166,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a16(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro17 = "\t\t\t\t16.ตรวจสอบระดับน้ำ "
        val intro177 = "ตรวจสอบระดับน้ำ พร้อมกับตรวจสอบข้าวตั้งท้อง"
        val Aty_17 = "15"
        val nex = "0"

        introduce18.setText(intro17)
        status18.setText(ss)
        a17(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity15")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd18.setText(d)
                        mm18.setText(m)
                        yy18.setText(y)
                        val intro = "16.ตรวจสอบระดับน้ำ "
                        val id1 = id
                        if(s == "no"){
                            status18.setText(ss)
                        }else{
                            status18.setText(sl)
                            no18.setText(no)

                        }
                        imageView40.setOnClickListener {
                            toA_no_check_rice(idf,name_f,address_f,Aty_17,intro17,intro177,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a17(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro18 = "\t\t\t\t\t\t17.ปล่อยน้ำออกจากคันนา"
        val intro188 = "ปล่อยน้ำออกจากคันนา เพื่อรอข้าวสุก"
        val Aty_18 = "16"
        val nex = "15"
        introduce19.setText(intro18)
        status19.setText(ss)
        a18(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity16")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd19.setText(d)
                        mm19.setText(m)
                        yy19.setText(y)
                        val intro = "17.ปล่อยน้ำออกจากคันนา"
                        val id1 = id
                        if(s == "no"){
                            status19.setText(ss)
                        }else{
                            status19.setText(sl)
                            no19.setText(no)

                        }
                        imageView41.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_18,intro,intro188,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a18(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro19 = "18.เก็บเกี่ยวข้าว"
        val intro199 = "เริ่มเก็บเกี่ยวข้าว"
        val Aty_19 = "17"
        val nex = "0"

        introduce21.setText(intro19)
        status21.setText(ss)
        //a18(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity17")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

            }
            override fun onDataChange(p0: DataSnapshot) {
                p0.children
                    .forEach {
                        val d: String = it.child("day").getValue().toString()
                        val m: String = it.child("month").getValue().toString()
                        val y: String = it.child("year").getValue().toString()
                        val s :String = it.child("status").getValue().toString()
                        val id:String = it.child("id").getValue().toString()
                        dd21.setText(d)
                        mm21.setText(m)
                        yy21.setText(y)
                        val id1 = id
                        if(s == "no"){
                            status21.setText(ss)
                        }else{
                            status21.setText(sl)
                            no21.setText(no)

                        }
                        imageView43.setOnClickListener {
                            toA_no_completed(idf,name_f,address_f,Aty_19,intro19,intro199,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun toA_no_chemical(idf: String,name_f:String,address_f:String,Aty:String,introo:String,intro_o: String,ida:String,netx:String,cout:String) {
        val intent = Intent(this, NO_chemical_N1::class.java)
        intent.putExtra(name_ff,name_f)
        intent.putExtra(address_ff,address_f)
        intent.putExtra(activityf,Aty)
        intent.putExtra(idAf,idf)
        intent.putExtra(intro,introo)
        intent.putExtra(intro_i,intro_o)
        intent.putExtra(ida00,ida)
        intent.putExtra(netxx,netx)
        intent.putExtra(coutA,cout)
        startActivity(intent)
    }
    private fun toA_no_check_water(idf: String,name_f:String,address_f:String,Aty:String,introo:String,intro_o: String,ida:String,netx:String,cout:String) {
        val intent = Intent(this, Check_water::class.java)
        intent.putExtra(name_ff,name_f)
        intent.putExtra(address_ff,address_f)
        intent.putExtra(activityf,Aty)
        intent.putExtra(idAf,idf)
        intent.putExtra(intro,introo)
        intent.putExtra(intro_i,intro_o)
        intent.putExtra(ida00,ida)
        intent.putExtra(netxx,netx)
        intent.putExtra(coutA,cout)
        startActivity(intent)
    }
    private fun toA_no_completed(idf: String,name_f:String,address_f:String,Aty:String,introo:String,intro_o: String,ida:String,netx:String,cout:String) {
        val ariaF = intent.getStringExtra(NO_Chemical_plan.areafram)
        val ariaFe = intent.getStringExtra(edit_noChemical_plan.areafram)
        if (ariaF != null){
            val ariaF = intent.getStringExtra(NO_Chemical_plan.areafram)
            val riceF = intent.getStringExtra(NO_Chemical_plan.Ricef)
            val typef = intent.getStringExtra(NO_Chemical_plan.Typef)
            val attributef = intent.getStringExtra(NO_Chemical_plan.attributef)
            val dayF = intent.getStringExtra(NO_Chemical_plan.Dayf)
            val monthF = intent.getStringExtra(NO_Chemical_plan.Monthf)
            val yearF = intent.getStringExtra(NO_Chemical_plan.Yearf)
            val Rice_quanF = intent.getStringExtra(NO_Chemical_plan.Rice_quantityf)
            val Ff1 = intent.getStringExtra(NO_Chemical_plan.Fformula1)
            val Mf1 = intent.getStringExtra(NO_Chemical_plan.Mfertilizer1)

            val intent = Intent(this, completed::class.java)
            intent.putExtra(name_ff,name_f)
            intent.putExtra(address_ff,address_f)
            intent.putExtra(activityf,Aty)
            intent.putExtra(idAf,idf)
            intent.putExtra(intro,introo)
            intent.putExtra(intro_i,intro_o)
            intent.putExtra(ida00,ida)
            intent.putExtra(netxx,netx)
            intent.putExtra(coutA,cout)

            intent.putExtra(areafram,ariaF)
            intent.putExtra(Ricef,riceF)
            intent.putExtra(Typef,typef)
            intent.putExtra(Attributef,attributef)
            intent.putExtra(Dayf,dayF)
            intent.putExtra(Monthf,monthF)
            intent.putExtra(Yearf,yearF)
            intent.putExtra(Rice_quantityf,Rice_quanF)
            intent.putExtra(Fformula1,Ff1)
            intent.putExtra(Mfertilizer1,Mf1)
            startActivity(intent)
        }else{
            val ariaF = intent.getStringExtra(edit_noChemical_plan.areafram)
            val riceF = intent.getStringExtra(edit_noChemical_plan.Ricef)
            val typef = intent.getStringExtra(edit_noChemical_plan.Typef)
            val attributef = intent.getStringExtra(edit_noChemical_plan.attributef)
            val dayF = intent.getStringExtra(edit_noChemical_plan.Dayf)
            val monthF = intent.getStringExtra(edit_noChemical_plan.Monthf)
            val yearF = intent.getStringExtra(edit_noChemical_plan.Yearf)
            val Rice_quanF = intent.getStringExtra(edit_noChemical_plan.Rice_quantityf)
            val Ff1 = intent.getStringExtra(edit_noChemical_plan.Fformula)
            val Mf1 = intent.getStringExtra(edit_noChemical_plan.Mfertilizer)

            val intent = Intent(this, completed::class.java)
            intent.putExtra(name_ff,name_f)
            intent.putExtra(address_ff,address_f)
            intent.putExtra(activityf,Aty)
            intent.putExtra(idAf,idf)
            intent.putExtra(intro,introo)
            intent.putExtra(intro_i,intro_o)
            intent.putExtra(ida00,ida)
            intent.putExtra(netxx,netx)
            intent.putExtra(coutA,cout)
            intent.putExtra(areafram,ariaF)
            intent.putExtra(Ricef,riceF)
            intent.putExtra(Typef,typef)
            intent.putExtra(Attributef,attributef)
            intent.putExtra(Dayf,dayF)
            intent.putExtra(Monthf,monthF)
            intent.putExtra(Yearf,yearF)
            intent.putExtra(Rice_quantityf,Rice_quanF)
            intent.putExtra(Fformula1,Ff1)
            intent.putExtra(Mfertilizer1,Mf1)
            startActivity(intent)
        }




    }
    private fun toA_no_check_rice(idf: String,name_f:String,address_f:String,Aty:String,introo:String,intro_o: String,ida:String,netx:String,cout:String) {
        val intent = Intent(this, checkRice::class.java)
        intent.putExtra(name_ff,name_f)
        intent.putExtra(address_ff,address_f)
        intent.putExtra(activityf,Aty)
        intent.putExtra(idAf,idf)
        intent.putExtra(intro,introo)
        intent.putExtra(intro_i,intro_o)
        intent.putExtra(ida00,ida)
        intent.putExtra(netxx,netx)
        intent.putExtra(coutA,cout)
        startActivity(intent)
    }

}

