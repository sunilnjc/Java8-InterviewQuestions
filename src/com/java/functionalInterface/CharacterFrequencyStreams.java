package com.java.functionalInterface;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequencyStreams {
    public static void main(String[] args) {

        String str = "Sunilkumar Kalabandis";


        //approach 1
        Map<String, Long> frequencyMap =
                Arrays.stream(str.split(""))
                        .map(s -> s.toLowerCase())
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting())
                );

        System.out.println(frequencyMap);


    }
}
