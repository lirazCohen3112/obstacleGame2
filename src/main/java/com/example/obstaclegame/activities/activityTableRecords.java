package com.example.obstaclegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.example.obstaclegame.R;
import com.example.obstaclegame.fragments.Fragments_list;
import com.example.obstaclegame.fragments.Fragments_map;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;


public class activityTableRecords extends AppCompatActivity{

    private MaterialTextView table_records_LBL_title;
    private MaterialButton table_records_BTN_updateList;

    private FrameLayout table_records_LAY_list;
    private FrameLayout table_records_LAY_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_records);

        findViews();

        Fragments_list fragments_list = new Fragments_list();
        getSupportFragmentManager().beginTransaction().add(R.id.table_records_LAY_list , fragments_list).commit();

        Fragments_map fragments_map = new Fragments_map();
        getSupportFragmentManager().beginTransaction().add(R.id.table_records_LAY_map , fragments_map).commit();

    }
    private void findViews() {

        table_records_LBL_title = findViewById(R.id.table_records_LBL_title);

        table_records_LAY_list = findViewById(R.id.table_records_LAY_list);
        table_records_LAY_map = findViewById(R.id.table_records_LAY_map);
    }
}