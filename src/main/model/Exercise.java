package model;

import java.util.ArrayList;

public abstract class Exercise {


    protected String name;


    //EFFECTS - Creates a new exercise object with given name.
    public Exercise(String name) {
        this.name = name;
    }



    //Effects - Returns the name of the Exercise.
    public String getExerciseName() {
        return this.name;
    }

}
