package com.alaskalany.careershowcase.ui.skills;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.database.entity.SkillEntity;
import com.alaskalany.careershowcase.databinding.FragmentSkillBinding;
import com.alaskalany.careershowcase.model.Skill;
import com.alaskalany.careershowcase.ui.BaseRecyclerViewAdapter;
import com.alaskalany.careershowcase.ui.BaseViewHolder;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SkillEntity}
 * TODO: Replace the implementation with code for your data type.
 */
public class SkillAdapter
        extends BaseRecyclerViewAdapter<SkillAdapter.ViewHolder, SkillEntity, SkillOnClickCallback> {

    /**
     * @param items
     * @param callback
     */
    @SuppressWarnings("WeakerAccess")
    public SkillAdapter(List<SkillEntity> items, SkillOnClickCallback callback) {

        super(items, callback);
    }

    /**
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentSkillBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                               R.layout.fragment_skill,
                                                               parent,
                                                               false);
        return new ViewHolder(binding);
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.mBinding.setSkill(mValues.get(positionToKey(position)));
        holder.mBinding.setCallback(getCallback());
        holder.mBinding.executePendingBindings();
    }

    /**
     *
     */
    public static class ViewHolder
            extends BaseViewHolder<FragmentSkillBinding> {

        /**
         * @param binding
         */
        public ViewHolder(FragmentSkillBinding binding) {

            super(binding.getRoot(), binding);
        }
    }
}
