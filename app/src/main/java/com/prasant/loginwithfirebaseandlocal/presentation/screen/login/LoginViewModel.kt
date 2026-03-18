package com.prasant.loginwithfirebaseandlocal.presentation.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prasant.loginwithfirebaseandlocal.domain.usecase.LoginUseCase
import com.prasant.loginwithfirebaseandlocal.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            loginUseCase(email, password).collectLatest { result ->
                when (result) {

                    is Result.Loading -> {
                        _state.update {
                            it.copy(
                                isLoading = true,
                                isSuccess = false,
                                error = null
                            )
                        }
                    }

                    is Result.Success<*> -> {
                        _state.update {
                            it.copy(
                                isLoading = false,
                                isSuccess = true,
                                error = null
                            )
                        }
                    }

                    is Result.Error -> {
                        _state.update {
                            it.copy(
                                isLoading = false,
                                isSuccess = false,
                                error = result.message ?: "Something went wrong"
                            )
                        }
                    }
                }
            }
        }
    }
}