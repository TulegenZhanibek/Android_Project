package com.example.lab3.usecase

import com.android.volley.NetworkResponse
import com.example.lab3.database.Users

interface UsersUseCase {
    suspend fun addUser(users: Users): Long

    suspend fun addUserList(users: List<Users>): List<Long>
    suspend fun getUserLoginVerify(mobNum: String, password: String): Users
    suspend fun getUserData(id: Long): Users

    suspend fun getDataFromNetworkUseCase(): NetworkResponse
}