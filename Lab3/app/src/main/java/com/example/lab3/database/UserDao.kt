package com.example.lab3.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(users: Users): Long
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserAll(users: List<Users>): List<Long>

    @Query("SELECT * FROM `USER_TABLE` WHERE email LIKE :email AND password LIKE :password")
    fun readLoginData(email: String, password: String):Users


    @Query("select * from `USER_TABLE` where id Like :id")
    fun getUserDataDetails(id:Long):Users

    @Query("DELETE FROM `USER_TABLE`")
    fun deleteAll()


}