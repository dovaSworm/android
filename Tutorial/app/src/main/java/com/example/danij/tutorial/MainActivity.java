package com.example.danij.tutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String poruka = "test poruka";
        final TextView mojTextViev = (TextView) findViewById(R.id.textView1);
        mojTextViev.setText("Ovo je moj prvi tekstview");
        String odViewa = mojTextViev.getText().toString();
//        Log.d(TAG, "onCreate: " + odViewa);
        Log.d(TAG, "onCreate: Started." );
////////////////////////////////////////////////////////////////////////////////////////
        ImageView prvaSlika = (ImageView) findViewById(R.id.slika1);
        int idSlike = getResources().getIdentifier("@drawable/angry", null, this.getPackageName());
        prvaSlika.setImageResource(idSlike);
        ///////////////////////////////////////////
        Button firstButton = (Button) findViewById(R.id.btnOne);
        Button secondButton = (Button) findViewById(R.id.btnTwo);
        //////////////////////////////////////////////////////////////
        Button navToSecondSccreen = (Button) findViewById(R.id.btnGoToSecondScreen);
        navToSecondSccreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondScreen.class);
                startActivity(intent);
            }
        });
        //////////////////////////////////////////////////////////////////////
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Cklicked button one");
                Toast.makeText(MainActivity.this, "Clicked button one", Toast.LENGTH_SHORT).show();
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mojTextViev.setText(poruka);
            }
        });
    }
}
