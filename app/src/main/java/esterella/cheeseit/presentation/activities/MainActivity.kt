package esterella.cheeseit.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import esterella.cheeseit.R
import esterella.cheeseit.databinding.ActivityMainBinding
import esterella.cheeseit.presentation.fragments.CategoryFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, CategoryFragment())
            .addToBackStack(null)
            .commit()
    }
}