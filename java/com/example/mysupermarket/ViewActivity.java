package com.example.mysupermarket;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<SupermarketModel> itemModelArrayList;
    private DBHelper dbHandler;
    private CourseRVAdapter itemRVAdapter;
    private RecyclerView itemRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);
        // initializing our all variables.
        itemModelArrayList = new ArrayList<>();
        dbHandler = new DBHelper(ViewActivity.this);

        // getting our course array
        // list from db handler class.
        itemModelArrayList = dbHandler.readCourses();

        // on below line passing our array lost to our adapter class.
        itemRVAdapter = new CourseRVAdapter(itemModelArrayList, ViewActivity.this);
        itemRV = findViewById(R.id.idRVItems);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewActivity.this, RecyclerView.VERTICAL, false);
        itemRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        itemRV.setAdapter(itemRVAdapter);
    }

    @Override
    public void onClick(View view) {


    }
}