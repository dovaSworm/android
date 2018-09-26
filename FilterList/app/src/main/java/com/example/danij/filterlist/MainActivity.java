package com.example.danij.filterlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText theFilter = (EditText) findViewById(R.id.filter_search);
        ListView mListView = (ListView) findViewById(R.id.theList);

        ArrayList<String> names = new ArrayList<>();
        names.add("Boro");
        names.add("Jovo");
        names.add("Savo");
        names.add("Simo");
        names.add("Mico");

        adapter = new ArrayAdapter(this, R.layout.list_item_layout, names);
        mListView.setAdapter(adapter);

        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (MainActivity.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}
