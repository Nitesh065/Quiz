package com.example.myquiz

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myquiz.Result
import org.w3c.dom.Text

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener{
    private var myCurrentPosition : Int = 1
    private var myQuestionList : ArrayList<Question>? = null
    private var mySelectedOptionPosition : Int = 0
    private var myUserName :String? = null
    private var myCorrectAns :Int = 0

    private var progressBar : ProgressBar? = null
    private var progressTextView : TextView? = null
    private var tvQuestion : TextView? = null
    private var tvImage : ImageView? = null

    private var tvOption1 : TextView? = null
    private var tvOption2 : TextView? = null
    private var tvOption3 : TextView? = null
    private var tvOption4 : TextView? = null
    private var btnSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        myUserName = intent.getStringExtra(Constants.USER_NAME)
        progressBar = findViewById(R.id.progress_bar)
        progressTextView = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQue)
        tvImage = findViewById(R.id.iv_image)
        tvOption1 = findViewById(R.id.tv_option1)
        tvOption2 = findViewById(R.id.tv_option2)
        tvOption3 = findViewById(R.id.tv_option3)
        tvOption4 = findViewById(R.id.tv_option4)
        btnSubmit = findViewById(R.id.btnSubmit)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)

        myQuestionList = Constants.getQuestions()

        setQuestion()
        defaultOptionView()


    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = myQuestionList!![myCurrentPosition - 1]
        tvQuestion?.text = question.question
        tvImage?.setImageResource(question.image)
        progressBar?.progress = myCurrentPosition
        progressTextView?.text = "$myCurrentPosition/${progressBar?.max}"
        tvOption1?.text = question.optionOne
        tvOption2?.text = question.optionTwo
        tvOption3?.text = question.optionThree
        tvOption4?.text = question.optionFour

        if (myCurrentPosition == myQuestionList!!.size){
            btnSubmit?.text = "FINISH"
        }
        else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView(){
        var options = ArrayList<TextView>()
        tvOption1?.let {
            options.add(0, it)
        }

        tvOption2?.let {
            options.add(1, it)
        }
        tvOption3?.let {
            options.add(2, it)
        }
        tvOption4?.let {
            options.add(3, it)
        }
        btnSubmit?.text = "SUBMIT"
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,R.drawable.default_option_border
            )
        }

    }

    private fun selectedOptionView(tv : TextView,selectedOptionNum : Int){
        defaultOptionView()

        mySelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
       when(view?.id){
           R.id.tv_option1 -> tvOption1?.let {
               selectedOptionView(it,1)
           }
           R.id.tv_option2 -> tvOption2?.let {
               selectedOptionView(it,2)
           }
           R.id.tv_option3 -> tvOption3?.let {
               selectedOptionView(it,3)
           }
           R.id.tv_option4 -> tvOption4?.let{
               selectedOptionView(it,4)
           }
           R.id.btnSubmit -> {
               if (mySelectedOptionPosition == 0) {
                   myCurrentPosition++

                   when {
                       myCurrentPosition <= myQuestionList!!.size -> setQuestion()
                   else -> {
                       val intent = Intent(this,Result::class.java)
                       intent.putExtra(Constants.USER_NAME,myUserName)
                       intent.putExtra(Constants.CORRECT_ANSWER,myCorrectAns)
                       intent.putExtra(Constants.TOTAL_QUESTIONS,myQuestionList?.size)
                       startActivity(intent)
                       finish()
                   }
                   }

               }
               else{
                   val question = myQuestionList?.get(myCurrentPosition -1)
                   if (question?.correctAns != mySelectedOptionPosition){
                       answerView(mySelectedOptionPosition,R.drawable.worng_option_border)
                   }
                   else{
                       myCorrectAns++
                   }
                   answerView(question!!.correctAns,R.drawable.correct_option_border)

               }
               if (myCurrentPosition == myQuestionList!!.size){
                   btnSubmit?.text = "FINISH"
               }
               else{
                   btnSubmit?.text = "GO TO NEXT QUESTION"
               }
               mySelectedOptionPosition = 0
           }
       }

    }

    private fun answerView(answer : Int, drawableView: Int){
        when(answer){
            1 -> tvOption1?.background = ContextCompat.getDrawable(
                this,drawableView
            )

            2 -> tvOption2?.background = ContextCompat.getDrawable(
                this,drawableView
            )

            3 -> tvOption3?.background = ContextCompat.getDrawable(
                this,drawableView
            )

            4 -> tvOption4?.background = ContextCompat.getDrawable(
                this,drawableView
            )
        }
    }
}