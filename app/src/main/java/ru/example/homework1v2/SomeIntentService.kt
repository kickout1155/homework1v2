package ru.example.homework1

import android.app.IntentService
import android.content.Intent

class SomeIntentService(name: String) : IntentService(name) {
    override fun onHandleIntent(intent: Intent?) {
        if (intent == null){
            return
        }
        val myIntent = Intent("my.custom.ACTION").putExtra("test","какое то значение")
        sendBroadcast(myIntent)
    }

}