package com.example.nourahalhindi_belt_exam2.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nourahalhindi_belt_exam2.databinding.ApiRowBinding
import com.example.nourahalhindi_belt_exam2.models.data.ShowTVItem

class Rv_API_Adapter(var showsList:ArrayList<ShowTVItem>, val clicklistener: Clicklistener): RecyclerView.Adapter<Rv_API_Adapter.ViewHolder>() {
    class ViewHolder(var binding:ApiRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        return ViewHolder(ApiRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val showTvItem=showsList[position]

        holder.binding.apply{

                txtshowname.text = showTvItem.show.name
                txtshowname.setOnClickListener {
                    clicklistener.saveShow(showTvItem)
            }
        }
    }
    interface Clicklistener{
       fun saveShow(show:ShowTVItem)
    }

    override fun getItemCount(): Int
        {
            return showsList.size
        }

    fun updateshowlist(newList:ArrayList<ShowTVItem>)
        {
            showsList=newList
            notifyDataSetChanged()
        }
}