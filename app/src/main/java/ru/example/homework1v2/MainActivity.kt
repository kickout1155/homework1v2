package ru.example.homework1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import ru.example.homework1v2.R

class MainActivity : AppCompatActivity() {
    val REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniUi()
    }

    private fun iniUi() {
        button_second_activity.setOnClickListener({
            startSecondActivity()
        })
    }

    private fun startSecondActivity() {
        val intent = Intent(applicationContext,SecondActivity::class.java)
        startActivityForResult(intent,REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //тут нужна проверка на resultcode но у нас 1 активти, поэтому обойдусь
        some_text.setText(data?.extras?.getString("test")?:getString(R.string.returnNull))
    }
}