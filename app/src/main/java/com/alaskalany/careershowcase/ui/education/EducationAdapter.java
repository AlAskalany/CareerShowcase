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

        holder.binding.setEducation(mValues.get(positionToKey(position)));
        holder.binding.setCallback(getCallback());
        holder.binding.executePendingBindings();
    }

    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        final FragmentEducationBinding binding;

        ViewHolder(FragmentEducationBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }

        @NonNull
        @Override
        public String toString() {

            return super.toString() + " '" + binding.textViewEducationTitle.getText() + "'";
        }
    }
}
