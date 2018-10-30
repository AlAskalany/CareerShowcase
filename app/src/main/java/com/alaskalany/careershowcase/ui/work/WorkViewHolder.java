package com.alaskalany.careershowcase.ui.work;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.databinding.FragmentWorkBinding;

public class WorkViewHolder
        extends RecyclerView.ViewHolder {

    final FragmentWorkBinding binding;

    WorkViewHolder(FragmentWorkBinding binding) {

        super(binding.getRoot());
        this.binding = binding;
    }

    @NonNull
    @Override
    public String toString() {

        return super.toString() + " '" + binding.textViewWorkTitle.getText() + "'";
    }
}
