package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeightedExerciseTest {

    WeightedExercise weighted1;

    @BeforeEach
    public void setup() {
        weighted1 = new WeightedExercise("Dumbell curls", 10, 4);
    }

    @Test
    public void constructorTest() {
        assertEquals(weighted1.getExerciseName(), "Dumbell curls");
    }

    @Test
    public void setWeightTest() {
        assertEquals(weighted1.getWeight(), 10);
        weighted1.setWeight(50);
        assertEquals(weighted1.getWeight(), 50);
    }

    @Test
    public void setRepsTest() {
        assertEquals(weighted1.getReps(), 4);
        weighted1.setReps(6);
        assertEquals(weighted1.getReps(), 6);
    }
}
