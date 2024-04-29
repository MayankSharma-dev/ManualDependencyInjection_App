package com.ms.manualdependencyinjection.domain

interface AuthRepository {
    suspend fun login(email: String, password: String)
}