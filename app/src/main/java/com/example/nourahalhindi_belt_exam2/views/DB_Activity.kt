package com.example.nourahalhindi_belt_exam2.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nourahalhindi_belt_exam2.ViewModel.ShowTVViewModel
import com.example.nourahalhindi_belt_exam2.databinding.ActivityDbBinding
import com.example.nourahalhindi_belt_exam2.models.ShowTable

class DB_Activity : AppCompatActivity(),RV_DB_Activity.Clicklistener {
    lateinit var binding: ActivityDbBinding
    lateinit var RvAdapter:RV_DB_Activity
    lateinit var viewModel: ShowTVViewModel
    lateinit var showList:List<ShowTable>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showList= listOf()

        RvAdapter= RV_DB_Activity(showList,this)
        binding.rvdatabasa.adapter=RvAdapter
        binding.rvdatabasa.layoutManager=LinearLayoutManager(this)


        //view model
        viewModel = ViewModelProvider(this).get(ShowTVViewModel::class.java)
        viewModel.getAllShows().observe(this) { it -> RvAdapter.updateshowlist(it)}



    }

    override fun showSummary(show: ShowTable) {
        Toast.makeText(this,show.summary,Toast.LENGTH_LONG).show()

    }

    override fun deleteShow(show: ShowTable) {
        viewModel.deleteShow(show)
        Toast.makeText(this,"the show was deleted ",Toast.LENGTH_LONG).show()

    }

}