package com.example.xhaw5112mobile_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class selectedCoursePage : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_selected_course_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val courseName = intent.getStringExtra("course_name")
        val courseImageResId = intent.getIntExtra("course_image", 0)

        val courseTitle = findViewById<TextView>(R.id.CourseTitle)
        val courseImage = findViewById<ImageView>(R.id.courseImage)
        val courseInfo = findViewById<TextView>(R.id.courseInfo)
        val homeButton = findViewById<Button>(R.id.coursePageHome)

        homeButton.setOnClickListener {
            val intent = Intent(this, homeScreen::class.java)
            startActivity(intent)
        }

        //each if statement checks which button was pressed previously
        //this is so the one screen can be edited, as opposed to bloating up the app with more screens than needed



        if (courseName == "Cooking"){
            courseTitle.text = "6 Week Course - $courseName"
            courseImage.setImageResource(courseImageResId)
            courseInfo.text = "Learn to prepare quick, healthy, and delicious meals with simple recipes designed for everyday cooking.\n\n" +
                    "Topics Include: \n\n" +
                    "Nutritional requirements for a healthy body\n\n" +
                    "Types of protein, carbohydrates and vegetables\n\n" +
                    "Planning meals\n\n" +
                    "Preparation and cooking of meals\n\n"
        }

        if (courseName == "Child Minding"){
            courseTitle.text = "6 Week Course - $courseName"
            courseImage.setImageResource(courseImageResId)
            courseInfo.text = "Equip yourself with the knowledge and techniques to care for children in a safe and nurturing environment.\n\n" +
                    "Topics Include: \n\n" +
                    "birth to six-month old baby needs\n\n" +
                    "seven-month to one year old needs\n\n" +
                    "Toddler needs\n\n" +
                    "Educational toys"
        }

        if (courseName == "Garden Maintenance"){
            courseTitle.text = "6 Week Course - $courseName"
            courseImage.setImageResource(courseImageResId)
            courseInfo.text = "Develop essential gardening skills to maintain vibrant, thriving gardens throughout the seasons\n\n" +
                    "Topics Include:\n\n" +
                    "Water restrictions and the watering requirements of indigenous and exotic plants\n\n" +
                    "Pruning and propagation of plants\n\n" +
                    "Planting techniques for different plant types\n\n"
        }

        if (courseName == "First Aid"){
            courseTitle.text = "6 Month Course - $courseName"
            courseImage.setImageResource(courseImageResId)
            courseInfo.text = "Learn essential first aid techniques to confidently handle medical emergencies and provide critical care when needed.\n\n" +
                    "Topics Include:\n\n" +
                    "Wounds and bleeding\n" +
                    "Burns and fractures\n" +
                    "Emergency scene management\n" +
                    "Cardio-Pulmonary Resuscitation (CPR)\n" +
                    "Respiratory distress e.g., Choking, blocked airway\n"
        }

        if (courseName == "Sewing"){
            courseTitle.text = "6 Month Course - $courseName"
            courseImage.setImageResource(courseImageResId)
            courseInfo.text = "Master sewing skills, from basic stitches to crafting your own clothing, and explore creative garment-making techniques.\n\n" +
                    "Topics include:\n\n" +
                    "Types of stitches\n" +
                    "Threading a sewing machine\n" +
                    "Sewing buttons, zips, hems and seams\n" +
                    "Alterations\n" +
                    "Designing and sewing new garments"
        }

        if (courseName == "Landscaping"){
            courseTitle.text = "6 Month Course - $courseName"
            courseImage.setImageResource(courseImageResId)
            courseInfo.text = "Discover the fundamentals of landscape design and learn how to create and maintain beautiful outdoor spaces.\n\n" +
                    "Topics Include:\n\n" +
                    "Indigenous and exotic plants and trees\n" +
                    "Fixed structures (fountains, statues, benches, tables, built-in braai)\n" +
                    "Balancing of plants and trees in a garden\n" +
                    "Aesthetics of plant shapes and colours\n" +
                    "Garden layout"
        }

        if(courseName == "Life Skills"){
            courseTitle.text = "6 Month Course - $courseName"
            courseImage.setImageResource(courseImageResId)
            courseInfo.text = " Build a foundation of practical life skills, including time management, communication, and financial literacy, to enhance daily living.\n\n" +
                    "Topics include:\n\n" +
                    "Opening a bank account\n" +
                    "Basic labour law (know your rights)\n" +
                    "Basic reading and writing literacy \n" +
                    "Basic numeric literacy"
        }
    }
}