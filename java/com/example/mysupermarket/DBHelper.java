package com.example.mysupermarket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "spdb.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Product(Id Text primary key, Item_Name Text,Item_price Text, Item_Quantity Text,IItem_Category Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists Product");
    }

    public boolean insertdata(String Id, String Item_Name, String Item_price, String Item_Quantity, String IItem_Category) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Id", Id);
        cv.put("Item_Name", Item_Name);
        cv.put("Item_price", Item_price);
        cv.put("Item_Quantity", Item_Quantity);
        cv.put("IItem_Category", IItem_Category);
        long result = database.insert("Product", null, cv);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean updatedata(String Id, String Item_Name, String Item_price, String Item_Quantity) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Item_price", Item_price);
        cv.put("Item_Quantity", Item_Quantity);

        Cursor cursor = database.rawQuery("Select * from Product where Item_Name = ?", new String[]{Item_Name});
        if (cursor.getCount() > 0) {
            long result = database.update("Product", cv, "Item_Name=?", new String[]{Item_Name});
            if (result == -1)
                return false;
            else
                return true;
        }
        else
            return false;
    }

    public boolean deletedata(String Item_Name) {
        SQLiteDatabase database = this.getWritableDatabase();


        Cursor cursor = database.rawQuery("Select * from Product where Item_Name = ?", new String[]{Item_Name});
        if (cursor.getCount() > 0) {
            long result = database.delete("Product", "Item_Name=?", new String[]{Item_Name});
            if (result == -1)
                return false;
            else
                return true;
        }
        else
            return false;
    }

    public ArrayList<SupermarketModel>  getdata(String Item_Name) {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from Product where Item_Name = ?",new String[]{Item_Name});
        ArrayList<SupermarketModel> itemModelArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursor.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                itemModelArrayList.add(new SupermarketModel(cursor.getString(1),
                        cursor.getString(4),
                        cursor.getString(2),
                        cursor.getString(3)));
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursor.close();
        return itemModelArrayList;

    }
    public ArrayList<SupermarketModel> readCourses() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM Product", null);

        // on below line we are creating a new array list.
        ArrayList<SupermarketModel> itemModelArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                itemModelArrayList.add(new SupermarketModel(cursorCourses.getString(1),
                        cursorCourses.getString(4),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return itemModelArrayList;
    }

}

