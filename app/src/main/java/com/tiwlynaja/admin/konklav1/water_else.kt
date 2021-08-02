package com.tiwlynaja.admin.konklav1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tiwlynaja.admin.konklav1.Noti_check_Rice.ResultActivity_CKR
import com.tiwlynaja.admin.konklav1.Noti_check_Water.ResultActivity_CKW
import com.tiwlynaja.admin.konklav1.check.Check_water
import com.tiwlynaja.admin.konklav1.check.checkRice
import kotlinx.android.synthetic.main.activity_water_else.*

class water_else : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_else)

        val water = intent.getStringExtra(Check_water.ckk)
        val water2 = intent.getStringExtra(checkRice.cka)
        val water3 = intent.getStringExtra(ResultActivity_CKW.ckk)
        val water4 = intent.getStringExtra(ResultActivity_CKR.ckkk)

        if (water.toInt() < 7 ||water2.toInt() <7 || water3.toInt() <7 || water4.toInt() <7){
            var  i11 ="น้อยเกินไป"
            var i22 ="ระบบแนะผู้ใช้งานจัดสรรน้ำให้เพียงพอก่อนดำเนินกิจกรรมต่อไป ระดับน้ำที่เหมาะสมอยู่ระหว่าง 7-15 ซม"
            i1.setText(i11)
            i2.setText(i22)
            image.setImageResource(R.drawable.nowater)
        }else if (water.toInt() > 15||water2.toInt() > 15){
            var  i11 ="มากเกินไป"
            var i22 ="ระบบแนะผู้ใช้งานจัดสรรน้ำให้เพียงพอดีดำเนินกิจกรรมต่อไป ระดับน้ำที่เหมาะสมอยู่ระหว่าง 7-15 ซม"
            i1.setText(i11)
            i2.setText(i22)
            image.setImageResource(R.drawable.water)
        }

        back.setOnClickListener {
            Toast.makeText(this, "กรุณากดส่งข้อมูล อีกครั้ง", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}
