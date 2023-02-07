package model;

import java.util.ArrayList;

public class Exercise {


    private String name;
    private int time;
    private int weight;
    private int reps;



    public Exercise(String name, int weight, int reps) {
        this.name = name;
        this.weight = weight;
        this.reps = reps;
    }

    public Exercise(String name, int time) {
        this.name = name;
        this.time = time;
    }


    private void  editTime(int time) {
        this.time = time;
    }


}
