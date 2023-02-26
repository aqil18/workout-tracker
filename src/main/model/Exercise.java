package model;


public abstract class Exercise {


    protected String name;


    //EFFECTS - Creates a new exercise object with given name.
    public Exercise(String name) {
        this.name = name;
        System.out.println("Your exercise " + name + " has been created.");
    }



    //EFFECTS - Returns the name of the Exercise.
    public String getExerciseName() {
        return this.name;
    }

}
