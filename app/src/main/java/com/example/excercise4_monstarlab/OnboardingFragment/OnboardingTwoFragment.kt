package com.example.excercise4_monstarlab.OnboardingFragment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.excercise4_monstarlab.HomeActivity
import com.example.excercise4_monstarlab.LoginActivity
import com.example.excercise4_monstarlab.MainActivity
import com.example.excercise4_monstarlab.R
import kotlinx.android.synthetic.main.fragment_onboarding_one.view.*
import kotlinx.android.synthetic.main.fragment_onboarding_two.view.*

class OnboardingTwoFragment : Fragment(){
    lateinit var mMainActivity: MainActivity
    val TAG: String = "TAG2"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_onboarding_two,container,false)
        mMainActivity = activity as MainActivity
        view.imageViewBack.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        view.btnGoToFragmentThree.setOnClickListener {
            var transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout, OnboardingThreeFragment())
            transaction?.addToBackStack(OnboardingThreeFragment().TAG)
            transaction?.commit()
        }
        view.textViewSkipTwo.setOnClickListener {
            val editor: SharedPreferences.Editor = mMainActivity.sharedPreferences.edit()
            editor.putInt("install",1)
            editor.apply()
            val intent: Intent = Intent(mMainActivity, LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(context,""+mMainActivity.sharedPreferences.getInt("install",0), Toast.LENGTH_SHORT).show()
        }
        return view
    }
}