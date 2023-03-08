package persistence;



import model.TimedExercise;
import model.WeightedExercise;
import model.Workout;




import static org.junit.Assert.assertEquals;

public class JsonTest {

    protected void checkWorkout(String name, int rating, Workout workout) {
        assertEquals(name, workout.getWorkoutName());
        //assertEquals(rating, workout.getRating());
    }

    protected void checkWeightedExercise(String name, int weight, int reps, WeightedExercise exercise) {
        assertEquals(name, exercise.getExerciseName());
        assertEquals(weight, exercise.getWeight());
        assertEquals(reps, exercise.getReps());
    }

    protected void checkTimedExercise(String name, int time, TimedExercise exercise) {
        assertEquals(name, exercise.getExerciseName());
        assertEquals(time, exercise.getTime());
    }

}
