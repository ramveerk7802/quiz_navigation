package com.example.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.navigation.R
import com.example.navigation.databinding.FragmentQuizWinBinding

class QuizWinFragment : Fragment() {

    private val binding : FragmentQuizWinBinding by lazy {
        FragmentQuizWinBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        binding.retakeButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_quizWinFragment_to_quizFragment)
        }



        return binding.root
    }


}