package com.alaskalany.careershowcase.ui.work;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.database.entity.WorkEntity;
import com.alaskalany.careershowcase.databinding.FragmentWorkBinding;
import com.alaskalany.careershowcase.model.Work;
import com.alaskalany.careershowcase.ui.BaseRecyclerViewAdapter;
import com.alaskalany.careershowcase.ui.BaseViewHolder;

import java.util.List;
import java.util.Objects;

/**
 * {@link RecyclerView.Adapter} that can display a {@link WorkEntity}
 * TODO: Replace the implementation with code for your data type.
 */
public class WorkAdapter
        extends BaseRecyclerViewAdapter<WorkAdapter.ViewHolder, WorkEntity, WorkOnClickCallback> {

    /**
     * @param items
     * @param callback
     */
    @SuppressWarnings("WeakerAccess")
    public WorkAdapter(List<WorkEntity> items, WorkOnClickCallback callback) {

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

    public void setProductList(final List<WorkEntity> workList) {

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

                    return ((Work) mValues.get(oldItemPosition)).getWorkId() ==
                           workList.get(newItemPosition).getWorkId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    Work newWork = workList.get(newItemPosition);
                    Work oldProduct = (Work) mValues.get(oldItemPosition);
                    return newWork.getWorkId() == oldProduct.getWorkId() &&
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
