package com.example.danij.actionbarwithcardview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

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

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navBarBottom);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.androidPic:

                        break;
                    case R.id.archive:
                        Intent intent1 = new Intent(MainActivity.this, ActivityTwo.class);
                        startActivity(intent1);
                        break;
                    case R.id.callBack:
                        Intent intent2 = new Intent(MainActivity.this, ActivityThree.class);
                        startActivity(intent2);
                        break;
                    case R.id.note:
                        Intent intent3 = new Intent(MainActivity.this, ActivityFour.class);
                        startActivity(intent3);
                        break;
                    case R.id.triangle:
                        Intent intent4 = new Intent(MainActivity.this, ActivityFive.class);
                        startActivity(intent4);
                        break;

                }
                return false;
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment1());
        adapter.addFragment(new Fragment2());
        adapter.addFragment(new Fragment3());
        viewPager.setAdapter(adapter);
    }
}
