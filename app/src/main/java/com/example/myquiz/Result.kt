package com.example.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.UserHandle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val tvName: TextView = findViewById(R.id.tv_name)
        val tvScore : TextView = findViewById(R.id.tv_score)
        val btFinish : Button = findViewById(R.id.bt_finish)
        val myUserName : String? = intent.getStringExtra(Constants.USER_NAME)
        val correctAns = intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        val totalQuestions  = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        tvName.text = myUserName
        tvScore.text = "Your Score is $correctAns out of $totalQuestions"
        btFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}