package com.alaskalany.careershowcase.ui.work;

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
import com.alaskalany.careershowcase.database.WorkContent;
import com.alaskalany.careershowcase.databinding.FragmentWorkListBinding;
import com.alaskalany.careershowcase.ui.BaseListFragment;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class WorkListFragment
        extends BaseListFragment<WorkAdapter, FragmentWorkListBinding> {

    // TODO: Customize parameters
    private final WorkOnClickCallback callback =
            item -> Toast.makeText(getContext(), "Clicked on WorkEntity Item", Toast.LENGTH_SHORT).show();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WorkListFragment() {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static BaseListFragment newInstance(int columnCount) {

        BaseListFragment fragment = new WorkListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_work_list, container, false);
        setAdapter(new WorkAdapter(WorkContent.ITEM_MAP, callback));
        Context context = binding.getRoot().getContext();
        if (getColumnCount() <= 1) {
            binding.listWork.setLayoutManager(new LinearLayoutManager(context));
        } else {
            binding.listWork.setLayoutManager(new GridLayoutManager(context, getColumnCount()));
        }
        binding.listWork.setAdapter(getAdapter());
        return binding.getRoot();
    }
}
