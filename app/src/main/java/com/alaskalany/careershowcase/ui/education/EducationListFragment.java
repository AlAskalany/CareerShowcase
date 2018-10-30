package com.alaskalany.careershowcase.ui.education;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.database.EducationContent;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class EducationListFragment
        extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private final EducationOnClickCallback callback = item -> {
        Toast.makeText(getContext(), "Clicked on EducationEntity Item", Toast.LENGTH_SHORT).show();
    };

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EducationListFragment() {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static EducationListFragment newInstance(int columnCount) {

        EducationListFragment fragment = new EducationListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_education_list, container, false);
        // Set the adapter
        if (view instanceof RecyclerView) {
            setupRecyclerViewAdapter(view,
                                     mColumnCount,
                                     new EducationAdapter(EducationContent.ITEM_MAP, callback));
        }
        return view;
    }

    private void setupRecyclerViewAdapter(@NonNull View view, int columns,
                                          RecyclerView.Adapter<EducationAdapter.ViewHolder> adapter) {

        Context context = view.getContext();
        RecyclerView recyclerView = (RecyclerView) view;
        if (columns <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, columns));
        }
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDetach() {

        super.onDetach();
    }
}
