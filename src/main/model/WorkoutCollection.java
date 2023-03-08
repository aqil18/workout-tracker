package model;

import exceptions.EmptyWorkoutList;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;

// Represents a WorkoutCollection as a list of workouts
public class WorkoutCollection implements Writable {

    private ArrayList<Workout> workouts;

    //EFFECTS - Creates a WorkoutCollection object with an empty workout list.
    public WorkoutCollection() {
        this.workouts = new ArrayList<>();
    }

    //MODIFIES - This
    //EFFECTS - Adds given workout to the workout collection
    public void addWorkout(Workout workout) {
        this.workouts.add(workout);
    }

    //MODIFIES - This
    //EFFECTS - Deletes all instances of the given workout from the workout collection
    public void deleteWorkout(Workout workout) {
        this.workouts.removeAll(Collections.singleton(workout));
    }

    //EFFECTS - Returns all workouts in the workout collection
    public ArrayList<Workout> getWorkouts() throws EmptyWorkoutList {
        if (this.workouts.size() == 0) {
            throw new EmptyWorkoutList();
        }
        return workouts;
    }

    //EFFECTS - Returns the workout at the given index from the workout collection
    public Workout getWorkout(int index) {
        return this.workouts.get(index);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("workouts", workoutsToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray workoutsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Workout w : workouts) {
            jsonArray.put(w.toJson());
        }

        return jsonArray;
    }



}
