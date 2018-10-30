package com.alaskalany.careershowcase.ui.education;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.database.EducationContent;
import com.alaskalany.careershowcase.databinding.FragmentEducationListBinding;
import com.alaskalany.careershowcase.ui.BaseListFragment;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class EducationListFragment
        extends BaseListFragment<EducationAdapter, FragmentEducationListBinding> {

    /**
     *
     */
    private final EducationOnClickCallback mCallBack =
            item -> Toast.makeText(getContext(), "Clicked on EducationEntity Item", Toast.LENGTH_SHORT).show();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EducationListFragment() {

    }

    /**
     * @param columnCount
     * @return
     */
    @SuppressWarnings("unused")
    public static EducationListFragment newInstance(int columnCount) {

        EducationListFragment fragment = new EducationListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_education_list, container, false);
        setAdapter(new EducationAdapter(EducationContent.ITEM_MAP, mCallBack));
        Context context = mBinding.getRoot().getContext();
        if (getColumnCount() <= 1) {
            mBinding.listEducation.setLayoutManager(new LinearLayoutManager(context));
        } else {
            mBinding.listEducation.setLayoutManager(new GridLayoutManager(context, getColumnCount()));
        }
        mBinding.listEducation.setAdapter(getAdapter());
        return mBinding.getRoot();
    }
}
