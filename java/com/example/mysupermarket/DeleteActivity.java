package com.example.mysupermarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
    EditText deleteItem;
    Button Deletingbtn;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        deleteItem = findViewById(R.id.DeleteItem);
        Deletingbtn = findViewById(R.id.deletingbtn);

        db = new DBHelper(this);
        Deletingbtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String name = deleteItem.getText().toString();
        boolean checkdata = db.deletedata(name);
        if(checkdata==true)
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Error in Deleting Data", Toast.LENGTH_SHORT).show();
    }
}
