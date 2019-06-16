package com.example.projet1.adapters

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.widget.AdapterView
import com.example.projet1.Actualite
import com.example.projet1.Thematique

class AccueilAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Actualite.newInstance("p1","p2")
            }
            else -> {
                return Thematique.newInstance("p1","p2")
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }


}