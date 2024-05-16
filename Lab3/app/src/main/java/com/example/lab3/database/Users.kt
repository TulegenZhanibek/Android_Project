package com.example.lab3.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "USER_TABLE")
data class Users(
    @PrimaryKey (autoGenerate = true)
    val id: Long=0,
    val name: String?="",
    val surname: String?="",
    val email: String?="",
    val password: String?=""
)
