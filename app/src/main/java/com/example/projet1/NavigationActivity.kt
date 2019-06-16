package com.example.projet1

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.activity_navigation.container

class NavigationActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val fragment : Fragment

        when (item.itemId) {
            R.id.navigation_home -> {
                fragment = fragment_accueil.newInstance("p1","p2")
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                fragment = Profile.newInstance("p1","p2")
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_enregistrement -> {
                fragment = Enregistrement.newInstance("p1","p2")
                loadFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val fragment = fragment_accueil.newInstance("p1","p2")
        loadFragment(fragment)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }


    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
            return true
        }
        return false
    }
}
