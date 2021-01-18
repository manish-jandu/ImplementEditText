package com.example.implementedittext

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var nameOutput:String="name"
    var classOutput:String="class"
    companion object{
        private const val SHOW_SECTION_REQUEST_CODE=1
        const val NAME="name"
        const val CLASS="class"
        const val SECTION="section"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSumitName:Button = findViewById(R.id.btn_submit_name)
        val btnSubmitClass:Button = findViewById(R.id.btn_submit_class)
        val etName:EditText = findViewById(R.id.et_name)
        val etClass:EditText = findViewById(R.id.et_class)


        btnSumitName.setOnClickListener {
            nameSubmit(etName.text.toString())
        }
        btnSubmitClass.setOnClickListener {
          classSubmit(etClass.text.toString())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val tvOutput:TextView = findViewById(R.id.tv_output)
        val section:String? = data!!.getStringExtra(SECTION)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == SHOW_SECTION_REQUEST_CODE){
                tvOutput.text = "So you are ${nameOutput.capitalize()} of $classOutput-$section"
            }else{
                Toast.makeText(
                    this,
                    "something went Wrong",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }


    private fun nameSubmit(name:String){
        if(!name.isEmpty()){
            nameOutput=name
            val intent = Intent(this,ShowNameActivity::class.java)
            intent.putExtra(NAME,name)
            startActivity(intent)
        }
        else{
            Toast.makeText(
                this,
                "Please Enter Name",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun classSubmit(classValue:String){
        if(!classValue.isEmpty()){
            classOutput=classValue
            val intent = Intent(this,ShowClassActivity::class.java)
            intent.putExtra(CLASS,classValue)
            startActivityForResult(intent,SHOW_SECTION_REQUEST_CODE)
        }else{
            Toast.makeText(
                this,
                "Please Enter Class",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}