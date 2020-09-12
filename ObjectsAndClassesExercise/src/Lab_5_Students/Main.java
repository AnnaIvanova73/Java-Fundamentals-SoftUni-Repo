package Lab_5_Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Students> listStudents = new ArrayList<>();

        String firstName = scan.next();
        while (!"end".equals(firstName)) {
            String lastName = scan.next();
            int age = scan.nextInt();
            String hometown = scan.next();

            Students currentStudent = new Students(firstName,lastName,age,hometown);
            listStudents.add(currentStudent);

            firstName = scan.next();
        }


        String townSearched = scan.next();

        for (Students listStudent : listStudents) {
            String currentTown = listStudent.getHometown();
            if(currentTown.equals(townSearched)){
                System.out.printf("%s %s is %d years old%n",
                        listStudent.getFirstName(),
                        listStudent.getLastName(),listStudent.getAge());
            }
        }
    }


}
