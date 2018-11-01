package com.alaskalany.careershowcase.ui.education;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.database.entity.EducationEntity;
import com.alaskalany.careershowcase.databinding.FragmentEducationBinding;
import org.jetbrains.annotations.Contract;

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

        holder.mBinding.setEducation(mValues.get(positionToKey(position)));
        holder.mBinding.setCallback(getCallback());
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

                    return mValues.get(oldItemPosition)
                                  .getEducationId() == educationList.get(newItemPosition)
                                                                    .getEducationId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    EducationEntity newSkill = educationList.get(newItemPosition);
                    EducationEntity oldSkill = mValues.get(oldItemPosition);
                    return newSkill.getEducationId() == oldSkill.getEducationId() &&
                           Objects.equals(newSkill.getEducationDescription(), oldSkill.getEducationDescription()) &&
                           Objects.equals(newSkill.getEducationTitle(), oldSkill.getEducationTitle()) &&
                           newSkill.getEducationDescription() == oldSkill.getEducationDescription();
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
