package persistence;


import exceptions.*;
import model.*;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class JsonReaderTest extends JsonTest{


    @Test
    public void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WorkoutCollection collection = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        } catch (NonPositiveException e) {
            fail("Unexpected NonPositiveException thrown.");
        }
    }

    @Test
    public void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyCollection.json");
        try {
            WorkoutCollection collection = reader.read();
            try {
                collection.getWorkouts();
                fail("Expected EmptyWorkoutList exception to be thrown.");
            } catch (EmptyWorkoutList e) {
                // pass
            }
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (NonPositiveException e) {
            fail("Unexpected NonPositiveException thrown.");
        }
    }

    @Test
    public void testReaderGeneralWorkouts() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCollection.json");
        try {
            WorkoutCollection collection = reader.read();
            try {
                ArrayList<Workout> workouts = collection.getWorkouts();
                assertEquals(2, workouts.size());
                checkWorkout("Back",4 , collection.getWorkout(0));
                checkWorkout("Arms", 5, collection.getWorkout(1));
            } catch (EmptyWorkoutList e) {
                fail("Unexpected EmptyWorkoutList exception thrown.");
            }
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (NonPositiveException e) {
            fail("Unexpected NonPositiveException thrown.");
        }
    }



    @Test
    public void testReaderGeneralExercises() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralCollection.json");

        try {
            WorkoutCollection collection = reader.read();
            Workout workout = collection.getWorkout(0);
            try {
                assertEquals(2, workout.getExercises().size());
                checkWeightedExercise("Rows", 10, 4, (WeightedExercise) workout.getExercise(0));
                checkTimedExercise("Extensions", 30, (TimedExercise) workout.getExercise(1));
            } catch (EmptyExerciseList e) {
                fail("Unexpected EmptyExerciseList exception thrown.");
            }
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (NonPositiveException e) {
            fail("Unexpected NonPositiveException thrown.");
        }

    }

    @Test
    public void testReaderNonPositiveExercises() {
        JsonReader reader = new JsonReader("./data/testReaderNonPositiveExercises.json");

        try {
            WorkoutCollection collection = reader.read();
            fail("Expected NonPositiveException to be thrown.");
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (NonPositiveException e) {
            // pass
        }

    }
}