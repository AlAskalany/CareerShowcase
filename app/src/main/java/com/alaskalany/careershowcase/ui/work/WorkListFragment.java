package com.alaskalany.careershowcase.ui.work;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.databinding.FragmentWorkListBinding;
import com.alaskalany.careershowcase.ui.ScrollToTop;
import com.alaskalany.careershowcase.viewmodel.WorkListViewModel;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class WorkListFragment
        extends androidx.fragment.app.Fragment
        implements ScrollToTop {

    /**
     *
     */
    protected static final String ARG_COLUMN_COUNT = "column-count";

    /**
     *
     */
    private final WorkOnClickCallback mCallback =
            item -> Toast.makeText(getContext(), "Clicked on WorkEntity Item", Toast.LENGTH_SHORT)
                         .show();

    /**
     *
     */
    protected FragmentWorkListBinding mBinding;

    /**
     *
     */
    protected WorkAdapter mAdapter;

    /**
     *
     */
    protected int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WorkListFragment() {

    }

    /**
     * @param columnCount
     *
     * @return
     */
    @SuppressWarnings("unused")
    public static WorkListFragment newInstance(int columnCount) {

        WorkListFragment fragment = new WorkListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     *
     * @return
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_work_list, container, false);
        mAdapter = new WorkAdapter(mCallback);
        Context context = mBinding.getRoot()
                                  .getContext();
        if (mColumnCount <= 1) {
            mBinding.listWork.setLayoutManager(new LinearLayoutManager(context));
        } else {
            mBinding.listWork.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        mBinding.listWork.setAdapter(mAdapter);
        return mBinding.getRoot();
    }

    /**
     * Called when the fragment's activity has been created and this
     * fragment's view hierarchy instantiated.  It can be used to do final
     * initialization once these pieces are in place, such as retrieving
     * views or restoring state.  It is also useful for fragments that use
     * {@link #setRetainInstance(boolean)} to retain their instance,
     * as this callback tells the fragment when it is fully associated with
     * the new activity instance.  This is called after {@link #onCreateView}
     * and before {@link #onViewStateRestored(Bundle)}.
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        final WorkListViewModel _model = ViewModelProviders.of(this)
                                                           .get(WorkListViewModel.class);
        mBinding.setWorkListViewModel(_model);
        _model.getWorks()
              .observe(this, pWorkEntities -> {
                  if (pWorkEntities != null) {
                      mAdapter.setWorkList(pWorkEntities);
                  } else {
                  }
                  mBinding.executePendingBindings();
              });
    }

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
    protected WorkAdapter getAdapter() {

        return mAdapter;
    }

    /**
     * @param adapter
     */
    protected void setAdapter(WorkAdapter adapter) {

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

    @Override
    public void top() {
        mBinding.listWork.smoothScrollToPosition(0);

    }
}
