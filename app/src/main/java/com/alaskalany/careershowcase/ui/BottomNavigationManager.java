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

package com.alaskalany.careershowcase.ui;

import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alaskalany.careershowcase.MainActivity;
import com.alaskalany.careershowcase.R;
import com.alaskalany.careershowcase.ui.contact.ContactListFragment;
import com.alaskalany.careershowcase.ui.education.EducationListFragment;
import com.alaskalany.careershowcase.ui.overview.OverviewFragment;
import com.alaskalany.careershowcase.ui.skills.SkillListFragment;
import com.alaskalany.careershowcase.ui.work.WorkListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

/**
 * Bottom Navigation Manager that handles {@link BottomNavigationView}
 */
public class BottomNavigationManager
        implements BottomNavigationView.OnNavigationItemSelectedListener,
                   BottomNavigationView.OnNavigationItemReselectedListener,
                   FragmentManager.OnBackStackChangedListener,
                   OnBackPressed {

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
     * {@link MainActivity}
     */
    private final FragmentActivity activity;

    /**
     * Collection of fragments used with {@link BottomNavigationView}
     */
    private final SparseArrayCompat<ScrollToTop> fragments;

    /**
     * {@link BottomNavigationView}
     */
    private BottomNavigationView navigation;

    /**
     * @param fragmentActivity {@link MainActivity}
     */
    public BottomNavigationManager(FragmentActivity fragmentActivity, BottomNavigationView navigation) {

        activity = fragmentActivity;
        fragments = new SparseArrayCompat<>();
        createFragments(fragments);
        this.navigation = navigation;

        // Set the bottom navigation view
        setBottomNavigationView(navigation);

        // listen to item selection and reselection from the bottom navigation view
        navigation.setOnNavigationItemSelectedListener(this);
        navigation.setOnNavigationItemReselectedListener(this);
    }

    private static void createFragments(@NonNull SparseArrayCompat<ScrollToTop> mFragments) {

        mFragments.put(OVERVIEW, new OverviewFragment());
        mFragments.put(EDUCATION, new EducationListFragment());
        mFragments.put(WORK, new WorkListFragment());
        mFragments.put(SKILLS, new SkillListFragment());
        mFragments.put(CONTACT, new ContactListFragment());
    }

    /**
     * @param navigation {@link BottomNavigationView}
     */
    private void setBottomNavigationView(BottomNavigationView navigation) {

        this.navigation = navigation;
    }

    /**
     * @param menuItem Bottom navigation menu item
     *
     * @return True if a menu item was selected
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Replace current fragment with requested fragment
        switch (menuItem.getItemId()) {
            case R.id.navigation_overview:
                replaceFragment(BottomNavigationManager.OVERVIEW);
                return true;
            case R.id.navigation_education:
                replaceFragment(BottomNavigationManager.EDUCATION);
                return true;
            case R.id.navigation_work:
                replaceFragment(BottomNavigationManager.WORK);
                return true;
            case R.id.navigation_skills:
                replaceFragment(BottomNavigationManager.SKILLS);
                return true;
            case R.id.navigation_contact:
                replaceFragment(BottomNavigationManager.CONTACT);
                return true;
        }
        return false;
    }

    /**
     * @param navFragment Navigation fragment
     *
     * @throws RuntimeException If the navigation fragment is null
     */
    private void replaceFragment(int navFragment) throws RuntimeException {

        ScrollToTop fragment = fragments.get(navFragment);
        if (fragment != null) {
            FragmentTransaction transaction = activity.getSupportFragmentManager()
                                                      .beginTransaction();
            transaction.replace(R.id.container_navigation, (Fragment) fragment);
            if (!(fragment instanceof OverviewFragment)) {
                transaction.addToBackStack(null);
            }
            transaction.commit();
        } else {
            throw new RuntimeException("Navigation fragment shouldn't be null");
        }
    }

    /**
     * Handles reselection of a {@link BottomNavigationView}'s menu item, by scrolling to the top of the screen
     *
     * @param menuItem Bottom navigation menu item
     */
    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
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

    /**
     * For app start, attach the {@link OverviewFragment}
     *
     * @param freshStart Is this a fresh activity start
     */
    public void init(boolean freshStart) {

        if (freshStart) {
            ScrollToTop fragment = fragments.get(OVERVIEW);
            if (fragment != null) {
                FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                transaction.add(R.id.container_navigation, (Fragment) fragment);
                //transaction.addToBackStack(null);
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
        Toast.makeText(activity.getApplicationContext(), "Backstack changed", Toast.LENGTH_SHORT)
             .show();
    }

    /**
     * Handling back presses by replacing any fragment with the {@link OverviewFragment}
     *
     * @return true if back was pressed with a fragment other than {@link OverviewFragment} attached
     */
    @Override
    public boolean onBackPressed() {
        // If back was pressed with a fragment other than the overview fragment attached
        if (navigation.getSelectedItemId() != R.id.navigation_overview) {

            // Set the overview menu item in the bottom navigation view as selected
            navigation.getMenu()
                      .getItem(0)
                      .setChecked(true);

            // Attach the overview fragment
            replaceFragment(OVERVIEW);
            return true;
        }
        // If back was pressed with the overview fragment attached
        return false;
    }
}
