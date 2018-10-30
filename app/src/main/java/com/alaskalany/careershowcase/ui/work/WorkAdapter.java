package com.alaskalany.careershowcase.ui.work;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.databinding.FragmentWorkBinding;
import com.alaskalany.careershowcase.model.Work;
import com.alaskalany.careershowcase.ui.BaseRecyclerViewAdapter;
import com.alaskalany.careershowcase.ui.BaseViewHolder;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Work}
 * TODO: Replace the implementation with code for your data type.
 */
public class WorkAdapter
        extends BaseRecyclerViewAdapter<WorkAdapter.ViewHolder, Work, WorkOnClickCallback> {

    /**
     * @param items
     * @param callback
     */
    @SuppressWarnings("WeakerAccess")
    public WorkAdapter(SparseArray<Work> items, WorkOnClickCallback callback) {

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

        FragmentWorkBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                              R.layout.fragment_work,
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

        holder.mBinding.setWork(mValues.get(positionToKey(position)));
        holder.mBinding.setCallback(getCallback());
        holder.mBinding.executePendingBindings();
    }

    /**
     *
     */
    public static class ViewHolder
            extends BaseViewHolder<FragmentWorkBinding> {

        /**
         * @param binding
         */
        ViewHolder(FragmentWorkBinding binding) {

            super(binding.getRoot(), binding);
        }
    }
}
