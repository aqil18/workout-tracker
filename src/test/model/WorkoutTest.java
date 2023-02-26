package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkoutTest {

    Workout workout;
    Exercise exercise1;
    Exercise exercise2;

    @BeforeEach
    public void setup() {
        workout = new Workout("Back");
        exercise1 = new WeightedExercise("Dumbell curls");
        exercise2 = new TimedExercise("3 min run");

    }

    @Test
    public void constructorTest() {
        assertEquals(workout.getExercises().size(), 0);
        assertEquals(workout.getWorkoutName(), "Back");
    }

    @Test
    public void addSingleExerciseTest() {
        workout.addExercise(exercise1);
        assertEquals(workout.getExercises().size(), 1);
        assertEquals(workout.getExercise(0), exercise1);
    }

    @Test
    public void addMultipleExercisesTest() {
        workout.addExercise(exercise1);
        workout.addExercise(exercise2);
        workout.addExercise(exercise1);

        assertEquals(workout.getExercises().size(), 3);
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
        assertEquals(workout.getExercises().size(), 1);
        assertEquals(workout.getExercise(0), exercise1);

    }


    @Test
    public void rateWorkoutTest() {
        workout.rateWorkout(5);
        assertEquals(workout.getRating(), 5);
    }




}
