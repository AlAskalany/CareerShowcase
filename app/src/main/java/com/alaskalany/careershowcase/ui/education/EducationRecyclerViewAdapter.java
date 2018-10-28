package com.alaskalany.careershowcase.ui.education;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.data.education.Education;
import com.alaskalany.careershowcase.ui.education.EducationListFragment.OnEducationListFragmentInteractionListener;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Education} and makes a call to the
 * specified {@link OnEducationListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class EducationRecyclerViewAdapter
        extends RecyclerView.Adapter<EducationViewHolder> {

    private final SparseArray<Education> mValues;
    private final OnEducationListFragmentInteractionListener mListener;

    @SuppressWarnings("WeakerAccess")
    public EducationRecyclerViewAdapter(SparseArray<Education> items,
                                        OnEducationListFragmentInteractionListener listener) {

        mValues = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public EducationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_education, parent, false);
        return new EducationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final EducationViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        //        holder.mIdView.setText(String.valueOf(mValues.get(position).getId()));
        holder.mContentView.setText(mValues.get(position + 1).getTitle());
        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                mListener.onEducationListFragmentInteraction(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }
}
