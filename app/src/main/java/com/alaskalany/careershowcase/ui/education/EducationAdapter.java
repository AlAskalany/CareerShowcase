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

    @SuppressWarnings("WeakerAccess")
    public EducationAdapter(SparseArray<Education> items, EducationOnClickCallback callback) {

        super(items, callback);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentEducationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                                   R.layout.fragment_education,
                                                                   parent,
                                                                   false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.mBinding.setEducation(mValues.get(positionToKey(position)));
        holder.mBinding.setCallback(getCallback());
        holder.mBinding.executePendingBindings();
    }

    public static class ViewHolder
            extends BaseViewHolder<FragmentEducationBinding> {

        public ViewHolder(FragmentEducationBinding binding) {

            super(binding.getRoot(), binding);
        }
    }
}
