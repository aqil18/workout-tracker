package ui;


import exceptions.EmptyExerciseList;
import exceptions.EmptyWorkoutList;
import exceptions.NonPositiveException;
import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Workout Tracker application
public class ConsoleWorkoutTracker extends WorkoutTracker {

    Scanner input = new Scanner(System.in);

    //EFFECTS - Starts the workout tracker by running the setup and run methods
    public ConsoleWorkoutTracker() {
        setup();
        runConsoleApp();
    }



    //EFFECTS - Initiates the processing loop
    private void runConsoleApp() {
        boolean isRunning = true;
        System.out.println("Welcome to The Workout Tracker!");


        while (isRunning) {
            displayCollectionMenu();
            String process = input.next().toLowerCase();

            switch (process) {
                case "quit":
                    isRunning = false;
                    break;
                case "load":
                    loadWorkoutCollection();
                    break;
                case "save":
                    saveWorkoutCollection();
                    break;
                default:
                    processCollectionMenu(process);
                    break;
            }
        }
        System.out.println("Thank you for using The Workout Tracker!");
    }


    //EFFECTS - Processes the main menu actions between adding, deleting, editing, rating and viewing workouts from
    //          the collection.
    private void processCollectionMenu(String string) {
        try {
            switch (string) {
                case "add":
                    collection.addWorkout(newWorkout());
                    break;
                case "delete":
                    collection.deleteWorkout(getUserWorkout("delete"));
                    break;
                case "edit":
                    processEditWorkoutMenu(getUserWorkout("edit"));
                    break;
                case "rate":
                    Workout rateWorkout = getUserWorkout("rate");
                    rateWorkout(rateWorkout);
                    break;
                case "view":
                    displayWorkouts();
                    break;
            }
        } catch (EmptyWorkoutList e) {
            System.out.println("Empty workout list!");
        }
    }


    //REQUIRES - addName.length > 0
    //EFFECTS - Creates and returns new workout with a given name
    private Workout newWorkout() {
        System.out.println("Name of new workout: ");
        String addName = input.next();
        System.out.println("Rating of workout out of 5: ");
        int rating = input.nextInt();
        System.out.println("Your workout " + addName + " has been created.");
        return new Workout(addName, rating);
    }

    //REQUIRES - 0 < index <  collection.workouts.length()
    //EFFECTS - Returns a workout in the collection based on user input
    private Workout getUserWorkout(String use) throws EmptyWorkoutList {
        displayWorkouts();
        System.out.println("Number of workout to " + use + ": ");
        int index = input.nextInt() - 1;
        return collection.getWorkout(index);

    }

    //EFFECTS - Rates workout based on user input
    private void rateWorkout(Workout rateWorkout) {
        System.out.println("Number out of 5 to rate: ");
        int rating = input.nextInt();
        rateWorkout.rateWorkout(rating);
    }


    //EFFECTS - Processes the edit workout menu actions between adding, deleting, editing and viewing exercises from
    //          the workout.
    private void processEditWorkoutMenu(Workout workout) {
        displayWorkoutMenu();
        try {
            switch (input.next().toLowerCase()) {
                case "add":
                    workout.addExercise(newExercise());
                    break;
                case "delete":
                    workout.deleteExercise(getUserExercise("delete", workout));
                    break;
                case "edit":
                    Exercise editExercise = getUserExercise("edit", workout);
                    processEditExercise(editExercise);
                    break;
                case "view":
                    displayExercises(workout);
                    break;
            }
        } catch (EmptyExerciseList e) {
            System.out.println("Empty exercise list!");
        }
    }

    //REQUIRES - addName.length() > 0
    //EFFECTS -  Returns a new weighted or timed exercise with a given name and fields
    private Exercise newExercise() {
        System.out.println("Name of new exercise: ");
        String addName = input.next();
        System.out.println("Type 'Weighted' if it is a weighted exercise and 'Timed' if it is a timed exercise");
        String type = input.next().toLowerCase();
        Exercise exercise;
        if (type.equals("weighted")) {
            exercise = newWeightedExercise(addName);
        } else {
            exercise = newTimedExercise(addName);
        }
        return exercise;
    }

    //EFFECTS - Creates and returns a new weighted exercise with a given name and fields.
    private Exercise newWeightedExercise(String addName) {
        System.out.println("Type in the weight in kg of the exercise: ");
        int weight = input.nextInt();
        System.out.println("Type in the number of reps of the exercise: ");
        int reps = input.nextInt();
        Exercise exercise = null;
        try {
            exercise = new WeightedExercise(addName, weight, reps);
            System.out.println("Your new weighted exercise " + addName + " has been created.");
        } catch (NonPositiveException e) {
            System.out.println("Invalid non positive input! " + addName + " has not been created.");
        }
        return exercise;
    }

    //EFFECTS - Creates and returns a new timed exercise with a given name and fields.
    private Exercise newTimedExercise(String addName) {
        System.out.println("Type in the length in minutes of the exercise: ");
        int time = input.nextInt();
        Exercise exercise = null;
        try {
            exercise = new TimedExercise(addName, time);
            System.out.println("Your new timed exercise " + addName + " has been created.");

        } catch (NonPositiveException e) {
            System.out.println("Invalid non positive input! " + addName + " has not been created.");
        }
        return exercise;
    }

    //REQUIRES - 0 < index <  workout.exercises.length()
    //EFFECTS - Returns an exercise in the selected workout based on user input
    private Exercise getUserExercise(String use, Workout workout) throws EmptyExerciseList {
        displayExercises(workout);
        System.out.println("Number of exercise to " + use + ": ");
        int index = input.nextInt() - 1;
        return workout.getExercise(index);
    }

    //EFFECTS - Edits exercise based on whether it is weighted or timed
    private void processEditExercise(Exercise exercise) {
        if (exercise instanceof WeightedExercise) {
            processEditWeightedExerciseMenu((WeightedExercise) exercise);
        } else {
            processEditTimedExerciseMenu((TimedExercise) exercise);
        }
    }


    //EFFECTS - Processes the edit weighted exercise menu actions between changing reps and weight for weighted
    //          exercises
    private void processEditWeightedExerciseMenu(WeightedExercise exercise) {
        displayExerciseMenu("weighted");
        String process = input.next().toLowerCase();
        if (process.equals("weight")) {
            System.out.println("New weight: ");
            int newWeight = input.nextInt();
            try {
                exercise.setWeight(newWeight);
            } catch (NonPositiveException e) {
                System.out.println("Invalid non positive weight! Weight has not been set.");
            }
        } else if (process.equals("reps")) {
            System.out.println("New reps: ");
            int newReps = input.nextInt();
            try {
                exercise.setReps(newReps);
            } catch (NonPositiveException e) {
                System.out.println("Invalid non positive Reps! Reps has not been set.");
            }
        }
    }

    //EFFECTS - Processes the edit timed exercise menu actions to change time for timed exercises
    private void processEditTimedExerciseMenu(TimedExercise exercise) {
        displayExerciseMenu("timed");
        if (input.next().equalsIgnoreCase("time")) {
            System.out.println("New time: ");
            int newTime = input.nextInt();
            try {
                exercise.setTime(newTime);
            } catch (NonPositiveException e) {
                System.out.println("Invalid non positive time! Time has not been set.");
            }
        }
    }

    //EFFECTS - Displays all workouts and respective rating in a collection for the user to select from
    private void displayWorkouts() throws EmptyWorkoutList {
        ArrayList<Workout> workoutList = collection.getWorkouts();
        for (Workout w : workoutList) {
            int index = workoutList.indexOf(w) + 1;
            System.out.println(index + ". " + w.getWorkoutName() + "  Rating: " + w.getRating() + "/5");
        }

    }

    //EFFECTS - Displays all exercises and respective fields in a workout for the user to select from
    private void displayExercises(Workout w) throws EmptyExerciseList {
        ArrayList<Exercise> exerciseList = w.getExercises();
        for (Exercise e : exerciseList) {
            int index = exerciseList.indexOf(e) + 1;
            if (e instanceof WeightedExercise) {
                int reps = ((WeightedExercise) e).getReps();
                int weight = ((WeightedExercise) e).getWeight();
                System.out.println(index + ". " + e.getExerciseName()
                        + "\n   Weight: " + weight + " Reps: " + reps);
            } else {
                int time = ((TimedExercise) e).getTime();
                System.out.println(index + ". " + e.getExerciseName() + "\n   Time: " + time);
            }

        }

    }

    //EFFECTS - Displays the operations that can be completed on a workout collection
    private void displayCollectionMenu() {
        String line = "\nSelect an option below by typing it in.\n "
                + "'Add' to add a new workout.\n "
                + "'Delete' to delete a workout.\n "
                + "'Edit' to edit a workout.\n "
                + "'Rate' to rate a workout. \n "
                + "'View' to view all workouts.\n "
                + "'Load' previous workout collection.\n "
                + "'Save' current workout collection.\n "
                + "'Quit' to quit the workout tracker.\n ";
        System.out.println(line);
    }

    //EFFECTS - Displays the operations that can be completed on a workout
    private void displayWorkoutMenu() {
        String line = "\nSelect an option below by typing it in.\n "
                + "'Add' to add a new exercise.\n "
                + "'Delete' to delete a exercise.\n "
                + "'Edit' to edit a exercise.\n "
                + "'View' to view all exercises.\n ";
        System.out.println(line);
    }

    //EFFECTS - Displays the operations that can be completed on an exercise
    private void displayExerciseMenu(String type) {
        System.out.println("\nSelect an option below by typing it in.\n ");
        String line;
        if (type.equals("weighted")) {
            line = "'Reps' to change the reps of the exercise.\n"
                    + "'Weight' to change the weight of the exercise.\n ";
        } else {
            line = "'Time' to change the length of the exercise.\n ";
        }
        System.out.println(line);
    }





}
