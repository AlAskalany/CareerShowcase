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
import com.alaskalany.careershowcase.entity.EducationEntity;
import com.alaskalany.careershowcase.databinding.FragmentEducationBinding;

import java.util.List;
import java.util.Objects;

/**
 * {@link RecyclerView.Adapter} that can display a {@link EducationEntity}
 * TODO: Replace the implementation with code for your data type.
 */
public class EducationAdapter
        extends RecyclerView.Adapter<EducationAdapter.ViewHolder> {

    /**
     *
     */
    protected final EducationOnClickCallback mCallback;

    /**
     *
     */
    protected List<EducationEntity> mValues;

    /**
     * @param callback
     */
    @SuppressWarnings("WeakerAccess")
    public EducationAdapter(EducationOnClickCallback callback) {

        this.mCallback = callback;
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

        FragmentEducationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                                   R.layout.fragment_education,
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

        holder.mBinding.setEducation(mValues.get(position));
        holder.mBinding.setCallback(getCallback());
        View rootView = holder.mBinding.getRoot();
        GlideApp.with(rootView).load(mValues.get(position).getLogoUrl()).into(holder.mBinding.imageViewEducationLogo);
        holder.mBinding.executePendingBindings();
    }

    public void setEducationList(final List<EducationEntity> educationList) {

        if (mValues == null) {
            mValues = educationList;
            notifyItemRangeInserted(0, educationList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {

                @Override
                public int getOldListSize() {

                    return mValues.size();
                }

                @Override
                public int getNewListSize() {

                    return educationList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

                    return mValues.get(oldItemPosition).getId() == educationList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    EducationEntity newSkill = educationList.get(newItemPosition);
                    EducationEntity oldSkill = mValues.get(oldItemPosition);
                    boolean isIdEqual = newSkill.getId() == oldSkill.getId();
                    boolean isDescriptionEqual = Objects.equals(newSkill.getDescription(), oldSkill.getDescription());
                    boolean isTitleEqual = Objects.equals(newSkill.getTitle(), oldSkill.getTitle());
                    boolean isInstitutionEqual = Objects.equals(newSkill.getInstitution(), oldSkill.getInstitution());
                    boolean isLocationEqual = Objects.equals(newSkill.getLocation(), oldSkill.getLocation());
                    boolean isDurationEqual = Objects.equals(newSkill.getDegree(), oldSkill.getDuration());
                    return isIdEqual && isDescriptionEqual && isTitleEqual && isInstitutionEqual && isLocationEqual &&
                           isDurationEqual;
                }
            });
            mValues = educationList;
            result.dispatchUpdatesTo(this);
        }
    }

    /**
     * @return
     */
    public EducationOnClickCallback getCallback() {

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
        public final FragmentEducationBinding mBinding;

        /**
         * @param binding
         */
        public ViewHolder(FragmentEducationBinding binding) {

            super(binding.getRoot());
            this.mBinding = binding;
        }
    }
}
