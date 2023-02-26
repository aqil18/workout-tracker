package model;

import java.util.ArrayList;

public class WorkoutCollection {

    private ArrayList<Workout> workouts;


    public WorkoutCollection() {
        this.workouts = new ArrayList<>();
    }



    //MODIFIES - This.
    //EFFECTS - Adds given workout to the workout collection
    public void addWorkout(Workout workout) {
        this.workouts.add(workout);
    }


    //MODIFIES - This.
    //EFFECTS - Deletes the workout in the given index from the workout collection
    public void deleteWorkout(Workout workout) {
        this.workouts.remove(workout);
    }




    //EFFECTS - Returns all workouts in the workout collection
    public ArrayList<Workout> viewWorkouts() {
        return this.workouts;
    }


    //EFFECTS - Returns the workout at the index i in the workout collection
    public Workout getWorkout(int index) {
        return this.workouts.get(index);
    }
}
