package com.example.mysupermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button InsertBtn, ViewBtn, UpdateBtn, DeleteBtn, Item_QuantityhBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InsertBtn = (Button) findViewById(R.id.Insertbtn);
        ViewBtn = (Button) findViewById(R.id.viewbtn);
        UpdateBtn = (Button) findViewById(R.id.updatebtn);
        DeleteBtn = (Button) findViewById(R.id.Deletebtn);
        Item_QuantityhBtn = (Button) findViewById(R.id.searchbtn);
        InsertBtn.setOnClickListener(this);
        ViewBtn.setOnClickListener(this);
        UpdateBtn.setOnClickListener(this);
        DeleteBtn.setOnClickListener(this);
        Item_QuantityhBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(InsertBtn)){
            Intent it = new Intent(this,InsertActivity.class);
            startActivity(it);

        }
        if(v.equals(UpdateBtn)){
            Intent it = new Intent(this,UpdateActivity.class);
            startActivity(it);

        }
        if(v.equals(DeleteBtn)){
            Intent it = new Intent(this,DeleteActivity.class);
            startActivity(it);

        }
        if (v.equals(ViewBtn)){
            Intent it = new Intent(this,ViewActivity.class);
            startActivity(it);
        }
        if (v.equals(Item_QuantityhBtn)){
            Intent it = new Intent(this,SearchActivity.class);
            startActivity(it);
        }
    }
}