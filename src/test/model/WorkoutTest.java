package model;

import exceptions.EmptyExerciseList;
import exceptions.NonPositiveException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WorkoutTest {

    Workout workout;
    Exercise exercise1;
    Exercise exercise2;

    @BeforeEach
    public void setup() {
        workout = new Workout("Back", 5);
        try {
            exercise1 = new WeightedExercise("Dumbell curls", 10, 4);
            exercise2 = new TimedExercise("3 min run", 3);
        } catch (NonPositiveException e) {
            //Exceptions do not need to be tested here.
        }

    }

    @Test
    public void constructorTest() {
    try {
        workout.getExercises().size();
        fail("Expected EmptyExerciseList exception to be thrown.");
    } catch (EmptyExerciseList e) {
        assertEquals(workout.getWorkoutName(), "Back");
        assertEquals(workout.getRating(), 5);
    }

    }

    @Test
    public void addSingleExerciseTest() {
        workout.addExercise(exercise1);
        try {
            assertEquals(workout.getExercises().size(), 1);
        } catch (EmptyExerciseList e) {
            fail("Unexpected EmptyExerciseList exception.");
        }
        assertEquals(workout.getExercise(0), exercise1);
    }

    @Test
    public void addMultipleExercisesTest() {
        workout.addExercise(exercise1);
        workout.addExercise(exercise2);
        workout.addExercise(exercise1);

        try {
            assertEquals(workout.getExercises().size(), 3);
        } catch (EmptyExerciseList e) {
            fail("Unexpected EmptyExerciseList exception.");
        }
        assertEquals(workout.getExercise(0), exercise1);
        assertEquals(workout.getExercise(1), exercise2);
        assertEquals(workout.getExercise(2), exercise1);

    }

    @Test
    public void deleteWorkoutTest() {
        workout.addExercise(exercise2);
        workout.addExercise(exercise1);
        workout.addExercise(exercise2);

        workout.deleteExercise(exercise2);
        try {
            assertEquals(workout.getExercises().size(), 1);
        } catch (EmptyExerciseList e) {
            fail("Unexpected EmptyExerciseList exception.");
        }
        assertEquals(workout.getExercise(0), exercise1);

    }


    @Test
    public void rateWorkoutTest() {
        workout.rateWorkout(3);
        assertEquals(workout.getRating(), 3);
    }




}
