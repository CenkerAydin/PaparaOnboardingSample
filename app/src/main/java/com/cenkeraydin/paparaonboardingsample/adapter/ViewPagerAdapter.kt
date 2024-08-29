package com.cenkeraydin.paparaonboardingsample.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cenkeraydin.paparaonboardingsample.fragments.OnboardingFragment1
import com.cenkeraydin.paparaonboardingsample.fragments.OnboardingFragment2
import com.cenkeraydin.paparaonboardingsample.fragments.OnboardingFragment3
import com.cenkeraydin.paparaonboardingsample.fragments.OnboardingFragment4
import com.cenkeraydin.paparaonboardingsample.fragments.OnboardingFragment5


class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 5 // Number of fragments

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OnboardingFragment1()
            1 -> OnboardingFragment2()
            2 -> OnboardingFragment3()
            3 -> OnboardingFragment4()
            4 -> OnboardingFragment5()
            else -> OnboardingFragment1()
        }
    }
}