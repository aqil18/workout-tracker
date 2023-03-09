package persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import exceptions.NonPositiveException;
import model.*;
import org.json.*;

// Represents a reader that reads workout collection from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }


    // EFFECTS: reads workout collection from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkoutCollection read() throws IOException, NonPositiveException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkoutCollection(jsonObject);
    }


    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }
        return contentBuilder.toString();
    }


    // EFFECTS: parses workout collection from JSON object and returns it
    private WorkoutCollection parseWorkoutCollection(JSONObject jsonObject) throws NonPositiveException {
        WorkoutCollection collection = new WorkoutCollection();
        addJsonWorkouts(collection, jsonObject);
        return collection;
    }

    // MODIFIES: collection
    // EFFECTS: parses workouts from JSON object and adds them to the collection
    private void addJsonWorkouts(WorkoutCollection collection, JSONObject jsonObject) throws NonPositiveException {
        JSONArray jsonArray = jsonObject.getJSONArray("workouts");
        for (Object json : jsonArray) {
            JSONObject nextWorkout = (JSONObject) json;
            addJsonWorkout(collection, nextWorkout);
        }
    }

    // MODIFIES: collection
    // EFFECTS: parses workout from JSON object and adds it to the collection
    private void addJsonWorkout(WorkoutCollection collection, JSONObject jsonObject) throws NonPositiveException {
        String name = jsonObject.getString("name");
        int rating = jsonObject.getInt("rating");

        Workout workout = new Workout(name, rating);
        addJsonExercises(workout, jsonObject);
        collection.addWorkout(workout);

    }

    // MODIFIES: workout
    // EFFECTS: parses exercises from JSON object and adds them to the workout
    private void addJsonExercises(Workout workout, JSONObject jsonObject) throws NonPositiveException {
        JSONArray jsonArray = jsonObject.getJSONArray("exercises");
        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            addJsonExercise(workout, nextExercise);
        }
    }

    // MODIFIES: workout
    // EFFECTS: parses exercise from JSON object and add it to the workout
    private void addJsonExercise(Workout workout, JSONObject jsonObject) throws NonPositiveException {
        String name = jsonObject.getString("name");

        Exercise exercise;
        if (jsonObject.has("weight")) {
            int weight = jsonObject.getInt("weight");
            int reps = jsonObject.getInt("reps");

            exercise = new WeightedExercise(name, weight, reps);
        } else {
            int time = jsonObject.getInt("time");
            exercise = new TimedExercise(name, time);
        }

        workout.addExercise(exercise);
    }
}