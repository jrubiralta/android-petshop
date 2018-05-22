package com.example.jordi.android_petshop.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jordi.android_petshop.R
import com.example.jordi.android_petshop.model.GenreView
import kotlinx.android.synthetic.main.item_genre.view.*

class GenreAdapter(var items: List<GenreView> = listOf(),
                   val onItemClick: (GenreView) -> Unit)
    : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    fun addAll(genreListView: List<GenreView>) {
        this.items = genreListView
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_genre, parent, false)
        return GenreViewHolder(view,
                onItemClick = { onItemClick(items[it]) })
    }

    override fun onBindViewHolder(holder: GenreViewHolder?, position: Int) {
        holder?.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class GenreViewHolder(itemView: View,
                          private val onItemClick: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {


        init {
            itemView.setOnClickListener { onItemClick(adapterPosition) }
        }

        fun bind(genreView: GenreView) {
            itemView.idGenre.text = genreView.id.toString()
            itemView.name.text = genreView.name
        }

    }

}