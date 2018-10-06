package com.example.danij.fragments;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private MyPagerAdapter myPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Usao---------------------------u main-------------------------------");

        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(viewPager);
    }
        private void setupViewPager(ViewPager viewPager){
            MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new Fragment1(), "Fragment 1");
            adapter.addFragment(new Fragment2(), "Fragment 2");
            adapter.addFragment(new Fragment3(), "Fragment 3");
            viewPager.setAdapter(adapter);
        }
    public void setViewPager(int fragmentNum){
        viewPager.setCurrentItem(fragmentNum);
    }
}
