package com.java.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class AsyncProgramming {

    static Object object = new Object();
    private static IntPredicate even = e->e%2==0;
    private static IntPredicate odd = o-> (o % 2) != 0;

    public static void execute(int no){
        synchronized (object){
            try {
                System.out.println(Thread.currentThread().getName() + " " + no);
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printNumber(IntPredicate condition){
        IntStream.rangeClosed(0,10)
                .filter(condition)
                .forEach(AsyncProgramming::execute);
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> AsyncProgramming.printNumber(even));
        CompletableFuture.runAsync(() -> AsyncProgramming.printNumber(odd));
        Thread.sleep(1000);
    }


}
