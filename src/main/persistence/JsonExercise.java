package persistence;

import org.json.JSONObject;

// Represents a thingy having a name and a category
public class JsonExercise implements Writable {
    private String name;
    private boolean isWeighted;
    private int weight;
    private int reps;
    private int time;


    // EFFECTS: constructs a thingy with a name and category
    public JsonExercise(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    // EFFECTS: returns string representation of this thingy
    public String toString() {
        return category + ": " + name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("isWeighted", isWeighted);
        if (isWeighted) {
            json.put("weight", weight);
            json.put("reps", reps);
        } else {
            json.put("time", time);
        }
        return json;
    }
}
