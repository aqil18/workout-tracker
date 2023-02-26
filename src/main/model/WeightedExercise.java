package model;

public class WeightedExercise extends Exercise {

    private int weight;
    private int reps;

    //EFFECTS - creates a Weighted exercise with a given name
    public WeightedExercise(String name) {
        super(name);

    }

    //MODIFIES - This
    //EFFECTS - Edits the weight field
    public void setWeight(int weight) {
        this.weight = weight;
    }

    //MODIFIES - This
    //EFFECTS - Edits the reps field
    public void setReps(int reps) {
        this.reps = reps;
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
