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
 *
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
     *
     */
    private final SparseArrayCompat<ScrollToTop> fragments;

    private BottomNavigationView navigation;

    /**
     * @param fragmentActivity {@link MainActivity}
     */
    public BottomNavigationManager(FragmentActivity fragmentActivity, BottomNavigationView navigation) {

        activity = fragmentActivity;
        fragments = new SparseArrayCompat<>();
        createFragments(fragments);
        this.navigation = navigation;
        setBottomNavigationView(navigation);
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

    public void setBottomNavigationView(BottomNavigationView navigation) {

        this.navigation = navigation;
    }

    /**
     * @param menuItem Bottom navigation menu item
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
     * @throws RuntimeException If the navigation fragment is null
     */
    private void replaceFragment(int navFragment) throws RuntimeException {

        ScrollToTop fragment = fragments.get(navFragment);
        if (fragment != null) {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
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
     * @return Bottom navigation fragment
     */
    private ScrollToTop getFragment(int fragmentId) {

        return Objects.requireNonNull(fragments.get(fragmentId));
    }

    /**
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

    @Override
    public void onBackStackChanged() {

        Toast.makeText(activity.getApplicationContext(), "Backstack changed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onBackPressed() {

        if (navigation.getSelectedItemId() != R.id.navigation_overview) {
            navigation.getMenu().getItem(0).setChecked(true);
            replaceFragment(OVERVIEW);
            return true;
        }
        return false;
    }
}
