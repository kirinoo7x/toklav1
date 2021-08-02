package com.tiwlynaja.admin.konklav1.Noti_check_do

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import java.util.*

class NotificationUtils {

    fun setNotification(
        timeInMilliSeconds: Long, activity1: String,  activity2: String?,atyy:String,nextt:String,title:String,message:String, activity: Activity) {
        if (timeInMilliSeconds > 0) {
            val alarmManager = activity.getSystemService(Activity.ALARM_SERVICE) as AlarmManager
            val alarmIntent = Intent(activity.applicationContext, AlarmReceiver::class.java)
            // AlarmReceiver1 = broadcast receiver

            alarmIntent.putExtra("reason", "notification")
            alarmIntent.putExtra("timestamp", timeInMilliSeconds)
            alarmIntent.putExtra(idfram,activity1)
            alarmIntent.putExtra(idf,activity2)
            alarmIntent.putExtra(aty,atyy)
            alarmIntent.putExtra(next,nextt)
            alarmIntent.putExtra(tt,title)
            alarmIntent.putExtra(mm,message)
            println(nextt)
            val calendar = Calendar.getInstance()

            calendar.set(Calendar.HOUR_OF_DAY,8)
            calendar.set(Calendar.MINUTE,0)
            calendar.set(Calendar.SECOND,0)
            //calendar.timeInMillis = timeInMilliSeconds
            println("-------"+calendar)

            val pendingIntent = PendingIntent.getBroadcast(activity, 0, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT)

            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)

        }

    }
    companion object{
         val idfram = "ida"
        val idf = "idf"
        val aty ="aty"
        val next = "next"
        val tt="tt"
        val mm = "mm"
    }
}