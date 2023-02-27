package model;

import exceptions.NonPositiveException;

// Represents a TimedExercise as an Exercise with time
public class TimedExercise extends Exercise {

    private int time;

    //EFFECTS - creates a Timed exercise with a given name and time
    public TimedExercise(String name, int time) throws NonPositiveException {
        super(name);
        setTime(time);
    }


    //MODIFIES - This
    //EFFECTS - Edits the time field
    public void setTime(int time) throws NonPositiveException {
        if (time > 0) {
            this.time = time;
        } else {
            throw new NonPositiveException();
        }
    }

    public int getTime() {
        return time;
    }

}
