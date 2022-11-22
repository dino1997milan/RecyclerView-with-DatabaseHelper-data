package com.elebio2.esercitazione02;

public class DataModelRisultati {

    String mNumeroCorsa;
    String mDataCorsa;
    String mPassi;
    String mKm;
    String mKcal;

    public DataModelRisultati(String mNumeroCorsa, String mDataCorsa, String mPassi, String mKm, String mKcal) {
        this.mNumeroCorsa = mNumeroCorsa;
        this.mDataCorsa = mDataCorsa;
        this.mPassi = mPassi;
        this.mKm = mKm;
        this.mKcal = mKcal;
    }

    public String getmPassi() {
        return mPassi;
    }

    public String getmKm() {
        return mKm;
    }

    public String getmKcal() {
        return mKcal;
    }

    public String getmNumeroCorsa() {
        return mNumeroCorsa;
    }

    public String getmDataCorsa() {
        return mDataCorsa;
    }
}
