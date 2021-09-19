package na.severinchik.lesson8.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class SampleService : Service() {


    override fun onCreate() {
        super.onCreate()
        println("--> onCreate: Service ")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("--> onStartCommand: Service")
        var intent = Intent("na.severinchik.iba_kotlin_lesson_111")
        intent.putExtra("KEY","VALUE")
        sendBroadcast(intent)

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        println("--> onDestroy: Service")
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        println("--> onBind: Service")

        return null
    }

    inner class LocalBinder : Binder() {
        fun getService(): SampleService = this@SampleService
    }
}