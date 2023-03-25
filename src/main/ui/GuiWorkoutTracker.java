package ui;

import model.WorkoutCollection;
import ui.gui.AddWorkoutUi;
import ui.gui.HomeUi;
import ui.gui.ViewWorkoutsUI;

public class GuiWorkoutTracker extends WorkoutTracker {


    public GuiWorkoutTracker() {
        setup();
        new HomeUi(this);
    }




}



