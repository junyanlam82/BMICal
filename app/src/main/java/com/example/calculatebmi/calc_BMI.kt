package com.example.calculatebmi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class calc_BMI : AppCompatActivity() {
    var bmiIndex:Double =0.00
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc__b_m_i)

        val userName = intent?.getStringExtra("userName")

        val showUserName = findViewById<TextView>(R.id.user_Name)

        showUserName.setText(userName)

        if(savedInstanceState!=null){
            savedInstanceState.getDouble("bmiIndex")
            val status = findViewById<TextView>(R.id.userStatus)

            status.setText(getStatus())
        }
        val btn = findViewById<Button>(R.id.btnCal)

        btn.setOnClickListener(){

            val height = findViewById<TextView>(R.id.weight_Value).text.toString().toDouble()
            val weight = findViewById<TextView>(R.id.height_Value).text.toString().toDouble()
            bmiIndex = weight / (height*height)
            val status = findViewById<TextView>(R.id.userStatus)

            status.setText(getStatus())

        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("bmiIndex",bmiIndex)
    }

    fun getStatus():String{
        if(bmiIndex<18.5)
            return "Underweight"
        if(bmiIndex<24.9)
            return "Normal weight"
        if(bmiIndex<29.9)
            return "Overweight"
        if(bmiIndex<34.9)
            return "Obesity Class 1"
        if(bmiIndex<39.9)
            return "Obesity Class 2"
        else
            return "Obesity Class 3"
    }
}