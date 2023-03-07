package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // FINAL
    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }


    // FINAL
    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkRoom read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }


    // FINAL
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }
        return contentBuilder.toString();
    }


    // FINAL
    // EFFECTS: parses workroom from JSON object and returns it
    private WorkRoom parseWorkRoom(JSONObject jsonObject) {
        WorkRoom wr = new WorkRoom();
        addJsonWorkouts(wr, jsonObject);
        return wr;
    }

    // FINAL
    // MODIFIES: wr
    // EFFECTS: parses workouts from JSON object and adds them to workroom
    private void addJsonWorkouts(WorkRoom wr, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("workouts");
        for (Object json : jsonArray) {
            JSONObject nextWorkout = (JSONObject) json;
            addJsonWorkout(wr, nextWorkout);
        }
    }

    //
    // MODIFIES: wr
    // EFFECTS: parses workout from JSON object and adds it to workroom
    private void addJsonWorkout(WorkRoom wr, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int rating = jsonObject.getInt("rating");


        JsonWorkout jsonWorkout = new JsonWorkout(name, rating);
        addJsonExercises(jsonWorkout, jsonObject);
        wr.addWorkout(jsonWorkout);

    }


    private void addJsonExercises(JsonWorkout workout, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("exercises");
        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            addJsonExercise(workout, nextExercise);
        }
    }


    private void addJsonExercise(JsonWorkout workout, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        boolean



    }




}
