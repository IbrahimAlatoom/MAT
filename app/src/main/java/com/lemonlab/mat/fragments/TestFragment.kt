package com.lemonlab.mat.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.lemonlab.mat.R
import com.lemonlab.mat.databinding.FragmentTestBinding


class TestFragment : Fragment() {
    private lateinit var binding: FragmentTestBinding

    data class Question(val text: String, val answers: List<String>)
    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "هل تجد نفسك تقضي وقتًا أطول على هاتفك الذكي أكثر مما تدرك؟",
            answers = listOf("نعم", "لا")),
        Question(text = "هل تجد نفسك تمضي الوقت بلا تفكير بشكل منتظم بالتحديق في هاتفك الذكي؟",
            answers = listOf("نعم", "لا")),
        Question(text = "هل يبدو أنك تفقد مسار الوقت عندما تكون على هاتفك الذكي؟",
            answers = listOf("نعم", "لا")),
        Question(text = "هل تجد نفسك تقضي وقتًا أطول في إرسال الرسائل النصية أو التغريد أو المراسلة عبر البريد الإلكتروني بدلاً من التحدث إلى الأشخاص شخصيًا؟",
            answers = listOf("نعم", "لا")),
        Question(text = "هل زاد مقدار الوقت الذي تقضيه في استخدام هاتفك الذكي؟",
            answers = listOf("نعم", "لا")),
        Question(text = "هل تتمنى لو أن لديك القدرة على أن تكون أقل تفاعلاً مع هاتفك الذكي؟",
            answers = listOf("نعم", "لا")),
        Question(text = "هل تنام وهاتفك الذكي (قيد التشغيل) تحت وسادتك أو بجوار سريرك بانتظام؟",
            answers = listOf("نعم", "لا")),
        Question(text = "هل تجد نفسك تشاهد وترد على النصوص والتغريدات ورسائل البريد الإلكتروني في جميع ساعات النهار والليل - حتى عندما يعني ذلك مقاطعة أشياء أخرى تقوم بها؟",
            answers = listOf("نعم", "لا")),
        Question(text = "هل ترسل رسائل نصية أو بريد إلكتروني أو تغرد أو تتصفح أثناء القيادة أو تقوم بأنشطة أخرى مماثلة تتطلب تركيزك وانتباهك؟",
            answers = listOf("نعم", "لا")),
        Question(text = "هل تشعر أن استخدامك لهاتفك الذكي يقلل من إنتاجيتك في بعض الأحيان؟",
            answers = listOf("نعم", "لا"))
    )
    lateinit var currentQuestion: Question
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_test, container, false)
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}