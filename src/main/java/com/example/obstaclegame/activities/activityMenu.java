package com.example.obstaclegame.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.obstaclegame.DataRecord;
import com.example.obstaclegame.MySPV3;
import com.example.obstaclegame.R;
import com.google.android.material.button.MaterialButton;

public class activityMenu extends AppCompatActivity {

    private MaterialButton main_LBL_gameSensors;
    private MaterialButton main_LBL_gameButtons;
    private MaterialButton main_LBL_tableRecords;
   // private Activity activityButtons;

   // private GameManager gameManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViews();
     //   activityButtons = activityButtons.class
        // DataRecord d = new DataRecord();
       // DataRecord.addRecord(2 , 333);

        MySPV3.init(this);

        main_LBL_gameSensors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySensors();
            }
        });

        main_LBL_gameButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityButtons();
            }
        });

        main_LBL_tableRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { openAactivityTableRecords (); }
        });
    }

    private void findViews() {

        main_LBL_gameSensors = findViewById(R.id.main_LBL_gameSensors);
        main_LBL_gameButtons = findViewById(R.id.main_LBL_gameButtons);
        main_LBL_tableRecords = findViewById(R.id.main_LBL_tableRecords);

    }

    private void openActivityButtons (){
        Intent intent = new Intent(activityMenu.this, activityButtons.class);
        startActivity(intent);
        finish();
    }

    private void openActivitySensors (){
        Intent intent = new Intent(activityMenu.this, activitySensors.class);
        startActivity(intent);
    }

    private void openAactivityTableRecords (){
        Intent intent = new Intent(activityMenu.this, activityTableRecords.class);
        startActivity(intent);
       // activityTableRecords.class.setGameManager(gameManager);
    }

   // public void setGameManager(GameManager gameManager){
      //  this.gameManager = gameManager;
   // }
}