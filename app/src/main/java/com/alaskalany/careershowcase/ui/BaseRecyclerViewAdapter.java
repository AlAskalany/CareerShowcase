package com.alaskalany.careershowcase.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.model.Model;
import com.alaskalany.careershowcase.model.Work;
import org.jetbrains.annotations.Contract;

import java.util.List;

/**
 * @param <T>
 * @param <V>
 * @param <M>
 */
public abstract class BaseRecyclerViewAdapter<T extends RecyclerView.ViewHolder, V extends Model, M extends ItemOnClickCallback>
        extends RecyclerView.Adapter<T> {

    /**
     *
     */
    protected List<V> mValues;

    /**
     *
     */
    protected final M mCallback;

    /**
     * @param items
     * @param callback
     */
    public BaseRecyclerViewAdapter(List<V> items, M callback) {

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
