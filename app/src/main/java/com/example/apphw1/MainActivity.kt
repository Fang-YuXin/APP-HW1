package com.example.apphw1

import android.app.Activity
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


        val button = findViewById<Button>(R.id.send)
        button.setOnClickListener{


        val NameEditText = findViewById<EditText>(R.id.NameEditText)
        val NameTextView = findViewById<TextView>(R.id.NameTextView)
        val SexEditText = findViewById<EditText>(R.id.SexEditText)
        val SexTextView = findViewById<TextView>(R.id.SexTextView)

        val name = NameEditText.text.toString()
        val sex = SexEditText.text.toString()


        val bundle = Bundle()
        bundle.putString("Key1", name)
        bundle.putString("Key2",sex)
/*
        val intent = Intent(this,MainActivity2::class.java)
        intent.putExtras(bundle)

        startActivityForResult(intent,1)
        startActivity(Intent(this,MainActivity2::class.java))*/
        val intent = Intent(this, MainActivity2::class.java).apply {
            putExtras(bundle)
        }
        startActivityForResult(intent, 1)

        }
    }

    //判斷onActivityRestult()方法來，取得返回資料
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        //判斷Intent不能為空，檢查資料是否有數值
        data?.extras?.let {
            if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                //show返回資料

                findViewById<TextView>(R.id.textView3).text =
                    "姓名: ${it.getString("Key1")}\n\n" +
                    "性別: ${it.getString("Key2")}\n\n"+
                    "尺寸: ${it.getString("Key3")}\n\n"+
                    "顏色: ${it.getString("Key4")}\n\n"

                }
            }

        }
    }