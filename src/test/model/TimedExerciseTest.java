package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TimedExerciseTest {

    TimedExercise timed1;


    @BeforeEach
    public void setup() {
        timed1 = new TimedExercise("3 min run", 3);
    }



    @Test
    public void constructorTest() {
        assertEquals(timed1.getExerciseName(), "3 min run");
        assertEquals(timed1.getTime(), 3);
    }

    @Test
    public void setWeightTest() {
        assertEquals(timed1.getTime(), 3);
        timed1.setTime(15);
        assertEquals(timed1.getTime(), 15);
    }
}
