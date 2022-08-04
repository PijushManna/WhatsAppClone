package com.example.signup.firebase.modules

import com.example.signup.base.interfaces.BaseUserRepository
import com.example.signup.base.interfaces.BaseVerificationService
import com.example.signup.base.services.UserRegistrationService
import com.example.signup.firebase.repo.FirebaseUserRepository
import com.example.signup.firebase.service.FirebaseDefaultAuthService
import com.example.signup.firebase.service.FirebaseEmailVerification
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class FirebaseRegistrationServicesModule {
    @Provides
    fun getFirebaseUserRepository(): BaseUserRepository = FirebaseUserRepository()

    @Provides
    fun getFirebaseEmailVerificationRepository(): BaseVerificationService = FirebaseEmailVerification()

    @Provides
    fun getDefaultAuthUi():FirebaseDefaultAuthService = FirebaseDefaultAuthService()

    @Provides
    @Inject
    fun getUserRegistration(userRepository: BaseUserRepository, verificationService: BaseVerificationService) : UserRegistrationService = UserRegistrationService(userRepository, verificationService)
}