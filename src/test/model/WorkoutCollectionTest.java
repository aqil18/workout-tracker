package model;

import exceptions.EmptyWorkoutList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class WorkoutCollectionTest {

    WorkoutCollection collection;
    Workout workout1;
    Workout workout2;
    Workout workout3;

    @BeforeEach
    public void setup() {
        collection = new WorkoutCollection();
        workout1 = new Workout("Back");
        workout2 = new Workout("Leg");
        workout3 = new Workout("Chest");

    }

    @Test
    public void constructorTest() {
        try {
            collection.getWorkouts().size();
            fail("Expected EmptyWorkoutList exception to be thrown.");
        } catch (EmptyWorkoutList e) {
            //Exception thrown.
        }
    }

    @Test
    public void addSingleWorkoutTest() {
        collection.addWorkout(workout1);
        try {
            assertEquals(collection.getWorkouts().size(), 1);
        } catch (EmptyWorkoutList e) {
            fail("Unexpected EmptyWorkoutList exception.");
        }
        assertEquals(collection.getWorkout(0), workout1);
    }

    @Test
    public void addMultipleWorkoutTest() {
        collection.addWorkout(workout2);
        collection.addWorkout(workout1);
        collection.addWorkout(workout3);

        try {
            assertEquals(collection.getWorkouts().size(), 3);
        } catch (EmptyWorkoutList e) {
            fail("Unexpected EmptyWorkoutList exception.");
        }
        assertEquals(collection.getWorkout(0), workout2);
        assertEquals(collection.getWorkout(1), workout1);
        assertEquals(collection.getWorkout(2), workout3);

    }

    @Test
    public void deleteWorkoutTest() {
        collection.addWorkout(workout3);
        collection.addWorkout(workout3);
        collection.addWorkout(workout2);

        collection.deleteWorkout(workout3);
        try {
            assertEquals(collection.getWorkouts().size(), 1);
        } catch (EmptyWorkoutList e) {
            fail("Unexpected EmptyWorkoutList exception.");
        }
        assertEquals(collection.getWorkout(0), workout2);

    }

}
