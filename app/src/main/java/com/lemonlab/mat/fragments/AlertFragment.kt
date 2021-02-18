package com.lemonlab.mat.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.lemonlab.mat.R
import com.lemonlab.mat.databinding.FragmentAlertBinding

class AlertFragment : Fragment() {
   private lateinit var binding : FragmentAlertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_alert
            ,container,false)

        binding.nextCard.setOnClickListener(){
            Navigation.findNavController(it).navigate(R.id
                .action_alertFragment_to_testFragment)
        }

        return binding.root
    }

}