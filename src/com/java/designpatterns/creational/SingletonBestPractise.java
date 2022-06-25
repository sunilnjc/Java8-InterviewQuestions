package com.java.designpatterns.creational;

public class SingletonBestPractise {

    // private constructor
    private SingletonBestPractise(){
    }

    // static reference - private and static
    // Add a wrapper by wrapping around a class
    private static class LazyInnerSingleton {
        private static SingletonBestPractise instance = new SingletonBestPractise();
    }

    // factory method
    public static SingletonBestPractise getSingleton() {
       return LazyInnerSingleton.instance;
    }

    public static void main(String[] args) {

        SingletonBestPractise singletonObj1 = SingletonBestPractise.getSingleton();
        System.out.println(singletonObj1.hashCode());

        SingletonBestPractise singletonObj2 = SingletonBestPractise.getSingleton();
        System.out.println(singletonObj2.hashCode());

    }

}
