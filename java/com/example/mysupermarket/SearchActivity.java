package com.example.mysupermarket;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener  {
    private ArrayList<SupermarketModel> itemModelArrayList;
    private DBHelper dbHandler;
    EditText txtSearch;

    private CourseRVAdapter itemRVAdapter;
    private RecyclerView itemRV;
    Button btnSearch;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
//        itemModelArrayList = new ArrayList<>();
        txtSearch =(EditText) findViewById(R.id.findText);
        btnSearch=(Button)findViewById(R.id.button);
        btnSearch.setOnClickListener(this);



        // t4.setText((String) itemModelArrayList);
    }


    @Override
    public void onClick(View view) {
        dbHandler = new DBHelper(SearchActivity.this);

        itemModelArrayList = dbHandler.getdata(txtSearch.getText().toString());
        itemRVAdapter = new CourseRVAdapter(itemModelArrayList, SearchActivity.this);
        itemRV = findViewById(R.id.idRVItems);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchActivity.this, RecyclerView.VERTICAL, false);
        itemRV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        itemRV.setAdapter(itemRVAdapter);
    }
}
