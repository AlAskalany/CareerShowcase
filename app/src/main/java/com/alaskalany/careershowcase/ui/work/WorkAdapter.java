package com.alaskalany.careershowcase.ui.work;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.GlideApp;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.databinding.FragmentWorkBinding;
import com.alaskalany.careershowcase.entity.WorkEntity;

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
    protected final WorkOnClickCallback workOnClickCallback;

    /**
     *
     */
    protected List<WorkEntity> workEntities;

    /**
     * @param workOnClickCallback
     */
    @SuppressWarnings("WeakerAccess")
    public WorkAdapter(WorkOnClickCallback workOnClickCallback) {

        this.workOnClickCallback = workOnClickCallback;
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
        binding.setWorkOnClickCallback(workOnClickCallback);
        return new ViewHolder(binding);
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.binding.setWork(workEntities.get(position));
        holder.binding.setWorkOnClickCallback(workOnClickCallback);
        View rootView = holder.binding.getRoot();
        GlideApp.with(rootView).load(workEntities.get(position).getLogoUrl()).into(holder.binding.imageViewWorkLogo);
        holder.binding.executePendingBindings();
    }

    public void setWorkList(final List<WorkEntity> workList) {

        if (workEntities == null) {
            workEntities = workList;
            notifyItemRangeInserted(0, workList.size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {

                @Override
                public int getOldListSize() {

                    return workEntities.size();
                }

                @Override
                public int getNewListSize() {

                    return workList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {

                    return workEntities.get(oldItemPosition).getId() == workList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    WorkEntity newWork = workList.get(newItemPosition);
                    WorkEntity oldProduct = workEntities.get(oldItemPosition);
                    return newWork.getId() == oldProduct.getId() &&
                            Objects.equals(newWork.getDescription(), oldProduct.getDescription()) &&
                            Objects.equals(newWork.getTitle(), oldProduct.getTitle()) &&
                            newWork.getDescription() == oldProduct.getDescription();
                }
            });
            workEntities = workList;
            result.dispatchUpdatesTo(this);
        }
    }

    /**
     * @return
     */
    public WorkOnClickCallback getWorkOnClickCallback() {

        return workOnClickCallback;
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {

        return workEntities == null ? 0 : workEntities.size();
    }

    /**
     *
     */
    public static class ViewHolder
            extends RecyclerView.ViewHolder {

        /**
         *
         */
        public final FragmentWorkBinding binding;

        /**
         * @param binding
         */
        ViewHolder(FragmentWorkBinding binding) {

            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
