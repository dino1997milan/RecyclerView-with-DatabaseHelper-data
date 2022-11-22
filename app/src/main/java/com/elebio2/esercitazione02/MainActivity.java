package com.elebio2.esercitazione02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
        DataBaseHelper mDataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDataBaseHelper = new DataBaseHelper(this,DataBaseHelper.TABLE_NAME);
        //mDataBaseHelper.doInsert("05/01/2021","321","2","84");

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new ListaRisultatiFragment())
                .commit();

    }

}