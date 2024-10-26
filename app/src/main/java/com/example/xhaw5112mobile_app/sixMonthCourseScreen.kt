package com.example.xhaw5112mobile_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class sixMonthCourseScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_six_month_course_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firstAidButton = findViewById<Button>(R.id.firstAidButton)
        val sewingButton = findViewById<Button>(R.id.sewingButton)
        val landscapingButton = findViewById<Button>(R.id.landscapingButton)
        val lifeSkillButton = findViewById<Button>(R.id.lifeSkillButtons)
        val homeButton = findViewById<Button>(R.id.sixMonthButton)

        homeButton.setOnClickListener {
            val intent = Intent(this, homeScreen::class.java)
            startActivity(intent)
        }

        firstAidButton.setOnClickListener {
            val intent = Intent(this, selectedCoursePage::class.java)
            intent.putExtra("course_name", "First Aid")
            intent.putExtra("course_image", R.drawable.firstaid_image)
            startActivity(intent)
        }

        sewingButton.setOnClickListener {
            val intent = Intent(this, selectedCoursePage::class.java)
            intent.putExtra("course_name", "Sewing")
            intent.putExtra("course_image", R.drawable.sewing_image)
            startActivity(intent)
        }

        landscapingButton.setOnClickListener {
            val intent = Intent(this, selectedCoursePage::class.java)
            intent.putExtra("course_name", "Landscaping")
            intent.putExtra("course_image", R.drawable.landscaping_image)
            startActivity(intent)
        }

        lifeSkillButton.setOnClickListener {
            val intent = Intent(this, selectedCoursePage::class.java)
            intent.putExtra("course_name", "Life Skills")
            intent.putExtra("course_image", R.drawable.lifeskills_image)
            startActivity(intent)
        }
    }
}