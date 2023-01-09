package com.example.nourahalhindi_belt_exam2.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShowTable(
    @PrimaryKey(autoGenerate = true)
    val pk: Int,
    val name: String,
    val language: String,
    val picture: String,
    val summary: String
    )