package com.alaskalany.careershowcase.ui.skills;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.databinding.FragmentSkillBinding;
import com.alaskalany.careershowcase.model.Skill;
import com.alaskalany.careershowcase.ui.BaseRecyclerViewAdapter;
import com.alaskalany.careershowcase.ui.BaseViewHolder;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Skill}
 * TODO: Replace the implementation with code for your data type.
 */
public class SkillAdapter
        extends BaseRecyclerViewAdapter<SkillAdapter.ViewHolder, Skill, SkillOnClickCallback> {

    @SuppressWarnings("WeakerAccess")
    public SkillAdapter(SparseArray<Skill> items, SkillOnClickCallback callback) {

        super(items, callback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentSkillBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                               R.layout.fragment_skill,
                                                               parent,
                                                               false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.binding.setSkill(mValues.get(positionToKey(position)));
        holder.binding.setCallback(getCallback());
        holder.binding.executePendingBindings();
    }

    public static class ViewHolder
            extends BaseViewHolder<FragmentSkillBinding> {

        public ViewHolder(FragmentSkillBinding binding) {

            super(binding.getRoot(), binding);
        }
    }
}
