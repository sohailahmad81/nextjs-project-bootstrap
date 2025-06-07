package com.example.soccergpsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.soccergpsapp.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.soccergpsapp.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.soccergpsapp.R
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.example.soccergpsapp.ui.SpeedGaugeView

class SpeedFragment : Fragment() {

    private lateinit var lineChartSpeed: LineChart
    private lateinit var pieChartSpeedZones: PieChart
    private lateinit var speedGauge1: SpeedGaugeView
    private lateinit var speedGauge2: SpeedGaugeView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_speed, container, false)

        lineChartSpeed = view.findViewById(R.id.lineChartSpeed)
        pieChartSpeedZones = view.findViewById(R.id.pieChartSpeedZones)
        speedGauge1 = view.findViewById(R.id.speedGauge1)
        speedGauge2 = view.findViewById(R.id.speedGauge2)

        setupSpeedLineChart()
        setupSpeedZonesDonutChart()
        setupSpeedGauges()

        return view
    }

    private fun setupSpeedLineChart() {
        val entries = listOf(
            Entry(0f, 1f),
            Entry(1f, 2f),
            Entry(2f, 3f),
            Entry(3f, 2f),
            Entry(4f, 4f),
            Entry(5f, 5f),
            Entry(6f, 6f)
        )
        val dataSet = LineDataSet(entries, "Speed Over Time")
        dataSet.color = Color.BLUE
        dataSet.valueTextColor = Color.BLACK
        val lineData = LineData(dataSet)
        lineChartSpeed.data = lineData
        lineChartSpeed.invalidate()
    }

    private fun setupSpeedZonesDonutChart() {
        val entries = listOf(
            PieEntry(40f, "Zone 1"),
            PieEntry(30f, "Zone 2"),
            PieEntry(20f, "Zone 3"),
            PieEntry(10f, "Zone 4")
        )
        val dataSet = PieDataSet(entries, "Time Spent in Speed Zones")
        dataSet.colors = listOf(
            Color.RED,
            Color.GREEN,
            Color.YELLOW,
            Color.MAGENTA
        )
        dataSet.valueTextColor = Color.BLACK
        val pieData = PieData(dataSet)
        pieChartSpeedZones.data = pieData
        pieChartSpeedZones.isDrawHoleEnabled = true
        pieChartSpeedZones.holeRadius = 50f
        pieChartSpeedZones.invalidate()
    }

    private fun setupSpeedGauges() {
        // Set example speed percentages for two gauges
        speedGauge1.setSpeedPercent(0.75f) // 75%
        speedGauge2.setSpeedPercent(0.50f) // 50%
    }

    private lateinit var barChartSpeedZonesFirstHalf: com.github.mikephil.charting.charts.BarChart
    private lateinit var barChartSpeedZonesSecondHalf: com.github.mikephil.charting.charts.BarChart

    private fun setupSpeedZonesBarCharts() {
        val speedZones = listOf("0-2 km/h", "2-6 km/h", "6-14 km/h", ">14 km/h")

        val firstHalfDistances = listOf(100f, 200f, 300f, 150f)
        val secondHalfDistances = listOf(120f, 180f, 250f, 200f)

        val entriesFirstHalf = firstHalfDistances.mapIndexed { index, value ->
            com.github.mikephil.charting.data.BarEntry(index.toFloat(), value)
        }
        val entriesSecondHalf = secondHalfDistances.mapIndexed { index, value ->
            com.github.mikephil.charting.data.BarEntry(index.toFloat(), value)
        }

        val dataSetFirstHalf = com.github.mikephil.charting.data.BarDataSet(entriesFirstHalf, "First Half")
        val dataSetSecondHalf = com.github.mikephil.charting.data.BarDataSet(entriesSecondHalf, "Second Half")

        dataSetFirstHalf.color = android.graphics.Color.BLUE
        dataSetSecondHalf.color = android.graphics.Color.RED

        val barDataFirstHalf = com.github.mikephil.charting.data.BarData(dataSetFirstHalf)
        val barDataSecondHalf = com.github.mikephil.charting.data.BarData(dataSetSecondHalf)

        barChartSpeedZonesFirstHalf.data = barDataFirstHalf
        barChartSpeedZonesSecondHalf.data = barDataSecondHalf

        barChartSpeedZonesFirstHalf.xAxis.valueFormatter = com.github.mikephil.charting.formatter.IndexAxisValueFormatter(speedZones)
        barChartSpeedZonesSecondHalf.xAxis.valueFormatter = com.github.mikephil.charting.formatter.IndexAxisValueFormatter(speedZones)

        barChartSpeedZonesFirstHalf.invalidate()
        barChartSpeedZonesSecondHalf.invalidate()
    }

    private lateinit var funnelChartPlaceholder: android.view.View

    private fun setupFunnelChartPlaceholder() {
        // Placeholder for funnel chart - can be replaced with actual funnel chart implementation
        funnelChartPlaceholder.setBackgroundColor(android.graphics.Color.LTGRAY)
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        barChartSpeedZonesFirstHalf = view.findViewById(R.id.barChartSpeedZonesFirstHalf)
        barChartSpeedZonesSecondHalf = view.findViewById(R.id.barChartSpeedZonesSecondHalf)
        funnelChartPlaceholder = view.findViewById(R.id.funnelChartPlaceholder)
        setupSpeedZonesBarCharts()
        setupFunnelChartPlaceholder()
    }
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        barChartSpeedZonesFirstHalf = view.findViewById(R.id.barChartSpeedZonesFirstHalf)
        barChartSpeedZonesSecondHalf = view.findViewById(R.id.barChartSpeedZonesSecondHalf)
        setupSpeedZonesBarCharts()
    }
}
}
