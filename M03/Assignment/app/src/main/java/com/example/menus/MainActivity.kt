package com.example.menus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.drawer_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_layout)

        val toolbar = toolbar
        setSupportActionBar(toolbar)

        val drawerLayout = drawer_layout
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navView = nav_view
        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.controller -> startActivity(Intent(this, ControllerConfiguration::class.java))
                R.id.light_config -> startActivity(Intent(this, LightConfiguration::class.java))
                R.id.light_select -> startActivity(Intent(this, LightSelecting::class.java))
                R.id.dark_mode -> Toast.makeText(this, "dark mode activated", Toast.LENGTH_SHORT).show()

            }
            drawerLayout.closeDrawers()
            true
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.light_off -> Toast.makeText(this, "lights are off", Toast.LENGTH_SHORT).show()
            R.id.add_light -> Toast.makeText(this, "added new light", Toast.LENGTH_SHORT).show()
            R.id.toggle_count -> Toast.makeText(this, "toggled", Toast.LENGTH_SHORT).show()
            R.id.sort -> Toast.makeText(this, "sorted", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
