package com.alaskalany.careershowcase;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.SparseArrayCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alaskalany.careershowcase.data.dummy.DummyContent;
import com.alaskalany.careershowcase.ui.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity
        extends AppCompatActivity
        implements OverviewFragment.OnFragmentInteractionListener,
                   WorkFragment.OnListFragmentInteractionListener,
                   EducationFragment.OnListFragmentInteractionListener,
                   SkillFragment.OnListFragmentInteractionListener,
                   ContactFragment.OnFragmentInteractionListener {

    private final OverviewFragment overviewFragment = new OverviewFragment();

    private final WorkFragment workFragment = new WorkFragment();

    private final EducationFragment educationFragment = new EducationFragment();

    private final SkillFragment skillFragment = new SkillFragment();

    private final ContactFragment contactFragment = new ContactFragment();

    SparseArrayCompat<Fragment> fragments = new SparseArrayCompat<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
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
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
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
}
