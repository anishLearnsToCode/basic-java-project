package com.company;

public class HelloWorld {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.evaluate(""));
        System.out.println(calculator.evaluate("2"));
        System.out.println(calculator.evaluate("2+1"));
        System.out.println(calculator.evaluate("2+1+4"));
        System.out.println(calculator.evaluate("2*3"));
        System.out.println(calculator.evaluate("2*3+5"));
        System.out.println(calculator.evaluate("2*3+5*8"));
    }
}
