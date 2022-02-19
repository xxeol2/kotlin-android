package com.example.firstandroid.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import java.lang.Math.ceil
import java.lang.Math.floor

class GridSpaceDecoration(private val margin: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        when(parent.getChildAdapterPosition(view) % 2) {
            0 -> {
                outRect.right = ceil(margin.toDouble()/2).toInt()
            }
            1 -> {
                outRect.left = floor(margin.toDouble()/2).toInt()
            }
        }
        outRect.bottom = margin
    }
}
