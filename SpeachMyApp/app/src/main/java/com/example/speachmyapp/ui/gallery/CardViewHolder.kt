package com.example.speachmyapp.ui.gallery

import androidx.recyclerview.widget.RecyclerView
import com.example.speachmyapp.databinding.CardCellBinding

class CardViewHolder(
    private val cardCellBinding: CardCellBinding
    ) : RecyclerView.ViewHolder(cardCellBinding.root)
{
    fun bindCatFact(catFact: CatFact)
    {
        cardCellBinding.compDescription.text = catFact.description
    }
}