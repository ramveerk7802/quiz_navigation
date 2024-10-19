package com.example.navigation.navigationUtill

import androidx.appcompat.app.AppCompatActivity
import com.example.navigation.R


object NavigationUtils {
    fun setToolbarTitle(activity: AppCompatActivity, destinationId: Int) {
        val title = when (destinationId) {
            R.id.homeFragment2 -> "Home"
            R.id.quizFragment -> "Quiz"
            R.id.quizWinFragment ->"You Win!"
            R.id.quizOverFragment -> "Game Over"
            // Add more cases as needed
            else -> ""
        }
        activity.supportActionBar?.title = title
    }
}