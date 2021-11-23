package com.example.servicesdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartService = findViewById<Button>(R.id.btnStartService)
        btnStartService.setOnClickListener{
            Intent(this, MyService::class.java).also{
                startService(it)
                findViewById<TextView>(R.id.text).text = "Service Running"
            }
        }

        val btnStopService = findViewById<Button>(R.id.btnStopService)
        btnStopService.setOnClickListener{
            Intent(this, MyService::class.java).also{
                stopService(it)
                findViewById<TextView>(R.id.text).text = "Service Stopped"
            }
        }

        val btnSendData = findViewById<Button>(R.id.btnSendData)
        btnSendData.setOnClickListener{
            Intent(this, MyService::class.java).also{
                val dataString = findViewById<EditText>(R.id.editText).text.toString()
                it.putExtra("EXTRA_DATA",dataString)
                startService(it)
            }
        }
    }
}