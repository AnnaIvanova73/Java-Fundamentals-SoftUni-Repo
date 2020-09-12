package Lab_6_Students_2_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Students_2_0> students = new ArrayList<>();

        String firstName = scan.next();
        while (!"end".equals(firstName)) {
            String lastName = scan.next();
            int age = scan.nextInt();
            String hometown = scan.next();



            Students_2_0 existingStudent = findStudent(firstName,lastName,students);
            if(existingStudent != null ){
                existingStudent.setAge(age);
                existingStudent.setHometown(hometown);
            }else{
                Students_2_0 currStudent = new Students_2_0(firstName, lastName, age, hometown);
                students.add(currStudent);
            }

            firstName = scan.next();
        }


        String townSearched = scan.next();

        for (Students_2_0  student : students) {
            String currentTown = student.getHometown();
            if(currentTown.equals(townSearched)){
                System.out.printf("%s %s is %d years old%n",
                        student.getFirstName(),
                        student.getLastName(),student.getAge());
            }
        }


    }

    static Students_2_0 findStudent (String firstName, String lastName, List<Students_2_0> students){
        for (Students_2_0 student : students) {
            if(student.getFirstName().equals(firstName) &&
                    student.getLastName().equals(lastName)){
                return student;
            }
        }
        return null;
    }

}

