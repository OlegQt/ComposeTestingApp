package com.composetestingapp.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.composetestingapp.R
import com.composetestingapp.databinding.MainLayoutBinding
import com.composetestingapp.presentation.fragment.SettingsFragment
import com.composetestingapp.presentation.fragment.StartFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainLayoutBinding
    private val fragmentList: ArrayList<Fragment> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        customizeUiBehaviour()
    }

    private fun customizeUiBehaviour() {
        // Fill Fragment list
        fragmentList.add(StartFragment())
        fragmentList.add(SettingsFragment())

        // Create adapter for viewpager2
        val demoCollectionAdapter = DemoCollectionAdapter(fragmentActivity = this, fragmentList)

        // ViewPager2 customize
        binding.fragmentPager.adapter = demoCollectionAdapter
        binding.fragmentPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                when (position) {
                    0 -> binding.navBar.selectedItemId = R.id.page_home
                    1 -> binding.navBar.selectedItemId = R.id.page_settings
                }

            }
        })

        // BottomNavigation Bar customize
        binding.navBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_home -> openPage(pageNumber = 0)
                R.id.page_settings -> openPage(pageNumber = 1)
                else -> openPage(pageNumber = 1000)
            }
        }
    }

    private fun openPage(pageNumber: Int): Boolean {
        return if (pageNumber < fragmentList.size) {
            binding.fragmentPager.currentItem = pageNumber
            true
        } else false
    }


    internal class DemoCollectionAdapter(
        fragmentActivity: FragmentActivity,
        private val arrayFragment: ArrayList<Fragment>
    ) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = arrayFragment.size
        override fun createFragment(position: Int): Fragment = arrayFragment[position]
    }
}