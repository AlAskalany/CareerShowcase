package com.alaskalany.careershowcase;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alaskalany.careershowcase.data.dummy.DummyContent;
import com.alaskalany.careershowcase.ui.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Main activity
 */
public class MainActivity
        extends AppCompatActivity
        implements OverviewFragment.OnFragmentInteractionListener,
                   WorkFragment.OnListFragmentInteractionListener,
                   EducationFragment.OnListFragmentInteractionListener,
                   SkillFragment.OnListFragmentInteractionListener,
                   ContactFragment.OnFragmentInteractionListener,
                   BottomNavigationView.OnNavigationItemSelectedListener,
                   BottomNavigationView.OnNavigationItemReselectedListener {

    /**
     * Fragments used in bottom navigation
     */
    private SparseArrayCompat<Fragment> fragments = new SparseArrayCompat<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        fragments.put(R.id.navigation_work, new OverviewFragment());
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();
        transaction.add(R.id.container, new OverviewFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // Replace current fragment with requested fragment
        switch (menuItem.getItemId()) {
            case R.id.navigation_overview:
                replaceFragment(new OverviewFragment());
                return true;
            case R.id.navigation_education:
                replaceFragment(new EducationFragment());
                return true;
            case R.id.navigation_work:
                replaceFragment(new WorkFragment());
                return true;
            case R.id.navigation_skills:
                replaceFragment(new SkillFragment());
                return true;
            case R.id.navigation_contact:
                replaceFragment(new ContactFragment());
                return true;
        }
        return false;
    }

    private void replaceFragment(Fragment fragment) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }
}
