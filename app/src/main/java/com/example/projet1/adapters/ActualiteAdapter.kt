package com.example.projet1.adapters

import android.app.Activity
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.support.constraint.ConstraintLayout
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
import com.example.projet1.NavigationActivity
import android.widget.Toast
import com.example.projet1.MainActivity
import android.support.constraint.ConstraintSet.WRAP_CONTENT


//RecyclerView.Adapter<ActualiteAdapter.ViewHolder>
class ActualiteAdapter(var Actualites : ArrayList<Actualite>) : RecyclerView.Adapter<ActualiteAdapter.ViewHolder>() {

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
        if (Data.FavoriteActualiteList.contains(Actualites[p1])) {
            p0.save.setBackgroundResource(R.drawable.saved_icon)
        } else {
            p0.save.setBackgroundResource(R.drawable.save_icon)
        }
        p0.save.setOnClickListener {
            if (Data.FavoriteActualiteList.contains(Actualites[p1])) {
                p0.save.setBackgroundResource(R.drawable.save_icon)
                Data.FavoriteActualiteList.remove(Actualites[p1])
            } else {
                p0.save.setBackgroundResource(com.example.projet1.R.drawable.saved_icon)
                Data.FavoriteActualiteList.add(Actualites[p1])
            }
        }
        p0.share.setOnClickListener {

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, Actualites[p1].title)
            intent.putExtra(Intent.EXTRA_TEXT, Actualites[p1].content)
            //startActivity(Intent.createChooser(intent,"Share Article"))


        }

        p0.itemView.setOnClickListener(View.OnClickListener {
            val params = p0.content.layoutParams as ConstraintLayout.LayoutParams
            params.height = WRAP_CONTENT

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
        val share = itemView.findViewById<Button>(R.id.item_share)
        val save = itemView.findViewById<Button>(R.id.item_save)
        val content = itemView.findViewById<TextView>(R.id.item_content)

    }



}