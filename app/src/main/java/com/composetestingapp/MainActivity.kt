package com.composetestingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.composetestingapp.databinding.MainLayoutBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = MainLayoutBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val fragmentList:ArrayList<Fragment> = arrayListOf()
        fragmentList.add(StartFragment())
        fragmentList.add(SettingsFragment())


        val demoCollectionAdapter = DemoCollectionAdapter(this,fragmentList)

        binding.fragmentPager.adapter = demoCollectionAdapter


    }


    class DemoCollectionAdapter(fragment: FragmentActivity, private val arrayFragment: ArrayList<Fragment>) :
        FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = arrayFragment.size
        override fun createFragment(position: Int): Fragment = arrayFragment[position]
    }
}