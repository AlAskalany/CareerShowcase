package com.alaskalany.careershowcase.ui.skills;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.GlideApp;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.entity.SkillEntity;
import com.alaskalany.careershowcase.databinding.FragmentSkillBinding;
import org.jetbrains.annotations.Contract;

import java.util.List;
import java.util.Objects;

/**
 * {@link RecyclerView.Adapter} that can display a {@link SkillEntity}
 * TODO: Replace the implementation with code for your data type.
 */
public class SkillAdapter
        extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {

    /**
     *
     */
    protected final SkillOnClickCallback mCallback;

    /**
     *
     */
    protected List<SkillEntity> mValues;

    /**
     * @param callback
     */
    @SuppressWarnings("WeakerAccess")
    public SkillAdapter(SkillOnClickCallback callback) {

        this.mCallback = callback;
    }

    /**
     * @param position
     *
     * @return
     */
    @Contract(pure = true)
    protected static int positionToKey(int position) {

        return position + 1;
    }

    /**
     * @param parent
     * @param viewType
     *
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentSkillBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                               R.layout.fragment_skill,
                                                               parent,
                                                               false);
        binding.setCallback(mCallback);
        return new ViewHolder(binding);
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.mBinding.setSkill(mValues.get(position));
        holder.mBinding.setCallback(getCallback());
        View rootView = holder.mBinding.getRoot();
        GlideApp.with(rootView).load(mValues.get(position).getLogoUrl()).into(holder.mBinding.imageViewSkillLogo);
        holder.mBinding.executePendingBindings();
    }

    public void setSkillList(final List<SkillEntity> skillList) {

        if (mValues == null) {
            mValues = skillList;
            notifyItemRangeInserted(0, skillList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {

                @Override
                public int getOldListSize() {

                    return mValues.size();
                }

                @Override
                public int getNewListSize() {

                    return skillList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

                    return mValues.get(oldItemPosition).getId() == skillList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    SkillEntity newSkill = skillList.get(newItemPosition);
                    SkillEntity oldSkill = mValues.get(oldItemPosition);
                    return newSkill.getId() == oldSkill.getId() &&
                           Objects.equals(newSkill.getTitle(), oldSkill.getTitle()) &&
                           newSkill.getLevel() == oldSkill.getLevel();
                }
            });
            mValues = skillList;
            result.dispatchUpdatesTo(this);
        }
    }

    /**
     * @return
     */
    public SkillOnClickCallback getCallback() {

        return mCallback;
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {

        return mValues == null ? 0 : mValues.size();
    }

    /**
     *
     */
    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        /**
         *
         */
        public final FragmentSkillBinding mBinding;

        /**
         * @param binding
         */
        public ViewHolder(FragmentSkillBinding binding) {

            super(binding.getRoot());
            this.mBinding = binding;
        }
    }
}
