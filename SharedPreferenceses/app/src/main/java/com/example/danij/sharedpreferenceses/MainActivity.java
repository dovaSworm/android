package com.example.danij.sharedpreferenceses;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mySharedPreferencese;
    private SharedPreferences.Editor editor;

    private EditText nameEt, passwordEt;
    private Button buttonLogin;
    private CheckBox checkBoxEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt = (EditText) findViewById(R.id.etName);
        passwordEt = (EditText) findViewById(R.id.etPassword);
        buttonLogin = (Button)findViewById(R.id.loginButton);
        checkBoxEt = (CheckBox) findViewById(R.id.checkbox);

        mySharedPreferencese = PreferenceManager.getDefaultSharedPreferences(this);
        editor = mySharedPreferencese.edit();

        checkSharedPreferences();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBoxEt.isChecked()){
                    editor.putString(getString(R.string.checkbox), "True");
                    editor.commit();

                    String name = nameEt.getText().toString();
                    editor.putString(getString(R.string.name), name);
                    editor.commit();

                    String password = passwordEt.getText().toString();
                    editor.putString(getString(R.string.password),password);
                    editor.commit();

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }else{
                    editor.putString(getString(R.string.checkbox), "False");
                    editor.commit();

                    editor.putString(getString(R.string.name), "");
                    editor.commit();

                    editor.putString(getString(R.string.password),"");
                    editor.commit();
                }
            }
        });
    }

    public void checkSharedPreferences(){
        String checkbox = mySharedPreferencese.getString(getString(R.string.checkbox), "false");
        String name = mySharedPreferencese.getString(getString(R.string.name), "");
        String password = mySharedPreferencese.getString(getString(R.string.password), "");

        nameEt.setText(name);
        passwordEt.setText(password);

        if(checkbox.equals("true")){
            checkBoxEt.setChecked(true);
        }else{
            checkBoxEt.setChecked(false);
        }
    }
}
