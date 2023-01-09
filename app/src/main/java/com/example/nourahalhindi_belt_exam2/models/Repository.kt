package com.example.nourahalhindi_belt_exam2.models

import androidx.lifecycle.LiveData

class Repository(val showDao: ShowDao ) {
   val getshow:LiveData<List<ShowTable>> = showDao.getAllShows()



    suspend fun addshow(show: ShowTable){
        showDao.addshow(show)
    }


   suspend fun deleteShow(show: ShowTable){
       showDao.deleteShow(show)
   }

}