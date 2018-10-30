package com.alaskalany.careershowcase.ui;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.Contract;

public abstract class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder, V, M extends ItemOnClickCallback>
        extends RecyclerView.Adapter<T> {

    protected final SparseArray<V> mValues;
    protected final M callback;

    public BaseRecyclerViewAdapter(SparseArray<V> items, M callback) {

        this.mValues = items;
        this.callback = callback;
    }

    @Contract(pure = true)
    protected static int positionToKey(int position) {

        return position + 1;
    }

    public M getCallback() {

        return callback;
    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }
}
