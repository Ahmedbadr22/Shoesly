package com.ab.dev.shoesly.presentation.fragments.login.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ab.dev.shoesly.R
import com.ab.dev.shoesly.databinding.FragmentLoginBinding
import com.ab.dev.shoesly.domain.models.state.LoginUiState
import com.ab.dev.shoesly.presentation.fragments.login.viewModel.LoginViewModel
import com.ab.dev.shoesly.presentation.mainActivity.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    private val loginViewModel : LoginViewModel by viewModel()

    private val signInIntentLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.let { data ->
                loginViewModel.loginWithGoogleAccount(data)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            viewModel = loginViewModel
            fragment = this@LoginFragment

            cbRememberMe.setOnCheckedChangeListener { _, isChecked ->
                loginViewModel.setOnRememberMeChanged(isChecked)
            }
        }

        lifecycleScope.launch {
            loginViewModel.uiState.collect { uiState ->
                showLoadingBar(uiState.isLoading)
                manageErrors(uiState)
                checkUserLoggingState(uiState)
            }
        }
    }

    private fun manageErrors(uiState: LoginUiState) {
        binding.apply {
            tfEmail.error = uiState.emailErrorMessage
            tfPassword.error = uiState.passwordErrorMessage
            tvMainErrorMessage.text = uiState.mainUserMessage
        }
    }

    private fun checkUserLoggingState(uiState: LoginUiState) {
        if(uiState.isUserLoggedIn) {
            loginViewModel.clearErrors()
            navigateToMain()
        }
    }

    fun loginWithGoogleAccount() {
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(requireActivity(), googleSignInOptions)
        val signInIntent = googleSignInClient.signInIntent
        signInIntentLauncher.launch(signInIntent)
    }

    private fun showLoadingBar(show: Boolean) {
        binding.apply {
            if (show) {
                cpiLoading.visibility = View.VISIBLE
                btnLogin.visibility = View.GONE
            } else {
                cpiLoading.visibility = View.GONE
                btnLogin.visibility = View.VISIBLE
            }
        }
    }

    fun navigateToSignUpFragment() {
        val navDirection = LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
        findNavController().navigate(navDirection)
    }

    private fun navigateToMain() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }



}