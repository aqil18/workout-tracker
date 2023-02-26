package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeightedExerciseTest {

    WeightedExercise weighted1;

    @BeforeEach
    public void setup() {
        weighted1 = new WeightedExercise("Dumbell curls");
    }

    @Test
    public void constructorTest() {
        assertEquals(weighted1.getExerciseName(), "Dumbell curls");
    }

    @Test
    public void setWeightTest() {
        weighted1.setWeight(10);
        assertEquals(weighted1.getWeight(), 10);
    }

    @Test
    public void setRepsTest() {
        weighted1.setReps(4);
        assertEquals(weighted1.getReps(), 4);
    }
}
