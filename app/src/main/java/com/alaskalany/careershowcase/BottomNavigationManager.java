package com.alaskalany.careershowcase;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alaskalany.careershowcase.ui.contact.ContactFragment;
import com.alaskalany.careershowcase.ui.education.EducationListFragment;
import com.alaskalany.careershowcase.ui.overview.OverviewFragment;
import com.alaskalany.careershowcase.ui.skills.SkillListFragment;
import com.alaskalany.careershowcase.ui.work.WorkListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 *
 */
class BottomNavigationManager
        implements BottomNavigationView.OnNavigationItemSelectedListener,
                   BottomNavigationView.OnNavigationItemReselectedListener {

    /**
     *
     */
    private static final int OVERVIEW = 0;
    /**
     *
     */
    private static final int EDUCATION = 1;
    /**
     *
     */
    private static final int WORK = 2;
    /**
     *
     */
    private static final int SKILLS = 3;
    /**
     *
     */
    private static final int CONTACT = 4;
    /**
     *
     */
    private final FragmentActivity mActivity;
    /**
     *
     */
    private final SparseArrayCompat<Fragment> mFragments;

    /**
     * @param fragmentActivity
     */
    BottomNavigationManager(FragmentActivity fragmentActivity) {

        mActivity = fragmentActivity;
        mFragments = new SparseArrayCompat<>();
        mFragments.put(OVERVIEW, new OverviewFragment());
        mFragments.put(EDUCATION, new EducationListFragment());
        mFragments.put(WORK, new WorkListFragment());
        mFragments.put(SKILLS, new SkillListFragment());
        mFragments.put(CONTACT, new ContactFragment());
    }

    /**
     * @param menuItem
     * @return
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
     * @param navFragment
     * @throws RuntimeException
     */
    private void replaceFragment(int navFragment) throws RuntimeException {

        Fragment fragment = mFragments.get(navFragment);
        if (fragment != null) {
            FragmentTransaction transaction = mActivity.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container_navigation, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            throw new RuntimeException("Navigation fragment shouldn't be null");
        }
    }

    /**
     * @param menuItem
     */
    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }

    /**
     * @param freshStart
     */
    void init(boolean freshStart) {

        if (freshStart) {
            Fragment fragment = mFragments.get(OVERVIEW);
            if (fragment != null) {
                FragmentManager supportFragmentManager = mActivity.getSupportFragmentManager();
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                transaction.add(R.id.container_navigation, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        }
    }
}
