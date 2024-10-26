package com.example.xhaw5112mobile_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class finalizeCheckoutScreen : AppCompatActivity() {

    private lateinit var selectedCoursesText: TextView
    private lateinit var totalAmountText: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_finalize_checkout_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        selectedCoursesText = findViewById(R.id.selectedCourses)
        totalAmountText = findViewById(R.id.finalPrice)

        val selectedCourses = intent.getStringArrayExtra("SELECTED_COURSES") ?: arrayOf()
        val totalAmount = intent.getDoubleExtra("TOTAL_AMOUNT", 0.0)
        val finalizeHome = findViewById<Button>(R.id.finalizeHome)
        val finalizeCheckout = findViewById<Button>(R.id.finalizeCheckout)

        finalizeHome.setOnClickListener {
            val intent = Intent(this, homeScreen::class.java)
            startActivity(intent)
        }

        finalizeCheckout.setOnClickListener {
            val intent = Intent(this, thankYouScreen::class.java)
            startActivity(intent)
        }

        val totalCourseSelected = selectedCourses.size
        var discountPercent = 0
        var discountText = ""

        if (totalCourseSelected == 1){
            discountText = "You Only Selected One course, you will not receive a discount"
        } else if (totalCourseSelected == 2) {
            discountText = "You have selected two courses, you will receive a discount of 5%"
            discountPercent = 5
        } else if (totalCourseSelected == 3) {
            discountText = "You have selected three courses, you will receive a discount of 10%"
            discountPercent = 10
        } else if (totalCourseSelected > 3){
            discountText = "You have selected more than three courses, you will receive a discount " +
                    "of 15%"
            discountPercent = 15
        }

        var discountAmount = (totalAmount * discountPercent)/100
        var finalPrice = totalAmount - discountAmount

        selectedCoursesText.text = "Selected Courses: \n ${selectedCourses.joinToString("\n")}"
        totalAmountText.text = "Total: \n" +
                "$discountText\n\n" +
                "Your FINAL price is: R$finalPrice"

    }
}