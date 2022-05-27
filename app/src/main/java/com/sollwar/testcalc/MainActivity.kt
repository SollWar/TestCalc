package com.sollwar.testcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import com.sollwar.testcalc.databinding.ActivityMainBinding
import com.sollwar.testcalc.ui.CalcFragment
import com.sollwar.testcalc.ui.LoginFragment

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val isFragmentContainerEmpty = savedInstanceState == null
        if (isFragmentContainerEmpty) {
            supportFragmentManager
                .beginTransaction()
                .add(binding.fragmentContainer.id, LoginFragment.newInstance())
                .commit()
        }
    }

    override fun singInSuccess() {
        supportFragmentManager
            .beginTransaction()
            .setTransition(TRANSIT_FRAGMENT_FADE)
            .replace(binding.fragmentContainer.id, CalcFragment.newInstance())
            .commit()
    }
}