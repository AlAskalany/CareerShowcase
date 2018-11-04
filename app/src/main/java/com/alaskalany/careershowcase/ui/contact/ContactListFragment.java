package com.alaskalany.careershowcase.ui.contact;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.databinding.FragmentContactListBinding;
import com.alaskalany.careershowcase.ui.ScrollToTop;
import com.alaskalany.careershowcase.viewmodel.ContactListViewModel;

/**
 * A fragment representing a list of Items.
 * <p/>
 */
public class ContactListFragment
        extends Fragment
        implements ScrollToTop {

    /**
     *
     */
    protected static final String ARG_COLUMN_COUNT = "column-count";

    /**
     *
     */
    private final ContactOnClickCallback mCallBack =
            item -> Toast.makeText(getContext(), "Clicked on ContactEntity Item", Toast.LENGTH_SHORT).show();

    /**
     *
     */
    protected FragmentContactListBinding mBinding;

    /**
     *
     */
    protected ContactAdapter mAdapter;

    /**
     *
     */
    protected int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ContactListFragment() {

    }

    /**
     * @param columnCount
     *
     * @return
     */
    @SuppressWarnings("unused")
    public static ContactListFragment newInstance(int columnCount) {

        ContactListFragment fragment = new ContactListFragment();
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

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_contact_list, container, false);
        setAdapter(new ContactAdapter(mCallBack));
        Context context = mBinding.getRoot().getContext();
        if (getColumnCount() <= 1) {
            mBinding.listContact.setLayoutManager(new LinearLayoutManager(context));
        } else {
            mBinding.listContact.setLayoutManager(new GridLayoutManager(context, getColumnCount()));
        }
        mBinding.listContact.setAdapter(getAdapter());
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
        final ContactListViewModel _model = ViewModelProviders.of(this).get(ContactListViewModel.class);
        mBinding.setContactListViewModel(_model);
        _model.getContacts().observe(this, contactEntities -> {
            if (contactEntities != null) {
                mAdapter.setContactList(contactEntities);
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
    protected ContactAdapter getAdapter() {

        return mAdapter;
    }

    /**
     * @param adapter
     */
    protected void setAdapter(ContactAdapter adapter) {

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

        mBinding.listContact.smoothScrollToPosition(0);
    }
}
