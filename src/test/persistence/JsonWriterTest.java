package persistence;

import exceptions.EmptyExerciseList;
import exceptions.EmptyWorkoutList;
import exceptions.NonPositiveException;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class JsonWriterTest extends JsonTest {
    Workout workout1;
    Workout workout2;
    WorkoutCollection generalCollection;

    @BeforeEach
    public void setup() {
        workout1 = new Workout("Arms", 5);
        workout2 = new Workout("Back", 4);

        try {
            Exercise exercise1 = new WeightedExercise("Bicep-Curls", 12, 8);
            Exercise exercise2 = new WeightedExercise("Hammer-Curls", 10, 8);
            Exercise exercise3 = new TimedExercise("Cardio", 20);
            workout1.addExercise(exercise1);
            workout1.addExercise(exercise2);
            workout1.addExercise(exercise3);
            generalCollection = new WorkoutCollection();
            generalCollection.addWorkout(workout1);
            generalCollection.addWorkout(workout2);
        } catch (NonPositiveException e) {
            //
        }

    }

    @Test
    public void testWriterInvalidFile() {
        try {
            WorkoutCollection collection = new WorkoutCollection();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
   public void testWriterEmptyCollection() {
        try {
            WorkoutCollection collection = new WorkoutCollection();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyCollection.json");
            writer.open();
            writer.write(collection);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyCollection.json");
            collection = reader.read();
            try {
                collection.getWorkouts();
                fail("Expected EmptyWorkoutList exception not thrown. ");
            } catch (EmptyWorkoutList e) {
                // pass
            }

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        } catch (NonPositiveException e) {
            fail("Unexpected NonPositiveException thrown.");
        }
    }

    @Test
    public void testWriterGeneralWorkouts() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCollection.json");
            writer.open();
            writer.write(generalCollection);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCollection.json");
            generalCollection = reader.read();
            try {
                assertEquals(2, generalCollection.getWorkouts().size());
                checkWorkout("Arms",5, generalCollection.getWorkout(0));
                checkWorkout("Back", 4, generalCollection.getWorkout(1));
            } catch (EmptyWorkoutList e) {
                fail("Unexpected EmptyWorkoutList exception thrown.");
            }
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        } catch (NonPositiveException e) {
            fail("Unexpected NonPositiveException thrown.");
        }
    }

    @Test
    public void testWriterGeneralExercises() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralCollection.json");
            writer.open();
            writer.write(generalCollection);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralCollection.json");
            generalCollection = reader.read();
            Workout workout = generalCollection.getWorkout(0);
            try {
                assertEquals(3, workout.getExercises().size());
                checkWeightedExercise("Bicep-Curls", 12, 8, (WeightedExercise) workout.getExercise(0));
                checkWeightedExercise("Hammer-Curls", 10, 8, (WeightedExercise) workout.getExercise(1));
                checkTimedExercise("Cardio", 20, (TimedExercise) workout.getExercise(2));
            } catch (EmptyExerciseList e) {
                fail("Unexpected EmptyWorkoutList exception thrown.");
            }
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }  catch (NonPositiveException e) {
            fail("Unexpected NonPositiveException thrown.");
        }
    }

}
