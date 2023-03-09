package model;

import exceptions.NonPositiveException;
import org.json.JSONObject;

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

    //EFFECTS - Returns the time field
    public int getTime() {
        return time;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("time", time);
        return json;
    }
}
