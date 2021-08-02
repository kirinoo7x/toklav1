package com.tiwlynaja.admin.konklav1.Noti_check_do

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmReceiver : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val service = Intent(context, NotificationService::class.java)
        service.putExtra("reason", intent?.getStringExtra("reason"))
        service.putExtra("timestamp", intent?.getLongExtra("timestamp", 0))
        service.putExtra(idfram,intent?.getStringExtra(idfram))
        service.putExtra(idf,intent?.getStringExtra(idf))
        service.putExtra(aty,intent?.getStringExtra(aty))
        service.putExtra(netx,intent?.getStringExtra(netx))
        service.putExtra(tt,intent?.getStringExtra(tt))
        service.putExtra(mm,intent?.getStringExtra(mm))

        context?.startService(service)

    }
    companion object{
        var idfram = "ida"
        var idf = "idf"
        var aty="aty"
        var netx = "next"
        var tt = "tt"
        var mm ="mm"
    }
}