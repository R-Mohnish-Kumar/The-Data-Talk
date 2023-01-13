package com.fastestindia.thedatatalk.CoursesActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import com.fastestindia.thedatatalk.R

class CoursesActivity : AppCompatActivity() {


    lateinit var pythonCardView: CardView
    lateinit var dataVisualisationCardView: CardView
    lateinit var dataCleaningCardView: CardView
    lateinit var dataPreProcessingCardView: CardView
    lateinit var machineLearningCardView: CardView
    lateinit var aiEthicsCardView: CardView
    lateinit var statisticsCardView: CardView
    lateinit var rProgrammingCardView: CardView
    lateinit var dataEngineeringCardView: CardView
    lateinit var juliaCardView: CardView
    lateinit var quantumCardView: CardView

    lateinit var backButton: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        pythonCardView=findViewById(R.id.pythonCourseCardView)
        dataVisualisationCardView=findViewById(R.id.dataVisualizationCourseCardView)
        dataCleaningCardView=findViewById(R.id.dataCleaningCourseCardView)
        dataPreProcessingCardView=findViewById(R.id.dataPreProcessingCourseCardView)
        machineLearningCardView=findViewById(R.id.machineLearningCourseCardView)
        aiEthicsCardView=findViewById(R.id.aiEthicsCourseCardView)
        statisticsCardView=findViewById(R.id.statisticsCourseCardView)
        rProgrammingCardView=findViewById(R.id.rProgrammingCourseCardView)
        dataEngineeringCardView=findViewById(R.id.dataEngineeringCourseCardView)
        juliaCardView=findViewById(R.id.juliaProgrammingCourseCardView)
        quantumCardView=findViewById(R.id.quantumComputingCourseCardView)

        backButton=findViewById(R.id.backImageButton)
        backButton.setOnClickListener{
            finish()
        }

        pythonCardView.setOnClickListener {
            val intent = Intent(applicationContext, CourseAccessSectionActivity::class.java)
            intent.putExtra("Course", "Python Programming")
            startActivity(intent) }
        dataVisualisationCardView.setOnClickListener { val intent = Intent(applicationContext, CourseAccessSectionActivity::class.java)
            intent.putExtra("Course", "Data Visualisation")
            startActivity(intent)  }
        dataCleaningCardView.setOnClickListener { val intent = Intent(applicationContext, CourseAccessSectionActivity::class.java)
            intent.putExtra("Course", "Data Cleaning")
            startActivity(intent)  }
        dataPreProcessingCardView.setOnClickListener { val intent = Intent(applicationContext, CourseAccessSectionActivity::class.java)
            intent.putExtra("Course", "Data PreProcessing")
            startActivity(intent)  }
        machineLearningCardView.setOnClickListener { val intent = Intent(applicationContext, CourseAccessSectionActivity::class.java)
            intent.putExtra("Course", "Machine Learning")
            startActivity(intent) }
        aiEthicsCardView.setOnClickListener { val intent = Intent(applicationContext, CourseAccessSectionActivity::class.java)
            intent.putExtra("Course", "AI Ethics")
            startActivity(intent)  }
        statisticsCardView.setOnClickListener { val intent = Intent(applicationContext, CourseAccessSectionActivity::class.java)
            intent.putExtra("Course", "Statistics")
            startActivity(intent)  }
        rProgrammingCardView.setOnClickListener { val intent = Intent(applicationContext, CourseAccessSectionActivity::class.java)
            intent.putExtra("Course", "R Programming")
            startActivity(intent)  }
        dataEngineeringCardView.setOnClickListener { val intent = Intent(applicationContext, CourseAccessSectionActivity::class.java)
            intent.putExtra("Course", "Data Engineering")
            startActivity(intent)  }
        juliaCardView.setOnClickListener { val intent = Intent(applicationContext, CourseAccessSectionActivity::class.java)
            intent.putExtra("Course", "Julia Programming")
            startActivity(intent)  }
        quantumCardView.setOnClickListener { val intent = Intent(applicationContext, CourseAccessSectionActivity::class.java)
            intent.putExtra("Course", "Quantum Computing")
            startActivity(intent)  }



    }
}