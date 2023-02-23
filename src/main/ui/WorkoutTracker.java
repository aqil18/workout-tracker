package ui;

import model.Exercise;
import model.WeightedExercise;
import model.Workout;
import model.WorkoutCollection;

import java.util.ArrayList;
import java.util.Scanner;

public class WorkoutTracker {


    WorkoutCollection collection;
    Scanner input;


    public WorkoutTracker() {
        setup();
        run();
    }



    private  void run() {
        Boolean isRunning = true;

        while (isRunning) {
            if (input.nextLine() == "quit") {
                isRunning = false;
            } else {
                processMainMenu();
            }
        }

    }

    //EFFECTS - Processes the main menu actions between adding, deleting, editing, viewing and rating a workout
    private void processMainMenu() {
        displayMainMenu();
        switch (input.nextLine()) {
            case "add":
                String name = input.nextLine();
                Workout w = new Workout(name);
                collection.addWorkout(w);
            case "view":
                displayWorkouts();

        }
    }





    //EFFECTS - Edit a given exercise fields
    private void processEditExerciseMenu() {
        switch (input.nextLine()) {
            case "weight":

            case "reps":

        }
    }

    //EFFECTS - Edit a given workout with adding, deleting or editing exercise
    private void processEditWorkoutMenu(Workout workout) {
        switch (input.nextLine()) {
            case "add":
                String name = input.nextLine();
                Exercise e = new WeightedExercise(name);
                workout.addExercise(e);
            case "view":
                displayExercises(workout);
        }
    }


    //EFFECTS - Displays all workouts in a collection for the user to select from
    private void displayWorkouts() {
        ArrayList<Workout> workoutList = collection.viewWorkouts();

        for (Workout w : workoutList) {
            System.out.println(workoutList.indexOf(w) + ". " + w.getWorkoutName());
        }
    }

    //EFFECTS - Displays all exercises in a workout for the user to select from
    private void displayExercises(Workout w) {
        ArrayList<Exercise> exerciseList = w.viewExercises();

        for (Exercise e : exerciseList) {
            System.out.println(exerciseList.indexOf(e) + ". " + e.getExerciseName());
        }
    }






    private void displayMainMenu() {
        System.out.println("Welcome to The Workout Tracker \n Type add to add a new workout or quit.");
    }




    private void setup() {
        input = new Scanner(System.in);
        collection = new WorkoutCollection();

    }




}
