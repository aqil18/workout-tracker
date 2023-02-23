package model;

import java.util.ArrayList;

public class WorkoutCollection {

    ArrayList<Workout> workouts;


    public WorkoutCollection() {
        this.workouts = new ArrayList<>();
    }



    //MODIFIES - This.
    //EFFECTS - Adds given workout to the workout list
    public void addWorkout(Workout workout) {
        this.workouts.add(workout);
    }


    //MODIFIES - This.
    //EFFECTS - Deletes the workout in the given index from the workout list
    public void deleteWorkout() {

    }


    //MODIFIES - This.
    //EFFECTS - Edits the workout in the given index from the workout list
    public void editWorkout() {

    }


    //MODIFIES - This.
    //EFFECTS - Returns all exercises in the workout list
    public ArrayList<Workout> viewWorkouts() {
        return this.workouts;
    }



}
