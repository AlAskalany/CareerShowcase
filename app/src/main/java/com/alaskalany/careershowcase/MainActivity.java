package com.alaskalany.careershowcase;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.SparseArrayCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alaskalany.careershowcase.databinding.ActivityMainBinding;
import com.alaskalany.careershowcase.ui.contact.ContactFragment;
import com.alaskalany.careershowcase.ui.education.EducationListFragment;
import com.alaskalany.careershowcase.ui.overview.OverviewFragment;
import com.alaskalany.careershowcase.ui.skills.SkillListFragment;
import com.alaskalany.careershowcase.ui.work.WorkListFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Main activity
 */
public class MainActivity
        extends AppCompatActivity
        implements OverviewFragment.OnOverviewFragmentInteractionListener,
                   ContactFragment.OnContactFragmentInteractionListener,
                   BottomNavigationView.OnNavigationItemSelectedListener,
                   BottomNavigationView.OnNavigationItemReselectedListener {

    private final OverviewFragment overviewFragment = new OverviewFragment();
    private final EducationListFragment educationListFragment = new EducationListFragment();
    private final WorkListFragment workListFragment = new WorkListFragment();
    private final SkillListFragment skillListFragment = new SkillListFragment();
    private final ContactFragment contactFragment = new ContactFragment();
    /**
     * Fragments used in bottom navigation
     */
    private SparseArrayCompat<Fragment> fragments = new SparseArrayCompat<>();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        BottomNavigationView navigationView = findViewById(R.id.navigation);
        setupBottomNavigation(navigationView, this, this);
        // Set bottom navigation to first fragment
        if (savedInstanceState == null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = supportFragmentManager.beginTransaction();
            transaction.add(R.id.container_navigation, overviewFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    private void setupBottomNavigation(@NonNull BottomNavigationView navigationView,
                                       BottomNavigationView.OnNavigationItemSelectedListener selectedListener,
                                       BottomNavigationView.OnNavigationItemReselectedListener reselectedListener) {

        navigationView.setOnNavigationItemSelectedListener(selectedListener);
        navigationView.setOnNavigationItemReselectedListener(reselectedListener);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Replace current fragment with requested fragment
        switch (menuItem.getItemId()) {
            case R.id.navigation_overview:
                replaceFragment(overviewFragment);
                return true;
            case R.id.navigation_education:
                replaceFragment(educationListFragment);
                return true;
            case R.id.navigation_work:
                replaceFragment(workListFragment);
                return true;
            case R.id.navigation_skills:
                replaceFragment(skillListFragment);
                return true;
            case R.id.navigation_contact:
                replaceFragment(contactFragment);
                return true;
        }
        return false;
    }

    private void replaceFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_navigation, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }

    @Override
    public void onOverviewFragmentInteraction(Uri uri) {

    }

    @Override
    public void onContactFragmentInteraction(Uri uri) {

    }
}
