package ui;


import ui.gui.workout.WorkoutUi;


public class GuiWorkoutTracker extends WorkoutTracker {


    public GuiWorkoutTracker() {
        setup();
        new WorkoutUi(this);
    }




}



