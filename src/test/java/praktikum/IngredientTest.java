package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;


@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final IngredientType expectedType;

    public IngredientTest(IngredientType type, IngredientType expectedType) {
        this.type = type;
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} . Ожидаемое значение {1}")
    public static Object[][] checkType () {
        return new Object[][] {
                {SAUCE, SAUCE},
                {FILLING, FILLING},
        };
    }

    @Test
    public void getPricePositiveTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "dinosaur", 900);
        Float actual = ingredient.getPrice();
        Float expected = 900.0f;
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceNegativeTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "dinosaur", 900);
        Float actual = ingredient.getPrice();
        Float expected = 700.0f;
        assertNotEquals(expected, actual);
    }

    @Test
    public void getNamePositiveTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "dinosaur", 900);
        assertEquals("dinosaur", ingredient.getName());
    }

    @Test
    public void getNameNegativeTest() {
        Ingredient ingredient = new Ingredient(SAUCE, "dinosaur", 900);
        assertNotEquals("cutlet", ingredient.getName());
    }

    @Test
    public void getTypePositiveTest() {
       Ingredient ingredient = new Ingredient(type, "dinosaur", 900);
        assertEquals(expectedType, ingredient.getType());
    }
}

