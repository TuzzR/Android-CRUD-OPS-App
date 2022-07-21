package com.example.mysupermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    EditText UpdateIname,UpdateP,UpdateItem_Quantity;
    Button Updatingbtn;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        UpdateIname = findViewById(R.id.UpdateItemName);
        UpdateP = findViewById(R.id.UpdatePrice);
        UpdateItem_Quantity = findViewById(R.id.UpdateQuan);

        db = new DBHelper(this);

        Updatingbtn = findViewById(R.id.Updatingbtn);
        Updatingbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = UpdateIname.getText().toString();
        String Tprice = UpdateP.getText().toString();
        String TItem_Quantity = UpdateItem_Quantity.getText().toString();
        Boolean checkdata = db.updatedata(null,name,Tprice,TItem_Quantity);
        if(checkdata==true)
            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Error in Updating Data", Toast.LENGTH_SHORT).show();
    }
}