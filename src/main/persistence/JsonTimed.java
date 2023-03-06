package persistence;

import org.json.JSONObject;
import persistence.Writable;

// Represents a thingy having a name and a category
public class JsonTimed implements Writable {
    private String name;
    private int time;

    // EFFECTS: constructs a thingy with a name and category
    public Thingy(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    // EFFECTS: returns string representation of this thingy
    public String toString() {
        return category + ": " + name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("time", time);
        return json;
    }
}
