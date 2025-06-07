package com.example.soccergpsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.soccergpsapp.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class DistanceFragment : Fragment() {

    private lateinit var barChartFirstHalf: BarChart
    private lateinit var barChartSecondHalf: BarChart
    private lateinit var lineChartDistanceOverTime: LineChart

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_distance, container, false)

        barChartFirstHalf = view.findViewById(R.id.barChartFirstHalf)
        barChartSecondHalf = view.findViewById(R.id.barChartSecondHalf)
        lineChartDistanceOverTime = view.findViewById(R.id.lineChartDistanceOverTime)

        setupFirstHalfBarChart()
        setupSecondHalfBarChart()
        setupDistanceOverTimeLineChart()

        return view
    }

    private fun setupFirstHalfBarChart() {
        val entries = listOf(
            BarEntry(0f, 3f),
            BarEntry(1f, 10f),
            BarEntry(2f, 12f),
            BarEntry(3f, 7f),
            BarEntry(4f, 8f),
            BarEntry(5f, 6f),
            BarEntry(6f, 3f)
        )
        val dataSet = BarDataSet(entries, "Distance Covered Every 5 Minutes")
        val barData = BarData(dataSet)
        barChartFirstHalf.data = barData
        barChartFirstHalf.invalidate()
    }

    private fun setupSecondHalfBarChart() {
        val entries = listOf(
            BarEntry(0f, 5f),
            BarEntry(1f, 15f),
            BarEntry(2f, 10f),
            BarEntry(3f, 12f),
            BarEntry(4f, 9f),
            BarEntry(5f, 7f),
            BarEntry(6f, 5f)
        )
        val dataSet = BarDataSet(entries, "Second Half Distance")
        val barData = BarData(dataSet)
        barChartSecondHalf.data = barData
        barChartSecondHalf.invalidate()
    }

    private fun setupDistanceOverTimeLineChart() {
        val entries = listOf(
            Entry(0f, 1f),
            Entry(1f, 2f),
            Entry(2f, 3f),
            Entry(3f, 2f),
            Entry(4f, 4f),
            Entry(5f, 5f),
            Entry(6f, 6f)
        )
        val dataSet = LineDataSet(entries, "Distance Over Time")
        val lineData = LineData(dataSet)
        lineChartDistanceOverTime.data = lineData
        lineChartDistanceOverTime.invalidate()
    }
}
