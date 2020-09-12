package Exercise_5_Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countOfStudents = Integer.parseInt(scan.nextLine());

        List<Students> listOfStudents = new ArrayList<>();

        for (int i = 0; i < countOfStudents ; i++) {
            String firstName = scan.next().trim();
            String secondName = scan.next().trim();
            double grade = Double.parseDouble(scan.next());
            Students currentStudent = new Students(firstName,secondName,grade);
            listOfStudents.add(currentStudent);
        }

        listOfStudents.sort(Comparator.comparingDouble(f -> f.getGrade()));
        Collections.reverse(listOfStudents);
        for (Students currentStudent : listOfStudents) {
            System.out.println(currentStudent);
        }
    }
}
