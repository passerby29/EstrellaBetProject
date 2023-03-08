package esterella.cheeseit.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import esterella.cheeseit.databinding.ActivityMainBinding
import esterella.cheeseit.presentation.viewmodels.InternationalViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: InternationalViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[InternationalViewModel::class.java]
        viewModel.getInternationalTest()
    }
}