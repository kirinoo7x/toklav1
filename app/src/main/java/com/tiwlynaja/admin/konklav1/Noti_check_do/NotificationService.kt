package com.tiwlynaja.admin.konklav1.Noti_check_do

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationManagerCompat
import com.tiwlynaja.admin.konklav1.Noti_check_do.NotificationUtils.Companion.idf
import com.tiwlynaja.admin.konklav1.R
import java.util.*

class NotificationService : IntentService("NotificationService") {
    private lateinit var mNotification: Notification
    private val mNotificationId: Int = 1000
    private val mNotificationId1: Int = 1001
    @SuppressLint("NewApi")

    private fun createChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            // Create the NotificationChannel, but only on API 26+ because
            // the NotificationChannel class is new and not in the support library

            val context = this.applicationContext
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance)
            notificationChannel.enableVibration(true)
            notificationChannel.setShowBadge(true)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.parseColor("#e8334a")
            notificationChannel.description = ""
            notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            notificationManager.createNotificationChannel(notificationChannel)
        }

    }
    companion object {
       const val CHANNEL_ID = "com.tiwlynaja.admin.konklav1.Noti.CHANNEL_ID"
        const val CHANNEL_NAME = "Sample Notification"
    }


    override fun onHandleIntent(intent: Intent?) {
        var ida = intent?.getStringExtra(AlarmReceiver.idfram)
        var idf= intent?.getStringExtra(AlarmReceiver.idf)
        var aty = intent?.getStringExtra(AlarmReceiver.aty)
        var netx =intent?.getStringExtra(AlarmReceiver.netx)
        var tt =intent?.getStringExtra(AlarmReceiver.tt)
        var mm =intent?.getStringExtra(AlarmReceiver.mm)
    println(netx)
        //Create Channel
        createChannel()

        var timestamp: Long = 0
        if (intent != null && intent.extras != null) {
            timestamp = intent.extras!!.getLong("timestamp")
        }
        if (timestamp > 0 ) {


            val context = this.applicationContext
            var notificationManager: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val notifyIntent = Intent(this, ResultActivity::class.java)



            val title = tt
            val message = mm

            notifyIntent.putExtra("title", title)
            notifyIntent.putExtra("message", message)
            notifyIntent.putExtra("id",ida)
            notifyIntent.putExtra("idf",idf)
            notifyIntent.putExtra("aty",aty)
            notifyIntent.putExtra("netx",netx)

            notifyIntent.putExtra("notification", true)

            notifyIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = timestamp

            val pendingIntent = PendingIntent.getActivity(context, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT)
            val res = this.resources
            val uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {


                mNotification = Notification.Builder(this, CHANNEL_ID)
                    // Set the intent that will fire when the user taps the notification
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(R.drawable.ic_launcher_round)
                    .setLargeIcon(BitmapFactory.decodeResource(res, R.mipmap.ic_launcher))
                    .setAutoCancel(true)
                    .setContentTitle(title)
                    .setStyle(Notification.BigTextStyle()
                    .bigText(message))
                    .setContentText(message).build()
            } else {

                mNotification = Notification.Builder(this)
                    // Set the intent that will fire when the user taps the notification
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(R.drawable.ic_launcher_round)
                    .setLargeIcon(BitmapFactory.decodeResource(res, R.mipmap.ic_launcher))
                    .setAutoCancel(true)
                    .setPriority(Notification.PRIORITY_MAX)
                    .setContentTitle(title)
                    .setStyle(Notification.BigTextStyle()
                    .bigText(message))
                    .setSound(uri)
                    .setContentText(message).build()


            }
            NotificationManagerCompat.from(this).apply {
                notify(System.currentTimeMillis().toInt() ,mNotification)
            }

        }

    }
}