package com.alaskalany.careershowcase.ui;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.Contract;

public abstract class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder, V>
        extends RecyclerView.Adapter<T> {

    protected final SparseArray<V> mValues;

    public BaseRecyclerViewAdapter(SparseArray<V> items) {

        mValues = items;
    }

    @Contract(pure = true)
    protected static int positionToKey(int position) {

        return position + 1;
    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }
}
