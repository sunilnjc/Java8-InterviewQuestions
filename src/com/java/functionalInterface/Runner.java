package com.java.functionalInterface;

public class Runner {
    public static void main(String[] args) {

        MyFunction function = (s1, s2) -> s1 + s2;
        System.out.println(function.test("Hello", "World"));


    }
}
