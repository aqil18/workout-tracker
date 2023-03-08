package model;

import exceptions.NonPositiveException;
import org.json.JSONObject;

// Represents a WeightedExercise as an Exercise with reps and weight
public class WeightedExercise extends Exercise {

    private int weight;
    private int reps;

    //EFFECTS - Creates a Weighted exercise with a given name, weight and reps
    public WeightedExercise(String name, int weight, int reps) throws NonPositiveException {
        super(name);
        setWeight(weight);
        setReps(reps);
    }

    //MODIFIES - This
    //EFFECTS - Edits the weight field
    public void setWeight(int weight) throws NonPositiveException {
        if (weight > 0) {
            this.weight = weight;
        } else {
            throw new NonPositiveException();
        }
    }

    //MODIFIES - This
    //EFFECTS - Edits the reps field
    public void setReps(int reps) throws NonPositiveException {
        if (reps > 0) {
            this.reps = reps;
        } else {
            throw new NonPositiveException();
        }

    }

    //EFFECTS - Returns the weight
    public int getWeight() {
        return weight;
    }

    //EFFECTS - Returns the reps
    public int getReps() {
        return reps;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("weight", weight);
        json.put("reps", reps);
        return json;
    }

}
