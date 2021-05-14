package com.example.excercise4_monstarlab

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.excercise4_monstarlab.Fragment.CoinFragment
import com.example.excercise4_monstarlab.Fragment.HomeFragment
import com.example.excercise4_monstarlab.Fragment.MenuFragment
import com.example.excercise4_monstarlab.Fragment.NewsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        loadFragment(HomeFragment(), null)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.actionHome -> {
                    bottomNavigationView.itemIconTintList =
                            ContextCompat.getColorStateList(this, R.color.item_bottom_navigation_color)
                    bottomNavigationView.itemBackground =
                            ContextCompat.getDrawable(this, R.drawable.item_bottom_nav_background)
                    loadFragment(HomeFragment(), null)
                }
                R.id.actionCoin -> {
                    bottomNavigationView.itemIconTintList =
                            ContextCompat.getColorStateList(this, R.color.item_bottom_navigation_color)
                    bottomNavigationView.itemBackground =
                            ContextCompat.getDrawable(this, R.drawable.item_bottom_nav_background)
                    loadFragment(CoinFragment(), "coinFragment")
                }
                R.id.actionNews -> {
                    bottomNavigationView.itemIconTintList =
                            ContextCompat.getColorStateList(this, R.color.item_bottom_navigation_color)
                    bottomNavigationView.itemBackground =
                            ContextCompat.getDrawable(this, R.drawable.item_bottom_nav_background)
                    loadFragment(NewsFragment(), "newsFragment")
                }
                R.id.actionMenu -> {
                    bottomNavigationView.itemIconTintList =
                            ContextCompat.getColorStateList(this, R.color.item_bottom_navigation_color)
                    bottomNavigationView.itemBackground =
                            ContextCompat.getDrawable(this, R.drawable.item_bottom_nav_background)
                    loadFragment(MenuFragment(), "menuFragment")
                }
            }
            true
        }
        bottomNavigationView.selectedItemId = R.id.actionHome
    }

    private fun loadFragment(fragment: Fragment, tag: String?) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayoutHome, fragment)
        transaction.addToBackStack(tag)
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var position = supportFragmentManager.backStackEntryCount
        if (position == 1) {
            var builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setTitle("Thông báo")
            builder.setMessage("Ứng dụng đã bị thoát!!!")
            builder.setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, which ->
                moveTaskToBack(true)

            })
            var alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }
    }
}