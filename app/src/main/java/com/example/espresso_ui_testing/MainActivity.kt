package com.example.espresso_ui_testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonToNextActivity = findViewById<Button>(R.id.button_to_next_activity)
        val intent = Intent(this, SecondActivity::class.java)

        buttonToNextActivity.setOnClickListener {
            startActivity(intent)
        }
    }
}