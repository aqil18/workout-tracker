package ui;

import model.Workout;

import java.util.Scanner;

public class WorkoutTracker {


    Scanner input;


    public WorkoutTracker() {
        setup();
        run();
    }



    private  void run() {
        Boolean isRunning = true;

        while (isRunning) {
            if (input.nextLine() == "Quit") {
                isRunning = false;
            } else {
                processMenu();
            }
        }

    }


    public void processMenu() {
        displayMainMenu();
        switch (input.nextLine()) {
            case "add":
                String name = input.nextLine();
                Workout w = new Workout(name);
            case "view":
                System.out.println("No workouts to show here.");
        }
    }


    private void displayMainMenu() {
        System.out.println("Welcome to The Workout Tracker \n Type add to add a new workout or quit.");
    }




    private void setup() {
        input = new Scanner(System.in);
    }




}
