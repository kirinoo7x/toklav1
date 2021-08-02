package com.tiwlynaja.admin.konklav1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.tiwlynaja.admin.konklav1.MainPageApp
import com.tiwlynaja.admin.konklav1.R
import com.tiwlynaja.admin.konklav1.multiplan
import kotlinx.android.synthetic.main.activity_calendar__noti.*

class viewchemical01 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar__noti)
        val idf = intent.getStringExtra(multiplan.idff)
        val namef = intent.getStringExtra(multiplan.name)
        val address = intent.getStringExtra(multiplan.address)


        val ss = "รอดำเนิดการ"
        val sl = "ดำเนินการเสร้จสิ้น"
        val no = "วันที่ดำเนิดการ"

        save.setImageResource(R.drawable.but24)

        save.setOnClickListener {
            startActivity(Intent(this, MainPageApp::class.java))
        }

        namefarm.setText(namef)
        addressfarm.setText(address)

        a0(idf,ss,sl,namef,address,no)
    }
    private fun a0(idf:String, ss:String, sl:String,name_f:String,address_f:String,no:String){
        val intro1 = "1.ไถกลบตอชัง"
        val intro11 = "ให้ทำการเตรียมดินพร้อมกับการไถกลบตอซังและฟางข้าว"
        val Aty_1 = "0"
        val nex = "0"
        a1(idf,ss,sl,name_f,address_f,no)
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




                    }

            }


        })
    }

    private fun a1(idf: String,ss: String,sl: String,name_f:String,address_f:String,no: String){
        val intro2 = "2.ปลูกพืชปุ๋ยสด"
        val intro22 = "ปลูกพืชปุ๋ยสด เช่น ถั่วพร้า ปอเทือง ประมาณ"
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


                    }

            }

        })
    }

    private fun a11(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro11 = "11.การตกกล้า"
        val intro111 = "หว่านงอกลงบนแปลงกล้าให้กระจายทั่วแปลงในอัตรา 50 กรัมต่อตารางเมตร หรือ 1 กิโลกรัมต่อ 20 ตารางเมตร\n ปริมาณข้าวที่ต้องใช้ 'หน้าหลัก'"
        val Aty_11 = "10"
        val nex = "15"
        introduce111.setText(intro11)
        status111.setText(ss)
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
                            status111.setText(ss)
                        }else{
                            status111.setText(sl)
                            no11.setText(no)

                        }

                    }

            }

        })
    }
    private fun a12(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro12 ="12.ใส่ปุ๋ยครั้งที่1"
        val intro122 = "ใส่ปุ๋ยครั้งที่ 1 แปลงต้นกล้า 10 กิโลกรัมต่อไร่"
        val Aty_12 = "11"
        val nex = "0"
        introduce12.setText(intro12)
        status12.setText(ss)
        a123(idf,ss,sl,name_f,address_f,no)
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


                    }

            }

        })
    }
    private fun a123(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro122 = "\t\t\t\t\t\t\t\t13.ตรวจสอบน้ำบริเวณแปลงปักดำ"
        val intro1222 = "ตรวจสอบปริมาณน้ำที่ใช้ในแปลงกล้า จะต้องมีน้ำอยู่ที่ 7-10 ซม"
        val Aty_12 = "12"
        val nex = "0"

        introduce122.setText(intro122)
        status122.setText(ss)
        a122(idf,ss,sl,name_f,address_f,no)
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
                        dd122.setText(d)
                        mm122.setText(m)
                        yy122.setText(y)
                        val id1 = id
                        var intro="12.ตรวจสอบน้ำบริเวณแปลงปักดำ"
                        if(s == "no"){
                            status122.setText(ss)
                        }else{
                            status122.setText(sl)
                            no12.setText(no)

                        }


                    }

            }

        })
    }
    private fun a122(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro123 = "\t\t\t\t\t14.ทำการไถดะและไถคราด"
        val intro1233 = "ทำการไถดะและไถคราด บริเวณแปลงปักดำ"
        val Aty_122 = "13"
        val nex = "0"
        a13(idf,ss,sl,name_f,address_f,no)
        introduce123.setText(intro123)
        status123.setText(ss)
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
                        dd123.setText(d)
                        mm123.setText(m)
                        yy123.setText(y)
                        val id1 = id
                        var intro = "10.ทำการไถดะและไถคราด"
                        if(s == "no"){
                            status123.setText(ss)
                        }else{
                            status123.setText(sl)
                            no123.setText(no)

                        }


                    }

            }

        })
    }
    private fun a13(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro13 = "15.ปักดำ"
        val intro133 = "การปักดำต้นกล้าจะต้องห่างกัน 20 ซม.โดยใช้กล้า 3 ต้นต่อจับ"
        val Aty_13 = "14"
        val nex = "0"

        introduce13.setText(intro13)
        status13.setText(ss)
        a14(idf,ss,sl,name_f,address_f,no)
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


                    }

            }

        })
    }

    private fun a14(idf: String, ss: String, sl: String, name_f:String, address_f:String, no: String) {
        val intro14 ="16.ใส่ปุ๋ยครั้งที่2"
        val intro144 = "ใส่ปุ๋ยครั้งที่ 2 แปลงต้นปักดำ 25 กิโลกรัมต่อไร่"
        val Aty_14 = "15"
        val nex = "1"
        introduce14.setText(intro14)
        status14.setText(ss)
        a15(idf,ss,sl,name_f,address_f,no)
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


                    }

            }

        })

    }

    private fun a15(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro15 = "\t\t\t\t17.ตรวจสอบระดับน้ำ "
        val intro155 = "ตรวจสอบระดับน้ำ พร้อมกับตรวจสอบข้าวแตกก่อ"
        val Aty_15 = "16"
        val nex = "1"

        introduce15.setText(intro15)
        status15.setText(ss)
        a16(idf,ss,sl,name_f,address_f,no)
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
                        dd15.setText(d)
                        mm15.setText(m)
                        yy15.setText(y)
                        var intro = "15.ตรวจสอบระดับน้ำ "
                        val id1 = id
                        if(s == "no"){
                            status15.setText(ss)
                        }else{
                            status15.setText(sl)
                            no15.setText(no)

                        }


                    }

            }

        })
    }
    private fun a16(idf: String, ss: String, sl: String, name_f:String, address_f:String, no: String) {
        val intro16 ="18.ใส่ปุ๋ยครั้งที่3"
        val intro166 = "ใส่ปุ๋ยครั้งที่ 3 แปลงต้นปักดำ 25 กิโลกรัมต่อไร่"
        val Aty_16 = "17"
        val nex = "1"
        introduce16.setText(intro16)
        status16.setText(ss)
        a17(idf,ss,sl,name_f,address_f,no)
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


                    }

            }

        })

    }

    private fun a17(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro17 = "\t\t\t\t19.ตรวจสอบระดับน้ำ "
        val intro177 = "ตรวจสอบระดับน้ำ พร้อมกับตรวจสอบข้าวตั้งท้อง"
        val Aty_17 = "18"
        val nex = "0"

        introduce17.setText(intro17)
        status17.setText(ss)
        a18(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity18")
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


                    }

            }

        })
    }

    private fun a18(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro18 = "\t\t\t\t\t\t20.ปล่อยน้ำออกจากคันนา"
        val intro188 = "ปล่อยน้ำออกจากคันนา เพื่อรอข้าวสุก"
        val Aty_18 = "19"
        val nex = "15"
        introduce18.setText(intro18)
        status18.setText(ss)
        a19(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity19")
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


                    }

            }

        })
    }

    private fun a19(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro19 = "21.เก็บเกี่ยวข้าว"
        val intro199 = "เริ่มเก็บเกี่ยวข้าว"
        val Aty_19 = "20"
        val nex = "0"

        introduce19.setText(intro19)
        status19.setText(ss)
        //a18(idf,ss,sl,name_f,address_f,no)
        var ref = FirebaseDatabase.getInstance().getReference("activity/$idf/activity20")
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


                    }

            }

        })
    }

}
