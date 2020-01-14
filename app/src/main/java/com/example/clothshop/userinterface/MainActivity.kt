package com.example.clothshop.userinterface

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.clothshop.R
import com.example.clothshop.models.ClothModel
import com.example.clothshop.userinterface.complaintlist.ComplaintListFragment
import com.example.clothshop.userinterface.home.HomeFragment
import com.example.clothshop.userinterface.home.HomeItemFragment
import com.example.clothshop.userinterface.complaint.ComplaintFragment
import com.example.clothshop.userinterface.home.onClothSelected
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), onClothSelected,NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
        {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.contentmain, HomeFragment.newInstance(), "CLOTHLIST")
                .commit()
        }

        setToolbar("CLOTHS")

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_gallery,
                R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean
    {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean
    {
        when(p0.itemId)
        {
            R.id.nav_home ->
            {
                setToolbar("CLOTHS")
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contentmain, HomeFragment.newInstance(), "CLOTHLIST")
                    .commit()
            }
            R.id.nav_gallery ->
            {
                setToolbar("COMPLAINTS")
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contentmain, ComplaintListFragment.newInstance(), "COMPLAINTS")
                    .commit()

            }
            R.id.nav_send ->
            {
                setToolbar("SEND")
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contentmain, ComplaintFragment.newInstance(), "SEND")
                    .commit()

            }

        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onClothSelected(clothmodel: ClothModel)
    {
        val detailsFragment = HomeItemFragment.newInstace(clothmodel)

        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.contentmain,detailsFragment,"Cloth")
            .addToBackStack(null)
            .commit()
    }

    private fun setToolbar(title : String)
    {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)

        val textView = toolbar.findViewById(R.id.toolbarTextView) as TextView
        textView.text = title

        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

}
