package com.example.nourahalhindi_belt_exam2.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nourahalhindi_belt_exam2.databinding.DbRowBinding
import com.example.nourahalhindi_belt_exam2.models.ShowTable
import com.example.nourahalhindi_belt_exam2.models.data.ShowTVItem

class RV_DB_Activity(var showsList:List<ShowTable>, val clicklistener:Clicklistener):RecyclerView.Adapter<RV_DB_Activity.ViewHolder>() {
    class ViewHolder(var binding: DbRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DbRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //showTVItem is array list <showItem>
        val showTvItem=showsList[position]

        val showName=showTvItem.name

        holder.binding.apply {
    //name and language is textViews
        name.text=showTvItem.name
        language.text=showTvItem.language

            val PhotoLink=showTvItem.picture //the the image from showItem class
            Glide.with(consLay).load(PhotoLink).into(showImage) //upload the image to the image view in database



        name.setOnClickListener{
            clicklistener.showSummary(showTvItem)
        }

        btnDelete.setOnClickListener {
            clicklistener.deleteShow(showTvItem)
        }

        }
    }

    interface Clicklistener
    {
        fun showSummary(show:ShowTable)
        fun deleteShow(show: ShowTable)
    }

    override fun getItemCount(): Int
    {
        return showsList.size
    }

    fun updateshowlist(newList:List<ShowTable>)
        {
            showsList=newList
            notifyDataSetChanged()
        }

}