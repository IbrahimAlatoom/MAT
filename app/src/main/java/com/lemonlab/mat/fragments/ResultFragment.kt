package com.lemonlab.mat.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.lemonlab.mat.R
import com.lemonlab.mat.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var binding : FragmentResultBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_result,container,false)

        val args = ResultFragmentArgs.fromBundle(requireArguments())

        when (args.yesesCounter){
            in 0..2 -> binding.resultText.text = "سلوكك طبيعي ولكن هذا لا يعني أنك يجب أن تعيش على هاتفك الذكي"
            in 3..4 -> binding.resultText.text = "سلوكك يميل نحو الاستخدام القهري(الإدماني)."
            in 5..7 -> binding.resultText.text = "من المحتمل أن يكون لديك نمط استخدام هاتف ذكي قهري."
            in 8..15 -> binding.resultText.text = "تفكر في زيارة طبيب نفسي أو معالج نفسي متخصص في الإدمان السلوكي للحصول على استشارة."
        }
        binding.backButton.setOnClickListener(){
            navController = findNavController()
            navController.navigate(R.id.action_resultFragment_to_titleFragment)
        }
        return binding.root

    }


}