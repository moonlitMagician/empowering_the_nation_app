package com.example.xhaw5112mobile_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class checkoutScreen : AppCompatActivity() {

    private lateinit var firstAidBox: CheckBox
    private lateinit var sewingBox: CheckBox
    private lateinit var childMindingBox: CheckBox
    private lateinit var cookingBox: CheckBox
    private lateinit var gardenMatienceBox: CheckBox
    private lateinit var landscapingBox: CheckBox
    private lateinit var lifeSkillsBox: CheckBox

    //calculating both the total price of all the courses selected
    private fun calculateTotal(): Double {
        var total = 0.0

        if (firstAidBox.isChecked) total += 1500.0
        if (sewingBox.isChecked) total += 1500.0
        if (childMindingBox.isChecked) total += 750.0
        if (cookingBox.isChecked) total += 750.0
        if (gardenMatienceBox.isChecked) total += 750.0
        if (landscapingBox.isChecked) total += 1500.0
        if (lifeSkillsBox.isChecked) total += 1500.0

        return total // Return the total amount
    }

    //getting the list of all the selected courses
    private fun getSelectedCourses(): List<String> {
        val selectedCourses = mutableListOf<String>()
        if (firstAidBox.isChecked) selectedCourses.add("First Aid")
        if (sewingBox.isChecked) selectedCourses.add("Sewing")
        if (childMindingBox.isChecked) selectedCourses.add("Child Minding")
        if (cookingBox.isChecked) selectedCourses.add("Cooking")
        if (gardenMatienceBox.isChecked) selectedCourses.add("Garden Maintenance")
        if (landscapingBox.isChecked) selectedCourses.add("Landscaping")
        if (lifeSkillsBox.isChecked) selectedCourses.add("Life Skills")
        return selectedCourses
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_checkout_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firstAidBox = findViewById<CheckBox>(R.id.firstAidBox)
        sewingBox = findViewById<CheckBox>(R.id.sewingBox)
        childMindingBox = findViewById<CheckBox>(R.id.childMindingBox)
        cookingBox = findViewById<CheckBox>(R.id.cookingBox)
        gardenMatienceBox = findViewById<CheckBox>(R.id.gardenMatienceBox)
        landscapingBox = findViewById<CheckBox>(R.id.landscapingBox)
        lifeSkillsBox = findViewById<CheckBox>(R.id.lifeSkillsBox)

        val enrollCheckout = findViewById<Button>(R.id.enrollCheckout)
        val enrollHome = findViewById<Button>(R.id.enrollHome)

        enrollHome.setOnClickListener {
            val intent = Intent(this, homeScreen::class.java)
            startActivity(intent)
        }

        enrollCheckout.setOnClickListener {
            val totalAmount = calculateTotal()
            val selectedCourses = getSelectedCourses()

            val intent = Intent(this, finalizeCheckoutScreen::class.java).apply {
                putExtra("SELECTED_COURSES", selectedCourses.toTypedArray())
                putExtra("TOTAL_AMOUNT", totalAmount)
            }
            startActivity(intent)
        }
    }


}