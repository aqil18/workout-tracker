package ui;

import exceptions.NonPositiveException;
import model.WorkoutCollection;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;


//The Workout Tracker
public abstract class WorkoutTracker {

    private static final  String JSON_STORE = "./data/workoutCollection.json";
    protected WorkoutCollection collection;
    protected JsonReader jsonReader;
    protected JsonWriter jsonWriter;



    // EFFECTS: saves the workout collection to file
    public void saveWorkoutCollection() {
        try {
            jsonWriter.open();
            jsonWriter.write(collection);
            jsonWriter.close();
            System.out.println("Saved all workouts to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workout collection from file
    public void loadWorkoutCollection() {
        try {
            collection = jsonReader.read();
            System.out.println("Loaded all workouts from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        } catch (NonPositiveException e) {
            System.out.println("Unable to load workouts due to non-positive weight/reps/time input(s).");
        }
    }


    //EFFECTS - Initializes workout tracker
    public void setup() {
        collection = new WorkoutCollection();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
    }

    public WorkoutCollection getCollection() {
        return collection;
    }

}
