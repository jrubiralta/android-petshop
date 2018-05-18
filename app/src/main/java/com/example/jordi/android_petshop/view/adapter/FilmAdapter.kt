package com.example.jordi.android_petshop.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.domain.model.Film
import com.example.jordi.android_petshop.R
import com.example.jordi.android_petshop.extensions.load
import com.example.jordi.android_petshop.model.FilmView
import kotlinx.android.synthetic.main.item_film.view.*

class FilmAdapter(var items: List<FilmView> = listOf(),
                  val onItemClick: (FilmView) -> Unit)
    : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    fun addAll(filmsView: List<FilmView>) {
        this.items = filmsView
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_film, parent, false)
        return FilmViewHolder(view,
                onItemClick = { onItemClick(items[it]) })
    }

    override fun onBindViewHolder(holder: FilmViewHolder?, position: Int) {
        holder?.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class FilmViewHolder(itemView: View,
                         onItemClick: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { onItemClick(adapterPosition) }
        }

        fun bind(filmView: FilmView) {
            itemView.imageFilm.load(filmView.getImage())
            itemView.idFilm.text = filmView.id.toString()
            itemView.filmTitle.text = filmView.title
        }
    }
}