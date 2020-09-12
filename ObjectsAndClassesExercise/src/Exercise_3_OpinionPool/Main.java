package Exercise_3_OpinionPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int linesPersonalInformation = Integer.parseInt(scan.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < linesPersonalInformation ; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name,age);
            people.add(person);
        }

        people
                .stream()
                .filter(p -> p.getAge() > 30)
                .sorted((p1,p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.println(p.toString()));
    }
}
