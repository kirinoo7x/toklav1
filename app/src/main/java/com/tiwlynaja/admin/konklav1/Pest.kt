package com.tiwlynaja.admin.konklav1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main_page_app.*
import kotlinx.android.synthetic.main.activity_pest.*

class Pest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pest)

        val name = intent.getStringExtra(lisePaet.namepest)
        val kill = intent.getStringExtra(lisePaet.killi)
        val imge = intent.getStringExtra(lisePaet.imge)

        namepast.setText(name)
        kill3.setText(kill)
        Picasso.get().load(imge).into(image_pest)

        back.setOnClickListener {
            finish()
        }
    }
}
