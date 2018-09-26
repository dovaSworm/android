package com.example.danij.sharedpreferenceses;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView secondTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        secondTV = (TextView) findViewById(R.id.textView2);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();

       String name = pref.getString(getString(R.string.name),"");
       secondTV.setText(name);
       String pass = pref.getString(getString(R.string.password), "");

    }
}
