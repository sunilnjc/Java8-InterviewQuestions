package com.java.functional.programming;

import java.util.Arrays;
import java.util.List;

public class Streams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Find the even number and double it
        // Imperative style of programming

        int totalImperative = 0;
        for(Integer e : numbers){
            if(e % 2 == 0){
                totalImperative += e * 2;
            }
        }
        System.out.println("Imperative programming result " + totalImperative);

        //Functional programming
        // Martin Fowler - Collection Pipeline Pattern

        int totalFunctional = numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(value -> value * 2)
                .sum();

        System.out.println("Functional programming result "+ totalFunctional);

    }
}
