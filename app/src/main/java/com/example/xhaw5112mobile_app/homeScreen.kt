package com.example.xhaw5112mobile_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class homeScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sixWeekButton = findViewById<Button>(R.id.sixWeekButton)
        val sixMonthButton = findViewById<Button>(R.id.sixMonthButton)
        val joinCourseButton = findViewById<Button>(R.id.joinCourseButton)
        val contactUsButton = findViewById<Button>(R.id.contactUsButton)

        sixWeekButton.setOnClickListener {
            val intent = Intent(this, sixWeekCourseScreen::class.java)
            startActivity(intent)
        }

        sixMonthButton.setOnClickListener {
            val intent = Intent(this, sixMonthCourseScreen::class.java)
            startActivity(intent)
        }

        contactUsButton.setOnClickListener {
            val intent = Intent(this, contactPage::class.java)
            startActivity(intent)
        }

        joinCourseButton.setOnClickListener {
            val intent = Intent(this, checkoutScreen::class.java)
            startActivity(intent)
        }
    }
}