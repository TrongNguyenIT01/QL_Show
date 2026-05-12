package com.example.ql_show;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Xem_Lich extends AppCompatActivity {

    ListView listView;
    DatabaseHelper db;
    ArrayList<AddShow> list;
    ShowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_lich);
        getSupportActionBar().hide();
        listView = findViewById(R.id.listViewShow);
        db = new DatabaseHelper(this);

        loadData();
    }

    private void loadData(){
        list = db.getAllShows();
        adapter = new ShowAdapter(this, list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }
}