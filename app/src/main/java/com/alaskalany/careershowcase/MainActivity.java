package com.alaskalany.careershowcase;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.alaskalany.careershowcase.databinding.ActivityMainBinding;
import com.alaskalany.careershowcase.ui.BottomNavigationManager;
import com.alaskalany.careershowcase.ui.contact.ContactFragment;
import com.alaskalany.careershowcase.ui.overview.OverviewFragment;

/**
 * Main activity
 */
public class MainActivity
        extends AppCompatActivity
        implements OverviewFragment.OnOverviewFragmentInteractionListener,
                   ContactFragment.OnContactFragmentInteractionListener {

    /**
     * Bottom navigation
     */
    private final BottomNavigationManager mNavigationManager = new BottomNavigationManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActivityMainBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.navigation.setOnNavigationItemSelectedListener(mNavigationManager);
        mBinding.navigation.setOnNavigationItemReselectedListener(mNavigationManager);
        // Set bottom navigation to first fragment
        mNavigationManager.init(savedInstanceState == null);
    }

    /**
     * @param uri uri
     */
    @Override
    public void onOverviewFragmentInteraction(Uri uri) {

    }

    /**
     * @param uri uri
     */
    @Override
    public void onContactFragmentInteraction(Uri uri) {

    }
}
