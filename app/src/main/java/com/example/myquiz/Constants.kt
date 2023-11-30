package com.example.myquiz

object Constants {

    const val USER_NAME :String = "user_name"
    const val TOTAL_QUESTIONS :String = "total_questions"
    const val CORRECT_ANSWER :String = "correct_answer"


    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        //1
        val question1 = Question(
            1,"Which Country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "India",
            "Belgium",
            "Fiji",
            1
        )
        questionList.add(question1)
        //2
        val question2 = Question(
            2,"Which Country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Australia",
            "India",
            "Belgium",
            "Germany",
            3
        )
        questionList.add(question2)
        //3
        val question3 = Question(
            3,"Which Country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Brazil",
            "Denmark",
            2
        )
        questionList.add(question3)
        //4
        val question4 = Question(
            4,"Which Country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Fiji",
            "Kuwait",
            "Argentina",
            1
        )
        questionList.add(question4)
        //5
        val question5 = Question(
            5,"Which Country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Argentina",
            "India",
            "Belgium",
            "Denmark",
            4
        )
        questionList.add(question5)
        //6
        val question6 = Question(
            6,"Which Country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Kuwait",
            "India",
            "Brazil",
            "Fiji",
            4
        )
        questionList.add(question6)
        //7
        val question7 = Question(
            7,"Which Country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "India",
            "New Zealand",
            "Denmark",
            1
        )
        questionList.add(question7)
        //8
        val question8 = Question(
            8,"Which Country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "India",
            "Argentina",
            "Belgium",
            "Australia",
            1
        )
        questionList.add(question8)
        //9
        val question9 = Question(
            9,"Which Country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Argentina",
            "India",
            "Kuwait",
            "Brazil",
            3
        )
        questionList.add(question9)
        //10
        val question10 = Question(
            10,"Which Country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Argentina",
            "New Zealand",
            "Kuwait",
            "Brazil",
            2
        )
        questionList.add(question10)

        return questionList
    }

}