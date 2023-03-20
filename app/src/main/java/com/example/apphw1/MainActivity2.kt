package com.example.apphw1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button1 = findViewById<Button>(R.id.button)
        button1.setOnClickListener{





        intent?.extras?.let {
            val value1 = it.getString("Key1")
            val value2 = it.getString("Key2")

            val SizeEditText2 = findViewById<EditText>(R.id.SizeEditText2)
            val ColorEditText2 = findViewById<EditText>(R.id.ColorEditText2)

            val size = SizeEditText2.text.toString()
            val color = ColorEditText2.text.toString()



            val bundle = Bundle()
            bundle.putString("Key1",value1)
            bundle.putString("Key2",value2)
            bundle.putString("Key3",size)
            bundle.putString("Key4",color)
            val intent = Intent().putExtras(bundle)
            setResult(Activity.RESULT_OK,intent.putExtras(bundle))
            //startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


        }
    }
}