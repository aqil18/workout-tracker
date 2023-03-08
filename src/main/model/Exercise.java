package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents an Exercise having a name
public abstract class Exercise implements Writable {


    protected String name;


    //EFFECTS - Creates a new exercise object with given name.
    public Exercise(String name) {
        this.name = name;
    }

    //EFFECTS - Returns the name of the Exercise.
    public String getExerciseName() {
        return this.name;
    }

    // EFFECTS: returns string representation of this thingy
    public String toString() {
        return category + ": " + name;
    }


    @Override
    public abstract JSONObject toJson();

}
