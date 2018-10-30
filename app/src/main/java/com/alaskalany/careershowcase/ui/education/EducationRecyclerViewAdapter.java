package com.alaskalany.careershowcase.ui.education;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.data.education.Education;
import com.alaskalany.careershowcase.databinding.FragmentEducationBinding;
import com.alaskalany.careershowcase.ui.BaseRecyclerViewAdapter;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Education}
 * TODO: Replace the implementation with code for your data type.
 */
public class EducationRecyclerViewAdapter
        extends BaseRecyclerViewAdapter<EducationViewHolder, Education, EducationOnClickCallback> {

    @SuppressWarnings("WeakerAccess")
    public EducationRecyclerViewAdapter(SparseArray<Education> items, EducationOnClickCallback callback) {

        super(items, callback);
    }

    @NonNull
    @Override
    public EducationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentEducationBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                                   R.layout.fragment_education,
                                                                   parent,
                                                                   false);
        return new EducationViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final EducationViewHolder holder, int position) {

        holder.binding.setEducation(mValues.get(positionToKey(position)));
        holder.binding.setCallback(getCallback());
        holder.binding.executePendingBindings();
    }
}
