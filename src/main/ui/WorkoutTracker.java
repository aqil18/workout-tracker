package ui;


import exceptions.NonPositiveException;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;


public class WorkoutTracker {


    WorkoutCollection collection;
    Scanner input;


    public WorkoutTracker() {
        setup();
        run();
    }


    private void run() {
        boolean isRunning = true;
        System.out.println("Welcome to The Workout Tracker!\n");


        while (isRunning) {
            displayCollectionMenu();
            String process = input.next();

            if (process.equals("quit")) {
                isRunning = false;
            } else {
                processMainMenu(process);
            }
        }
    }

    //EFFECTS - Processes the main menu actions between adding, deleting, editing, viewing and rating a workout from
    //          the collection.
    private void processMainMenu(String string) {

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
                System.out.println("Number out of 5 to rate: ");
                int rating = input.nextInt();
                rateWorkout.rateWorkout(rating);
                break;
            case "view":
                displayWorkouts();
                break;
        }

    }


    //REQUIRES - Non-zero length string and no spaces in between words from user input
    //EFFECTS - Creates and returns new workout with a given name
    private Workout newWorkout() {
        System.out.println("Name of new workout: ");
        String addName = input.next();
        return new Workout(addName);
    }

    //REQUIRES - A user input that matches the index number of a workout shown
    //EFFECTS - Returns a workout in the collection based on user input
    private Workout getUserWorkout(String use) {
        displayWorkouts();
        System.out.println("Number of workout to " + use + ": ");
        int index = input.nextInt() - 1;
        return collection.getWorkout(index);
    }


    //REQUIRES - Non-zero size workout collection
    //EFFECTS - Edit a given workout with adding, deleting or editing exercise
    private void processEditWorkoutMenu(Workout workout) {
        displayWorkoutMenu();
        switch (input.next()) {
            case "add":
                workout.addExercise(newExercise());
                break;
            case "delete":
                workout.deleteExercise(getUserExercise("delete", workout));
                break;
            case "edit":
                Exercise editExercise = getUserExercise("edit", workout);
                if (editExercise instanceof WeightedExercise) {
                    processEditWeightedExerciseMenu((WeightedExercise) editExercise);
                } else {
                    processEditTimedExerciseMenu((TimedExercise) editExercise);
                }

                break;
            case "view":
                displayExercises(workout);
                break;
        }

    }

    //REQUIRES - Correct user input
    //EFFECTS - Creates a new weighted or timed exercise with a respective name and fields
    private Exercise newExercise() {
        System.out.println("Name of new exercise: ");
        String addName = input.next();
        System.out.println("Type 'Weighted' if it is a weighted exercise and 'Timed' if it is a timed exercise");
        String type = input.next();
        Exercise exercise;
        if (type.equals("weighted")) {
            exercise = newWeightedExercise(addName);
        } else {
            exercise = newTimedExercise(addName);
        }
        return exercise;
    }


    private Exercise newWeightedExercise(String addName) {
        System.out.println("Type in the weight in kg of the exercise: ");
        int weight = input.nextInt();
        System.out.println("Type in the number of reps of the exercise: ");
        int reps = input.nextInt();
        Exercise exercise = null;
        try {
            exercise = new WeightedExercise(addName, weight, reps);
        } catch (NonPositiveException e) {
            System.out.println("Invalid non positive input! Fields have not been set.");
        }
        return exercise;
    }

    private Exercise newTimedExercise(String addName) {
        System.out.println("Type in the length in minutes of the exercise: ");
        int time = input.nextInt();
        Exercise exercise = null;
        try {
            exercise = new TimedExercise(addName, time);
        } catch (NonPositiveException e) {
            System.out.println("Invalid non positive input! Field has not been set.");
        }
        return exercise;
    }






    //REQUIRES - A user input that matches the index number of an exercise shown
    //EFFECTS - Returns an exercise in the selected workout based on user input
    private Exercise getUserExercise(String use, Workout workout) {
        displayExercises(workout);
        System.out.println("Number of exercise to " + use + ": ");
        int index = input.nextInt() - 1;
        return workout.getExercise(index);
    }


    //REQUIRES - Non-zero size exercise list
    //EFFECTS - Edit a given exercise fields
    private void processEditWeightedExerciseMenu(WeightedExercise exercise) {
        displayExerciseMenu("weighted");
        if (input.next().equals("weight")) {
            System.out.println("New weight: ");
            int newWeight = input.nextInt();
            try {
                exercise.setWeight(newWeight);
            } catch (NonPositiveException e) {
                System.out.println("Invalid non positive weight! Weight has not been set.");
            }
        } else if (input.next().equals("reps")) {
            System.out.println("New reps: ");
            int newReps = input.nextInt();
            try {
                exercise.setReps(newReps);
            } catch (NonPositiveException e) {
                System.out.println("Invalid non positive Reps! Reps has not been set.");
            }
        }
    }

    //REQUIRES - Non-zero size exercise list
    //EFFECTS - Edits a given exercise fields
    private void processEditTimedExerciseMenu(TimedExercise exercise) {
        displayExerciseMenu("timed");
        if (input.next().equals("time")) {
            System.out.println("New time: ");
            int newTime = input.nextInt();
            try {
                exercise.setTime(newTime);
            } catch (NonPositiveException e) {
                System.out.println("Invalid non positive time! Time has not been set.");
            }
        }
    }


    //EFFECTS - Displays all workouts in a collection for the user to select from
    private void displayWorkouts() {
        ArrayList<Workout> workoutList = collection.getWorkouts();
        for (Workout w : workoutList) {
            int index = workoutList.indexOf(w) + 1;
            System.out.println(index + ". " + w.getWorkoutName());
        }
    }


    //EFFECTS - Displays all exercises in a workout for the user to select from
    private void displayExercises(Workout w) {
        ArrayList<Exercise> exerciseList = w.getExercises();
        for (Exercise e : exerciseList) {
            int index = exerciseList.indexOf(e) + 1;
            System.out.println(index + ". " + e.getExerciseName());
        }
    }

    //EFFECTS - Displays the operations that can be completed on a workout collection
    private void displayCollectionMenu() {
        String line = "Select an option below by typing it in.\n "
                + "'Add' to add a new workout.\n "
                + "'Delete' to delete a workout.\n "
                + "'Edit' to edit a workout.\n "
                + "'Rate' to rate a workout. \n "
                + "'View' to view all workouts.\n "
                + "'Quit' to quit the workout tracker.\n ";
        System.out.println(line);
    }

    //EFFECTS - Displays the operations that can be completed on a workout
    private void displayWorkoutMenu() {
        String line = "Select an option below by typing it in.\n "
                + "'Add' to add a new exercise.\n "
                + "'Delete' to delete a exercise.\n "
                + "'Edit' to edit a exercise.\n "
                + "'View' to view all exercises.\n ";
        System.out.println(line);
    }

    //REQUIRES - Correct user input
    //EFFECTS - Displays the operations that can be completed on an exercise
    private void displayExerciseMenu(String type) {
        System.out.println("Select an option below by typing it in.\n ");
        String line;
        if (type.equals("weighted")) {
            line = "'Reps' to change the reps of the exercise.\n "
                    + "'Weight' to change the weight of the exercise.\n ";
        } else {
            line = "'Time' to change the length of the exercise.\n ";
        }
        System.out.println(line);
    }

    //EFFECTS - Initializes workout tracker
    private void setup() {
        input = new Scanner(System.in);
        collection = new WorkoutCollection();
    }


}
