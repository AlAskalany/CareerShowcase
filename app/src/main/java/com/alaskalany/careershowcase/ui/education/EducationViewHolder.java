package com.alaskalany.careershowcase.ui.education;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.data.education.Education;
import com.alaskalany.careershowcase.databinding.FragmentEducationBinding;

public class EducationViewHolder
        extends RecyclerView.ViewHolder {

    final FragmentEducationBinding mBinding;
    Education mItem;

    EducationViewHolder(FragmentEducationBinding binding) {

        super(binding.getRoot());
        mBinding = binding;
    }

    @NonNull
    @Override
    public String toString() {

        return super.toString() + " '" + mBinding.textViewEducationTitle.getText() + "'";
    }
}
