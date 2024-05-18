package com.example.flightapp.flighttime.data.sensors

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.example.flightapp.R

class SensorService: Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        // Add notification for Start and Landing
        val notification = NotificationCompat.Builder(this, "start_tracking")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Tracking the Flight")
            .setContentText("")
            .build()

        startForeground(1, notification)
    }

    enum class Actions {
        START,STOP
    }
}