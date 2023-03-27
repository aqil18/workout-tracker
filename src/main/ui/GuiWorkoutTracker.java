package ui;


import ui.gui.HomeUi;


public class GuiWorkoutTracker extends WorkoutTracker {


    public GuiWorkoutTracker() {
        setup();
        new HomeUi(this);
    }




}



