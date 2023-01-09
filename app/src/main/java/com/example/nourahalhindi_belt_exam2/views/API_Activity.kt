package com.example.nourahalhindi_belt_exam2.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.nourahalhindi_belt_exam2.ViewModel.ShowTVViewModel
import com.example.nourahalhindi_belt_exam2.databinding.ActivityApiBinding
import com.example.nourahalhindi_belt_exam2.models.*
import com.example.nourahalhindi_belt_exam2.models.data.ShowTV
import com.example.nourahalhindi_belt_exam2.models.data.ShowTVItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class API_Activity : AppCompatActivity(), Rv_API_Adapter.Clicklistener {
    lateinit var bindig:ActivityApiBinding
    //var apiKey="HepHgD_KBHlnBiYnEiWUnV_t5sWzjdpV"
    lateinit var viewModel: ShowTVViewModel
    var input =""
    val showList= arrayListOf<ShowTVItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig=ActivityApiBinding.inflate(layoutInflater)
        setContentView(bindig.root)

        val adapter= Rv_API_Adapter(showList,this)
        bindig.rvapi.adapter=adapter


        viewModel = ViewModelProvider(this).get(ShowTVViewModel::class.java)


     bindig.apply {
         btSearch.setOnClickListener {
             input = bindig.edInput.text.toString()
             println("input:"+input)


             val apiClint = APIClinet().getClint()
             if (apiClint != null) {
                 val apiInterface = apiClint.create(APIInterface::class.java)
                 apiInterface.getshows(input).enqueue(object : Callback<ShowTV> {
                     override fun onResponse(call: Call<ShowTV>, response: Response<ShowTV>) {
                         val body = response.body()
                         // println(response.body().toString()+"MESSAGEEEE")
                         if (body != null) {
                             val shows = body
                             showList.clear()
                             for (showTvItem in shows) {
//                                 val showItem = showTVItem("".toDouble(), show.show)
                                 showList.add(showTvItem)
                              Log.d("retrofit", "onResponse ${showTvItem.show.name}")
                             }
                             adapter.updateshowlist(showList)
                             edInput.text.clear()
                         }
                     }

                     override fun onFailure(call: Call<ShowTV>, t: Throwable) {
                         println("failure 222222222222222222222222222")
                         Log.d("retrofit", "onFailure:${t.message}")

                     }
                 })
             }

         }
     }
    }

    override fun saveShow(show: ShowTVItem) {
        val defaultImage = "https://i.ibb.co/c3HnKCT/images.jpg"
        val defaultSummary = "No summary available"

        if (show.show.image!=null) {
            if (show.show.summary != null) {
                viewModel.addshow(ShowTable(
                    show.show.id,
                    show.show.name,
                    show.show.language,
                    show.show.image.medium,
                    show.show.summary
                ))

            } else {
                viewModel.addshow(ShowTable(
                    show.show.id,
                    show.show.name,
                    show.show.language,
                    show.show.image.medium,
                    defaultSummary
                ))
            }
        } else {
            if (show.show.summary != null) {
                viewModel.addshow(ShowTable(
                    show.show.id,
                    show.show.name,
                    show.show.language,
                    defaultImage,
                    show.show.summary
                ))
            } else {
                viewModel.addshow(ShowTable(
                    show.show.id,
                    show.show.name,
                    show.show.language,
                    defaultImage,
                    defaultSummary
                ))
            }
        }

        Toast.makeText(this, "the show added to database", Toast.LENGTH_SHORT).show()

    }


}