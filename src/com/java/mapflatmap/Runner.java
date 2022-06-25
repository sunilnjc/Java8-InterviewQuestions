package com.java.mapflatmap;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {

        List<Customer> customerData = CustomerDatabase.getAll();

//        Map works on a single stream and returns a stream of data - one to one mapping
        List<String> email = customerData.stream().map(Customer::getEmail).collect(Collectors.toList());
        System.out.println(email);

        // stream of stream of data and returns stream of stream of data by using map. - data transformation
        List<List<String>> phoneNumbers = customerData.stream()
                .map(Customer::getPhoneNumbers)
                .collect(Collectors.toList());

        System.out.println(phoneNumbers);

        // flatmap - one to many mapping - data transformation and data flattening
        // parallel streaming
        long startTime = System.currentTimeMillis();
        List<String> flatPhoneNumbers = customerData.stream().parallel()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("parallel streaming with the time frame " + flatPhoneNumbers + " " + totalTime);


        long startTime1 = System.currentTimeMillis();
        List<String> flatPhoneNumberSequential = customerData.stream()
                .flatMap(customer -> customer.getPhoneNumbers().stream())
                .collect(Collectors.toList());
        long endTime1 = System.currentTimeMillis();
        long totalTime1 = endTime1 - startTime1;

        System.out.println("Sequential streaming with time frame " + flatPhoneNumberSequential + " " + totalTime1);

    }
}
