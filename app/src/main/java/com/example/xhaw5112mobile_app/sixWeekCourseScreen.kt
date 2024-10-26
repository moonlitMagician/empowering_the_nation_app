package com.example.xhaw5112mobile_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class sixWeekCourseScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_six_week_course_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val childMindingButton = findViewById<Button>(R.id.childMindingButton)
        val cookingButton = findViewById<Button>(R.id.cookingButton)
        val gardenMaintenanceButton = findViewById<Button>(R.id.gardenMatienceButton)
        val homeButton = findViewById<Button>(R.id.sixWeekHome)

        homeButton.setOnClickListener {
            val intent = Intent(this, homeScreen::class.java)
            startActivity(intent)
        }

        gardenMaintenanceButton.setOnClickListener {
            val intent = Intent(this, selectedCoursePage::class.java)
            intent.putExtra("course_name", "Garden Maintenance")
            intent.putExtra("course_image", R.drawable.garden_image)
            startActivity(intent)
        }

        cookingButton.setOnClickListener {
            val intent = Intent(this, selectedCoursePage::class.java)
            intent.putExtra("course_name", "Cooking")
            intent.putExtra("course_image", R.drawable.cooking_image)
            startActivity(intent)
        }

        childMindingButton.setOnClickListener {
            val intent = Intent(this, selectedCoursePage::class.java)
            intent.putExtra("course_name", "Child Minding")
            intent.putExtra("course_image", R.drawable.childminding_image)
            startActivity(intent)
        }
    }
}