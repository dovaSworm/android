package com.example.danij.bottomnavbarwithactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_layout);

        TextView title = (TextView) findViewById(R.id.activity2text);
        title.setText("This is activity 2");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navBarBottom);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.androidPic:
                        Intent intent = new Intent(ActivityTwo.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.archive:
                        break;
                    case R.id.callBack:
                        Intent intent2 = new Intent(ActivityTwo.this, ActivityThree.class);
                        startActivity(intent2);
                        break;
                    case R.id.note:
                        Intent intent3 = new Intent(ActivityTwo.this, ActivityFour.class);
                        startActivity(intent3);
                        break;
                    case R.id.triangle:
                        Intent intent4 = new Intent(ActivityTwo.this, ActivityFive.class);
                        startActivity(intent4);
                        break;

                }
                return false;
            }
        });
    }
}
