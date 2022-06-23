package com.company;

import java.util.Set;

public class ExpressionEvaluator {
    private static final char ADDITION = '+';
    private static final char MULTIPLICATION = '*';
    private static final char SUBTRACTION = '-';
    private static final char DIVISION = '/';

    private static final Set<Character> MULTIPLICATIVE_OPERATORS = Set.of(MULTIPLICATION, DIVISION);
    private static final Set<Character> ADDITIVE_OPERATORS = Set.of(ADDITION, SUBTRACTION);

    private String expression;
    private int index;

    public long evaluate(String expression) {
        if (expression.isEmpty()) return 0;
        this.expression = expression;
        this.index = 0;
        return addition();
    }

    private long addition() {
        long result = multiplication();
        while (index < expression.length() && isAdditiveOperator(expression.charAt(index))) {
            char operator = expression.charAt(index++);
            result = applyOperator(result, multiplication(), operator);
        }
        return result;
    }

    private long multiplication() {
        long result = digit();
        while (index < expression.length() && isMultiplicativeOperator(expression.charAt(index))) {
            char operator = expression.charAt(index++);
            result = applyOperator(result, digit(), operator);
        }
        return result;
    }

    private long digit() {
        if (isOpeningBrace()) {
            index++;
            long result = addition();
            index++;
            return result;
        }
        long result = toNumber(expression.charAt(index));
        index++;
        return result;
    }

    private long toNumber(char c) {
        return c - '0';
    }

    private boolean isAdditiveOperator(char c) {
        return ADDITIVE_OPERATORS.contains(c);
    }

    private boolean isMultiplicativeOperator(char c) {
        return MULTIPLICATIVE_OPERATORS.contains(c);
    }

    private boolean isOpeningBrace() {
        return expression.charAt(index) == '(';
    }

    private long applyOperator(long a, long b,char operator) {
        return switch(operator) {
            case ADDITION -> a + b;
            case MULTIPLICATION -> a * b;
            case SUBTRACTION -> a - b;
            case DIVISION -> a / b;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
