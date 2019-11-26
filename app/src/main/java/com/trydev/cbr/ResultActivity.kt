package com.trydev.cbr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    private lateinit var btnBack : TextView
    private lateinit var textSolution: TextView
    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textSolution = text_solution
        textResult = result

        var strIndication : String = intent.getStringExtra("strIndication")
        var solution : String = intent.getStringExtra("solution")

        textSolution.text = solution
        textResult.text = strIndication

        btnBack = btn_back
        btn_back.setOnClickListener {
            super.onBackPressed()
        }
    }
}
