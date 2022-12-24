package com.example.obstaclegame;

import java.util.ArrayList;

public class GameManager {

    private int carLocation = 2;
    private int lives = 3;
    private int[][] data_routes;
    private int score;
    private ArrayList <RecordLine> recordLines;

    public GameManager() {
        data_routes = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        recordLines = new ArrayList<>();
    }

    public int[][] getDataRoutes() {
        return data_routes;
    }

    public void changeCarLocation(int carLoc) {
        carLocation = carLoc;
    }

    public int getCarLocation() {
        return carLocation;
    }

    public int getLives() {
        return lives;
    }

    public void changeScore(int num)
    {
        score = score + num;
    }

    public int getScore(){
        return score;
    }

    public void missingCounterLives() {
        lives--;
    }


}