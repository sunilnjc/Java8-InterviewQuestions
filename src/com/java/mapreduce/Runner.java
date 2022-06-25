package com.java.mapreduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {

        List<Employee> employeeList = EmployeeDatabase.getEmployees();

        List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

        List<String> words = Arrays.asList("corejava", "spring", "hibernate");

        int sum = 0;
        for (int no : numbers) {
            sum = sum + no;
        }
        System.out.println(sum);

        Optional<Integer> numbersSum = numbers.stream().reduce((a, b) -> a + b);
        Optional<Integer> numbersSum2 = numbers.stream().reduce(Integer::sum);
        System.out.println(numbersSum.get());

        // use map to return the name of employees whose grade is A
        List<String> employeeName = employeeList.stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(employee -> employee.getName()).collect(Collectors.toList());
        System.out.println(employeeName);

        // return average salary of grade A employee
        employeeList.stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i->i)
                .average().getAsDouble();

    }
}
