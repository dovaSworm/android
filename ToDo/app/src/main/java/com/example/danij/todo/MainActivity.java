package com.example.danij.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    private Button button;
    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.btnAddItem);
        items = new ArrayList<>();
        readItems();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        setupListViewListener();
    }

    private void setupListViewListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                adapter.notifyDataSetChanged();
                writeItems();
                return true;
            }
        });
    }

    public void addNewItem(View view){
        String itemText = "-" + editText.getText().toString();
        adapter.add(itemText);
        editText.setText("");
        writeItems();
    }

    private void readItems(){
        File fileDir = getFilesDir();
        File toDoFile = new File(fileDir, "toDo.txt");

        try {
           items = new ArrayList<String>(FileUtils.readLines(toDoFile));
        }catch (IOException e){
            items = new ArrayList<String>();
        }
    }

    private void writeItems(){
        File fileDir = getFilesDir();
        File toDoFile = new File(fileDir, "toDo.txt");
        try {
            FileUtils.writeLines(toDoFile, items);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
