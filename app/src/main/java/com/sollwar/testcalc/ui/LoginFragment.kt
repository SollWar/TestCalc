package com.sollwar.testcalc.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.sollwar.testcalc.MainViewModel
import com.sollwar.testcalc.R
import com.sollwar.testcalc.databinding.FragmentLoginBinding
import com.sollwar.testcalc.navigator

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.login.setOnClickListener {
            waitOn()
            viewModel.singIn(
                binding.username.text.toString().trim(),
                binding.password.text.toString()
            )
        }

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer { user ->
                user?.let {
                    waitOff()
                    if (user.userId != -1) navigator().singInSuccess()
                    else Toast.makeText(context, getString(R.string.login_failed), Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    private fun waitOn() {
        binding.login.isEnabled = false
        binding.password.isEnabled = false
        binding.username.isEnabled = false
        binding.loading.visibility = View.VISIBLE
    }

    private fun waitOff() {
        binding.login.isEnabled = true
        binding.password.isEnabled = true
        binding.username.isEnabled = true
        binding.loading.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }
}