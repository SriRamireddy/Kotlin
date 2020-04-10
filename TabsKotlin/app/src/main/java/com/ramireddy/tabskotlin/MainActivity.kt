package com.ramireddy.tabskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var vp1 : ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vp1 = findViewById(R.id.vp)
        val tb : TabLayout = findViewById(R.id.tabid)
        val vpa : ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager,2)
        vp1.adapter = vpa
        tb. setupWithViewPager(vp1)
    }

    class ViewPagerAdapter(fm : FragmentManager, v : Int) : FragmentPagerAdapter(fm,v) {

        override fun getItem(position: Int): Fragment {

            when(position){
                0 -> return Tab1()
                1 -> return Tab2()
            }
            return null!!
        }

        override fun getCount(): Int {

            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {

            when(position){
                0 -> return "Tab1"
                1 -> return "Tab2"
            }
            return super.getPageTitle(position)
        }

    }

}
