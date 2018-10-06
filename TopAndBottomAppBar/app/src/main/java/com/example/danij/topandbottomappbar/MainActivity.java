package com.example.danij.topandbottomappbar;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter sectionsPagerAdapter;
    private ViewPager mviewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mviewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(mviewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mviewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_assignment_left);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_autorenew);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_attach);
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment1());
        adapter.addFragment(new Fragment2());
        adapter.addFragment(new Fragment3());
        viewPager.setAdapter(adapter);
    }
}
