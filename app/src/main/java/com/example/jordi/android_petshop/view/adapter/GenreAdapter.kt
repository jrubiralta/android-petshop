package com.example.jordi.android_petshop.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jordi.android_petshop.R
import com.example.jordi.android_petshop.model.GenreView
import kotlinx.android.synthetic.main.item_genre.view.*

class GenreAdapter(var items: List<GenreView> = listOf())
    : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_genre, parent, false)
        return GenreViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenreViewHolder?, position: Int) {
        holder?.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(genreView: GenreView) {
            itemView.idGenre.text = genreView.id.toString()
            itemView.name.text = genreView.name
        }
    }

}