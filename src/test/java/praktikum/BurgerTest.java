package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;


    @Test
    public void setBuns() {
        burger = new Burger();
        burger.setBuns(bun);
        assertNotNull(burger.bun);
    }

    @Test
    public void addIngredient() {
        burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        List<Ingredient> expected = Arrays.asList(ingredient1, ingredient2);
        assertEquals(expected, burger.ingredients);
    }

    @Test
    public void removeIngredient() {
        burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        List<Ingredient> expected = Collections.singletonList(ingredient2);
        assertEquals(expected, burger.ingredients);
    }

    @Test
    public void moveIngredient() {
        burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        List<Ingredient> expected = Arrays.asList(ingredient2, ingredient1);
        assertEquals(expected, burger.ingredients);
    }

    @Test
    public void getPrice() {
        Mockito.when(bun.getPrice()).thenReturn((float) 100);
        Mockito.when(ingredient1.getPrice()).thenReturn((float) 150);
        float expected = 100 * 2 + 150;
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        assertEquals(expected, burger.getPrice(), 0);
    }

    @Test
    public void getReceipt() {
        Mockito.when(bun.getPrice()).thenReturn((float) 100);
        Mockito.when(ingredient1.getPrice()).thenReturn((float) 150);
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient1.getName()).thenReturn("cutlet");
        Mockito.when(ingredient1.getType()).thenReturn(FILLING);
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        String expected = String.format("(==== black bun ====)%n= filling cutlet =%n(==== black bun ====)%n%nPrice: 350,000000%n");
        assertEquals(expected, burger.getReceipt());
    }

}