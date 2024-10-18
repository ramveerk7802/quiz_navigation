package com.example.navigation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.navigation.R
import com.example.navigation.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // initialize binding
        binding = FragmentQuizBinding.inflate(inflater,container,false)



        binding.winButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_quizFragment_to_quizWinFragment)
        }
        binding.overButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_quizFragment_to_quizOverFragment)
        }


        return binding.root
    }


}