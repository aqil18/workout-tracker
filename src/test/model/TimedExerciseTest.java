package model;

import exceptions.NonPositiveException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class TimedExerciseTest {

    TimedExercise timed1;

    @Test
    public void constructorTest() {
        //Exception would not be thrown here
        try {
            timed1 = new TimedExercise("3-min-run", 3);
            assertEquals(timed1.getExerciseName(), "3-min-run");
            assertEquals(timed1.getTime(), 3);
        } catch (NonPositiveException e) {
            fail("Unexpected NonPositiveException");
        }
    }

    @Test
    public void negativeConstructorTest() {
        //Exception is thrown
        try {
            timed1 = new TimedExercise("3-min-run", -33);
            fail("Negative number inputted and no NonPositiveException is thrown");
        } catch (NonPositiveException e) {
            //Exception is caught.
        }
    }




    @Test
    public void setTimeTest() {
        //Exception would not be thrown here
        try {
            timed1 = new TimedExercise("3-min-run", 3);
            assertEquals(timed1.getTime(), 3);
            timed1.setTime(15);
            assertEquals(timed1.getTime(), 15);
        } catch (NonPositiveException e) {
            fail("Unexpected NonZeroException");
        }
    }

    @Test
    public void setNegativeTimeTest() {
        //Exception thrown here
        try {
            timed1 = new TimedExercise("3-min-run", 3);
            assertEquals(timed1.getTime(), 3);
            timed1.setTime(-15);
            fail("Negative number inputted and no NonPositiveException is thrown");
        } catch (NonPositiveException e) {
            //Exception is caught
        }
    }

    @Test
    public void setZeroTimeTest() {
        //Exception thrown here
        try {
            timed1 = new TimedExercise("3-min-run", 3);
            assertEquals(timed1.getTime(), 3);
            timed1.setTime(0);
            fail("Zero inputted and no NonPositiveException is thrown");
        } catch (NonPositiveException e) {
            //Exception is caught
        }
    }
}
