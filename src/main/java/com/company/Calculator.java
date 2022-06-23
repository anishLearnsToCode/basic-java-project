package com.company;

import java.util.Set;
import java.util.Stack;

public class Calculator {
    private static final char MULTIPLICATION = '*';
    private static final char ADDITION = '+';
    private static final Set<Character> OPERATORS = Set.of(ADDITION, MULTIPLICATION);

    public long evaluate(String expression) {
        final Stack<String> stack = new Stack<>();
        for (int i = 0 ;  i < expression.length() ; i++) {
            final char character = expression.charAt(i);
            if (isOperator(character)) {
                stack.push(getString(character));
            } else {
                if (!stack.isEmpty() && isMultiplication(stack.peek())) {
                    stack.pop();
                    String previousNumber = stack.pop();
                    stack.push(multiply(getString(character), previousNumber));
                } else {
                    stack.push(getString(character));
                }
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            String element = stack.pop();
            if (isNumber(element)) {
                result += toNumber(element);
            }
        }

        return result;
    }

    private boolean isOperator(char c) {
        return OPERATORS.contains(c);
    }

    private boolean isMultiplication(String c) {
        return c.equals(getString(MULTIPLICATION));
    }

    private boolean isNumber(String s) {
        return s.length() > 1 || !OPERATORS.contains(s.charAt(0));
    }

    private String getString(char c) {
        return c + "";
    }

    private String getString(int a) {
        return a + "";
    }

    private String multiply(String a, String b) {
        return getString(toNumber(a) * toNumber(b));
    }

    private String add(char a, char b) {
        return getString(toNumber(a) + toNumber(b));
    }

    private int toNumber(String s) {
        int result = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            int digit = toNumber(s.charAt(i));
            result = 10 * result + digit;
        }
        return result;
    }

    private int toNumber(char c) {
        return c - '0';
    }
}
