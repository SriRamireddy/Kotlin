package com.ramireddy.stayathomestaysafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {

    lateinit var tab : TabLayout
    lateinit var viewPager : ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        tab = findViewById(R.id.tab)
        viewPager = findViewById(R.id.view_pager)
        val padapter = PagerAdapter(supportFragmentManager,3)
        viewPager.adapter=padapter
        tab.setupWithViewPager(viewPager)

    }

    class PagerAdapter(fm : FragmentManager, i: Int) : FragmentPagerAdapter(fm,i){

        val c = i
        override fun getItem(position: Int): Fragment {

            when(position){
                0 -> return SymptomsFragment()
                1 -> return SymptomsFragment()
                2 -> return SymptomsFragment()
            }
            return null!!

        }

        override fun getCount(): Int {

            return c
        }

        override fun getPageTitle(position: Int): CharSequence? {

            when(position)
            {
                0 -> return "Symtomps"
                1 -> return "Precausions"
                2 -> return "Info"
            }

            return super.getPageTitle(position)
        }


    }


}
