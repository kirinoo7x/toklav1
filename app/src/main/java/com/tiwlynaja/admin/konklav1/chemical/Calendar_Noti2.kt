package com.tiwlynaja.admin.konklav1.chemical

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
import com.tiwlynaja.admin.konklav1.NOchemical.Calendar_Noti_chemical
import com.tiwlynaja.admin.konklav1.check.Check_water
import com.tiwlynaja.admin.konklav1.check.NO_chemical_N1
import com.tiwlynaja.admin.konklav1.check.checkRice
import com.tiwlynaja.admin.konklav1.check.completed_chemical
import kotlinx.android.synthetic.main.activity_calendar__noti.*
import kotlinx.android.synthetic.main.activity_calendar__noti2.*
import kotlinx.android.synthetic.main.activity_calendar__noti2.addressfarm
import kotlinx.android.synthetic.main.activity_calendar__noti2.day
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd10
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd11
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd12
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd13
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd15
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd16
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd17
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd18
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd19
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd2
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd3
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd4
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd5
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd6
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd7
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd8
import kotlinx.android.synthetic.main.activity_calendar__noti2.dd9
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView11
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView15
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView16
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView25
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView26
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView27
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView28
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView29
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView30
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView31
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView32
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView33
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView34
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView35
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView37
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView38
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView39
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView41
import kotlinx.android.synthetic.main.activity_calendar__noti2.imageView43
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce1
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce10
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce12
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce13
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce15
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce16
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce17
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce18
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce19
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce2
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce3
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce4
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce5
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce6
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce7
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce8
import kotlinx.android.synthetic.main.activity_calendar__noti2.introduce9
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm10
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm11
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm12
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm13
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm15
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm16
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm17
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm18
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm19
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm2
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm3
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm4
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm5
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm6
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm7
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm8
import kotlinx.android.synthetic.main.activity_calendar__noti2.mm9
import kotlinx.android.synthetic.main.activity_calendar__noti2.month
import kotlinx.android.synthetic.main.activity_calendar__noti2.namefarm
import kotlinx.android.synthetic.main.activity_calendar__noti2.no1
import kotlinx.android.synthetic.main.activity_calendar__noti2.no10
import kotlinx.android.synthetic.main.activity_calendar__noti2.no11
import kotlinx.android.synthetic.main.activity_calendar__noti2.no12
import kotlinx.android.synthetic.main.activity_calendar__noti2.no13
import kotlinx.android.synthetic.main.activity_calendar__noti2.no15
import kotlinx.android.synthetic.main.activity_calendar__noti2.no17
import kotlinx.android.synthetic.main.activity_calendar__noti2.no18
import kotlinx.android.synthetic.main.activity_calendar__noti2.no19
import kotlinx.android.synthetic.main.activity_calendar__noti2.no2
import kotlinx.android.synthetic.main.activity_calendar__noti2.no3
import kotlinx.android.synthetic.main.activity_calendar__noti2.no4
import kotlinx.android.synthetic.main.activity_calendar__noti2.no5
import kotlinx.android.synthetic.main.activity_calendar__noti2.no6
import kotlinx.android.synthetic.main.activity_calendar__noti2.no7
import kotlinx.android.synthetic.main.activity_calendar__noti2.no8
import kotlinx.android.synthetic.main.activity_calendar__noti2.no9
import kotlinx.android.synthetic.main.activity_calendar__noti2.save
import kotlinx.android.synthetic.main.activity_calendar__noti2.save1
import kotlinx.android.synthetic.main.activity_calendar__noti2.backtomain
import kotlinx.android.synthetic.main.activity_calendar__noti2.status1
import kotlinx.android.synthetic.main.activity_calendar__noti2.status10
import kotlinx.android.synthetic.main.activity_calendar__noti2.status12
import kotlinx.android.synthetic.main.activity_calendar__noti2.status13
import kotlinx.android.synthetic.main.activity_calendar__noti2.status15
import kotlinx.android.synthetic.main.activity_calendar__noti2.status16
import kotlinx.android.synthetic.main.activity_calendar__noti2.status17
import kotlinx.android.synthetic.main.activity_calendar__noti2.status18
import kotlinx.android.synthetic.main.activity_calendar__noti2.status19
import kotlinx.android.synthetic.main.activity_calendar__noti2.status2
import kotlinx.android.synthetic.main.activity_calendar__noti2.status3
import kotlinx.android.synthetic.main.activity_calendar__noti2.status4
import kotlinx.android.synthetic.main.activity_calendar__noti2.status5
import kotlinx.android.synthetic.main.activity_calendar__noti2.status6
import kotlinx.android.synthetic.main.activity_calendar__noti2.status7
import kotlinx.android.synthetic.main.activity_calendar__noti2.status8
import kotlinx.android.synthetic.main.activity_calendar__noti2.status9
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy10
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy11
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy12
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy13
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy15
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy16
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy17
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy18
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy19
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy2
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy3
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy4
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy5
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy6
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy7
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy8
import kotlinx.android.synthetic.main.activity_calendar__noti2.yy9

class Calendar_Noti2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar__noti2)

        val id = intent.getStringExtra(Plan.idFram)
        val namef = intent.getStringExtra(Plan.namefram)
        val address = intent.getStringExtra(Plan.addressfram)

        namefarm.setText(namef)
        addressfarm.setText(address)



        val ss = "รอดำเนินการ"
        val sl = "ดำเนินการเสร้จสิ้น"
        val no = "วันที่ดำเนินการ"

        save1.setImageResource(R.drawable.but23)
        backtomain.setImageResource(R.drawable.but18)

        namefarm.setText(namef)
        addressfarm.setText(address)
        imageView15.setImageResource(R.mipmap.trasho)
        imageView15.setOnClickListener {
            var userId = FirebaseAuth.getInstance().uid
            val del_DB_plan = FirebaseDatabase.getInstance().getReference("plan/$userId")
            del_DB_plan.child("$id").removeValue()
            val all_del_DB = FirebaseDatabase.getInstance().getReference("plan_all")
            all_del_DB.child("$id").removeValue()
            val activity_dal = FirebaseDatabase.getInstance().getReference("activity")
            activity_dal.child("$id").removeValue()
            Toast.makeText(this,"Del", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainPageApp::class.java)
            startActivity(intent)
        }
        backtomain.setOnClickListener {
            var userId = FirebaseAuth.getInstance().uid
            val del_DB_plan = FirebaseDatabase.getInstance().getReference("plan/$userId")
            del_DB_plan.child("$id").removeValue()
            val all_del_DB = FirebaseDatabase.getInstance().getReference("plan_all")
            all_del_DB.child("$id").removeValue()
            val activity_dal = FirebaseDatabase.getInstance().getReference("activity")
            activity_dal.child("$id").removeValue()
            Toast.makeText(this,"Del", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainPageApp::class.java))
        }


        a0(id,ss,sl,namef,address,no)
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
        val Fformula2 = "formula2"
        val Fformula3 = "formula3"
        val Mfertilizer1 = "Mfertilizer1" // ปริมาณปุ๋ย
        val Mfertilizer2 = "Mfertilizer2"
        val Mfertilizer3 = "Mfertilizer3"
        val idFram = "idfram"
        val idff ="idf"
    }
    private fun a0(idf:String, ss:String, sl:String,name_f:String,address_f:String,no:String){

        save1.setOnClickListener {
            val intent = Intent(this, Noti_chemical::class.java)
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
                        val id :String = it.child("id").getValue().toString()
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
                            toA_no_chemical(idf,name_f,address_f,Aty_1,intro1,intro11,id,nex,s)

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
                        var intro = "7.ตรวจสอบเมล็ดพันธุ์"
                        val id1 = id
                        if(s == "no"){
                            status7.setText(ss)
                        }else{
                            status7.setText(sl)
                            no7.setText(no)

                        }
                        imageView29.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_7,intro,intro77,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a8(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro8 ="8.ใส่ปุ๋ยคอก"
        val intro88 = "ใส่ปุ๋ยคอกแปลงนา"
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
        val intro9 = "\t\t\t\t\t\t\t\t\t\t9.ตรวจสอบปริมาณน้ำบริเวณแปลงนา"
        val intro99 = "ตรวจสอบปริมาณน้ำที่ใช้ในแปลงนา จะต้องมีน้ำอยู่ที่ 7-15 ซม"
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
        a11(idf,ss,sl,name_f,address_f,no)
        introduce10.setText(intro10)
        status10.setText(ss)
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
                        var intro = "10.ทำการไถดะและไถคราด"
                        if(s == "no"){
                            status10.setText(ss)
                        }else{
                            status10.setText(sl)
                            no10.setText(no)

                        }
                        imageView32.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_10,intro,intro100,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a11(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro11 = "\t\t\t\t11.หว่านเมล็ดพันธุ์"
        val intro111 = "หว่านงอกลงบนแปลงกล้าให้กระจายทั่วแปลงในอัตรา 30 กิโลกรัมต่อไร่"
        val Aty_11 = "10"
        val nex = "15"
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
        val intro12 = "12.ตัดต้นข้าว"
        val intro122 = "ตัดต้นข้าวให้ได้ความยาว 5 - 7 ซม"
        val Aty_12 = "11"
        val nex = "1"
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
                        if(s == "no"){
                            status12.setText(ss)
                        }else{
                            status12.setText(sl)
                            no12.setText(no)

                        }
                        imageView34.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_12,intro12,intro122,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a13(idf: String, ss: String, sl: String, name_f:String, address_f:String, no: String) {
        val intro13 ="13.ใส่ปุ๋ยครั้งที่ 1 "
        val intro133 = "ใส่ปุ๋ยครั้งที่ 1 แปลงนา 30 กิโลกรัมต่อไร่"
        val Aty_13 = "12"
        val nex = "1"
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
                        if(s == "no"){
                            status13.setText(ss)
                        }else{
                            status13.setText(sl)
                            no13.setText(no)
                        }
                        imageView35.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_13,intro13,intro133,id1,nex,s)
                        }

                    }

            }

        })

    }

    private fun a14(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro14 = "\t\t\t\t14.ตรวจสอบระดับน้ำ "
        val intro144 = "ตรวจสอบระดับน้ำ พร้อมกับตรวจสอบข้าวแตกก่อ"
        val Aty_14 = "13"
        val nex = "1"

        introduce15.setText(intro14)
        status15.setText(ss)
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
                        dd15.setText(d)
                        mm15.setText(m)
                        yy15.setText(y)
                        var intro = "14.ตรวจสอบระดับน้ำ "
                        val id1 = id
                        if(s == "no"){
                            status15.setText(ss)
                        }else{
                            status15.setText(sl)
                            no15.setText(no)

                        }
                        imageView37.setOnClickListener {
                            toA_no_check_rice(idf,name_f,address_f,Aty_14,intro,intro144,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a15(idf: String, ss: String, sl: String, name_f:String, address_f:String, no: String) {
        val intro15 ="15.ใส่ปุ๋ยครั้งที่2"
        val intro155 = "ใส่ปุ๋ยครั้งที่ 2 แปลงนา 10 กิโลกรัมต่อไร่"
        val Aty_15 = "14"
        val nex = "1"
        introduce16.setText(intro15)
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
                        val id1 = id
                        if(s == "no"){
                            status14.setText(ss)
                        }else{
                            status14.setText(sl)
                            no14.setText(no)
                        }
                        imageView38.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_15,intro15,intro155,id1,nex,s)
                        }

                    }

            }

        })

    }

    private fun a16(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro16 = "\t\t\t\t16.ตรวจสอบระดับน้ำ "
        val intro166 = "ตรวจสอบระดับน้ำ พร้อมกับตรวจสอบข้าวตั้งท้อง"
        val Aty_16 = "15"
        val nex = "0"

        introduce17.setText(intro16)
        status17.setText(ss)
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
                        dd17.setText(d)
                        mm17.setText(m)
                        yy17.setText(y)
                        val intro = "16.ตรวจสอบระดับน้ำ "
                        val id1 = id
                        if(s == "no"){
                            status17.setText(ss)
                        }else{
                            status17.setText(sl)
                            no17.setText(no)

                        }
                        imageView39.setOnClickListener {
                            toA_no_check_rice(idf,name_f,address_f,Aty_16,intro16,intro166,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a17(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro17 = "\t\t\t\t\t\t17.ปล่อยน้ำออกจากคันนา"
        val intro177 = "ปล่อยน้ำออกจากคันนา เพื่อรอข้าวสุก"
        val Aty_17 = "16"
        val nex = "15"
        introduce18.setText(intro17)
        status18.setText(ss)
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
                        dd18.setText(d)
                        mm18.setText(m)
                        yy18.setText(y)
                        val intro = "17.ปล่อยน้ำออกจากคันนา"
                        val id1 = id
                        if(s == "no"){
                            status18.setText(ss)
                        }else{
                            status18.setText(sl)
                            no18.setText(no)

                        }
                        imageView41.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_17,intro,intro177,id1,nex,s)
                        }

                    }

            }

        })
    }

    private fun a18(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro18 = "18.เก็บเกี่ยวข้าว"
        val intro188 = "เริ่มเก็บเกี่ยวข้าว"
        val Aty_18 = "17"
        val nex = "0"

        introduce19.setText(intro18)
        status19.setText(ss)
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
                        dd19.setText(d)
                        mm19.setText(m)
                        yy19.setText(y)
                        val id1 = id
                        if(s == "no"){
                            status19.setText(ss)
                        }else{
                            status19.setText(sl)
                            no19.setText(no)

                        }
                        imageView43.setOnClickListener {
                            toA_no_completed(idf,name_f,address_f,Aty_18,intro18,intro188,id1,nex,s)
                        }

                    }

            }

        })
    }


    private fun toA_no_chemical(idf: String,name_f:String,address_f:String,Aty:String,introo:String,intro_o: String,ida:String,netx:String,cout:String) {
        val intent = Intent(this, NO_chemical_N1::class.java)
        intent.putExtra(Calendar_Noti_chemical.name_ff,name_f)
        intent.putExtra(Calendar_Noti_chemical.address_ff,address_f)
        intent.putExtra(Calendar_Noti_chemical.activityf,Aty)
        intent.putExtra(Calendar_Noti_chemical.idAf,idf)
        intent.putExtra(Calendar_Noti_chemical.intro,introo)
        intent.putExtra(Calendar_Noti_chemical.intro_i,intro_o)
        intent.putExtra(Calendar_Noti_chemical.ida00,ida)
        intent.putExtra(Calendar_Noti_chemical.netxx,netx)
        intent.putExtra(Calendar_Noti_chemical.coutA,cout)
        startActivity(intent)
    }
    private fun toA_no_check_water(idf: String,name_f:String,address_f:String,Aty:String,introo:String,intro_o: String,ida:String,netx:String,cout:String) {
        val intent = Intent(this, Check_water::class.java)
        intent.putExtra(Calendar_Noti_chemical.name_ff,name_f)
        intent.putExtra(Calendar_Noti_chemical.address_ff,address_f)
        intent.putExtra(Calendar_Noti_chemical.activityf,Aty)
        intent.putExtra(Calendar_Noti_chemical.idAf,idf)
        intent.putExtra(Calendar_Noti_chemical.intro,introo)
        intent.putExtra(Calendar_Noti_chemical.intro_i,intro_o)
        intent.putExtra(Calendar_Noti_chemical.ida00,ida)
        intent.putExtra(Calendar_Noti_chemical.netxx,netx)
        intent.putExtra(Calendar_Noti_chemical.coutA,cout)
        startActivity(intent)
    }
    private fun toA_no_completed(idf: String,name_f:String,address_f:String,Aty:String,introo:String,intro_o: String,ida:String,netx:String,cout:String) {

        var areaf = intent.getStringExtra(Plan.ariafram)
        var rice = intent.getStringExtra(Plan.Ricef)
        var riceq = intent.getStringExtra(Plan.Rice_quantityf)
        var type = intent.getStringExtra(Plan.Typef)
        var attribute = intent.getStringExtra(Plan.attributef)
        var day = intent.getStringExtra(Plan.Dayf)
        var month = intent.getStringExtra(Plan.Monthf)
        var year = intent.getStringExtra(Plan.Yearf)

        var ff1 = intent.getStringExtra(Plan.Fformula1)
        var ff2 = intent.getStringExtra(Plan.Fformula2)
        var ff3 = intent.getStringExtra(Plan.Fformula3)

        var mf1 = intent.getStringExtra(Plan.Mfertilizer1)
        var mf2 = intent.getStringExtra(Plan.Mfertilizer2)
        var mf3 = intent.getStringExtra(Plan.Mfertilizer3)

        val intent = Intent(this, completed_chemical::class.java)
        intent.putExtra(Calendar_Noti.name_ff,name_f)
        intent.putExtra(Calendar_Noti.address_ff,address_f)
        intent.putExtra(Calendar_Noti.activityf,Aty)
        intent.putExtra(Calendar_Noti.idAf,idf)
        intent.putExtra(Calendar_Noti.intro,introo)
        intent.putExtra(Calendar_Noti.intro_i,intro_o)
        intent.putExtra(Calendar_Noti.ida00,ida)
        intent.putExtra(Calendar_Noti.netxx,netx)
        intent.putExtra(Calendar_Noti.coutA,cout)

        intent.putExtra(Calendar_Noti.areafram,areaf)
        intent.putExtra(Calendar_Noti.Ricef,rice)
        intent.putExtra(Calendar_Noti.Typef,type)
        intent.putExtra(Calendar_Noti.Attributef,attribute)
        intent.putExtra(Calendar_Noti.Dayf,day)
        intent.putExtra(Calendar_Noti.Monthf,month)
        intent.putExtra(Calendar_Noti.Yearf,year)
        intent.putExtra(Calendar_Noti.Rice_quantityf,riceq)
        intent.putExtra(Calendar_Noti.Fformula1,ff1)
        intent.putExtra(Calendar_Noti.Fformula2,ff2)
        intent.putExtra(Calendar_Noti.Fformula3,ff3)
        intent.putExtra(Calendar_Noti.Mfertilizer1,mf1)
        intent.putExtra(Calendar_Noti.Mfertilizer2,mf2)
        intent.putExtra(Calendar_Noti.Mfertilizer3,mf3)
        startActivity(intent)
    }
    private fun toA_no_check_rice(idf: String,name_f:String,address_f:String,Aty:String,introo:String,intro_o: String,ida:String,netx:String,cout:String) {
        val intent = Intent(this, checkRice::class.java)
        intent.putExtra(Calendar_Noti_chemical.name_ff,name_f)
        intent.putExtra(Calendar_Noti_chemical.address_ff,address_f)
        intent.putExtra(Calendar_Noti_chemical.activityf,Aty)
        intent.putExtra(Calendar_Noti_chemical.idAf,idf)
        intent.putExtra(Calendar_Noti_chemical.intro,introo)
        intent.putExtra(Calendar_Noti_chemical.intro_i,intro_o)
        intent.putExtra(Calendar_Noti_chemical.ida00,ida)
        intent.putExtra(Calendar_Noti_chemical.netxx,netx)
        intent.putExtra(Calendar_Noti_chemical.coutA,cout)
        startActivity(intent)
    }

}
