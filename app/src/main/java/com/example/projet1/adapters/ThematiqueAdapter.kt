package com.example.projet1.adapters

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import com.example.projet1.Models.Thematique
import com.example.projet1.R
import android.widget.CompoundButton
import com.example.projet1.Data
import kotlinx.android.synthetic.main.fragment_actualite.*


class ThematiqueAdapter (val Thematiques : ArrayList<Thematique>) : RecyclerView.Adapter<ThematiqueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val vi = LayoutInflater.from(p0.context).inflate(R.layout.fragment_thematique_item, p0,false)
        return  ViewHolder((vi))
    }

    override fun getItemCount(): Int {
        return Thematiques.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.title.text = Thematiques[p1].title
        p0.switch.isChecked = Thematiques[p1].allowed
        p0.switch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            Data.ThematiqueList[p1].allowed = isChecked
        })
    }

    inner class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.thematique_title)
        val switch = itemView.findViewById<Switch>(R.id.thematique_switch)

    }

}