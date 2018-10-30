package com.alaskalany.careershowcase.ui.work;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.data.work.Work;
import com.alaskalany.careershowcase.databinding.FragmentWorkBinding;
import com.alaskalany.careershowcase.ui.BaseRecyclerViewAdapter;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Work}
 * TODO: Replace the implementation with code for your data type.
 */
public class WorkRecyclerViewAdapter
        extends BaseRecyclerViewAdapter<WorkViewHolder, Work, WorkOnClickCallback> {

    @SuppressWarnings("WeakerAccess")
    public WorkRecyclerViewAdapter(SparseArray<Work> items, WorkOnClickCallback callback) {

        super(items, callback);
    }

    @NonNull
    @Override
    public WorkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentWorkBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                              R.layout.fragment_work,
                                                              parent,
                                                              false);
        return new WorkViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final WorkViewHolder holder, int position) {

        holder.binding.setWork(mValues.get(positionToKey(position)));
        holder.binding.setCallback(getCallback());
        holder.binding.executePendingBindings();
    }
}
