package com.alaskalany.careershowcase.ui.skills;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.data.skills.Skill;
import com.alaskalany.careershowcase.data.skills.SkillContent;
import org.jetbrains.annotations.Contract;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnSkillListFragmentInteractionListener}
 * interface.
 */
public class SkillListFragment
        extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnSkillListFragmentInteractionListener mListener;

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
    public void onAttach(Context context) {

        super.onAttach(context);
        registerListener(context);
    }

    @Contract("null -> fail")
    private void registerListener(Context context) {

        if (context instanceof OnSkillListFragmentInteractionListener) {
            mListener = (OnSkillListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnWorkListFragmentInteractionListener");
        }
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

        View view = inflater.inflate(R.layout.fragment_skill_list, container, false);
        // Set the adapter
        if (view instanceof RecyclerView) {
            setupRecyclerViewAdapter(view, mColumnCount,
                                     new SkillRecyclerViewAdapter(SkillContent.ITEM_MAP, mListener));
        }
        return view;
    }

    private void setupRecyclerViewAdapter(@NonNull View view, int columns,
                                          RecyclerView.Adapter<SkillViewHolder> adapter) {

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
        unregisterListener();
    }

    private void unregisterListener() {

        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnSkillListFragmentInteractionListener {

        // TODO: Update argument type and name
        void onSkillListFragmentInteraction(Skill item);
    }
}
