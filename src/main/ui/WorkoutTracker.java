package ui;


import model.*;

import java.util.ArrayList;
import java.util.Scanner;
import exceptions.EmptyWorkoutListException;
import exceptions.EmptyExercsieListException;


public class WorkoutTracker {


    WorkoutCollection collection;
    Scanner input;


    public WorkoutTracker() {
        setup();
        run();
    }



    private  void run() {
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
    private void processMainMenu(String string)  {
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
                    System.out.println("Number out of 5 to rate: ");
                    int rating = input.nextInt();
                    rateWorkout.rateWorkout(rating);
                    break;
                case "view":
                    displayWorkouts();
                    break;
            }
        } catch (EmptyWorkoutListException e) {
            System.out.println("Workout list is empty!\n ");
        }
    }

    private Workout newWorkout() {
        System.out.println("Name of new workout: ");
        String addName = input.next();
        return new Workout(addName);
    }

    private Workout getUserWorkout(String use) throws EmptyWorkoutListException {
        displayWorkouts();
        System.out.println("Number of workout to " + use + ": ");
        int index = input.nextInt() - 1;
        return collection.getWorkout(index);
    }




    //REQUIRES - Non-zero size workout collection
    //EFFECTS - Edit a given workout with adding, deleting or editing exercise
    private void processEditWorkoutMenu(Workout workout) {
        displayWorkoutMenu();
        try {
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
        } catch (EmptyExercsieListException e) {
            System.out.print("Exercise list is empty!\n\n");
        }
    }

    //REQUIRES - Correct user input between timed and weighted
    private Exercise newExercise() {
        System.out.println("Name of new exercise: ");
        String addName = input.next();
        System.out.println("Type 'Weighted' if it is a weighted exercise and 'Timed' if it is a timed exercise");
        String type = input.next();
        if (type.equals("weighted")) {
            return new WeightedExercise(addName);
        } else {
            return new TimedExercise(addName);
        }

    }


    private Exercise getUserExercise(String use, Workout workout) throws EmptyExercsieListException {
        displayExercises(workout);
        System.out.println("Number of exercise to " + use + ": ");
        int index = input.nextInt() - 1;
        return workout.getExercise(index);
    }



    //REQUIRES - Non-zero size exercise list and correct user input.
    //EFFECTS - Edit a given exercise fields
    private void processEditWeightedExerciseMenu(WeightedExercise exercise) {
        displayExerciseMenu("weighted");
        if (input.next().equals("weight")) {
            System.out.println("New weight: ");
            int newWeight = input.nextInt();
            exercise.setWeight(newWeight);
        } else if (input.next().equals("reps")) {
            System.out.println("New reps: ");
            int newReps = input.nextInt();
            exercise.setReps(newReps);
        }
    }

    private void processEditTimedExerciseMenu(TimedExercise exercise) {
        displayExerciseMenu("timed");
        if (input.next().equals("time")) {
            System.out.println("New time: ");
            int newTime = input.nextInt();
            exercise.setTime(newTime);
        }
    }



    //EFFECTS - Displays all workouts in a collection for the user to select from
    private void displayWorkouts() throws EmptyWorkoutListException {
        ArrayList<Workout> workoutList = collection.getWorkouts();
        if (workoutList.size() == 0) {
            throw new EmptyWorkoutListException();
        } else {
            for (Workout w : workoutList) {
                int index = workoutList.indexOf(w) + 1;
                System.out.println(index + ". " + w.getWorkoutName());
            }
        }

    }

    //EFFECTS - Displays all exercises in a workout for the user to select from
    private void displayExercises(Workout w) throws EmptyExercsieListException {
        ArrayList<Exercise> exerciseList = w.getExercises();
        if (exerciseList.size() == 0) {
            throw new EmptyExercsieListException();
        } else {
            for (Exercise e : exerciseList) {
                int index = exerciseList.indexOf(e) + 1;
                System.out.println(index + ". " + e.getExerciseName());
            }
        }
    }




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

    private void displayWorkoutMenu() {
        String line = "Select an option below by typing it in.\n "
                + "'Add' to add a new exercise.\n "
                + "'Delete' to delete a exercise.\n "
                + "'Edit' to edit a exercise.\n "
                + "'View' to view all exercises.\n ";
        System.out.println(line);
    }



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



    private void setup() {
        input = new Scanner(System.in);
        collection = new WorkoutCollection();
    }




}
