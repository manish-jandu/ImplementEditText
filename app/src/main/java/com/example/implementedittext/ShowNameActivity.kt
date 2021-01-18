package com.example.implementedittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShowNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_name)
        val tvNameOutput:TextView = findViewById(R.id.tv_name_output)
        val message = intent.getStringExtra(MainActivity.NAME)

        if(message.isNotEmpty()){
            tvNameOutput.setText("So Your name is $message")
        }
    }
}