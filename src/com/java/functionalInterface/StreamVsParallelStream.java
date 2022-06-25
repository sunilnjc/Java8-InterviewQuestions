package com.java.functionalInterface;

import java.util.stream.IntStream;

public class StreamVsParallelStream {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        IntStream.rangeClosed(1,10)
                .forEach(t -> System.out.println(Thread.currentThread().getName()+ " " + t));
        long endTime = System.currentTimeMillis();

        long totalTime = endTime - startTime;
        System.out.println("sequential flow " + totalTime);

        long startTime1 = System.currentTimeMillis();
        IntStream.rangeClosed(1,10)
                .parallel()
                .forEach(t -> System.out.println(Thread.currentThread().getName()+ " " + t));
        long endTime1 = System.currentTimeMillis();
        long totalTime1 = endTime1 - startTime1;
        System.out.println("parallel flow " + totalTime1);


    }
}
