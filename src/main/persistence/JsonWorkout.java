package persistence;

import persistence.JsonExercise;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a thingy having a name and a category
public class JsonWorkout implements Writable {
    private String name;
    private int rating;
    private List<JsonExercise> exerciseThingies;

    // EFFECTS: constructs a thingy with a name and category
    public JsonWorkout(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.exerciseThingies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    // MODIFIES: this
    // EFFECTS: adds JsonExercise to list of JsonExercise
    public void addWorkout(JsonExercise jsonExercise) {
        exerciseThingies.add(jsonExercise);
    }

    // EFFECTS: returns an unmodifiable list of thingies in this workroom
    public java.util.List<JsonExercise> getWorkoutThingies() {
        return Collections.unmodifiableList(exerciseThingies);
    }

    // EFFECTS: returns number of thingies in this workroom
    public int numThingies() {
        return exerciseThingies.size();
    }


    // EFFECTS: returns string representation of this thingy
    public String toString() {
        return category + ": " + name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("exercises", exercisesToJson());
        json.put("rating", rating);

        return json;
    }

    // EFFECTS: returns exercises in JsonWorkout as a JSON array
    private JSONArray exercisesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (JsonExercise e : exerciseThingies) {
            jsonArray.put(e.toJson());
        }
        return jsonArray;
    }
}