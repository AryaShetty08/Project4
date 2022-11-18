package com.example.project4;

import org.junit.Test;
import pizzaManager.BuildYourOwn;
import pizzaManager.NYPizza;

import static org.junit.Assert.*;
import static pizzaManager.Size.SMALL;
import static pizzaManager.Topping.SAUSAGE;

public class BuildYourOwnTest {

    @Test
    public void testPrice() {
        BuildYourOwn test = new BuildYourOwn(new NYPizza());
        test.setSize(SMALL);
        test.add(SAUSAGE);
        assertNotEquals(8.99, test.price(), 0);
    }
}