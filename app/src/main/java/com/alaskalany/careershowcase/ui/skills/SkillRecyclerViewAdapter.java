package com.alaskalany.careershowcase.ui.skills;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.data.skills.Skill;
import com.alaskalany.careershowcase.databinding.FragmentSkillBinding;
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

        FragmentSkillBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                               R.layout.fragment_skill,
                                                               parent,
                                                               false);
        return new SkillViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final SkillViewHolder holder, int position) {

        holder.binding.setSkill(mValues.get(position));
        holder.binding.executePendingBindings();;
    }

    @Override
    public int getItemCount() {

        return mValues.size();
    }
}
