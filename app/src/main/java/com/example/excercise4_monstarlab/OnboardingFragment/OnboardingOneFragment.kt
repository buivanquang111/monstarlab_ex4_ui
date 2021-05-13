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

class OnboardingOneFragment : Fragment() {
    lateinit var mMainActivity: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_onboarding_one,container,false)
        mMainActivity = activity as MainActivity
        view.btnGoToFragmentTwo.setOnClickListener {
            var transaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout, OnboardingTwoFragment())
            transaction?.addToBackStack(OnboardingTwoFragment().TAG)
            transaction?.commit()
        }
        view.textViewSkipOne.setOnClickListener {
            val editor: SharedPreferences.Editor = mMainActivity.sharedPreferences.edit()
            editor.putInt("install",1)
            editor.apply()

            val intent: Intent = Intent(mMainActivity,LoginActivity::class.java)
            startActivity(intent)
            Toast.makeText(context,""+mMainActivity.sharedPreferences.getInt("install",0),Toast.LENGTH_SHORT).show()
        }

        return view
    }

}