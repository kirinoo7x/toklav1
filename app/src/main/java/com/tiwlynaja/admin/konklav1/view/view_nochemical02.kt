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
import kotlinx.android.synthetic.main.activity_calendar__noti_chemical2.*

class view_nochemical02 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar__noti_chemical2)

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
        val intro9 = "\t\t\t\t\t\t\t\t\t\t\t\t9.ตรวจสอบปริมาณน้ำบริเวณแปลงเพาะปลูก"

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
                        var intro="9.ตรวจสอบปริมาณน้ำบริเวณแปลงเพาะปลูก"
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
                        var intro = "10.ทำการไถดะและไถคราด"
                        val id1 = id
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
        val intro11 = "\t\t\t\t11.การหว่านเมล็ดพันธุ์"

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
                        val intro = "11.การหว่านเมล็ดพันธุ์"
                        val id1 = id
                        if(s == "no"){
                            status11.setText(ss)
                        }else{
                            status11.setText(sl)
                            no11.setText(no)

                        }

                    }

            }

        })
    }

    private fun a12(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro12 = "12.ตัดต้นกล้า"

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
                        val intro = "12.ตัดต้นกล้า"
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

    private fun a13(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro13 = "\t\t\t\t13.ตรวจสอบระดับน้ำ"

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
                        val intro = "13.ตรวจสอบระดับน้ำ"
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

    private fun a14(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro14 = "\t\t\t\t14.ตรวจสอบระดับน้ำ "

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
                        val intro = "16.ตรวจสอบระดับน้ำ"
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
        val intro15 = "\t\t\t\t\t\t15.ปล่อยน้ำออกจากคันนา"

        introduce15.setText(intro15)
        status15.setText(ss)
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
                        dd15.setText(d)
                        mm15.setText(m)
                        yy15.setText(y)
                        val intro = "17.ปล่อยน้ำออกจากคันนา"
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

    private fun a16(idf: String, ss: String, sl: String, name_f: String, address_f: String, no: String) {
        val intro16 = "16.เก็บเกี่ยวข้าว"

        introduce16.setText(intro16)
        status16.setText(ss)
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
                        dd16.setText(d)
                        mm16.setText(m)
                        yy16.setText(y)
                        val id1 = id
                        if(s == "no"){
                            status16.setText(ss)
                        }else{
                            status16.setText(sl)
                            no16.setText(no)

                        }

                    }

            }

        })
    }


}
