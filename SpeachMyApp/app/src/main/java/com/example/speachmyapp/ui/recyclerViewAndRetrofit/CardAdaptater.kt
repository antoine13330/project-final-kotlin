package com.example.speachmyapp.ui.recyclerViewAndRetrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.speachmyapp.databinding.CardCellBinding

class CardAdapter(val c: Context,
                  val catFactsList: List<CatFact>
    ) : RecyclerView.Adapter<CardViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from,parent,false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindCatFact(catFactsList[position])
    }

    override fun getItemCount(): Int = catFactsList.size

}