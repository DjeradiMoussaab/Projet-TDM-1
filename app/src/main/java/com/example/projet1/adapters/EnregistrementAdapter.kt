package com.example.projet1.adapters

import android.content.Intent
import android.graphics.Color
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.projet1.Data
import com.example.projet1.Models.Actualite
import com.example.projet1.R

class EnregistrementAdapter (val Actualites : ArrayList<Actualite>) : RecyclerView.Adapter<EnregistrementAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val vi = LayoutInflater.from(p0.context).inflate(R.layout.fragment_actualite_item, p0,false)
        return  ViewHolder((vi))
    }

    override fun getItemCount(): Int {
        return Actualites.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.image.setImageResource(Actualites[p1].image)
        p0.title.text = Actualites[p1].title
        p0.author.text = "Auteur : ${Actualites[p1].author}"
        p0.theme.text = "Thématique : ${Actualites[p1].theme.title}"
        p0.share.visibility = View.INVISIBLE
        p0.save.setBackgroundResource(R.drawable.delete_icon)
        p0.save.setOnClickListener {
            if (Data.FavoriteActualiteList.contains(Actualites[p1])) {
                Data.FavoriteActualiteList.remove(Actualites[p1])
                this.notifyDataSetChanged()
            }
        }
        p0.itemView.setOnClickListener(View.OnClickListener {
            val params = p0.content.layoutParams as ConstraintLayout.LayoutParams
            params.height = ConstraintSet.WRAP_CONTENT

            p0.content.requestLayout()

            if(p0.content.text.length == 0 ) {
                p0.content.text = Actualites[p1].content
            } else {
                p0.content.text = ""
            }
        })
    }

    inner class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.item_photo)
        val title = itemView.findViewById<TextView>(R.id.item_title)
        val author = itemView.findViewById<TextView>(R.id.item_author)
        val theme = itemView.findViewById<TextView>(R.id.item_theme)
        val save = itemView.findViewById<Button>(R.id.item_save)
        val share = itemView.findViewById<Button>(R.id.item_share)
        val content = itemView.findViewById<TextView>(R.id.item_content)


    }

}