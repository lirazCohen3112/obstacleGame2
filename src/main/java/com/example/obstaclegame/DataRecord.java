package com.example.obstaclegame;

import java.util.ArrayList;

public class DataRecord {

    public static ArrayList <RecordLine> recordLines = new ArrayList<>();;

    public static void addRecord (int num , int score){
        recordLines.add(new RecordLine(num , score));
    }

    public static ArrayList<RecordLine> getRecordLines (){
        return recordLines;
    }
}
