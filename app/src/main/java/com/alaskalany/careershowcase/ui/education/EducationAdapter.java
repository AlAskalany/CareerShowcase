package com.alaskalany.careershowcase.ui.education;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.databinding.FragmentEducationBinding;
import com.alaskalany.careershowcase.model.Education;
import com.alaskalany.careershowcase.ui.BaseRecyclerViewAdapter;
import com.alaskalany.careershowcase.ui.BaseViewHolder;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Education}
 * TODO: Replace the implementation with code for your data type.
 */
public class EducationAdapter
        extends BaseRecyclerViewAdapter<EducationAdapter.ViewHolder, Education, EducationOnClickCallback> {

    /**
     * @param items
     * @param callback
     */
    @SuppressWarnings("WeakerAccess")
    public EducationAdapter(SparseArray<Education> items, EducationOnClickCallback callback) {

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

        FragmentEducationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                                   R.layout.fragment_education,
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

        holder.mBinding.setEducation(mValues.get(positionToKey(position)));
        holder.mBinding.setCallback(getCallback());
        holder.mBinding.executePendingBindings();
    }

    /**
     *
     */
    public static class ViewHolder
            extends BaseViewHolder<FragmentEducationBinding> {

        /**
         * @param binding
         */
        public ViewHolder(FragmentEducationBinding binding) {

            super(binding.getRoot(), binding);
        }
    }
}
