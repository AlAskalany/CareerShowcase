package com.alaskalany.careershowcase.ui.skills;

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
import com.alaskalany.careershowcase.databinding.FragmentSkillListBinding;
import com.alaskalany.careershowcase.viewmodel.SkillListViewModel;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class SkillListFragment
        extends androidx.fragment.app.Fragment {

    /**
     *
     */
    protected static final String ARG_COLUMN_COUNT = "column-count";

    /**
     *
     */
    private final SkillOnClickCallback mCallback =
            item -> Toast.makeText(getContext(), "Clicked on SkillEntity Item", Toast.LENGTH_SHORT)
                         .show();

    /**
     *
     */
    protected FragmentSkillListBinding mBinding;

    /**
     *
     */
    protected SkillAdapter mAdapter;

    /**
     *
     */
    protected int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SkillListFragment() {

    }

    /**
     * @param columnCount
     *
     * @return
     */
    @SuppressWarnings("unused")
    public static SkillListFragment newInstance(int columnCount) {

        SkillListFragment fragment = new SkillListFragment();
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

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_skill_list, container, false);
        setAdapter(new SkillAdapter(mCallback));
        mBinding.listSkill.setAdapter(getAdapter());
        Context context = mBinding.getRoot()
                                  .getContext();
        if (getColumnCount() <= 1) {
            mBinding.listSkill.setLayoutManager(new LinearLayoutManager(context));
        } else {
            mBinding.listSkill.setLayoutManager(new GridLayoutManager(context, getColumnCount()));
        }
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
        final SkillListViewModel _model = ViewModelProviders.of(this)
                                                            .get(SkillListViewModel.class);
        mBinding.setSkillListViewModel(_model);
        _model.getSkills()
              .observe(this, pWorkEntities -> {
                  if (pWorkEntities != null) {
                      mAdapter.setSkillList(pWorkEntities);
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
    protected SkillAdapter getAdapter() {

        return mAdapter;
    }

    /**
     * @param adapter
     */
    protected void setAdapter(SkillAdapter adapter) {

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
