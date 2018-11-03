package com.alaskalany.careershowcase.ui.work;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.entity.WorkEntity;
import com.alaskalany.careershowcase.databinding.FragmentWorkBinding;

import java.util.List;
import java.util.Objects;

/**
 * {@link RecyclerView.Adapter} that can display a {@link WorkEntity}
 * TODO: Replace the implementation with code for your data type.
 */
public class WorkAdapter
        extends RecyclerView.Adapter<WorkAdapter.ViewHolder> {

    /**
     *
     */
    protected final WorkOnClickCallback mCallback;

    /**
     *
     */
    protected List<WorkEntity> mValues;

    /**
     * @param callback
     */
    @SuppressWarnings("WeakerAccess")
    public WorkAdapter(WorkOnClickCallback callback) {

        this.mCallback = callback;
    }

    /**
     * @param parent
     * @param viewType
     *
     * @return
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        FragmentWorkBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                                                              R.layout.fragment_work,
                                                              parent,
                                                              false);
        binding.setCallback(mCallback);
        return new ViewHolder(binding);
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.mBinding.setWork(mValues.get(position));
        holder.mBinding.setCallback(mCallback);
        holder.mBinding.executePendingBindings();
    }

    public void setWorkList(final List<WorkEntity> workList) {

        if (mValues == null) {
            mValues = workList;
            notifyItemRangeInserted(0, workList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {

                @Override
                public int getOldListSize() {

                    return mValues.size();
                }

                @Override
                public int getNewListSize() {

                    return workList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

                    return mValues.get(oldItemPosition)
                                  .getId() == workList.get(newItemPosition)
                                                      .getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    WorkEntity newWork = workList.get(newItemPosition);
                    WorkEntity oldProduct = mValues.get(oldItemPosition);
                    return newWork.getId() == oldProduct.getId() &&
                           Objects.equals(newWork.getDescription(), oldProduct.getDescription()) &&
                           Objects.equals(newWork.getTitle(), oldProduct.getTitle()) &&
                           newWork.getDescription() == oldProduct.getDescription();
                }
            });
            mValues = workList;
            result.dispatchUpdatesTo(this);
        }
    }

    /**
     * @return
     */
    public WorkOnClickCallback getCallback() {

        return mCallback;
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {

        return mValues == null ? 0 : mValues.size();
    }

    /**
     *
     */
    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        /**
         *
         */
        public final FragmentWorkBinding mBinding;

        /**
         * @param binding
         */
        ViewHolder(FragmentWorkBinding binding) {

            super(binding.getRoot());
            this.mBinding = binding;
        }
    }
}
