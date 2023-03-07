package com.ab.dev.shoesly.presentation.fragments.splash.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ab.dev.shoesly.app.constants.APP.SPLASH_TIME
import com.ab.dev.shoesly.databinding.FragmentSplashScreenBinding
import com.ab.dev.shoesly.presentation.fragments.splash.viewModel.SplashViewModel
import com.ab.dev.shoesly.presentation.mainActivity.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() {
    private val splashViewModel: SplashViewModel by viewModel()

    private lateinit var binding: FragmentSplashScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.myLooper()!!).postDelayed({
            if (splashViewModel.isRememberMe && splashViewModel.isValidToken) navigateToMain()
            else navigateToLoginFragment()
        }, SPLASH_TIME)
    }

    private fun navigateToMain() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    private fun navigateToLoginFragment() {
        val navDirection = SplashScreenFragmentDirections.actionSplashScreenFragmentToLoginFragment()
        findNavController().navigate(navDirection)
    }
}