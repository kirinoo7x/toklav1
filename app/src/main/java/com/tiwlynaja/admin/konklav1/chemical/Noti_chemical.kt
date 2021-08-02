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
import com.tiwlynaja.admin.konklav1.Noti_check_Rice.NotificationUtils_CKR
import com.tiwlynaja.admin.konklav1.Noti_check_Water.NotificationUtils_CKW
import com.tiwlynaja.admin.konklav1.Noti_check_completed.NotificationUtils_CKC
import com.tiwlynaja.admin.konklav1.Noti_check_do.NotificationUtils
import com.tiwlynaja.admin.konklav1.check.Check_water
import com.tiwlynaja.admin.konklav1.check.NO_chemical_N1
import com.tiwlynaja.admin.konklav1.check.checkRice
import com.tiwlynaja.admin.konklav1.check.completed_chemical
import kotlinx.android.synthetic.main.activity_calendar__noti.*
import java.util.*

class Noti_chemical : AppCompatActivity() {
    private val mNotificationTime = Calendar.getInstance().timeInMillis + 5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar__noti)


        val idfeu = intent.getStringExtra(L_chemical.idfu)
        val name_frem = intent.getStringExtra(L_chemical.namefram)
        val addressF = intent.getStringExtra(L_chemical.Address)


        val idff = intent.getStringExtra(Calendar_Noti.idff)
        val nameff= intent.getStringExtra(Calendar_Noti.name_fff)
        val addressff =intent.getStringExtra(Calendar_Noti.address_fff)
        val ss = "รอดำเนินการ"
        val sl = "ดำเนินการเสร้จสิ้น"
        val no = "วันที่ดำเนินการ"
        imageView15.setImageResource(R.mipmap.trasho)
        if (idfeu == null){
            a0(idff,ss,sl,nameff,addressff,no)
            addressfarm.setText(addressff)
            namefarm.setText(nameff)

            imageView15.setOnClickListener {
                var userId = FirebaseAuth.getInstance().uid
                val del_DB_plan = FirebaseDatabase.getInstance().getReference("plan/$userId")
                del_DB_plan.child("$idff").removeValue()
                val all_del_DB = FirebaseDatabase.getInstance().getReference("plan_all")
                all_del_DB.child("$idff").removeValue()
                val activity_dal = FirebaseDatabase.getInstance().getReference("activity")
                activity_dal.child("$idff").removeValue()
                Toast.makeText(this,"Del", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LiseFramUser::class.java)
                startActivity(intent)
            }
        }else{
            a0(idfeu,ss,sl,name_frem,addressF,no)
            addressfarm.setText(addressF)
            namefarm.setText(name_frem)

            imageView15.setOnClickListener {
                var userId = FirebaseAuth.getInstance().uid
                val del_DB_plan = FirebaseDatabase.getInstance().getReference("plan/$userId")
                del_DB_plan.child("$idfeu").removeValue()
                val all_del_DB = FirebaseDatabase.getInstance().getReference("plan_all")
                all_del_DB.child("$idfeu").removeValue()
                val activity_dal = FirebaseDatabase.getInstance().getReference("activity")
                activity_dal.child("$idfeu").removeValue()
                Toast.makeText(this,"Del", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainPageApp::class.java)
                startActivity(intent)
            }
        }
        save.setImageResource(R.drawable.but24)
        save.setOnClickListener {
            startActivity(Intent(this,MainPageApp::class.java))
        }

    }

    private fun a0(idf:String, ss:String, sl:String,name_f:String,address_f:String,no:String){
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
                            notino_chemical(idf,id,d,m,y,Aty_1,nex,intro1,intro11)

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
                            notino_chemical(idf,id1,d,m,y,Aty_2,nex,intro2,intro22)
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
                            notino_chemical(idf,id1,d,m,y,Aty_3,nex,intro3,intro33)
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
                            notino_chemical(idf,id1,d,m,y,Aty_3,nex,intro3,intro33)
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
                            notino_chemical(idf,id1,d,m,y,Aty_4,nex,intro4,intro44)
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
                            notino_chemical(idf,id1,d,m,y,Aty_6,nex,intro6,intro66)
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
                            notino_chemical(idf,id1,d,m,y,Aty_7,nex,intro7,intro77)
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
                            notino_chemical(idf,id1,d,m,y,Aty_8,nex,intro8,intro88)
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
                        var intro="9.ตรวจสอบปริมาณน้ำบริเวณแปลงกล้า"
                        if(s == "no"){
                            status9.setText(ss)
                            notino_chemical_check_water(idf,id1,d,m,y,Aty_9,nex,intro,intro99)
                        }else{
                            status9.setText(sl)
                            no9.setText(no)

                        }
                        imageView31.setOnClickListener {
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
                            notino_chemical(idf,id1,d,m,y,Aty_10,nex,intro,intro100)
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
                            notino_chemical(idf,id1,d,m,y,Aty_11,nex,intro11,intro111)
                        }else{
                            status111.setText(sl)
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
                            notino_chemical(idf,id1,d,m,y,Aty_12,nex,intro12,intro122)
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
                        var intro="13.ตรวจสอบน้ำบริเวณแปลงปักดำ"
                        if(s == "no"){
                            status122.setText(ss)
                            notino_chemical_check_water(idf,id1,d,m,y,Aty_12,nex,intro,intro1222)
                        }else{
                            status122.setText(sl)
                            no12.setText(no)

                        }
                        imageView343.setOnClickListener {
                            toA_no_check_water(idf,name_f,address_f,Aty_12,intro,intro1222,id1,nex,s)
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
                        var intro = "14.ทำการไถดะและไถคราด"
                        if(s == "no"){
                            status123.setText(ss)
                            notino_chemical(idf,id1,d,m,y,Aty_122,nex,intro,intro1233)
                        }else{
                            status123.setText(sl)
                            no123.setText(no)

                        }
                        imageView3433.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_122,intro,intro1233,id1,nex,s)
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
                            notino_chemical(idf,id1,d,m,y,Aty_13,nex,intro13,intro133)
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
                            notino_chemical(idf,id1,d,m,y,Aty_14,nex,intro14,intro144)
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
                            notino_chemical_check_rice(idf,id1,d,m,y,Aty_15,nex,intro,intro155)
                        }else{
                            status15.setText(sl)
                            no15.setText(no)

                        }
                        imageView37.setOnClickListener {
                            toA_no_check_rice(idf,name_f,address_f,Aty_15,intro,intro155,id1,nex,s)
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
                            notino_chemical(idf,id1,d,m,y,Aty_16,nex,intro16,intro166)
                        }else{
                            status14.setText(sl)
                            no14.setText(no)
                        }
                        imageView38.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_16,intro16,intro166,id1,nex,s)
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
                        val intro = "19.ตรวจสอบระดับน้ำ "
                        val id1 = id
                        if(s == "no"){
                            status17.setText(ss)
                            notino_chemical_check_rice(idf,id1,d,m,y,Aty_17,nex,intro,intro177)
                        }else{
                            status17.setText(sl)
                            no17.setText(no)

                        }
                        imageView39.setOnClickListener {
                            toA_no_check_rice(idf,name_f,address_f,Aty_17,intro17,intro177,id1,nex,s)
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
                            notino_chemical(idf,id1,d,m,y,Aty_18,nex,intro18,intro188)
                        }else{
                            status18.setText(sl)
                            no18.setText(no)

                        }
                        imageView41.setOnClickListener {
                            toA_no_chemical(idf,name_f,address_f,Aty_18,intro,intro188,id1,nex,s)
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
                            notino_chemical_check_completed(idf,id1,d,m,y,Aty_19,nex,intro19,intro199)
                        }else{
                            status19.setText(sl)
                            no19.setText(no)

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


        var aria = intent.getStringExtra(LiseFramUser.Framland)
        val address = intent.getStringExtra(LiseFramUser.Address)
        val rice = intent.getStringExtra(LiseFramUser.Rice)
        val type = intent.getStringExtra(LiseFramUser.cultivation)
        val Attribute = intent.getStringExtra(LiseFramUser.Type)
        var day = intent.getStringExtra(LiseFramUser.Day)
        var month = intent.getStringExtra(LiseFramUser.Month)
        var year =intent.getStringExtra(LiseFramUser.Year)
        var ff1 = intent.getStringExtra(LiseFramUser.Fformula1)
        var ff2 = intent.getStringExtra(LiseFramUser.Fformula2)
        var ff3 = intent.getStringExtra(LiseFramUser.Fformula3)
        var mf1 = intent.getStringExtra(LiseFramUser.Mfertilizer1)
        var mf2 = intent.getStringExtra(LiseFramUser.Mfertilizer2)
        var mf3 = intent.getStringExtra(LiseFramUser.Mfertilizer3)
        var riceq = intent.getStringExtra(LiseFramUser.Rice_quantityf)

        val intent = Intent(this,
            completed_chemical::class.java)
        intent.putExtra(Calendar_Noti.name_ff,name_f)
        intent.putExtra(Calendar_Noti.address_ff,address_f)
        intent.putExtra(Calendar_Noti.activityf,Aty)
        intent.putExtra(Calendar_Noti.idAf,idf)
        intent.putExtra(Calendar_Noti.intro,introo)
        intent.putExtra(Calendar_Noti.intro_i,intro_o)
        intent.putExtra(Calendar_Noti.ida00,ida)
        intent.putExtra(Calendar_Noti.netxx,netx)
        intent.putExtra(Calendar_Noti.coutA,cout)

        intent.putExtra(Calendar_Noti.areafram,aria)
        intent.putExtra(Calendar_Noti.Ricef,rice)
        intent.putExtra(Calendar_Noti.Typef,type)
        intent.putExtra(Calendar_Noti.Attributef,Attribute)
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


    private fun notino_chemical(idf: String,ida: String,d:String,m:String,y:String,Aty: String,netx: String,introT:String,introM:String){
        var months = 0
        when(m){
            "มกราคม" -> months = 0
            "กุมภาพันธ์"-> months = 1
            "มีนาคม" -> months = 2
            "เมษายน" -> months = 3
            "พฤษภาคม" -> months = 4
            "มิถุนายน" -> months = 5
            "กรกฎาคม" -> months = 6
            "สิงหาคม" -> months = 7
            "กันยายน" -> months = 8
            "ตุลาคม" -> months = 9
            "พฤศจิกายน" -> months = 10
            "ธันวาคม" -> months = 11
        }
        val calendar = Calendar.getInstance()
        val yy =calendar.get(Calendar.YEAR)
        val mm =calendar.get(Calendar.MONTH)
        val dd=calendar.get(Calendar.DAY_OF_MONTH)
        if (y.toInt() == yy && months == mm && d.toInt()== dd)
        {
            NotificationUtils().setNotification(mNotificationTime, ida, idf,Aty,netx,introT,introM, this@Noti_chemical)
        }
    }
    private fun notino_chemical_check_water(idf: String,ida: String,d:String,m:String,y:String,Aty: String,netx: String,introT:String,introM:String){
        var months = 0
        when(m){
            "มกราคม" -> months = 0
            "กุมภาพันธ์"-> months = 1
            "มีนาคม" -> months = 2
            "เมษายน" -> months = 3
            "พฤษภาคม" -> months = 4
            "มิถุนายน" -> months = 5
            "กรกฎาคม" -> months = 6
            "สิงหาคม" -> months = 7
            "กันยายน" -> months = 8
            "ตุลาคม" -> months = 9
            "พฤศจิกายน" -> months = 10
            "ธันวาคม" -> months = 11
        }
        val calendar = Calendar.getInstance()
        val yy =calendar.get(Calendar.YEAR)
        val mm =calendar.get(Calendar.MONTH)
        val dd=calendar.get(Calendar.DAY_OF_MONTH)
        if (y.toInt() == yy && months == mm && d.toInt()== dd)
        {
            NotificationUtils_CKW().setNotification(mNotificationTime, ida, idf,Aty,netx,introT,introM, this@Noti_chemical)
        }
    }
    private fun notino_chemical_check_rice(idf: String,ida: String,d:String,m:String,y:String,Aty: String,netx: String,introT:String,introM:String){
        var months = 0
        when(m){
            "มกราคม" -> months = 0
            "กุมภาพันธ์"-> months = 1
            "มีนาคม" -> months = 2
            "เมษายน" -> months = 3
            "พฤษภาคม" -> months = 4
            "มิถุนายน" -> months = 5
            "กรกฎาคม" -> months = 6
            "สิงหาคม" -> months = 7
            "กันยายน" -> months = 8
            "ตุลาคม" -> months = 9
            "พฤศจิกายน" -> months = 10
            "ธันวาคม" -> months = 11
        }
        val calendar = Calendar.getInstance()
        val yy =calendar.get(Calendar.YEAR)
        val mm =calendar.get(Calendar.MONTH)
        val dd=calendar.get(Calendar.DAY_OF_MONTH)
        if (y.toInt() == yy && months == mm && d.toInt()== dd)
        {
            NotificationUtils_CKR().setNotification(mNotificationTime, ida, idf,Aty,netx,introT,introM, this@Noti_chemical)
        }
    }
    private fun notino_chemical_check_completed(idf: String,ida: String,d:String,m:String,y:String,Aty: String,netx: String,introT:String,introM:String){
        var months = 0
        when(m){
            "มกราคม" -> months = 0
            "กุมภาพันธ์"-> months = 1
            "มีนาคม" -> months = 2
            "เมษายน" -> months = 3
            "พฤษภาคม" -> months = 4
            "มิถุนายน" -> months = 5
            "กรกฎาคม" -> months = 6
            "สิงหาคม" -> months = 7
            "กันยายน" -> months = 8
            "ตุลาคม" -> months = 9
            "พฤศจิกายน" -> months = 10
            "ธันวาคม" -> months = 11
        }
        val calendar = Calendar.getInstance()
        val yy =calendar.get(Calendar.YEAR)
        val mm =calendar.get(Calendar.MONTH)
        val dd=calendar.get(Calendar.DAY_OF_MONTH)
        println(yy+mm+dd)
        if (y.toInt() == yy && months == mm && d.toInt()== dd)
        {
            NotificationUtils_CKC().setNotification(mNotificationTime, ida, idf,Aty,netx,introT,introM, this@Noti_chemical)
        }
    }
}
