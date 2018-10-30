package com.alaskalany.careershowcase.ui.skills;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.databinding.FragmentSkillBinding;

public class SkillViewHolder
        extends RecyclerView.ViewHolder {

    final FragmentSkillBinding binding;

    SkillViewHolder(FragmentSkillBinding binding) {

        super(binding.getRoot());
        this.binding = binding;
    }

    @NonNull
    @Override
    public String toString() {

        return super.toString() + " '" + binding.textViewSkillTitle.getText() + "'";
    }
}
