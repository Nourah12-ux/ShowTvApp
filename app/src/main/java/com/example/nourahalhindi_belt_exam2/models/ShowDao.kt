package com.example.nourahalhindi_belt_exam2.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShowDao {
    @Query("SELECT * FROM ShowTable")
    fun getAllShows(): LiveData<List<ShowTable>>

    @Insert
    fun addshow(show: ShowTable)

    @Delete
    fun deleteShow(show: ShowTable)


}