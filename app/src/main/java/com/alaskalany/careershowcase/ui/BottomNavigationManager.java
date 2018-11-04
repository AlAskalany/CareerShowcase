package com.alaskalany.careershowcase.ui;

import android.view.MenuItem;
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
 *
 */
public class BottomNavigationManager
        implements BottomNavigationView.OnNavigationItemSelectedListener,
                   BottomNavigationView.OnNavigationItemReselectedListener {

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
    private final FragmentActivity mActivity;

    /**
     *
     */
    private final SparseArrayCompat<ScrollToTop> mFragments;

    /**
     * @param fragmentActivity {@link MainActivity}
     */
    public BottomNavigationManager(FragmentActivity fragmentActivity) {

        mActivity = fragmentActivity;
        mFragments = new SparseArrayCompat<>();
        mFragments.put(OVERVIEW, new OverviewFragment());
        mFragments.put(EDUCATION, new EducationListFragment());
        mFragments.put(WORK, new WorkListFragment());
        mFragments.put(SKILLS, new SkillListFragment());
        mFragments.put(CONTACT, new ContactListFragment());
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

        ScrollToTop fragment = mFragments.get(navFragment);
        if (fragment != null) {
            FragmentTransaction transaction = mActivity.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container_navigation, (Fragment) fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            throw new RuntimeException("Navigation fragment shouldn't be null");
        }
    }

    /**
     * @param menuItem Bottom navigation menu item
     */
    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
        // Replace current fragment with requested fragment
        switch (menuItem.getItemId()) {
            case R.id.navigation_overview:
                scrollToFragmentTop(getFragment(OVERVIEW));
                break;
            case R.id.navigation_education:
                scrollToFragmentTop(getFragment(EDUCATION));
                break;
            case R.id.navigation_work:
                scrollToFragmentTop(getFragment(WORK));
                break;
            case R.id.navigation_skills:
                scrollToFragmentTop(getFragment(SKILLS));
                break;
            case R.id.navigation_contact:
                scrollToFragmentTop(getFragment(CONTACT));
                break;
        }
    }

    /**
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

        return Objects.requireNonNull(mFragments.get(fragmentId));
    }

    /**
     * @param freshStart Is this a fresh activity start
     */
    public void init(boolean freshStart) {

        if (freshStart) {
            ScrollToTop fragment = mFragments.get(OVERVIEW);
            if (fragment != null) {
                FragmentManager supportFragmentManager = mActivity.getSupportFragmentManager();
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                transaction.add(R.id.container_navigation, (Fragment) fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        }
    }
}
