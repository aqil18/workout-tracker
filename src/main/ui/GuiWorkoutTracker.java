package ui;


import ui.gui.workout.WorkoutUi;

// GUI Workout Tracker application
public class GuiWorkoutTracker extends WorkoutTracker {

    //EFFECTS - Starts the workout tracker by running the setup and run methods
    public GuiWorkoutTracker() {
        setup();
        new WorkoutUi(this);
    }




}



