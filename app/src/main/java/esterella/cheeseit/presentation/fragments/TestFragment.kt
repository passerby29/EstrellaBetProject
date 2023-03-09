package esterella.cheeseit.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import esterella.cheeseit.databinding.FragmentTestBinding
import esterella.cheeseit.domain.models.Main
import esterella.cheeseit.presentation.viewmodels.MainViewModel

class TestFragment : Fragment() {

    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel
    private var category: String? = CATEGORY_UNKNOWN
    private var answers: String = "Correct 0/5"
    private var questions: String = "Question 1/5"
    private lateinit var onTesFinishedListener: OnTestFinishedListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnTestFinishedListener) {
            onTesFinishedListener = context
        } else {
            throw RuntimeException("Activity  must implement OnTestFinishedListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTestBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchRightTest()
        binding.answersTv.text = answers
        binding.questionsTv.text = questions
        viewModel.test.observe(viewLifecycleOwner) {
            binding.textViewMain.text = it[0].mQuestion
            initButtons(it)
        }
        viewModel.countOfRightAnswers.observe(viewLifecycleOwner) {
            answers = "Correct $it/5"
            binding.answersTv.text = answers
        }
        viewModel.countOfQuestions.observe(viewLifecycleOwner) {
            questions = "Question $it/5"
            binding.questionsTv.text = questions
        }
        viewModel.shouldCloseScreen.observe(viewLifecycleOwner) {
            onTesFinishedListener.onTestFinished(answers)
        }
    }

    private fun launchRightTest() {
        when (category) {
            CATEGORY_INTERNATIONAL -> viewModel.getInternationalTest()
            CATEGORY_EUROPE -> viewModel.getEuropeTest()
            CATEGORY_EPL -> viewModel.getEPLTest()
            CATEGORY_WORLD -> viewModel.getWorldTest()
        }
    }

    private fun parseParams() {
        val args = requireArguments()
        if (!args.containsKey(TEST_CATEGORY)) {
            throw RuntimeException("Param category is absent")
        }
        category = args.getString(TEST_CATEGORY)
        if (category != CATEGORY_EUROPE
            && category != CATEGORY_WORLD
            && category != CATEGORY_EPL
            && category != CATEGORY_INTERNATIONAL
        ) {
            throw RuntimeException("Unknown category $category")
        }
    }

    private fun initButtons(list: List<Main>) {
        binding.testButton1.apply {
            text = list[0].mAnswer
            setOnClickListener {
                viewModel.apply {
                    selectedButton.value = 0
                    checkAnswer()
                }
            }
        }
        binding.testButton2.apply {
            text = list[1].mAnswer
            setOnClickListener {
                viewModel.apply {
                    selectedButton.value = 1
                    checkAnswer()
                }
            }
        }
        binding.testButton3.apply {
            text = list[2].mAnswer
            setOnClickListener {
                viewModel.apply {
                    selectedButton.value = 2
                    checkAnswer()
                }
            }
        }
        binding.testButton4.apply {
            text = list[3].mAnswer
            setOnClickListener {
                viewModel.apply {
                    selectedButton.value = 3
                    checkAnswer()
                }
            }
        }
    }

    companion object {
        private const val TEST_CATEGORY = "test_category"
        const val CATEGORY_INTERNATIONAL = "category_international"
        const val CATEGORY_EPL = "category_epl"
        const val CATEGORY_EUROPE = "category_europe"
        const val CATEGORY_WORLD = "category_world"
        private const val CATEGORY_UNKNOWN = ""

        fun newInstance(category: String): TestFragment {
            return TestFragment().apply {
                arguments = Bundle().apply {
                    putString(TEST_CATEGORY, category)
                }
            }
        }
    }

    interface OnTestFinishedListener {
        fun onTestFinished(result: String) {}
    }
}