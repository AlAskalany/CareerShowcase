package com.alaskalany.careershowcase.ui.skills;

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
import com.alaskalany.careershowcase.database.SkillContent;
import com.alaskalany.careershowcase.databinding.FragmentSkillListBinding;
import com.alaskalany.careershowcase.ui.BaseListFragment;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class SkillListFragment
        extends BaseListFragment<SkillAdapter, FragmentSkillListBinding> {

    /**
     *
     */
    private final SkillOnClickCallback mCallback =
            item -> Toast.makeText(getContext(), "Clicked on SkillEntity Item", Toast.LENGTH_SHORT).show();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SkillListFragment() {

    }

    /**
     * @param columnCount
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
     * @return
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_skill_list, container, false);
        setAdapter(new SkillAdapter(SkillContent.ITEM_MAP, mCallback));
        mBinding.listSkill.setAdapter(getAdapter());
        Context context = mBinding.getRoot().getContext();
        if (getColumnCount() <= 1) {
            mBinding.listSkill.setLayoutManager(new LinearLayoutManager(context));
        } else {
            mBinding.listSkill.setLayoutManager(new GridLayoutManager(context, getColumnCount()));
        }
        return mBinding.getRoot();
    }
}
