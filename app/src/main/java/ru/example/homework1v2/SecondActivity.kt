package ru.example.homework1

import android.R.id.closeButton
import android.R.id.message
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import ru.example.homework1v2.R


class SecondActivity: AppCompatActivity() {
    val someBroadcastReceiver = SomeBroadcastReceiver()

    inner class SomeBroadcastReceiver: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            closeActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        iniUi()
    }

    private fun iniUi() {
        button_start_service.setOnClickListener {
            initService()
        }

    }

    private fun initService() {
        val intentService = Intent(this,SomeIntentService::class.java)
        startService(intentService)
    }

    override fun onStart() {
        super.onStart()
        val intentFilter = IntentFilter("my.custom.ACTION")
        registerReceiver(someBroadcastReceiver,intentFilter)
    }

    override fun onStop() {
        unregisterReceiver(someBroadcastReceiver)
        super.onStop()
    }

    private fun closeActivity(intent: Intent?){
        setResult(Activity.RESULT_OK,intent)
        finish()
    }


}