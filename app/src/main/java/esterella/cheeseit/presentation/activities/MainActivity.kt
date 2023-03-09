package esterella.cheeseit.presentation.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import esterella.cheeseit.R
import esterella.cheeseit.databinding.ActivityMainBinding
import esterella.cheeseit.presentation.fragments.CategoryFragment
import esterella.cheeseit.presentation.fragments.TestFragment

class MainActivity : AppCompatActivity(), TestFragment.OnTestFinishedListener {

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

    override fun onTestFinished(result: String) {
        super.onTestFinished(result)
        Toast.makeText(
            this@MainActivity,
            "Test is finished! $result",
            Toast.LENGTH_LONG
        )
            .show()
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, CategoryFragment())
            .addToBackStack(null)
            .commit()
    }
}