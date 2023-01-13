package com.fastestindia.thedatatalk.ResourceActivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import com.fastestindia.thedatatalk.R

class ResourceDataActivity : AppCompatActivity() {
    lateinit var linearRegressionCardView: CardView
    lateinit var logisticRegressionCardView: CardView
    lateinit var svmCardView: CardView
    lateinit var knnCardView: CardView
    lateinit var neuralNetworkCardView: CardView
    lateinit var kMeansCardView: CardView
    lateinit var computerVisionCardView: CardView
    lateinit var nlpCardView: CardView
    lateinit var deepLearningCardView: CardView
    lateinit var timeSeriesCardView: CardView
    lateinit var pcsCardView: CardView
    lateinit var hiddenCardView: CardView
    lateinit var reinforcementCardView: CardView
    lateinit var xgBoostCardView: CardView


    lateinit var backButton: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource_data)
        linearRegressionCardView=findViewById(R.id.linearRegressionModelCardView)
        logisticRegressionCardView=findViewById(R.id.logisticRegressionModelCardView)
        svmCardView=findViewById(R.id.svmModelCourseCardView)
        knnCardView=findViewById(R.id.knnModelCardView)
        neuralNetworkCardView=findViewById(R.id.neuralNetworkModelCardView)
        kMeansCardView=findViewById(R.id.kMeansModelCardView)
        computerVisionCardView=findViewById(R.id.computerVisionModelCardView)
        nlpCardView=findViewById(R.id.nlpModelCardView)
        deepLearningCardView=findViewById(R.id.deepLearningModelCardView)
        timeSeriesCardView=findViewById(R.id.timeSeriesModelCardView)
        pcsCardView=findViewById(R.id.pcaModelCardView)
        hiddenCardView=findViewById(R.id.hiddenMarkovModelCardView)
        reinforcementCardView=findViewById(R.id.reinforcementModelCardView)
        xgBoostCardView=findViewById(R.id.xgBoostModelsCardView)

        backButton=findViewById(R.id.backImageButton)
        backButton.setOnClickListener{
            finish()
        }

        linearRegressionCardView.setOnClickListener {
            val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "Linear Regression")
            startActivity(intent) }
        logisticRegressionCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "Logistic Regression")
            startActivity(intent)  }
        svmCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "SVM")
            startActivity(intent)  }
        knnCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "KNN")
            startActivity(intent)  }
        neuralNetworkCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "Neural Network")
            startActivity(intent) }
        kMeansCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "K Means")
            startActivity(intent)  }
        computerVisionCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "Computer Vision")
            startActivity(intent)  }
        nlpCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "NLP")
            startActivity(intent)  }
        deepLearningCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "Deep Learning")
            startActivity(intent)  }
        timeSeriesCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "Time Series")
            startActivity(intent)  }
        pcsCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "PCA")
            startActivity(intent)  }
        hiddenCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "Hidden Markov Model")
            startActivity(intent)  }
        reinforcementCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "Reinforcement Learning")
            startActivity(intent)  }
        xgBoostCardView.setOnClickListener { val intent = Intent(applicationContext, ModelDataContentActivity::class.java)
            intent.putExtra("Model", "XG Boost")
            startActivity(intent)  }

    }
}