package com.alaskalany.careershowcase.ui;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<B extends ViewDataBinding>
        extends RecyclerView.ViewHolder {

    public final B mBinding;

    public BaseViewHolder(View itemView, B binding) {

        super(itemView);
        this.mBinding = binding;
    }
}
