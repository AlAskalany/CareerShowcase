/*
 * MIT License
 *
 * Copyright (c) 2018 Ahmed AlAskalany
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.alaskalany.careershowcase.ui.overview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
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
public class OverviewFragment extends Fragment implements ScrollToTop, SwipeRefreshLayout.OnRefreshListener {
    
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
    private String param1;
    
    /**
     *
     */
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String param2;
    
    /**
     *
     */
    private OnOverviewFragmentInteractionListener onOverviewFragmentInteractionListener;
    
    /**
     *
     */
    private FragmentOverviewBinding binding;
    
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
     *
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
        
        if (onOverviewFragmentInteractionListener != null) {
            onOverviewFragmentInteractionListener.onOverviewFragmentInteraction(uri);
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
            onOverviewFragmentInteractionListener = (OnOverviewFragmentInteractionListener) context;
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
            param1 = getArguments().getString(ARG_PARAM1);
            param2 = getArguments().getString(ARG_PARAM2);
        }
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
        
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false);
        binding.setName("Ahmed AlAskalany");
        binding.setHeadline("Software Engineer");
        
        binding.swipeRefreshLayout.setOnRefreshListener(this);
        
        binding.imageButtonLinkedin.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/askalany/"));
            startActivity(browserIntent);
        });
        
        binding.imageButtonGithub.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/AlAskalany"));
            startActivity(browserIntent);
        });
        
        binding.imageButtonTwitter.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/Askalanism"));
            startActivity(browserIntent);
        });
        // Inflate the layout for this fragment
        GlideApp.with(this).load(getString(R.string.profile_picture_url)).into(binding.imageViewProfilePicture);
        return binding.getRoot();
    }
    
    /**
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        
        super.onActivityCreated(savedInstanceState);
        binding.executePendingBindings();
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
        
        onOverviewFragmentInteractionListener = null;
    }
    
    @Override
    public void top() {
    
    }
    
    @Override
    public void onRefresh() {
    
        binding.swipeRefreshLayout.setRefreshing(false);
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
