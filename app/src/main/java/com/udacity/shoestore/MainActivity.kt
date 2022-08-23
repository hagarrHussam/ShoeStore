package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
     private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        Timber.plant(Timber.DebugTree())
        binding.setLifecycleOwner(this)
        navController = this.findNavController(R.id.mynavhostfragment)
        setSupportActionBar(binding.toolbar)
        Timber.plant(Timber.DebugTree())
        NavigationUI.setupActionBarWithNavController(this, navController)
    }


    }

