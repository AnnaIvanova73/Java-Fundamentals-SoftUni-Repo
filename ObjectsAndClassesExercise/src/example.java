import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class example {


    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        Map<String, List<Employee>> departments = new HashMap<>();

        while (lines-- > 0) {

            String input = scanner.nextLine();

            List<String> data = Arrays.stream(input.split(" ")).collect(Collectors.toList());

            String name = data.get(0);
            double salary = Double.parseDouble(data.get(1));
            String position = data.get(2);
            String department = data.get(3);

            Employee employee = new Employee(name, salary, position, department);

            if (data.size() == 5) {
                if (input.contains("@")) {
                    employee.email = data.get(4);
                } else {
                    employee.setAge(Integer.parseInt(data.get(4)));
                }
            } else if (data.size() == 6) {
                employee.setEmail(data.get(4));
                employee.setAge(Integer.parseInt(data.get(5)));

            }
            if (!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            } else {
                departments.get(department).add(employee);
            }
        }

        departments.entrySet().stream().sorted((a, b) -> {
            double avrFirst = a.getValue().stream()
                    .mapToDouble(Employee::getSalary).average().orElse(Double.NaN);
            double avrSecond = b.getValue().stream()
                    .mapToDouble(Employee::getSalary).average().orElse(Double.NaN);
            return Double.compare(avrSecond, avrFirst);

        }).limit(1).forEach(e -> {
            System.out.println(String.format("Highest Average Salary: %s", e.getKey()));
            e.getValue().stream().sorted((a,b) ->
                    Double.compare(b.getSalary(),
                            a.getSalary()))
                    .forEach(o -> System.out.println(String.format("%s %.2f %s %d", o.getName(),
                            o.getSalary(), o.getEmail(), o.getAge())));
        });


    }

    public static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email;
        private int age;

        public Employee(String name, double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = "n/a";
            this.age = -1;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getPosition() {
            return position;
        }

        public String getDepartment() {
            return department;
        }

        public String getEmail() {
            return email;
        }

        public int getAge() {
            return age;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}