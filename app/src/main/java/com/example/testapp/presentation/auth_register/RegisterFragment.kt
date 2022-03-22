package com.example.testapp.presentation.auth_register

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.testapp.R
import com.example.testapp.core.BaseFragment
import com.example.testapp.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {

    private val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.registerState.collect { state ->
                when (state) {
                    is RegisterState.Success -> {
                        when (state.response.status) {
                            "TRUE" -> {
                                val dialog = AlertDialog.Builder(activity)
                                dialog.setPositiveButton("OK") { _, _ ->
                                    findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
                                }
                                dialog.setMessage("Регистрация успешна. ID - ${state.response.userId}")
                                dialog.create()
                                dialog.show()
                            }
                            else -> {
                                val dialog = AlertDialog.Builder(activity)
                                dialog.setPositiveButton("OK") { _, _ ->
                                }
                                dialog.setMessage(state.response.message)
                                dialog.create()
                                dialog.show()
                            }
                        }
                    }
                    is RegisterState.Failure -> {
                        Toast.makeText(activity, state.errorText, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }


        binding.apply {
            rbConfirmData.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    btnRegister.alpha = 1.0F
                    btnRegister.setOnClickListener {
                        registerUser()
                    }
                }
            }
            btnLoginTab.setOnClickListener {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
            btnGoBack.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

    private fun getGender(): String {
        return when {
            binding.rbFemale.isChecked -> {
                "F"
            }
            binding.rbMale.isChecked -> {
                "M"
            }
            else -> {
                ""
            }
        }
    }

    private fun registerUser() {

        viewModel.registerUser(
            name = binding.etName.text.toString(),
            personalGender = getGender(),
            personalBirthday = binding.etBirthday.text.toString(),
            personalMobile = binding.etPhoneNumber.text.toString(),
            email = binding.etEmail.text.toString(),
            workCompany = binding.etCompanyName.text.toString(),
            ufServiceNumber = binding.etServiceNumber.text.toString(),
            login = binding.etLogin.text.toString(),
            password = binding.etPassword.text.toString(),
            confirmPassword = binding.etConfirmPassword.text.toString()
        )
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentRegisterBinding.inflate(inflater, container, false)

}