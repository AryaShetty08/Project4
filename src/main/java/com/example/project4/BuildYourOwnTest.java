package com.example.project4;

import org.junit.Test;
import pizzaManager.BuildYourOwn;
import pizzaManager.ChicagoPizza;
import pizzaManager.NYPizza;

import static org.junit.Assert.*;
import static pizzaManager.Size.*;
import static pizzaManager.Topping.*;

/**
 * BuildYourOwnTest is a JUnit class to test the price method in the BuildYourOwn class
 * It runs through several tests for checking the variation combinations of pizzas
 * that can be made from sizes and toppings
 * @author Arya Shetty, John Greaney-Cheng
 */
public class BuildYourOwnTest {

    /**
     * Tests if the price changes when the size of the pizza changes
     * Checks both NYPizza and Chicago style
     */
    @Test
    public void testPriceSize() {
        BuildYourOwn test = new BuildYourOwn(new NYPizza());
        test.setSize(SMALL);
        assertEquals(8.99, test.price(), 0);

        BuildYourOwn test1 = new BuildYourOwn(new NYPizza());
        test1.setSize(MEDIUM);
        assertEquals(10.99, test1.price(), 0);

        BuildYourOwn test2 = new BuildYourOwn(new NYPizza());
        test2.setSize(LARGE);
        assertEquals(12.99, test2.price(), 0);

        BuildYourOwn test3 = new BuildYourOwn(new ChicagoPizza());
        test3.setSize(SMALL);
        assertEquals(8.99, test3.price(), 0);

        BuildYourOwn test4 = new BuildYourOwn(new ChicagoPizza());
        test4.setSize(MEDIUM);
        assertEquals(10.99, test4.price(), 0);

        BuildYourOwn test5 = new BuildYourOwn(new ChicagoPizza());
        test5.setSize(LARGE);
        assertEquals(12.99, test5.price(), 0);
    }

    /**
     * Tests if the price changes when the size of the pizza changes and if topping is added
     * Checks both NYPizza and Chicago style
     */
    @Test
    public void testPriceTop() {
        BuildYourOwn test = new BuildYourOwn(new NYPizza());
        test.setSize(SMALL);
        test.add(SAUSAGE);
        assertEquals(10.58, test.price(), 0);

        BuildYourOwn test1 = new BuildYourOwn(new NYPizza());
        test1.setSize(MEDIUM);
        test1.add(SAUSAGE);
        assertEquals(12.58, test1.price(), 0);

        BuildYourOwn test2 = new BuildYourOwn(new NYPizza());
        test2.setSize(LARGE);
        test2.add(SAUSAGE);
        assertEquals(14.58, test2.price(), 0);

        BuildYourOwn test4 = new BuildYourOwn(new ChicagoPizza());
        test4.setSize(SMALL);
        test4.add(SAUSAGE);
        assertEquals(10.58, test4.price(), 0);

        BuildYourOwn test5 = new BuildYourOwn(new ChicagoPizza());
        test5.setSize(MEDIUM);
        test5.add(SAUSAGE);
        assertEquals(12.58, test5.price(), 0);

        BuildYourOwn test6 = new BuildYourOwn(new ChicagoPizza());
        test6.setSize(LARGE);
        test6.add(SAUSAGE);
        assertEquals(14.58, test6.price(), 0);
    }

    /**
     * Tests if the price changes when the size of the pizza changes and toppings are added and removed
     * Checks both NYPizza and Chicago style
     */
    @Test
    public void testPriceMultipleTop() {
        BuildYourOwn test = new BuildYourOwn(new NYPizza());
        test.setSize(SMALL);
        test.add(SAUSAGE);
        test.add(PEPPERONI);
        test.add(PINEAPPLE);
        test.add(MUSHROOM);
        test.add(SPINACH);
        test.add(OLIVES);
        test.add(ONION);
        assertEquals(20.12, test.price(), 0);

        BuildYourOwn test1 = new BuildYourOwn(new NYPizza());
        test1.setSize(MEDIUM);
        test1.add(SAUSAGE);
        test1.add(SAUSAGE);
        test1.add(PEPPERONI);
        test1.add(PINEAPPLE);
        assertEquals(17.35, test1.price(), 0);

        BuildYourOwn test2 = new BuildYourOwn(new NYPizza());
        test2.setSize(LARGE);
        test2.add(SAUSAGE);
        test2.add(SAUSAGE);
        test2.add(PEPPERONI);
        test2.add(PINEAPPLE);
        test2.remove(PEPPERONI);
        test2.remove(PINEAPPLE);
        assertEquals(16.17, test2.price(), 0);

        BuildYourOwn test3 = new BuildYourOwn(new NYPizza());
        test3.setSize(SMALL);
        test3.add(SAUSAGE);
        test3.add(PEPPERONI);
        test3.add(PINEAPPLE);
        test3.add(MUSHROOM);
        test3.add(SPINACH);
        test3.add(OLIVES);
        test3.add(ONION);
        assertEquals(20.12, test3.price(), 0);

        BuildYourOwn test4 = new BuildYourOwn(new NYPizza());
        test4.setSize(MEDIUM);
        test4.add(SAUSAGE);
        test4.add(SAUSAGE);
        test4.add(PEPPERONI);
        test4.add(PINEAPPLE);
        assertEquals(17.35, test4.price(), 0);

        BuildYourOwn test5 = new BuildYourOwn(new NYPizza());
        test5.setSize(LARGE);
        test5.add(SAUSAGE);
        test5.add(SAUSAGE);
        test5.add(PEPPERONI);
        test5.add(PINEAPPLE);
        test5.remove(PEPPERONI);
        test5.remove(PINEAPPLE);
        assertEquals(16.17, test5.price(), 0);
    }
}