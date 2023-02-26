package model;

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
        assertEquals(collection.getWorkouts().size(), 0);
    }

    @Test
    public void addSingleWorkoutTest() {
        collection.addWorkout(workout1);
        assertEquals(collection.getWorkouts().size(), 1);
        assertEquals(collection.getWorkout(0), workout1);
    }

    @Test
    public void addMultipleWorkoutTest() {
        collection.addWorkout(workout2);
        collection.addWorkout(workout1);
        collection.addWorkout(workout3);

        assertEquals(collection.getWorkouts().size(), 3);
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
        assertEquals(collection.getWorkouts().size(), 1);
        assertEquals(collection.getWorkout(0), workout2);

    }


}
