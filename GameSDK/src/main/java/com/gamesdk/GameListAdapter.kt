package com.gamesdk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_games.view.*

class GameListAdapter(
    private val data: ArrayList<Result>,
    private val callback: (Int,Result,View) -> Unit
) : RecyclerView.Adapter<GameListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_games, parent, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        loadImage(holder.itemView.imageViewGame,data[position].image)
        holder.itemView.textViewGameTitle.text = data[position].title

        holder.itemView.setOnClickListener{
            callback.invoke(position,data[position],holder.itemView.imageViewGame)
        }
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
