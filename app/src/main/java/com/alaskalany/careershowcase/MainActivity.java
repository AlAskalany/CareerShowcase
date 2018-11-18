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

package com.alaskalany.careershowcase;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.SparseArrayCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alaskalany.careershowcase.databinding.ActivityMainBinding;
import com.alaskalany.careershowcase.ui.ScrollToTop;
import com.alaskalany.careershowcase.ui.contact.ContactListFragment;
import com.alaskalany.careershowcase.ui.education.EducationListFragment;
import com.alaskalany.careershowcase.ui.overview.OverviewFragment;
import com.alaskalany.careershowcase.ui.skills.SkillListFragment;
import com.alaskalany.careershowcase.ui.work.WorkListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

/**
 * Main activity
 */
public class MainActivity extends AppCompatActivity
        implements OverviewFragment.OnOverviewFragmentInteractionListener, FragmentManager.OnBackStackChangedListener,
                   BottomNavigationView.OnNavigationItemSelectedListener,
                   BottomNavigationView.OnNavigationItemReselectedListener {
    
    /**
     * Debugging tag
     */
    @SuppressWarnings("unused")
    public static final String TAG = "MainActivity";
    
    /**
     * {@link OverviewFragment}
     */
    private static final int OVERVIEW = 0;
    
    /**
     * {@link EducationListFragment}
     */
    private static final int EDUCATION = 1;
    
    /**
     * {@link WorkListFragment}
     */
    private static final int WORK = 2;
    
    /**
     * {@link SkillListFragment}
     */
    private static final int SKILLS = 3;
    
    /**
     * {@link ContactListFragment}
     */
    private static final int CONTACT = 4;
    
    /**
     * Collection of fragments used with {@link BottomNavigationView}
     */
    private final SparseArrayCompat<ScrollToTop> fragments = new SparseArrayCompat<>();
    
    /**
     * Activity layout bindings
     */
    ActivityMainBinding binding;
    
    /**
     * {@link BottomNavigationView}
     */
    private BottomNavigationView bottomNavigationView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        
        // Bind to layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        
        bottomNavigationView = binding.navigation;
        
        // listen to item selection and reselection from the bottom navigation view
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemReselectedListener(this);
        
        createFragments(fragments);
        
        initializeBottomNavigation(savedInstanceState == null);
        
        // Handle connectivity
        Runnable networkHandler = this::handleNetwork;
        networkHandler.run();
    }
    
    private static void createFragments(@NonNull SparseArrayCompat<ScrollToTop> mFragments) {
        
        mFragments.put(OVERVIEW, new OverviewFragment());
        mFragments.put(EDUCATION, new EducationListFragment());
        mFragments.put(WORK, new WorkListFragment());
        mFragments.put(SKILLS, new SkillListFragment());
        mFragments.put(CONTACT, new ContactListFragment());
    }
    
    /**
     * For app start, attach the {@link OverviewFragment}
     *
     * @param freshStart Is this a fresh activity start
     */
    public void initializeBottomNavigation(boolean freshStart) {
        
        if (freshStart) {
            ScrollToTop fragment = fragments.get(OVERVIEW);
            if (fragment != null) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                transaction.add(R.id.container_navigation, (Fragment) fragment);
                transaction.commit();
            }
        }
    }
    
    /**
     * Called whenever the contents of the back stack change.
     */
    @Override
    public void onBackStackChanged() {
        // TODO
        Toast.makeText(getApplicationContext(), "Backstack changed", Toast.LENGTH_SHORT).show();
    }
    
    /**
     * Interface {@link OverviewFragment.OnOverviewFragmentInteractionListener}
     * for interacting with {@link OverviewFragment}
     *
     * @param uri uri
     */
    @Override
    public void onOverviewFragmentInteraction(Uri uri) {
        // TODO handle interaction with the OverviewFragment from MainActivity
    }
    
    /**
     * Called when the activity has detected the user's press of the back
     * key.  The default implementation simply finishes the current activity,
     * but you can override this to do whatever you want.
     */
    @Override
    public void onBackPressed() {
        
        // If back was pressed with a fragment other than the overview fragment attached
        if (bottomNavigationView.getSelectedItemId() != R.id.navigation_overview) {
            // Set the overview menu item in the bottom navigation view as selected
            bottomNavigationView.getMenu().getItem(0).setChecked(true);
            // Attach the overview fragment
            replaceFragment(OVERVIEW);
        } else {
            finish();
        }
    }
    
    /**
     * @param navFragment Navigation fragment
     *
     * @throws RuntimeException If the navigation fragment is null
     */
    private void replaceFragment(int navFragment) throws RuntimeException {
        
        ScrollToTop fragment = fragments.get(navFragment);
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container_navigation, (Fragment) fragment);
            if (!(fragment instanceof OverviewFragment)) {
                transaction.addToBackStack(null);
            }
            transaction.commit();
        } else {
            throw new RuntimeException("Navigation fragment shouldn't be null");
        }
    }
    
    @Override
    public void onNavigationItemReselected(@NonNull MenuItem item) {
        
        switch (item.getItemId()) {
            case R.id.navigation_overview:
                // Overview menu item reselected, scroll to the top of the overview fragment
                scrollToFragmentTop(getFragment(OVERVIEW));
                break;
            case R.id.navigation_education:
                // Education menu item reselected, scroll to the top of the education fragment
                scrollToFragmentTop(getFragment(EDUCATION));
                break;
            case R.id.navigation_work:
                // Work menu item reselected, scroll to the top of the work fragment
                scrollToFragmentTop(getFragment(WORK));
                break;
            case R.id.navigation_skills:
                // Skills menu item reselected, scroll to the top of the skills fragment
                scrollToFragmentTop(getFragment(SKILLS));
                break;
            case R.id.navigation_contact:
                // Contact menu item reselected, scroll to the top of the contact fragment
                scrollToFragmentTop(getFragment(CONTACT));
                break;
        }
    }
    
    /**
     * Scroll to the top of the fragment implemented {@link ScrollToTop}
     *
     * @param fragment Bottom navigation fragment
     */
    private void scrollToFragmentTop(@NonNull ScrollToTop fragment) {
        
        fragment.top();
    }
    
    /**
     * @param fragmentId Fragment id
     *
     * @return Bottom navigation fragment
     */
    private ScrollToTop getFragment(int fragmentId) {
        
        return Objects.requireNonNull(fragments.get(fragmentId));
    }
    
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        
        // Replace current fragment with requested fragment
        switch (item.getItemId()) {
            case R.id.navigation_overview:
                replaceFragment(OVERVIEW);
                return true;
            case R.id.navigation_education:
                replaceFragment(EDUCATION);
                return true;
            case R.id.navigation_work:
                replaceFragment(WORK);
                return true;
            case R.id.navigation_skills:
                replaceFragment(SKILLS);
                return true;
            case R.id.navigation_contact:
                replaceFragment(CONTACT);
                return true;
        }
        return false;
    }
    
    private void handleNetwork() {
        
        ConnectivityManager connMgr =
                (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        
        boolean isWifiConn = false;
        boolean isMobileConn = false;
        
        // Get active network information
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }
        
        // Online if network info exists and is connected
        boolean isOnline = networkInfo != null && networkInfo.isConnected();
        
        if (isOnline) {
            // If online
            // Check connectivity for all networks
            for (Network network : connMgr.getAllNetworks()) {
                NetworkInfo info = connMgr.getNetworkInfo(network);
                if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                    // If Wi-Fi
                    isWifiConn |= info.isConnected();
                    if (isWifiConn) {
                        Toast.makeText(getApplicationContext().getApplicationContext(), "WiFi connected",
                                       Toast.LENGTH_SHORT).show();
                    }
                }
                if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                    // If mobile network
                    isMobileConn |= info.isConnected();
                    if (isMobileConn) {
                        Toast.makeText(getApplicationContext().getApplicationContext(), "Mobile connected",
                                       Toast.LENGTH_SHORT).show();
                    }
                }
            }
        } else {
            Toast.makeText(getApplicationContext().getApplicationContext(), "Not connected", Toast.LENGTH_SHORT).show();
        }
    }
}
