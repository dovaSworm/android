package com.example.danij.actionbarwithcardview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ActivityThree extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_layout);

        TextView title = (TextView) findViewById(R.id.activity3text);
        title.setText("This is activity 3");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navBarBottom);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.androidPic:
                        Intent intent = new Intent(ActivityThree.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.archive:
                        Intent intent2 = new Intent(ActivityThree.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;
                    case R.id.callBack:
                        break;
                    case R.id.note:
                        Intent intent3 = new Intent(ActivityThree.this, ActivityFour.class);
                        startActivity(intent3);
                        break;
                    case R.id.triangle:
                        Intent intent4 = new Intent(ActivityThree.this, ActivityFive.class);
                        startActivity(intent4);
                        break;

                }
                return false;
            }
        });
    }
}
