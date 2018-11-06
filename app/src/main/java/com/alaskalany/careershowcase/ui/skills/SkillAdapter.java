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
import com.alaskalany.careershowcase.databinding.FragmentSkillBinding;
import com.alaskalany.careershowcase.entity.SkillEntity;
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
    protected final SkillOnClickCallback skillOnClickCallback;

    /**
     *
     */
    protected List<SkillEntity> skillEntities;

    /**
     * @param skillOnClickCallback
     */
    @SuppressWarnings("WeakerAccess")
    public SkillAdapter(SkillOnClickCallback skillOnClickCallback) {

        this.skillOnClickCallback = skillOnClickCallback;
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
        binding.setSkillOnClickCallback(skillOnClickCallback);
        return new ViewHolder(binding);
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.binding.setSkill(skillEntities.get(position));

        holder.binding.setSkillOnClickCallback(skillOnClickCallback);
        View rootView = holder.binding.getRoot();
        GlideApp.with(rootView).load(skillEntities.get(position).getLogoUrl()).into(holder.binding.imageViewSkillLogo);
        holder.binding.executePendingBindings();
    }

    public void setSkillList(final List<SkillEntity> skillList) {

        if (skillEntities == null) {
            skillEntities = skillList;
            notifyItemRangeInserted(0, skillList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {

                @Override
                public int getOldListSize() {

                    return skillEntities.size();
                }

                @Override
                public int getNewListSize() {

                    return skillList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

                    return skillEntities.get(oldItemPosition).getId() == skillList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    SkillEntity newSkill = skillList.get(newItemPosition);
                    SkillEntity oldSkill = skillEntities.get(oldItemPosition);
                    return newSkill.getId() == oldSkill.getId() &&
                            Objects.equals(newSkill.getTitle(), oldSkill.getTitle()) &&
                            newSkill.getLevel() == oldSkill.getLevel();
                }
            });
            skillEntities = skillList;
            result.dispatchUpdatesTo(this);
        }
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {

        return skillEntities == null ? 0 : skillEntities.size();
    }

    /**
     *
     */
    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        /**
         *
         */
        public final FragmentSkillBinding binding;

        /**
         * @param binding
         */
        public ViewHolder(FragmentSkillBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
