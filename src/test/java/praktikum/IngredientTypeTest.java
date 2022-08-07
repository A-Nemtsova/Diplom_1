package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;


public class IngredientTypeTest {
    private final String[] valueIngredientType = {"SAUCE", "FILLING"};

    @Test
    public void values() {
        IngredientType[] expected = {SAUCE, FILLING};
        assertEquals(expected, IngredientType.values());
    }

    @Test
    public void valueOf() {
        for (String value : valueIngredientType) {
            assertEquals(value, IngredientType.valueOf(value).toString());
        }
    }
}