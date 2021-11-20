package com.example.roomdatabasepractice_mvvm

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val Name: String,
    val PhoneNumber: String,
    val CreatedDate: Date,
    val isActive: Int
)
