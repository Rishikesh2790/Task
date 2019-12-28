package com.example.task;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerDecoration extends RecyclerView.ItemDecoration {
    int sidepadding;
    int toppadding;

    public RecyclerDecoration(int sidepadding, int toppadding) {

        this.sidepadding = sidepadding;
        this.toppadding = toppadding;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.bottom=toppadding;
        outRect.top=toppadding;

        outRect.left=sidepadding;
        outRect.right=sidepadding;


    }
}
