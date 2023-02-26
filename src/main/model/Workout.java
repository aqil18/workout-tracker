package model;

import java.util.ArrayList;
import java.util.Collections;

public class Workout {
    private ArrayList<Exercise> exercises;
    private String name;
    private int rating;



    //EFFECTS - Creates an empty list of exercises with a given name
    public Workout(String name) {
        this.name = name;
        this.exercises = new ArrayList<>();
        System.out.println("Your workout " + name + " has been created.");
    }


    //MODIFIES - This
    //EFFECTS - Adds given exercise to the workout list
    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }


    //MODIFIES - This
    //EFFECTS - Deletes all instances of the given exercise from the workout list
    public void deleteExercise(Exercise exercise) {
        this.exercises.removeAll(Collections.singleton(exercise));
    }

    //MODIFIES - This
    //EFFECTS - Adds a rating to the workout
    public void rateWorkout(int rating) {
        this.rating = rating;
    }

    //EFFECTS - Returns all exercises in the workout list
    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    //EFFECTS - Returns the exercise at the given index
    public Exercise getExercise(int index) {
        return this.exercises.get(index);
    }

    //EFFECTS - Returns the workout name
    public String getWorkoutName() {
        return name;
    }

    public Integer getRating() {
        return rating;
    }


}
