package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BunTest {
    private Bun bun;

    @Before
    public void init() {
        bun = new Bun("Pink bun", 900.0f);
    }


    @Test
    public void getNamePositiveTest() {
        assertEquals("Pink bun", bun.getName());
    }

    @Test
    public void getPricePositiveTest() {
        Float actual = bun.getPrice();
        Float expected = 900.0f;
        assertEquals(expected, actual);
    }
}