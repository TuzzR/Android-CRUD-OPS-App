package com.example.mysupermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener{
    EditText Id,Item_Name,Item_Price,Item_Quantity,Item_Category;
    Button insertionbtn;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        Id = findViewById(R.id.item_id);
        Item_Name = findViewById(R.id.item_name);
        Item_Price = findViewById(R.id.item_price);
        Item_Quantity = findViewById(R.id.item_quan);
        Item_Category = findViewById(R.id.item_category);

        db = new DBHelper(this);

        insertionbtn = findViewById(R.id.Insert_btn);
        insertionbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String id = Id.getText().toString();
        String Iname = Item_Name.getText().toString();
        String Iprice = Item_Price.getText().toString();
        String Iquan = Item_Quantity.getText().toString();
        String Icat = Item_Quantity.getText().toString();
        Boolean checkdata = db.insertdata(id,Iname,Iprice,Iquan,Icat);
        if(checkdata==true)
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Error in Entering Data", Toast.LENGTH_SHORT).show();
    }
}
