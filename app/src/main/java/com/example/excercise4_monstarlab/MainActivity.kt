package com.example.excercise4_monstarlab

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.excercise4_monstarlab.OnboardingFragment.OnboardingOneFragment

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (null ==savedInstanceState) {
           sharedPreferences = getSharedPreferences("SHARED_INSTALL", Context.MODE_PRIVATE)
           if (sharedPreferences.getInt("install", 0) == 1) {
               Toast.makeText(this, "install", Toast.LENGTH_SHORT).show()
               val intent: Intent = Intent(this, LoginActivity::class.java)
               startActivity(intent)
           } else {
               loadFragment(OnboardingOneFragment())
               Toast.makeText(this, "no no", Toast.LENGTH_SHORT).show()
           }
        }
    }
    fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}