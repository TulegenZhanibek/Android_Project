package com.example.lab3.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab3.database.Users
import com.example.lab3.resource.Resource
import com.example.lab3.usecase.UsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch


@HiltViewModel
class SignUpViewModel @Inject constructor(private var usersUseCase: UsersUseCase) : ViewModel() {

    private val _insertUsersDataStatus = MutableLiveData<Resource<Long>>()
    val insertUsersDataStatus: LiveData<Resource<Long>> = _insertUsersDataStatus

    private val _insertUsersDataStatusList = MutableLiveData<Resource <List<Long>>>()
    val insertUsersDataStatusList: LiveData<Resource<Long>> = _insertUsersDataStatus

    suspend fun insertUserData(users: Users) {
        viewModelScope.launch {
            _insertUsersDataStatus.postValue(Resource.loading(null))
            try {
                val data = usersUseCase.addUser(users)
                _insertUsersDataStatus.postValue(Resource.success(data, 0))
            } catch (exception: Exception) {
                _insertUsersDataStatus.postValue(Resource.error(null, exception.message!!))
            }
        }
    }

    fun insertUserDataList(users: List<Users>) {
        viewModelScope.launch {
            _insertUsersDataStatusList.postValue(Resource.loading(null))
            try {
                val data = usersUseCase.addUserList(users)
                _insertUsersDataStatusList.postValue(Resource.success(data, 0))
            } catch (exception: Exception) {
                _insertUsersDataStatusList.postValue(Resource.error(null, exception.message!!))
            }
        }
    }


}