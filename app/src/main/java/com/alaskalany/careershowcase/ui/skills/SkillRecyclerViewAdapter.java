package com.alaskalany.careershowcase.ui.skills;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.data.skills.Skill;
import com.alaskalany.careershowcase.ui.skills.SkillListFragment.OnSkillListFragmentInteractionListener;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Skill} and makes a call to the
 * specified {@link OnSkillListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class SkillRecyclerViewAdapter
        extends RecyclerView.Adapter<SkillViewHolder> {

    private final SparseArray<Skill> mValues;
    private final OnSkillListFragmentInteractionListener mListener;

    @SuppressWarnings("WeakerAccess")
    public SkillRecyclerViewAdapter(SparseArray<Skill> items, OnSkillListFragmentInteractionListener listener) {

        mValues = items;
        mListener = listener;
    }

    @NonNull
    @Override
    public SkillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_skill, parent, false);
        return new SkillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SkillViewHolder holder, int position) {

        holder.mItem = mValues.get(position);
        //        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position + 1).getDetails());
        holder.mView.setOnClickListener(v -> {
            if (null != mListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                mListener.onSkillListFragmentInteraction(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }
}
