package com.alaskalany.careershowcase.ui.education;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.databinding.FragmentEducationBinding;

public class EducationViewHolder
        extends RecyclerView.ViewHolder {

    final FragmentEducationBinding binding;

    EducationViewHolder(FragmentEducationBinding binding) {

        super(binding.getRoot());
        this.binding = binding;
    }

    @NonNull
    @Override
    public String toString() {

        return super.toString() + " '" + binding.textViewEducationTitle.getText() + "'";
    }
}
