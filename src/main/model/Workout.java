package model;


import exceptions.EmptyExerciseList;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;

// Represents a workout as a list of exercises with a name and rating
public class Workout implements Writable {
    private ArrayList<Exercise> exercises;
    private String name;
    private int rating;

    //EFFECTS - Creates an empty list of exercises with a given name
    public Workout(String name, int rating) {
        this.name = name;
        this.exercises = new ArrayList<>();
        this.rating = rating;
    }

    //MODIFIES - This
    //EFFECTS - Adds given exercise to the workout list
    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
        EventLog.getInstance().logEvent(new Event("Added the "
                + exercise.getExerciseName()
                + " exercise to the "
                + name
                + " workout."));
    }


    //MODIFIES - This
    //EFFECTS - Deletes all instances of the given exercise from the workout list
    public void deleteExercise(Exercise exercise) {
        this.exercises.removeAll(Collections.singleton(exercise));
        EventLog.getInstance().logEvent(new Event("Deleted "
                + exercise.getExerciseName()
                + " exercise from the "
                + name
                + " workout."));
    }

    //REQUIRES - Non-negative integer rating
    //MODIFIES - This
    //EFFECTS - Edits the rating of the workout
    public void rateWorkout(int rating) {
        this.rating = rating;
    }

    //EFFECTS - Returns all exercises in the workout list
    public ArrayList<Exercise> getExercises()  throws EmptyExerciseList {
        if (this.exercises.size() == 0) {
            throw new EmptyExerciseList();
        }
        return this.exercises;
    }

    //EFFECTS - Returns the exercise at the given index
    public Exercise getExercise(int index) {
        return this.exercises.get(index);
    }

    //EFFECTS - Returns the workout name
    public String getWorkoutName() {
        return name;
    }

    //EFFECTS - Returns the rating of the workout
    public Integer getRating() {
        return rating;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("exercises", exercisesToJson());
        json.put("rating", rating);

        return json;
    }

    // EFFECTS: returns exercises in workout as a JSON array
    private JSONArray exercisesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Exercise e : exercises) {
            jsonArray.put(e.toJson());
        }
        return jsonArray;
    }



}
