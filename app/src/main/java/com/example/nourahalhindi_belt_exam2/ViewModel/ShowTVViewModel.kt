package com.example.nourahalhindi_belt_exam2.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.nourahalhindi_belt_exam2.models.Repository
import com.example.nourahalhindi_belt_exam2.models.ShowDao
import com.example.nourahalhindi_belt_exam2.models.ShowDatabase
import com.example.nourahalhindi_belt_exam2.models.ShowTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowTVViewModel(application: Application):AndroidViewModel(application) {

    private val repository:Repository
    private val shows: LiveData<List<ShowTable>>
    private val showDao:ShowDao

    init {
        showDao=ShowDatabase.getDatabase(application).showDao()
        repository=Repository(showDao)
        shows=repository.getshow
    }
    fun addshow(show:ShowTable) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.addshow(show)
        }
    }

    fun getAllShows(): LiveData<List<ShowTable>> {
        return shows
    }


    fun deleteShow(show: ShowTable) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.deleteShow(show)
        }
    }
}