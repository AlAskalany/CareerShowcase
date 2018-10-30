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
import com.alaskalany.careershowcase.ui.work.WorkListFragment.OnWorkListFragmentInteractionListener;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Work} and makes a call to the
 * specified {@link WorkListFragment.OnWorkListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class WorkRecyclerViewAdapter
        extends BaseRecyclerViewAdapter<WorkViewHolder, Work> {

    private final OnWorkListFragmentInteractionListener mListener;

    @SuppressWarnings("WeakerAccess")
    public WorkRecyclerViewAdapter(SparseArray<Work> items,
                                   WorkListFragment.OnWorkListFragmentInteractionListener listener) {

        super(items);
        mListener = listener;
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
        holder.binding.executePendingBindings();
    }
}
