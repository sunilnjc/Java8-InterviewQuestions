package com.java.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Masheq bank interview question
 * Find duplicate Elements in a list via Java 8
 */
public class DuplicateElements {

    public static void main(String[] args) {

        Set<String> collect = Arrays.asList("A", "B", "C", "A")
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        System.out.println(collect);
    }
}
