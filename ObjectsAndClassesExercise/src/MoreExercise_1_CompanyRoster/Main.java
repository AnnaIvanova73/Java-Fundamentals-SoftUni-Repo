package MoreExercise_1_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int employeeCount = Integer.parseInt(scan.nextLine());

        Map<String, List<Employee>> departments = new HashMap<>();

        for (int i = 0; i < employeeCount; i++) {
            String[] empl = scan.nextLine().split("\\s+");
            String name = empl[0];
            double salary = Double.parseDouble(empl[1]);
            String position = empl[2];
            String department = empl[3];
            String email = "n/a";
            int age = -1;
            Employee newEmployee = new Employee(name, salary, position, department, email, age);

            if (empl.length == 5 && empl[4].contains("@")) {
                email = empl[4];
                newEmployee.setEmail(email);
            }
            if (empl.length == 5 && !empl[4].contains("@")) {
                age = Integer.parseInt(empl[4]);
                newEmployee.setAge(age);
            }
            if (empl.length == 6) {
                email = empl[4];
                age = Integer.parseInt(empl[5]);
                newEmployee.setEmail(email);
                newEmployee.setAge(age);
            }

            departments.putIfAbsent(department,new ArrayList<>());
            departments.get(department).add(newEmployee);

        }

        departments
                .entrySet()
                .stream()
                .sorted((s1,s2) -> {
                    double first = s1.getValue()
                            .stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();
                    double second = s2.getValue()
                            .stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .getAsDouble();
                    return Double.compare(second,first);
                })
                .limit(1)
                .forEach( e -> {
                    System.out.println(String.format("Highest Average Salary: %s", e.getKey()));
                    e.getValue()
                            .stream()
                            .sorted((s1,s2) ->
                                    Double.compare(s2.getSalary(),s1.getSalary()))
                            .forEach(o -> System.out.println(String.format("%s %.2f %s %d", o.getName(),
                                    o.getSalary(), o.getEmail(), o.getAge())));
                });


    }
}
