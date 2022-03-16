package com.example.magiccards.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.magiccards.R
import com.example.magiccards.models.Card

class ItemCardListAdapter(private var itemList: List<Card>,
                          private val context: Context,
                          private val cardListener: CardListener) : RecyclerView.Adapter<ItemCardListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_list, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ItemCardListAdapter.ViewHolder, position: Int) {
        val item = itemList[position]

        holder.name.text = item.name
        holder.type.text = item.type
        holder.rarity.text = item.rarity

        Glide
            .with(context)
            .load(item.imageUrl)
            .fitCenter()
            .into(holder.image)

        holder.card.setOnClickListener {
            cardListener.sendCardID(item.id)
        }
    }

    override fun getItemCount(): Int = itemList.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.card_name)
        val type: TextView = view.findViewById(R.id.card_type)
        val rarity: TextView = view.findViewById(R.id.card_rarity)
        val image: ImageView = view.findViewById(R.id.card_image)
        val card: ConstraintLayout = view.findViewById(R.id.card)
    }
}