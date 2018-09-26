package com.example.danij.cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        Log.d(TAG, "onCreate: Usao u onCreate---------------------------------------------------------------------");
        listView = (ListView) findViewById(R.id.listView);
        ArrayList<Card> listOfCards = new ArrayList();
        listOfCards.add(new Card("profilna", "drawable://" + R.drawable.profilna));
        listOfCards.add(new Card("galaxy", "drawable://" + R.drawable.galaxy));
        listOfCards.add(new Card("make", "drawable://" + R.drawable.make));
        listOfCards.add(new Card("teren", "drawable://" + R.drawable.teren));
        listOfCards.add(new Card("teren_pticija", "drawable://" + R.drawable.teren_pticija));
        listOfCards.add(new Card("vertilalna_uzarena", "drawable://" + R.drawable.vertikalna_uzarena));

        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.activity_main, listOfCards);
        listView.setAdapter(adapter);

    }
}
