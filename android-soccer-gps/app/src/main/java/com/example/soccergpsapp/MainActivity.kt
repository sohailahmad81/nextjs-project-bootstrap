package com.example.soccergpsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.example.soccergpsapp.model.GpsData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import com.google.android.material.tabs.TabLayout
import androidx.viewpager2.widget.ViewPager2
import com.example.soccergpsapp.ui.MainPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        val adapter = MainPagerAdapter(this)
        viewPager.adapter = adapter

        tabLayout.addTab(tabLayout.newTab().setText("Distance"))
        tabLayout.addTab(tabLayout.newTab().setText("Speed"))
        tabLayout.addTab(tabLayout.newTab().setText("Movement Pattern"))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
}
