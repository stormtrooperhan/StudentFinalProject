package com.android.example.okrllythisisthefinalone

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val button1 = findViewById(R.id.goToSymptomDetailsActivity) as Button
    val button2 = findViewById(R.id.Glossary) as Button
    val button3 = findViewById(R.id.goToGraphs) as Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //go to input todays symptomatic details
        button1.setOnClickListener {
            val intent = Intent(this, SymptomActivityDetails::class.java)
            startActivity(intent)
        }
g
        button2.setOnClickListener {
            val intent2 = Intent(this, glossary::class.java)
            startActivity(intent2)
        }

        button3.setOnClickListener {
            val intent3 = Intent(this, glossary::class.java)
            startActivity(intent3)
        }


    }

}


