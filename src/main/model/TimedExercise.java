package model;

public class TimedExercise extends Exercise {

    private int time;

    //EFFECTS - creates a Timed exercise with a given name and time
    public TimedExercise(String name, int time) {
        super(name);
        this.time = time;
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
