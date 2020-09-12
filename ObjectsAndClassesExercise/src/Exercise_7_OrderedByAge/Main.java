package Exercise_7_OrderedByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        String name = scan.next();
        while(!name.equals("End")){

            String id = scan.next();
            int age = scan.nextInt();

            Person currentPerson = new Person(name,id,age);
            persons.add(currentPerson);

            name=scan.next();
        }
        persons.sort((a,b) -> a.getAge()- b.getAge());

        for (Person person : persons) {
            System.out.println(person.toString());
        }
    }
}
