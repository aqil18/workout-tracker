package model;

public class TimedExercise extends Exercise {

    private int time;

    //EFFECTS creates a Timed exercise with given name.
    public TimedExercise(String name) {
        super(name);
    }

    //EFFECTS - Edits the time field
    public void editTime(int time) {
        this.time = time;
    }



}
