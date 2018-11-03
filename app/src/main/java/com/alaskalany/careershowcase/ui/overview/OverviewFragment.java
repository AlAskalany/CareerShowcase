package com.alaskalany.careershowcase.ui.overview;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.alaskalany.careershowcase.GlideApp;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.databinding.FragmentOverviewBinding;
import com.alaskalany.careershowcase.ui.ScrollToTop;
import org.jetbrains.annotations.Contract;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnOverviewFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OverviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OverviewFragment
        extends Fragment implements ScrollToTop {

    /**
     *
     */
    private static final String ARG_PARAM1 = "param1";

    /**
     *
     */
    private static final String ARG_PARAM2 = "param2";

    /**
     *
     */
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String mParam1;

    /**
     *
     */
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String mParam2;

    /**
     *
     */
    private OnOverviewFragmentInteractionListener mListener;

    /**
     *
     */
    private FragmentOverviewBinding mBinding;

    /**
     *
     */
    public OverviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OverviewFragment.
     */
    @SuppressWarnings({"unused", "WeakerAccess"})
    public static OverviewFragment newInstance(String param1, String param2) {

        OverviewFragment fragment = new OverviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * @param uri
     */
    @SuppressWarnings("unused")
    public void onButtonPressed(Uri uri) {

        if (mListener != null) {
            mListener.onOverviewFragmentInteraction(uri);
        }
    }

    /**
     * @param context
     */
    @Override
    public void onAttach(Context context) {

        super.onAttach(context);
        registerListener(context);
    }

    /**
     * @param context
     */
    @Contract("null -> fail")
    private void registerListener(Context context) {

        if (context instanceof OnOverviewFragmentInteractionListener) {
            mListener = (OnOverviewFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnOverviewFragmentInteractionListener");
        }
    }

    /**
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false);
        mBinding.setName("Ahmed AlAskalany");
        mBinding.setHeadline("Software Engineer");
        // Inflate the layout for this fragment
        GlideApp.with(this)
                .load("http://chittagongit.com//images/app-icon-material-design/app-icon-material-design-11.jpg")
                .into(mBinding.imageViewProfilePicture);
        return mBinding.getRoot();
    }

    /**
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        mBinding.executePendingBindings();
    }

    /**
     *
     */
    @Override
    public void onDetach() {

        super.onDetach();
        unregisterListener();
    }

    /**
     *
     */
    private void unregisterListener() {

        mListener = null;
    }

    @Override
    public void top() {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnOverviewFragmentInteractionListener {

        // TODO: Update argument type and name
        void onOverviewFragmentInteraction(Uri uri);
    }
}
