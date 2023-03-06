package persistence;

import org.json.JSONObject;
import persistence.Writable;

// Represents a thingy having a name and a category
public class JsonWeighted implements Writable {
    private String name;
    private int weight;
    private int reps;

    // EFFECTS: constructs a thingy with a name and category
    public JsonWeighted(String name, int weight) {
        this.name = name;
        this.weight = weight;
        this.reps = reps;
    }

    public String getName() {
        return name;
    }

    //EFFECTS - Returns the weight
    public int getWeight() {
        return weight;
    }

    //EFFECTS - Returns the reps
    public int getReps() {
        return reps;
    }


    // EFFECTS: returns string representation of this thingy
    public String toString() {
        return category + ": " + name;
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
