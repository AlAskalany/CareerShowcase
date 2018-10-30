package com.alaskalany.careershowcase.ui;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/**
 * @param <A>
 * @param <B>
 */
public abstract class BaseListFragment<A extends BaseRecyclerViewAdapter, B extends ViewDataBinding>
        extends Fragment {

    /**
     *
     */
    protected static final String ARG_COLUMN_COUNT = "column-count";
    /**
     *
     */
    protected B mBinding;
    /**
     *
     */
    private A mAdapter;
    /**
     *
     */
    private int mColumnCount = 1;

    /**
     * @return
     */
    protected int getColumnCount() {

        return mColumnCount;
    }

    /**
     * @param mColumnCount
     */
    protected void setColumnCount(int mColumnCount) {

        this.mColumnCount = mColumnCount;
    }

    /**
     * @return
     */
    protected A getAdapter() {

        return mAdapter;
    }

    /**
     * @param adapter
     */
    protected void setAdapter(A adapter) {

        this.mAdapter = adapter;
    }

    /**
     * @param context
     */
    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
    }

    /**
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            setColumnCount(getArguments().getInt(ARG_COLUMN_COUNT));
        }
    }

    /**
     *
     */
    @Override
    public void onDetach() {

        super.onDetach();
    }
}
