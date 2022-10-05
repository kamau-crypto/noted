package com.xfactor.noted

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xfactor.noted.database.AppDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        //Intialize the db
//        val db= Room.databaseBuilder(applicationContext,AppDatabase::class.java,"noted-database").build()
        val db= Room.databaseBuilder((applicationContext),AppDatabase::class.java,"noted-database").allowMainThreadQueries().build()
        // Setting ActionBar logo
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.ic_logo)
        supportActionBar?.setDisplayUseLogoEnabled(true)

        setContentView(R.layout.activity_main)

        // Setup navigation
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_delete, R.id.navigation_listcontainer, R.id.navigation_newlist))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val listDao= db.listDao();
        val lists:List<com.xfactor.noted.database.List> = listDao.getAll();

        Log.e("lists",lists.toString())
        listDao.insertAll(com.xfactor.noted.database.List(1,"Test List"))
        Log.e("lists",listDao.getAll().toString())

    }
}


