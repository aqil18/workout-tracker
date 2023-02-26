package model;

import java.util.ArrayList;

public class Workout {
    private ArrayList<Exercise> exercises;
    private String name;
    private int rating;



    //EFFECTS - Creates an empty list of exercises with a name
    public Workout(String name) {
        this.name = name;
        this.exercises = new ArrayList<>();
        System.out.println("Your workout " + name + " has been created.");
    }


    //MODIFIES - This.
    //EFFECTS - Adds given exercise to the workout list
    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }


    //MODIFIES - This.
    //EFFECTS - Deletes the exercise in the given index from the workout list
    public void deleteExercise(Exercise exercise) {
        this.exercises.remove(exercise);
    }


    //MODIFIES - This.
    //EFFECTS - Returns all exercises in the workout list
    public ArrayList<Exercise> viewExercises() {
        return exercises;
    }



    //M
    public void rateWorkout(int rating) {
        this.rating = rating;
    }

    public Exercise getExercise(int index) {
        return this.exercises.get(index);
    }

    public String getWorkoutName() {
        return name;
    }


}
