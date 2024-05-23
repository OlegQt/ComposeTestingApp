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
        val demoCollectionAdapter = DemoCollectionAdapter(this, fragmentList)

        // ViewPager2 customize
        binding.fragmentPager.adapter = demoCollectionAdapter
        binding.fragmentPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                when (position) {
                    0 -> binding.navBar.selectedItemId = R.id.page_a
                    1 -> binding.navBar.selectedItemId = R.id.page_b
                }

            }
        })

        // BottomNavigation Bar customize
        binding.navBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.page_a -> openPage(0)
                R.id.page_b -> openPage(1)
                else -> openPage(1000)
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
        fragment: FragmentActivity,
        private val arrayFragment: ArrayList<Fragment>
    ) :
        FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = arrayFragment.size
        override fun createFragment(position: Int): Fragment = arrayFragment[position]
    }
}