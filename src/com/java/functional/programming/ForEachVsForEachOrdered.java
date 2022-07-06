package com.java.functional.programming;

import java.util.Arrays;
import java.util.List;

public class ForEachVsForEachOrdered {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //forEach is unordered when you apply parallel
        // It depends on the stream too - list is ordered, set is unordered
        numbers.stream()
                .parallel()
                .map(e -> transformMap(e))
                .forEach(System.out::println);

        //forEachOrdered is ordered when you apply parallel
        // Only when the stream is ordered such as LIST
        //Ordering doesn't work on SET because set is unordered

        numbers.stream()
                .parallel()
                .map(e -> transformMap(e))
                .forEachOrdered(System.out::println);
    }

    private static int transformMap(Integer e) {
        try {
            Thread.sleep(1000);
//            System.out.println("Execution order "+ e);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        return e;
    }
}
