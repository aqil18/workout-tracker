package model;

public class WeightedExercise extends Exercise {

    private int weight;
    private int reps;

    //Effects creates a Weighted exercise with given name.
    public WeightedExercise(String name) {
        super(name);

    }

    //EFFECTS - Edits the weight field
    public void editWeight(int weight) {
        this.weight = weight;
    }

    //EFFECTS - Edits the reps field
    public void editReps(int reps) {
        this.reps = reps;
    }


}
