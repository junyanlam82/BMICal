package com.example.calculatebmi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

   // lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
    val btn = findViewById<Button>(R.id.btnEnter)
       btn.setOnClickListener {
            val intent = Intent(this, calc_BMI::class.java)
            val userName = findViewById<TextView>(R.id.editName)
            intent.putExtra("userName", userName.text.toString())
            startActivity(intent)
        }

    }
}