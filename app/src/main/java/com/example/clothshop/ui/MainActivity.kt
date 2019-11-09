package com.example.clothshop.ui

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
import com.example.clothshop.ui.gallery.GalleryFragment
import com.example.clothshop.ui.home.HomeFragment
import com.example.clothshop.ui.home.HomeItemFragment
import com.example.clothshop.ui.send.SendFragment
import com.example.clothshop.ui.share.ShareFragment
import com.example.clothshop.ui.slideshow.SlideshowFragment
import com.example.clothshop.ui.tools.ToolsFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),HomeFragment.OnClothSelected,NavigationView.OnNavigationItemSelectedListener {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
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

        val fab: FloatingActionButton = this.findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_gallery,
                R.id.nav_slideshow,
                R.id.nav_tools,
                R.id.nav_share,
                R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)

        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
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
                setToolbar("GALLERY")
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contentmain, GalleryFragment.newInstance(), "GALLERY")
                    .commit()

            }
            R.id.nav_slideshow ->
            {
                setToolbar("SLIDESHOW")
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contentmain, SlideshowFragment.newInstance(), "SLIDESHOW")
                    .commit()

            }
            R.id.nav_tools ->
            {
                setToolbar("TOOLS")
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contentmain, ToolsFragment.newInstance(), "TOOLS")
                    .commit()

            }
            R.id.nav_share ->
            {
                setToolbar("SHARE")
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contentmain, ShareFragment.newInstance(), "SHARE")
                    .commit()

            }
            R.id.nav_send ->
            {
                setToolbar("SEND")
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.contentmain, SendFragment.newInstance(), "SEND")
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

    fun setToolbar(title : String)
    {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)

        val textView = toolbar.findViewById(R.id.toolbarTextView) as TextView
        textView.text = title

        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }


}
