package model;

public class TimedExercise extends Exercise {

    private int time;

    //EFFECTS - creates a Timed exercise with the given name
    public TimedExercise(String name) {
        super(name);
    }


    //MODIFIES - This
    //EFFECTS - Edits the time field
    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

}
