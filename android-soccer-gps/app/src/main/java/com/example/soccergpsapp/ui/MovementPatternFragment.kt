package com.example.soccergpsapp.ui

import android.graphics.PointF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.soccergpsapp.R

class MovementPatternFragment : Fragment() {

    private lateinit var heatmapViewFirstHalf: HeatmapView
    private lateinit var heatmapViewSecondHalf: HeatmapView
    private lateinit var movementPathViewFirstHalf: MovementPathView
    private lateinit var movementPathViewSecondHalf: MovementPathView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movement_pattern, container, false)

        heatmapViewFirstHalf = view.findViewById(R.id.heatmapViewFirstHalf)
        heatmapViewSecondHalf = view.findViewById(R.id.heatmapViewSecondHalf)
        movementPathViewFirstHalf = view.findViewById(R.id.movementPathViewFirstHalf)
        movementPathViewSecondHalf = view.findViewById(R.id.movementPathViewSecondHalf)

        // Sample heatmap points (normalized coordinates 0..1) for all speeds
        val samplePointsFirstHalf = listOf(
            PointF(0.2f, 0.3f),
            PointF(0.25f, 0.35f),
            PointF(0.3f, 0.4f),
            PointF(0.4f, 0.5f),
            PointF(0.5f, 0.6f)
        )
        val samplePointsSecondHalf = listOf(
            PointF(0.6f, 0.7f),
            PointF(0.65f, 0.75f),
            PointF(0.7f, 0.8f),
            PointF(0.75f, 0.85f),
            PointF(0.8f, 0.9f)
        )

        heatmapViewFirstHalf.setHeatmapPoints(samplePointsFirstHalf)
        heatmapViewSecondHalf.setHeatmapPoints(samplePointsSecondHalf)

        // Sample movement path points (normalized coordinates 0..1)
        val movementPointsFirstHalf = listOf(
            PointF(0.1f, 0.2f),
            PointF(0.15f, 0.25f),
            PointF(0.2f, 0.3f),
            PointF(0.25f, 0.35f),
            PointF(0.3f, 0.4f)
        )
        val movementPointsSecondHalf = listOf(
            PointF(0.5f, 0.6f),
            PointF(0.55f, 0.65f),
            PointF(0.6f, 0.7f),
            PointF(0.65f, 0.75f),
            PointF(0.7f, 0.8f)
        )

        movementPathViewFirstHalf.setMovementPoints(movementPointsFirstHalf)
        movementPathViewSecondHalf.setMovementPoints(movementPointsSecondHalf)

        return view
    }
}
