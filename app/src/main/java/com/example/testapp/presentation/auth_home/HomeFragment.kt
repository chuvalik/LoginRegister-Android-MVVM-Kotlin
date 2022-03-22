package com.example.testapp.presentation.auth_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testapp.R
import com.example.testapp.core.BaseFragment
import com.example.testapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnToLogin.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }

        binding.btnToRegister.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_registerFragment)
        }
    }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) =  FragmentHomeBinding.inflate(inflater, container, false)

}