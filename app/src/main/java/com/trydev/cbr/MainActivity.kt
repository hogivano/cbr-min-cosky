package com.trydev.cbr

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.trydev.cbr.ui.fragment.HistoryFragment
import com.trydev.cbr.ui.fragment.HomeFragment
import com.trydev.cbr.ui.fragment.IndicationFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{

    private lateinit var navBottom : BottomNavigationView
    private lateinit var btnFind : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.navBottom = nav_bottom
        navBottom.inflateMenu(R.menu.bottom_nav_menu)
        navBottom.itemTextColor = ColorStateList.valueOf(resources.getColor(R.color.black50))
        navBottom.setOnNavigationItemSelectedListener(this)

        supportFragmentManager.beginTransaction().replace(content.id, HomeFragment(), "fragment").commit()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId){
            R.id.nav_home -> {
                supportFragmentManager.beginTransaction().replace(content.id, HomeFragment(), "fragment").commit()
                return true
            }

            R.id.nav_indication -> {
                supportFragmentManager.beginTransaction().replace(content.id, IndicationFragment(), "fragment").commit()
                return true
            }

            R.id.nav_history -> {
                supportFragmentManager.beginTransaction().replace(content.id, HistoryFragment(), "fragment").commit()
                return true
            }
        }

        return false
    }
}
