package com.prasant.loginwithfirebaseandlocal.domain.usecase

import com.prasant.loginwithfirebaseandlocal.domain.repository.AuthRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val authRepository: AuthRepository) {
    operator fun invoke() = authRepository.logoutUser()
}