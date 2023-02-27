package model;

import exceptions.NonPositiveException;

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

}
