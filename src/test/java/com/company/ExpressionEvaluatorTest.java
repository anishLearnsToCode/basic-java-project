package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExpressionEvaluatorTest {

    @Test
    public void emptyStringSumIs0() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals(0, expressionEvaluator.evaluate(""));
    }

    @Test
    public void simpleAddition() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals(1+2, expressionEvaluator.evaluate("1+2"));
    }

    @Test
    public void complexAddition() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals(1+2+3, expressionEvaluator.evaluate("1+2+3"));
    }

    @Test
    public void veryComplexAddition() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals(1+2+3+4+5+6+7+8+9+0+1, expressionEvaluator.evaluate("1+2+3+4+5+6+7+8+9+0+1"));
    }

    @Test
    public void simpleMultiplication() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals(2*3, expressionEvaluator.evaluate("2*3"));
    }

    @Test
    public void complexMultiplication() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals(1*2*3*4*5, expressionEvaluator.evaluate("1*2*3*4*5"));
    }

    @Test
    public void complexExpression() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals(2+3*4+5*2, expressionEvaluator.evaluate("2+3*4+5*2"));
    }

    @Test
    public void simpleSubtraction() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals(9-5, expressionEvaluator.evaluate("9-5"));
    }

    @Test
    public void simpleDivision() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals(5/2, expressionEvaluator.evaluate("5/2"));
    }

    @Test
    public void allOperators() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals(5/2-6-4+3+4*8, expressionEvaluator.evaluate("5/2-6-4+3+4*8"));
    }

    @Test
    public void digitInBracket() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals((2), expressionEvaluator.evaluate("(2)"));
    }

    @Test
    public void additionInBrackets() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals((2+4), expressionEvaluator.evaluate("(2+4)"));
    }

    @Test
    public void subtractionInBrackets() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals((2-8), expressionEvaluator.evaluate("(2-8)"));
    }

    @Test
    public void multiplicationInBrackets() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals((2*5), expressionEvaluator.evaluate("(2*5)"));
    }

    @Test
    public void divisionInBrckets() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals((6/4), expressionEvaluator.evaluate("(6/4)"));
    }

    @Test
    public void complexBracketsExpression() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals((2+(3/5 + 0 - 5 + (4*9))), expressionEvaluator.evaluate("(2+(3/5+0-5+(4*9)))"));
    }

    @Test
    public void operatorPrecedence() {
        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
        assertEquals((1+2)*3, expressionEvaluator.evaluate("(1+2)*3"));
    }
}
