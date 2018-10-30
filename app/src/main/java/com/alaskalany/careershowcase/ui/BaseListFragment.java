package com.alaskalany.careershowcase.ui;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

public abstract class BaseListFragment<A extends BaseRecyclerViewAdapter, B extends ViewDataBinding>
        extends Fragment {

    // TODO: Customize parameter argument names
    protected static final String ARG_COLUMN_COUNT = "column-count";
    protected B binding;
    private A adapter;
    // TODO: Customize parameters
    private int mColumnCount = 1;

    protected int getColumnCount() {

        return mColumnCount;
    }

    protected void setColumnCount(int mColumnCount) {

        this.mColumnCount = mColumnCount;
    }

    protected A getAdapter() {

        return adapter;
    }

    protected void setAdapter(A adapter) {

        this.adapter = adapter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            setColumnCount(getArguments().getInt(ARG_COLUMN_COUNT));
        }
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
    }

    @Override
    public void onDetach() {

        super.onDetach();
    }
}
