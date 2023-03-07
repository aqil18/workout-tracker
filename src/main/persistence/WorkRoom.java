package persistence;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a workroom having a collection of thingies
public class WorkRoom implements Writable {
    private List<JsonWorkout> workoutThingies;

    // EFFECTS: constructs workroom with a name and empty list of thingies
    public WorkRoom() {
        workoutThingies = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds jsonWorkout to this workroom
    public void addWorkout(JsonWorkout jsonWorkout) {
        workoutThingies.add(jsonWorkout);
    }

    // EFFECTS: returns an unmodifiable list of thingies in this workroom
    public List<JsonWorkout> getWorkoutThingies() {
        return Collections.unmodifiableList(workoutThingies);
    }

    // EFFECTS: returns number of thingies in this workroom
    public int numThingies() {
        return workoutThingies.size();
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

        for (JsonWorkout w : workoutThingies) {
            jsonArray.put(w.toJson());
        }

        return jsonArray;
    }
}

