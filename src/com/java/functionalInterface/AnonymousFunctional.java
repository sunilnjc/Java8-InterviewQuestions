package com.java.functionalInterface;

import java.util.function.Function;

public class AnonymousFunctional {

    public String sound(Function<String, String> function, String animal){
        return function.apply(animal);
    }

    public static void main(String[] args) {

        AnonymousFunctional functional = new AnonymousFunctional();
        String animal = "pig";

        Function<String, String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return "cry";
            }
        };

        Integer value = Integer.valueOf("10");

        System.out.println(functional.sound(function, animal));
    }

}
