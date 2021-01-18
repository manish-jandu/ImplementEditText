package com.example.implementedittext

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class ShowClassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_class)
        val tvClassOutput:TextView = findViewById(R.id.tv_class_output)
        val etSection:EditText = findViewById(R.id.et_section)
        val btnSubmitSection:Button = findViewById(R.id.btn_submit_section)
        val message:String = intent.getStringExtra(MainActivity.CLASS)

        if(message.isNotEmpty()){
            tvClassOutput.setText("so Your Class is $message")
        }

        btnSubmitSection.setOnClickListener {
            if(etSection.text.isNotEmpty()){
                val intent = Intent(this,MainActivity::class.java)
                intent.putExtra(MainActivity.SECTION,etSection.text.toString())
                setResult(Activity.RESULT_OK,intent)
                finish()
            }
            else{
                Toast.makeText(
                    this,
                    "Please enter section",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}