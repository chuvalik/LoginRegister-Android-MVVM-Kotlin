package com.example.testapp.presentation.auth_login

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.testapp.R
import com.example.testapp.core.BaseFragment
import com.example.testapp.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect


@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel: LoginViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.loginState.collect { state ->
                when (state) {
                    is LoginState.Success -> {
                        when (state.response.status) {
                            true -> {
                                val dialog = AlertDialog.Builder(activity)
                                dialog.setPositiveButton("OK") { _, _ ->
                                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                                }
                                dialog.setMessage("Авторизация успешна. ID - ${state.response.id}")
                                dialog.create()
                                dialog.show()

                            }
                            false -> {
                                val dialog = AlertDialog.Builder(activity)
                                dialog.setPositiveButton("OK") { _, _ ->
                                }
                                dialog.setMessage(state.response.message)
                                dialog.create()
                                dialog.show()
                            }
                        }
                    }
                    is LoginState.Failure -> {
                        Toast.makeText(activity, state.error, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.apply {
            btnLogin.setOnClickListener {
                loginUser()
            }
            btnRegisterTab.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
            }
            btnGoBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun loginUser() {
        viewModel.loginUser(
            login = binding.etLogin.text.toString(),
            password = binding.etPassword.text.toString()
        )
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLoginBinding.inflate(inflater, container, false)


}