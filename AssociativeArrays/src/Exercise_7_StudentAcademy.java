import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_7_StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int students = Integer.parseInt(scan.nextLine());

        Map<String, ArrayList<Double>> diaryStudents = new HashMap<>();
        for (int i = 0; i <students ; i++) {
            String nameStudent = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());

            diaryStudents.putIfAbsent(nameStudent,new ArrayList<>());
            diaryStudents.get(nameStudent).add(grade);
        }

        diaryStudents
                .entrySet()
                .stream()
                .filter(s -> s
                        .getValue()
                        .stream()
                        .mapToDouble(Double::valueOf)
                        .average()
                        .getAsDouble() >= 4.50)
                .sorted((s1,s2) ->{
                    double first = s1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double second = s2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(second,first);
                })
                .forEach(s -> System.out.println(String.format("%s -> %.2f",s.getKey(),
                s.getValue().stream().mapToDouble(Double:: valueOf)
                .average()
                .getAsDouble())));


    }
}
