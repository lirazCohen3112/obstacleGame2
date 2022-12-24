package com.example.obstaclegame.activities;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.obstaclegame.DataRecord;
import com.example.obstaclegame.GameManager;
import com.example.obstaclegame.MySPV3;
import com.example.obstaclegame.R;
import com.example.obstaclegame.RecordLine;
import com.google.android.material.textview.MaterialTextView;

import java.util.Random;

public class activitySensors extends AppCompatActivity{
    private static final String SP_KEY_SCORE = "SP_KEY_SCORE";
    private Handler handler;

    private BackgroundSound backgroundSound;

    private SensorManager sensorManager;
    private Sensor acc_sensor;

    private long timeStamp = 0;

    private ImageView[][] game_IMG_stones;
    private ImageView[][] game_IMG_coins;
    private ImageView[] game_IMG_car;
    private ImageView[] game_IMG_heart;

    private MaterialTextView main_LBL_score;

    private ImageView main_IMG_heart1;
    private ImageView main_IMG_heart2;
    private ImageView main_IMG_heart3;

    private ImageView main_IMG_stone1;
    private ImageView main_IMG_stone2;
    private ImageView main_IMG_stone3;
    private ImageView main_IMG_stone4;
    private ImageView main_IMG_stone5;
    private ImageView main_IMG_stone6;
    private ImageView main_IMG_stone7;
    private ImageView main_IMG_stone8;
    private ImageView main_IMG_stone9;
    private ImageView main_IMG_stone10;
    private ImageView main_IMG_stone11;
    private ImageView main_IMG_stone12;
    private ImageView main_IMG_stone13;
    private ImageView main_IMG_stone14;
    private ImageView main_IMG_stone15;
    private ImageView main_IMG_stone16;
    private ImageView main_IMG_stone17;
    private ImageView main_IMG_stone18;
    private ImageView main_IMG_stone19;
    private ImageView main_IMG_stone20;

    private ImageView main_IMG_coin1;
    private ImageView main_IMG_coin2;
    private ImageView main_IMG_coin3;
    private ImageView main_IMG_coin4;
    private ImageView main_IMG_coin5;
    private ImageView main_IMG_coin6;
    private ImageView main_IMG_coin7;
    private ImageView main_IMG_coin8;
    private ImageView main_IMG_coin9;
    private ImageView main_IMG_coin10;
    private ImageView main_IMG_coin11;
    private ImageView main_IMG_coin12;
    private ImageView main_IMG_coin13;
    private ImageView main_IMG_coin14;
    private ImageView main_IMG_coin15;
    private ImageView main_IMG_coin16;
    private ImageView main_IMG_coin17;
    private ImageView main_IMG_coin18;
    private ImageView main_IMG_coin19;
    private ImageView main_IMG_coin20;

    private ImageView main_IMG_car1;
    private ImageView main_IMG_car2;
    private ImageView main_IMG_car3;
    private ImageView main_IMG_car4;
    private ImageView main_IMG_car5;

    private GameManager gameManager;

    private int numRows = 4;
    private int numCols = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        findViews();

        gameManager = new GameManager();

        game_IMG_car[0].setVisibility(View.INVISIBLE);
        game_IMG_car[1].setVisibility(View.INVISIBLE);
        game_IMG_car[3].setVisibility(View.INVISIBLE);
        game_IMG_car[4].setVisibility(View.INVISIBLE);

        for (int i = 0; i < numRows; i++){
            for (int t = 0; t < numCols; t++)
            {
                game_IMG_stones[i][t].setVisibility(View.INVISIBLE);
            }
        }

        for(int i = 0 ; i < numRows ; i++)
        {
            for(int j = 0 ; j < numCols ; j++)
            {
                game_IMG_coins[i][j].setVisibility(View.INVISIBLE);
            }
        }

        stoneObstacle();

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        acc_sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    private void findViews() {

        main_LBL_score = findViewById(R.id.main_LBL_score);

        main_IMG_heart1 = findViewById(R.id.main_IMG_heart1);
        main_IMG_heart2 = findViewById(R.id.main_IMG_heart2);
        main_IMG_heart3 = findViewById(R.id.main_IMG_heart3);

        main_IMG_car1 = findViewById(R.id.main_IMG_car1);
        main_IMG_car2 = findViewById(R.id.main_IMG_car2);
        main_IMG_car3 = findViewById(R.id.main_IMG_car3);
        main_IMG_car4 = findViewById(R.id.main_IMG_car4);
        main_IMG_car5 = findViewById(R.id.main_IMG_car5);

        main_IMG_stone1 = findViewById(R.id.main_IMG_stone1);
        main_IMG_stone2 = findViewById(R.id.main_IMG_stone2);
        main_IMG_stone3 = findViewById(R.id.main_IMG_stone3);
        main_IMG_stone4 = findViewById(R.id.main_IMG_stone4);
        main_IMG_stone5 = findViewById(R.id.main_IMG_stone5);
        main_IMG_stone6 = findViewById(R.id.main_IMG_stone6);
        main_IMG_stone7 = findViewById(R.id.main_IMG_stone7);
        main_IMG_stone8 = findViewById(R.id.main_IMG_stone8);
        main_IMG_stone9 = findViewById(R.id.main_IMG_stone9);
        main_IMG_stone10 = findViewById(R.id.main_IMG_stone10);
        main_IMG_stone11 = findViewById(R.id.main_IMG_stone11);
        main_IMG_stone12 = findViewById(R.id.main_IMG_stone12);
        main_IMG_stone13 = findViewById(R.id.main_IMG_stone13);
        main_IMG_stone14 = findViewById(R.id.main_IMG_stone14);
        main_IMG_stone15 = findViewById(R.id.main_IMG_stone15);
        main_IMG_stone16 = findViewById(R.id.main_IMG_stone16);
        main_IMG_stone17 = findViewById(R.id.main_IMG_stone17);
        main_IMG_stone18 = findViewById(R.id.main_IMG_stone18);
        main_IMG_stone19 = findViewById(R.id.main_IMG_stone19);
        main_IMG_stone20 = findViewById(R.id.main_IMG_stone20);

        main_IMG_coin1 = findViewById(R.id.main_IMG_coin1);
        main_IMG_coin2 = findViewById(R.id.main_IMG_coin2);
        main_IMG_coin3 = findViewById(R.id.main_IMG_coin3);
        main_IMG_coin4 = findViewById(R.id.main_IMG_coin4);
        main_IMG_coin5 = findViewById(R.id.main_IMG_coin5);
        main_IMG_coin6 = findViewById(R.id.main_IMG_coin6);
        main_IMG_coin7 = findViewById(R.id.main_IMG_coin7);
        main_IMG_coin8 = findViewById(R.id.main_IMG_coin8);
        main_IMG_coin9 = findViewById(R.id.main_IMG_coin9);
        main_IMG_coin10 = findViewById(R.id.main_IMG_coin10);
        main_IMG_coin11 = findViewById(R.id.main_IMG_coin11);
        main_IMG_coin12 = findViewById(R.id.main_IMG_coin12);
        main_IMG_coin13 = findViewById(R.id.main_IMG_coin13);
        main_IMG_coin14 = findViewById(R.id.main_IMG_coin14);
        main_IMG_coin15 = findViewById(R.id.main_IMG_coin15);
        main_IMG_coin16 = findViewById(R.id.main_IMG_coin16);
        main_IMG_coin17 = findViewById(R.id.main_IMG_coin17);
        main_IMG_coin18 = findViewById(R.id.main_IMG_coin18);
        main_IMG_coin19 = findViewById(R.id.main_IMG_coin19);
        main_IMG_coin20 = findViewById(R.id.main_IMG_coin20);

        game_IMG_coins = new ImageView[][]{
                {main_IMG_coin1, main_IMG_coin5, main_IMG_coin9 , main_IMG_coin13 , main_IMG_coin17},
                {main_IMG_coin2, main_IMG_coin6, main_IMG_coin10 , main_IMG_coin14 , main_IMG_coin18},
                {main_IMG_coin3, main_IMG_coin7, main_IMG_coin11 , main_IMG_coin15 , main_IMG_coin19},
                {main_IMG_coin4, main_IMG_coin8, main_IMG_coin12 , main_IMG_coin16 , main_IMG_coin20}
        };

        game_IMG_stones = new ImageView[][]{
                {main_IMG_stone1, main_IMG_stone5, main_IMG_stone9 , main_IMG_stone13 , main_IMG_stone17},
                {main_IMG_stone2, main_IMG_stone6, main_IMG_stone10 , main_IMG_stone14 , main_IMG_stone18},
                {main_IMG_stone3, main_IMG_stone7, main_IMG_stone11 , main_IMG_stone15 , main_IMG_stone19},
                {main_IMG_stone4, main_IMG_stone8, main_IMG_stone12 , main_IMG_stone16 , main_IMG_stone20}
        };

        game_IMG_car = new ImageView[]{
                main_IMG_car1,
                main_IMG_car2,
                main_IMG_car3,
                main_IMG_car4,
                main_IMG_car5
        };

        game_IMG_heart = new ImageView[]{
                main_IMG_heart3,
                main_IMG_heart2,
                main_IMG_heart1
        };
    }

    public void moveLeft() {
        game_IMG_car[gameManager.getCarLocation()-1].setVisibility(View.VISIBLE);
        for(int i = 0 ; i < numCols ; i++)
        {
            if(i != gameManager.getCarLocation()-1)
            {
                game_IMG_car[i].setVisibility(View.INVISIBLE);
            }
        }
        gameManager.changeCarLocation(gameManager.getCarLocation()-1);
    }

    public void moveRight() {
        game_IMG_car[gameManager.getCarLocation()+1].setVisibility(View.VISIBLE);
        for(int i = 0 ; i < numCols ; i++)
        {
            if(i != gameManager.getCarLocation()+1)
            {
                game_IMG_car[i].setVisibility(View.INVISIBLE);
            }
        }
        gameManager.changeCarLocation(gameManager.getCarLocation()+1);
    }

    public void stoneObstacle() {
        handler = new Handler();
        final int delay = 1000;

        handler.postDelayed(new Runnable() {
            public void run() {
                movingObjects(game_IMG_stones , 1);
                startingNewObjects(game_IMG_stones , 1);
                movingObjects(game_IMG_coins , 2);
                startingNewObjects(game_IMG_coins , 2);
                ifCollisionWithStone();
                ifCollisionWithCoin();
                handler.postDelayed(this, delay);
            }
        }, delay);

    }

    public void startingNewObjects(ImageView[][] arrObjects , int id) {
        Random r = new Random();
        int RndNum = r.nextInt(numCols);

        if(gameManager.getDataRoutes()[0][RndNum] == 0)
        {
            gameManager.getDataRoutes()[0][RndNum] = id;
            arrObjects[0][RndNum].setVisibility(View.VISIBLE);
        }
        else {
            startingNewObjects(arrObjects , id);
        }
    }

    public void movingObjects(ImageView[][] arrObjects , int id){
        for (int i = numRows-1 ; i >= 0 ; i--){
            for(int j = 0 ; j < numCols ; j++)
            {
                if (gameManager.getDataRoutes()[i][j] == id ){
                    if(i != numRows -1)
                    {
                        arrObjects[i][j].setVisibility(View.INVISIBLE);
                        gameManager.getDataRoutes()[i][j] = 0;
                        arrObjects[i+1][j].setVisibility(View.VISIBLE);
                        gameManager.getDataRoutes()[i+1][j] = id;
                    }
                    else
                    {
                        arrObjects[i][j].setVisibility(View.INVISIBLE);
                        gameManager.getDataRoutes()[i][j] = 0;
                    }
                }
            }
        }
    }

    void ifCollisionWithStone(){
        for(int j = 0 ; j < numCols ; j++){
            if(gameManager.getDataRoutes()[numRows-1][j] == 1 && gameManager.getCarLocation() == j){
                gameManager.missingCounterLives();
                game_IMG_heart[gameManager.getLives()].setVisibility(View.INVISIBLE);

                new BackgroundSound();

                Toast.makeText(this , "Oops , collision" , Toast.LENGTH_LONG).show();

                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {

                    v.vibrate(500);
                }
            }
        }

        if(gameManager.getLives() == 0 )
        {
            Toast.makeText(this, "Game over", Toast.LENGTH_LONG).show();
            Intent gameIntent = new Intent(this, activityMenu.class);
            startActivity(gameIntent);
        }
    }

    public void ifCollisionWithCoin(){
        for(int j = 0 ; j < numCols ; j++) {
            if (gameManager.getDataRoutes()[numRows - 1][j] == 2 && gameManager.getCarLocation() == j) {
                gameManager.changeScore(10);
                main_LBL_score.setText("" + gameManager.getScore());
            }
        }
    }

    private SensorEventListener accSensorEventListener = new SensorEventListener(){
        int step = 0;
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];

            if(x > 0.2){
                if (System.currentTimeMillis() - timeStamp > 500) {
                    timeStamp = System.currentTimeMillis();
                    if(step <= 2 && step > -2) {
                        moveLeft();
                        step--;
                        Log.d("pttt" , "step=" + step);
                    }
                }
            }

            if(x < 0){
                if (System.currentTimeMillis() - timeStamp > 500) {
                    timeStamp = System.currentTimeMillis();
                    if(step < 2 && step >= -2) {
                        moveRight();
                        step++;
                        Log.d("pttt" , "step=" + step);
                    }
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
            Log.d("pttt" , "onAccuracyChanged");
        }
    };

    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(accSensorEventListener , acc_sensor , SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(accSensorEventListener);
    }

    public class BackgroundSound extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            MediaPlayer player = MediaPlayer.create(activitySensors.this, R.raw.msc_explosion_sound);
            player.setLooping(true); // Set looping
            player.setVolume(1.0f, 1.0f);
            player.start();

            return null;
        }
    }

    protected void onStop(){
        super.onStop();

        handler.removeMessages(0);

        int score = MySPV3.getInstance().getInt(SP_KEY_SCORE, gameManager.getScore());
        MySPV3.getInstance().putInt("MY_DB", gameManager.getScore());
        DataRecord.addRecord(2 , score);

        Intent gameIntent = new Intent(this, activityMenu.class);
        startActivity(gameIntent);
    }
}