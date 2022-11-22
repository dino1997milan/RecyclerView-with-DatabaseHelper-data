package com.elebio2.esercitazione02;

import static com.elebio2.esercitazione02.DataBaseHelper.TABLE_NAME;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaRisultatiFragment extends Fragment {

    ArrayList<String> mDateCorseList;
    ArrayList<String> mNumeriCorseList;
    ArrayList<String> mPassiList;
    ArrayList<String> mKmList;
    ArrayList<String> mKcalList;
    ArrayList<DataModelRisultati> mDataModelList;

    DataBaseHelper mDatabaseHelper;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista_risultati, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mNumeriCorseList = new ArrayList<String>();
        mDateCorseList = new ArrayList<String>();
        mPassiList = new ArrayList<String>();
        mKmList = new ArrayList<String>();
        mKcalList = new ArrayList<String>();

        mDatabaseHelper = new DataBaseHelper(getContext(),TABLE_NAME);

//        mNumeriCorseList.add("1");
//        mNumeriCorseList.add("2");
//        mNumeriCorseList.add("3");
//        mNumeriCorseList.add("4");
//        mNumeriCorseList.add("5");
//        mNumeriCorseList.add("6");
//        mNumeriCorseList.add("7");
//        mNumeriCorseList.add("10");
//
//        for(int i=0;i<mNumeriCorseList.size();i++){
//            mDateCorseList.add("05/01/2022");}
//
//        for(int i=0;i<mNumeriCorseList.size();i++){
//        mPassiList.add("50");}
//
//        for(int i=0;i<mNumeriCorseList.size();i++){
//            mKmList.add("0.2");}
//
//        for(int i=0;i<mNumeriCorseList.size();i++){
//            mKcalList.add("5");}

        mDatabaseHelper.doInsert("05/01/2021","321","2","84",TABLE_NAME);

//        mDataModelList = new ArrayList<DataModelRisultati>();
//        for(int i=0; i<mNumeriCorseList.size();i++){
//            mDataModelList.add(new DataModelRisultati(
//                    mNumeriCorseList.get(i),
//                    mDateCorseList.get(i), mPassiList.get(i),mKmList.get(i)
//                    ,mKcalList.get(i)
//            ));
//        }

        Cursor cursor = mDatabaseHelper.getTable(TABLE_NAME);
        mDataModelList = new ArrayList<DataModelRisultati>();
        while(cursor.moveToNext()){

            mDataModelList.add(new DataModelRisultati(String.valueOf(cursor.getInt(0)),
                    cursor.getString(1),cursor.getString(2),
                    cursor.getString(3),cursor.getString(4)));  //così posso ottenere a mio piacimento tutte le informazioni di ogni colonna

        }

            GridLayoutManager mGridLayoutManager = new GridLayoutManager(getContext(), 1);
        RecyclerView mRecyclerView = view.findViewById(R.id.recyclerViewRisultati);
        MyAdapterRisultati mAdapter = new MyAdapterRisultati(mDataModelList, getContext());
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mRecyclerView.setAdapter(mAdapter);



    }
}
