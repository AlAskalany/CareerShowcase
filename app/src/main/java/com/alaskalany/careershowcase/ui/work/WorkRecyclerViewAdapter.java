package com.alaskalany.careershowcase.ui.work;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.data.work.Work;
import com.alaskalany.careershowcase.ui.work.WorkListFragment.OnWorkListFragmentInteractionListener;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Work} and makes a call to the
 * specified {@link WorkListFragment.OnWorkListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class WorkRecyclerViewAdapter
        extends RecyclerView.Adapter<WorkViewHolder> {

    private final SparseArray<Work> mValues;
    private final OnWorkListFragmentInteractionListener mListener;

    @SuppressWarnings("WeakerAccess")
    public WorkRecyclerViewAdapter(SparseArray<Work> items,
                                   WorkListFragment.OnWorkListFragmentInteractionListener listener) {

        mValues = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public WorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_work, parent, false);
        return new WorkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final WorkViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        //        holder.mIdView.setText(String.valueOf(mValues.get(position).getId()));
        holder.mContentView.setText(mValues.get(position + 1).getDescription());
        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                mListener.onWorkListFragmentInteraction(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }
}
