package com.example.firstandroid.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class LinearSpaceDecoration(private val margin: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = margin
    }
}