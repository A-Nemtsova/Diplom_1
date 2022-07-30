package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    private final IngredientType ingredientType;
    private final String valueIngredientType;

    public IngredientTypeTest(IngredientType ingredientType, String valueIngredientType) {
        this.ingredientType = ingredientType;
        this.valueIngredientType = valueIngredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getValueIngredientType () {
        return new Object[][] {
                {SAUCE, "SAUCE"},
                {FILLING, "FILLING"},
        };
    }

    @Test
    public void values() {
        IngredientType [] expected = {SAUCE, FILLING};
        assertEquals(expected, IngredientType.values());
    }

    @Test
    public void valueOf() {
        assertEquals(ingredientType, IngredientType.valueOf(valueIngredientType));
    }

}