package com.example.lab3.usecase

import UserRepository
import com.android.volley.NetworkResponse
import com.example.lab3.database.Users

class UsersUseCaseImpl (private var userRepository: UserRepository): UsersUseCase {
    override suspend fun addUser(users: Users): Long {
        val id= userRepository.addUser(users)
        return id
    }

    override suspend fun addUserList(users: List<Users>): List<Long> {
        val id= userRepository.addUserList(users)
        return id
    }

    override suspend fun getUserLoginVerify(mobNum:String, password:String): Users {
        return userRepository.verifyLoginUser(mobNum, password)
    }

    override suspend fun getUserData(id: Long): Users {
        return userRepository.getUserDataDetails(id)
    }

    override  suspend fun getDataFromNetworkUseCase(): NetworkResponse {
        return userRepository.getDataFromNetwork()
    }
}