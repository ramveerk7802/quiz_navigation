package com.example.navigation

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.navigation.databinding.ActivityMainBinding
import com.example.navigation.navigationUtill.NavigationUtils
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener

class MainActivity : AppCompatActivity(),OnNavigationItemSelectedListener {

    private lateinit var binding : ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var drawer :DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }







        navHostFragment = supportFragmentManager.findFragmentById(R.id.navControllerFragment) as NavHostFragment

        drawer = binding.drawerLayout

       val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(binding.navView,navController)
        NavigationUI.setupActionBarWithNavController(this,navController,drawer)


//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            when (destination.id) {
//                R.id.homeFragment2  -> supportActionBar?.title = "Home"
//                R.id.quizFragment -> supportActionBar?.title = "Quiz"
//                R.id.quizWinFragment -> supportActionBar?.title = "You Win!"
//                R.id.quizOverFragment -> supportActionBar?.title = "Game Over"
//                // Add more cases as needed for other fragments
//            }
//        }

        navController.addOnDestinationChangedListener{_,destination,_ ->
            NavigationUtils.setToolbarTitle(this,destination.id)

        }





        binding.navView.setNavigationItemSelectedListener(this)



    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = navHostFragment.navController
//        return navController.navigateUp()
//    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = navHostFragment.navController
        return NavigationUI.navigateUp(navController,drawer)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 ->{
                drawer.closeDrawer(GravityCompat.START)
                Toast.makeText(this,"Clicked on item1",Toast.LENGTH_SHORT).show()
            }
            R.id.item2 ->{
                drawer.closeDrawer(GravityCompat.START)
                Toast.makeText(this,"Clicked on item2",Toast.LENGTH_SHORT).show()
            }
            R.id.item3 ->{
                drawer.closeDrawer(GravityCompat.START)
//                where link the fragment then work it
//                navHostFragment.navController.navigate(R.id.action_homeFragment2_to_quizFragment)
                Toast.makeText(this,"Clicked on item3",Toast.LENGTH_SHORT).show()
            }
        }
        return NavigationUI.onNavDestinationSelected(item,navHostFragment.navController)
    }
}