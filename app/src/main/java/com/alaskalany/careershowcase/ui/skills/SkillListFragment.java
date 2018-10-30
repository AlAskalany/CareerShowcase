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

    // TODO: Customize parameter argument names
    private final SkillOnClickCallback callback =
            item -> Toast.makeText(getContext(), "Clicked on SkillEntity Item", Toast.LENGTH_SHORT).show();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SkillListFragment() {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SkillListFragment newInstance(int columnCount) {

        SkillListFragment fragment = new SkillListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_skill_list, container, false);
        setAdapter(new SkillAdapter(SkillContent.ITEM_MAP, callback));
        binding.listSkill.setAdapter(getAdapter());
        Context context = binding.getRoot().getContext();
        if (getColumnCount() <= 1) {
            binding.listSkill.setLayoutManager(new LinearLayoutManager(context));
        } else {
            binding.listSkill.setLayoutManager(new GridLayoutManager(context, getColumnCount()));
        }
        return binding.getRoot();
    }
}
