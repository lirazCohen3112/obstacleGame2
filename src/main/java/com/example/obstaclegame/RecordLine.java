package com.example.obstaclegame;

public class RecordLine {

   // private String name;
    private int num;
    private int score;

    public RecordLine(int num , int score ){
        this.num = num;
        this.score = score;
        // this.name = name;
    }

    public int getNum (){
        return num;
    }

    public void setNum (int num){
        this.num = num;
    }

    public int getScore (){
        return score;
    }

    public void setScore (int score){
        this.score = score;
    }

   // public String setName (){
 //       return name;
//    }

  //  public void setName (String name){
 //       this.name = name;
 //   }
}
