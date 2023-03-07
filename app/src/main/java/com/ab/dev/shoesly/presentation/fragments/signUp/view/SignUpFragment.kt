package com.ab.dev.shoesly.presentation.fragments.signUp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.ab.dev.shoesly.R
import com.ab.dev.shoesly.databinding.FragmentSignUpBinding
import com.ab.dev.shoesly.domain.models.state.RegistrationUiState
import com.ab.dev.shoesly.presentation.fragments.signUp.viewModel.SignUpViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    private val signUpViewModel : SignUpViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController : NavController = findNavController()

        binding.apply {
            toolBarSignUp.setupWithNavController(navController)
            viewModel = signUpViewModel
        }

        lifecycleScope.launch {
            signUpViewModel.registrationState.collect { uiState ->
                showLoadingBar(uiState.isLoading)
                manageErrors(uiState)
                onRegistrationSuccess(uiState.isSuccessOperation)
            }
        }
    }

    private fun manageErrors(uiState: RegistrationUiState) {
        binding.apply {
            tfFirstName.error = uiState.firstNameErrorMessage
            tfLastName.error = uiState.lastNameErrorMessage
            tfEmail.error = uiState.emailErrorMessage
            tfPassword.error = uiState.passwordErrorMessage

            if (uiState.isSuccessOperation) {
                tvMainErrorMessage.setText(R.string.account_created_successfully)
                val greenColor = resources.getColor(R.color.green, activity?.theme)
                tvMainErrorMessage.setTextColor(greenColor)
            } else {
                val redColor = resources.getColor(R.color.red, activity?.theme)
                tvMainErrorMessage.setTextColor(redColor)
                tvMainErrorMessage.setText(uiState.mainUserMessageRes ?: R.string.empty)
            }
        }
    }

    private fun onRegistrationSuccess(isSuccess: Boolean) {
        if(isSuccess) {
            Log.d("SignUpFragment", "Success Operation")
        }
    }

    private fun showLoadingBar(show: Boolean) {
        binding.apply {
            if (show) {
                pbLoading.visibility = View.VISIBLE
                btnRegistration.visibility = View.GONE
            } else {
                pbLoading.visibility = View.GONE
                btnRegistration.visibility = View.VISIBLE
            }
        }
    }

}