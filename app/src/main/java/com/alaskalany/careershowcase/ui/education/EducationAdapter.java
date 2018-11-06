package com.alaskalany.careershowcase.ui.education;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.GlideApp;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.databinding.FragmentEducationBinding;
import com.alaskalany.careershowcase.entity.EducationEntity;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link EducationEntity}
 * TODO: Replace the implementation with code for your data type.
 */
public class EducationAdapter
        extends RecyclerView.Adapter<EducationAdapter.ViewHolder> {

    /**
     *
     */
    protected final EducationOnClickCallback educationOnClickCallback;

    /**
     *
     */
    protected List<EducationEntity> educationEntities;

    /**
     * @param callback
     */
    @SuppressWarnings("WeakerAccess")
    public EducationAdapter(EducationOnClickCallback callback) {

        this.educationOnClickCallback = callback;
    }

    /**
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentEducationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.fragment_education,
                parent,
                false);
        binding.setEducationOnClickCallback(educationOnClickCallback);
        return new ViewHolder(binding);
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.binding.setEducation(educationEntities.get(position));

        holder.binding.setEducationOnClickCallback(educationOnClickCallback);
        View rootView = holder.binding.getRoot();
        GlideApp.with(rootView).load(educationEntities.get(position).getLogoUrl()).into(holder.binding.imageViewEducationLogo);
        holder.binding.executePendingBindings();
    }

    public void setEducationList(final List<EducationEntity> educationList) {

        if (educationEntities == null) {
            educationEntities = educationList;
            notifyItemRangeInserted(0, educationList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {

                @Override
                public int getOldListSize() {

                    return educationEntities.size();
                }

                @Override
                public int getNewListSize() {

                    return educationList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

                    return educationEntities.get(oldItemPosition).getId() == educationList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    EducationEntity newEducation = educationList.get(newItemPosition);
                    EducationEntity oldEducation = educationEntities.get(oldItemPosition);
                    return newEducation.getId() == oldEducation.getId() &&
                            newEducation.getDescription() == oldEducation.getDescription() &&
                            newEducation.getTitle() == oldEducation.getTitle();
                }
            });
            educationEntities = educationList;
            result.dispatchUpdatesTo(this);
        }
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {

        return educationEntities == null ? 0 : educationEntities.size();
    }

    /**
     *
     */
    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        /**
         *
         */
        public final FragmentEducationBinding binding;

        /**
         * @param binding
         */
        public ViewHolder(FragmentEducationBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
