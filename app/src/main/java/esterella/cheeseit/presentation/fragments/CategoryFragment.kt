package esterella.cheeseit.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import esterella.cheeseit.R
import esterella.cheeseit.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener { openTest(TestFragment.CATEGORY_INTERNATIONAL) }
        binding.button2.setOnClickListener { openTest(TestFragment.CATEGORY_EUROPE) }
        binding.button3.setOnClickListener { openTest(TestFragment.CATEGORY_EPL) }
        binding.button4.setOnClickListener { openTest(TestFragment.CATEGORY_WORLD) }
    }

    private fun openTest(category: String) {
        launchFragment(TestFragment.newInstance(category))
    }

    private fun launchFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}