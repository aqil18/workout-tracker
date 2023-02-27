package model;


import exceptions.NonPositiveException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeightedExerciseTest {

    WeightedExercise weighted1;


    @Test
    public void constructorTest() {
        try {
            weighted1 = new WeightedExercise("Dumbell-curls", 10, 4);
            assertEquals(weighted1.getExerciseName(), "Dumbell-curls");
            assertEquals(weighted1.getWeight(), 10);
            assertEquals(weighted1.getReps(), 4);
        } catch (NonPositiveException e) {
            fail("Unexpected NonPositiveException");
        }

    }

    @Test
    public void negativeConstructorTest() {
        try {
            weighted1 = new WeightedExercise("Dumbell-curls", -10, 4);
            fail("Negative number inputted and no NonPositiveException is thrown");

        } catch (NonPositiveException e) {
            //Exception thrown
        }

    }

    @Test
    public void setWeightTest() {
        try {
            weighted1 = new WeightedExercise("Dumbell-curls", 10, 4);
            assertEquals(weighted1.getWeight(), 10);
            weighted1.setWeight(50);
            assertEquals(weighted1.getWeight(), 50);
        } catch (NonPositiveException e) {
            fail("Unexpected NonPositiveException");
        }

    }

    @Test
    public void setNegativeWeightTest() {
        try {
            weighted1 = new WeightedExercise("Dumbell-curls", 10, 4);
            assertEquals(weighted1.getWeight(), 10);
            weighted1.setWeight(-555);
            fail("Negative number inputted and no NonPositiveException is thrown");
        } catch (NonPositiveException e) {
            //Exception thrown
        }
    }

    @Test
    public void setZeroWeightTest() {
        try {
            weighted1 = new WeightedExercise("Dumbell-curls", 10, 4);
            assertEquals(weighted1.getWeight(), 10);
            weighted1.setWeight(0);
            fail("Zero inputted and no NonPositiveException is thrown");
        } catch (NonPositiveException e) {
            //Exception thrown
        }
    }

    @Test
    public void setRepsTest() {
        try {
            weighted1 = new WeightedExercise("Dumbell-curls", 10, 4);
            assertEquals(weighted1.getReps(), 4);
            weighted1.setReps(6);
            assertEquals(weighted1.getReps(), 6);
        } catch (NonPositiveException e) {
            fail("Unexpected NonPositiveException");
        }

    }

    @Test
    public void setNegativeRepsTest() {
        try {
            weighted1 = new WeightedExercise("Dumbell-curls", 10, 4);
            assertEquals(weighted1.getReps(), 4);
            weighted1.setReps(-556);
            fail("Negative number inputted and no NonPositiveException is thrown");
        } catch (NonPositiveException e) {
            //Exception thrown
        }
    }

    @Test
    public void setZeroRepsTest() {
        try {
            weighted1 = new WeightedExercise("Dumbell-curls", 10, 4);
            assertEquals(weighted1.getReps(), 4);
            weighted1.setReps(0);
            fail("Zero inputted and no NonPositiveException is thrown");
        } catch (NonPositiveException e) {
            //Exception thrown
        }
    }



}
