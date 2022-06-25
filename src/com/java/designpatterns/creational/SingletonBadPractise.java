package com.java.designpatterns.creational;

public class SingletonBadPractise {

    // private constructor
    private SingletonBadPractise(){
    }

    // static reference - private and static
    private static SingletonBadPractise instance = null;

    // factory method
    public static SingletonBadPractise getSingleton() {
        if(instance == null){
            instance = new SingletonBadPractise();
        }
        return instance;
    }

    public static void main(String[] args) {

        SingletonBadPractise singletonObj1 = SingletonBadPractise.getSingleton();
        System.out.println(singletonObj1.hashCode());

        SingletonBadPractise singletonObj2 = SingletonBadPractise.getSingleton();
        System.out.println(singletonObj2.hashCode());

    }

}
