package com.java.functionalInterface;

import javax.swing.text.html.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxSalaryDept {
    public static void main(String[] args) {

        List<Employee> employeeList = Stream.of(
                new Employee(101,"john","A","DEV", 60000),
                new Employee(109,"peter","B","DEV",30000),
                new Employee(102,"mak","A","QA",80000),
                new Employee(103,"kim","A","QA",90000),
                new Employee(104,"json","C","DevOps",15000))
                .collect(Collectors.toList());

        Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary);

        Map<String, Optional<Employee>> employeeMap = employeeList.stream()
                .collect(
                        Collectors.groupingBy(
                        Employee::getDepartment,
                                Collectors.reducing(BinaryOperator.maxBy(comparator)))
        );

        System.out.println(employeeMap);

        // Approach 2

        Map<String, Employee> collect = employeeList.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)
                        ));
        System.out.println(collect);

        //Practise

        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingDouble(Employee::getSalary)))));

    }
}
