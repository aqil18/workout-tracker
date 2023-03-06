package persistence;

import org.json.JSONObject;

public interface Writable {
    // EFFECTS: returns this as J   SON object
    JSONObject toJson();
}
