package com.lemonlab.mat.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
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
            answers = listOf("نعم", "لا")),
        Question(text = "هل تشعر بالتردد في البقاء بدون هاتفك الذكي ، حتى لفترة قصيرة؟",
            answers = listOf("نعم", "لا")),
        Question(text = "هل تشعر بعدم الراحة أو عدم الارتياح عندما تترك هاتفك الذكي عن طريق الخطأ في السيارة أو في المنزل ، أو لا توجد لديك خدمة إنترنت أو حينما يكسر هاتفك؟",
            answers = listOf("نعم", "لا")),
        Question(text = "عندما تأكل وجبات الطعام ، هل هاتفك الذكي دائمًا جزء من إعداد مكان الطاولة؟",
            answers = listOf("نعم", "لا")),
        Question(text = "عندما يرن هاتفك الذكي أو يصدر صفيرًا ، هل تشعر برغبة شديدة في التحقق من النصوص والتغريدات ورسائل البريد الإلكتروني والتحديثات وما إلى ذلك؟",
            answers = listOf("نعم", "لا")),
        Question(text = "هل تجد نفسك تتفقد هاتفك المحمول أو هاتفك الذكي دون تفكير عدة مرات في اليوم ، حتى عندما تعلم أنه من المحتمل ألا يكون هناك شيء جديد أو مهم لتراه؟",
            answers = listOf("نعم", "لا"))
    )
    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = 15
    var yesesCounter =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_test, container, false)
        setQuestion(questionIndex)

        binding.test = this

        binding.submitButton.setOnClickListener(){
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            if (-1 != checkedId) {
                when (checkedId) {
                    R.id.radio_button_yes -> yesesCounter++
                }
                if (questionIndex == numQuestions) {
                    var navController = findNavController()
                    navController.navigate(TestFragmentDirections.actionTestFragmentToResultFragment(yesesCounter))
                    questionIndex=0
                    yesesCounter=0
                }
                questionIndex++
                setQuestion(questionIndex)
                binding.invalidateAll()
                }
            }

        return binding.root
    }

    private fun setQuestion(index:Int) {
        if(index<numQuestions){
        currentQuestion = questions[index]
        answers = currentQuestion.answers.toMutableList()

        }
    }
}