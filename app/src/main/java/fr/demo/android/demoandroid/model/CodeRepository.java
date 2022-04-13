package fr.demo.android.demoandroid.model;

import androidx.annotation.NonNull;

public class CodeRepository extends MRData{

    private MRData MRData;


    //private int limit;
    @NonNull
    @Override
    public String toString() {
        return "CodeRepository{" + MRData.series + '}';
    }


}