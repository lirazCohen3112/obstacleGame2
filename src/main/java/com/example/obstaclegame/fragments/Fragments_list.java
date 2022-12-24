package com.example.obstaclegame.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.obstaclegame.R;
import com.example.obstaclegame.RecordAdapter;
import com.example.obstaclegame.RecordLine;
import com.example.obstaclegame.DataRecord;

import java.util.ArrayList;

public class Fragments_list extends Fragment {

    private RecyclerView main_LST_records;
    private ArrayList<RecordLine> records;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        main_LST_records = view.findViewById(R.id.main_LST_records);
        records = DataRecord.getRecordLines();

        RecordAdapter recordAdapter = new RecordAdapter(this , records);
        main_LST_records.setLayoutManager(new LinearLayoutManager(getContext()));
        main_LST_records.setAdapter(recordAdapter);

        return view;
    }

}
