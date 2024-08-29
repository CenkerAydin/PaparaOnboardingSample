package com.cenkeraydin.paparaonboardingsample

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.cenkeraydin.paparaonboardingsample.adapter.ViewPagerAdapter
import com.cenkeraydin.paparaonboardingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var dostContainer : LinearLayout
    private val dots = arrayOfNulls<ImageView>(5)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager
        dostContainer = binding.dotsContainer
        viewPager.adapter = ViewPagerAdapter(this)
        setupDots()
        setCurrentDot(0)

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentDot(position)
            }
        })
    }

    private fun setupDots(){
        for (i in dots.indices){
            dots[i] = ImageView(this).apply {
                setImageResource(R.drawable.dot_inactive)
                val params =LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(8,0,8,0)
                }
                layoutParams = params
            }
            dostContainer.addView(dots[i])
        }
    }

    private fun setCurrentDot(index: Int){
        for (i in dots.indices){
            dots[i]?.setImageResource(if (i == index) R.drawable.dot_active else R.drawable.dot_inactive)
        }
    }
}
