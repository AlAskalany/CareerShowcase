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

class BottomNavigationManager
        implements BottomNavigationView.OnNavigationItemSelectedListener,
                   BottomNavigationView.OnNavigationItemReselectedListener {

    private static final int OVERVIEW = 0;
    private static final int EDUCATION = 1;
    private static final int WORK = 2;
    private static final int SKILLS = 3;
    private static final int CONTACT = 4;
    private final FragmentActivity activity;
    private final SparseArrayCompat<Fragment> fragments;

    BottomNavigationManager(FragmentActivity fragmentActivity) {

        activity = fragmentActivity;
        fragments = new SparseArrayCompat<>();
        fragments.put(OVERVIEW, new OverviewFragment());
        fragments.put(EDUCATION, new EducationListFragment());
        fragments.put(WORK, new WorkListFragment());
        fragments.put(SKILLS, new SkillListFragment());
        fragments.put(CONTACT, new ContactFragment());
    }

    private void replaceFragment(int navFragment) throws RuntimeException {

        Fragment fragment = fragments.get(navFragment);
        if (fragment != null) {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container_navigation, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else {
            throw new RuntimeException("Navigation fragment shouldn't be null");
        }
    }

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

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }

    void init(boolean freshStart) {

        if (freshStart) {
            Fragment fragment = fragments.get(OVERVIEW);
            if (fragment != null) {
                FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
                FragmentTransaction transaction = supportFragmentManager.beginTransaction();
                transaction.add(R.id.container_navigation, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        }
    }
}
