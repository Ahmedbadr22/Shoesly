package com.ab.dev.shoesly.presentation.fragments.signUp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ab.dev.shoesly.R
import com.ab.dev.shoesly.app.utils.exceptions.BadRequestException
import com.ab.dev.shoesly.app.utils.exceptions.NotValidDataException
import com.ab.dev.shoesly.data.model.response.error.RegistrationErrorBody
import com.ab.dev.shoesly.domain.models.error.RegistrationFormError
import com.ab.dev.shoesly.domain.models.form.RegistrationForm
import com.ab.dev.shoesly.domain.models.state.RegistrationUiState
import com.ab.dev.shoesly.domain.useCase.registration.RegisterUserEmailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val registerUserEmailUseCase: RegisterUserEmailUseCase,
) : ViewModel() {

    val registrationState: MutableStateFlow<RegistrationUiState> = MutableStateFlow(RegistrationUiState())
    val registrationForm = RegistrationForm()

    fun signUp() {
        registrationState.update { currentUiState -> currentUiState.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                registerUserEmailUseCase(registrationForm)
                registrationState.update { currentUiState ->
                    currentUiState.copy(
                        isLoading = false,
                        isSuccessOperation = true,
                        mainUserMessageRes = R.string.account_created_successfully
                    )
                }
            } catch (exception: NotValidDataException) {
                val registrationFormError = exception.data as RegistrationFormError
                registrationState.update { currentUiState ->
                    currentUiState.copy(
                        isLoading = false,
                        isSuccessOperation = false,
                        firstNameErrorMessage = registrationFormError.firstNameError,
                        lastNameErrorMessage = registrationFormError.lastNameError,
                        emailErrorMessage = registrationFormError.emailError,
                        passwordErrorMessage = registrationFormError.passwordError,
                    )
                }
            } catch (exception: BadRequestException) {
                val registrationFormError = exception.error as RegistrationErrorBody
                registrationState.update { currentUiState ->
                    currentUiState.copy(
                        isLoading = false,
                        isSuccessOperation = false,
                        firstNameErrorMessage = registrationFormError.firstNameError,
                        lastNameErrorMessage = registrationFormError.lastNameError,
                        emailErrorMessage = registrationFormError.emailError,
                        passwordErrorMessage = registrationFormError.passwordError,
                    )
                }
            }
        }
    }
}