package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void emptyStringShouldReturn0() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.evaluate(""));
    }

    @Test
    public void twoPlusFiveShouldBe7() {
        Calculator calculator = new Calculator();
        assertEquals(7, calculator.evaluate("2+5"));
    }

    @Test
    public void simpleMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(3 * 4, calculator.evaluate("3*4"));
    }

    @Test
    public void complexExpression() {
        Calculator calculator = new Calculator();
        assertEquals(2 * 3 + 5 * 8, calculator.evaluate("2*3+5*8"));
    }
}
