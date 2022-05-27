package com.sollwar.testcalc.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.sollwar.testcalc.MainViewModel
import com.sollwar.testcalc.R
import com.sollwar.testcalc.databinding.FragmentCalcBinding

class CalcFragment : Fragment() {

    private var _binding: FragmentCalcBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalcBinding.inflate(inflater, container, false)
        binding.username.text = getString(R.string.welcome, viewModel.currentUser.value?.userName.toString())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.plus.setOnClickListener {
            binding.result.text = calc("+")
        }
        binding.minus.setOnClickListener {
            binding.result.text = calc("-")
        }
        binding.multiply.setOnClickListener {
            binding.result.text = calc("*")
        }
        binding.divide.setOnClickListener {
            binding.result.text = calc("/")
        }
    }

    private fun calc(procedure: String): String {
        val firstArgument = binding.firstArgument.text.toString()
        val secondArgument = binding.secondArgument.text.toString()
        return if (firstArgument != "" && secondArgument != "")
            viewModel.calc.calc(firstArgument, secondArgument, procedure)
        else {
            Toast.makeText(context, getString(R.string.invalid_arguments), Toast.LENGTH_SHORT).show()
            getString(R.string.result)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance(): CalcFragment {
            return CalcFragment()
        }
    }
}