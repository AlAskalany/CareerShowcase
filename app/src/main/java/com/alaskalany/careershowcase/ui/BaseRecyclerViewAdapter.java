package com.alaskalany.careershowcase.ui;

import android.util.SparseArray;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.Contract;

/**
 * @param <T>
 * @param <V>
 * @param <M>
 */
public abstract class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder, V, M extends ItemOnClickCallback>
        extends RecyclerView.Adapter<T> {

    /**
     *
     */
    protected final SparseArray<V> mValues;
    /**
     *
     */
    protected final M mCallback;

    /**
     * @param items
     * @param callback
     */
    public BaseRecyclerViewAdapter(SparseArray<V> items, M callback) {

        this.mValues = items;
        this.mCallback = callback;
    }

    /**
     * @param position
     * @return
     */
    @Contract(pure = true)
    protected static int positionToKey(int position) {

        return position + 1;
    }

    /**
     * @return
     */
    public M getCallback() {

        return mCallback;
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {

        return mValues.size();
    }
}
