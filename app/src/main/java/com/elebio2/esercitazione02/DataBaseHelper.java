package com.elebio2.esercitazione02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "DatabaseHelper";

    public static final String TABLE_NAME = " corse";
    private static final String COL0 = "ID";
    private static final String COL1 = "data";
    private static final String COL2 = "passi";
    private static final String COL3 = "km";
    private static final String COL4 = "kcal";



    public DataBaseHelper(Context context,String user) {
        super(context, user, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                COL1 +" TEXT,"+ COL2 + " TEXT,"+
//                COL3+" TEXT,"+COL4+" TEXT)";
//        db.execSQL(createTable);
        onCreateModified(db,TABLE_NAME);
    }

    public void onCreateModified(SQLiteDatabase db,String user){
        String createTable = "CREATE TABLE " + user + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL1 +" TEXT,"+ COL2 + " TEXT,"+
                COL3+" TEXT,"+COL4+" TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
//        onCreate(db);
    }

    public boolean doInsert(String data,String passi,String km,String kcal,String user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,data);
        contentValues.put(COL2,passi);
        contentValues.put(COL3,km);
        contentValues.put(COL4,kcal);

        Log.d(TAG, " Dati aggiunti " + data + " "+ passi +" "+km +" "+kcal+ " "+" aggiunti alla tabella " + TABLE_NAME);

        long result = db.insert(user, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getTable(String user){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + user;
        Cursor dati_tabella = db.rawQuery(query, null);
        return dati_tabella;
    }

    public Cursor getDay(int numeroID,String user){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " +user +
                " WHERE " + COL0 + " = '" + numeroID + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }


}
