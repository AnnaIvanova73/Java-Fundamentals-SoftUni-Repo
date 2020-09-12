import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> lessons = getLessons(scan);


        String input = scan.nextLine();
        while (!"course start".equals(input)) {
            String[] tokens = input.split(":");

            String command = tokens[0];
            String lesson = tokens[1];
            String exerciseName = String.format("%s-Exercise", lesson);

            boolean hasExercise = checkExistence(exerciseName, lessons);
            boolean hasLesson = checkExistence(lesson, lessons);

            switch (command) {
                case "Add":
                    if (!hasLesson) {
                        lessons.add(lesson);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (!hasLesson) {
                        lessons.add(index, lesson);
                    }
                    break;

                case "Remove":
                    if (hasLesson) {
                        lessons.remove(lesson);
                    }
                    if (hasExercise) {
                        lessons.remove(exerciseName);
                    }
                    break;
                case "Swap":

                    String lessonPerSwap = tokens[2];
                    String exerciseSecond = String.format("%s-Exercise", lessonPerSwap);
                    boolean hasSecondExercise = checkExistence(exerciseSecond, lessons);
                    boolean hasSecondLesson = checkExistence(lessonPerSwap, lessons);
                    int indexOne = lessons.indexOf(lesson);
                    int indexTwo = lessons.indexOf(lessonPerSwap);
                    int exerciseIndices;

                    if (hasSecondLesson && hasLesson) {
                        String temp = lessons.get(indexOne);
                        lessons.set(indexOne, lessonPerSwap);
                        lessons.set(indexTwo, temp);
                    }
                    if (hasSecondExercise) {
                        String temp = exerciseSecond;
                        exerciseIndices = lessons.indexOf(exerciseSecond);
                        lessons.remove(exerciseIndices);
                        lessons.add(indexOne + 1, temp);

                    }
                    if (hasExercise) {
                        String temp = exerciseName;
                        exerciseIndices = lessons.indexOf(exerciseName);
                        lessons.remove(exerciseIndices);
                        lessons.add(indexTwo + 1, temp);

                    }
                    break;
                case "Exercise":
                    int position = findIndexLesson (lesson,lessons);
                    if (!hasExercise && hasLesson) {
                            lessons.add(position+1,exerciseName);
                    }

                    if (!hasLesson && !hasExercise) {
                        lessons.add(lesson);
                        lessons.add(exerciseName);
                        break;
                    }


            }
            input = scan.nextLine();
        }
        int count = 0;
        for (String lesson : lessons) {
            count++;
            System.out.printf("%d.%s%n", count, lesson);
        }
    }

    private static int findIndexLesson(String lesson, List<String> lessons) {
        int index =0;
        for (int i = 0; i < lessons.size() ; i++) {
            String currentElement = lessons.get(i);
           if(currentElement.equals(lesson)){
               index=i;
               break;
           }
        }
        return index;
    }


    private static boolean checkExistence(String lesson, List<String> lessons) {

        for (String elements : lessons) {
            if (elements.equals(lesson)) {
                return true;
            }
        }
        return false;
    }


    private static List<String> getLessons(Scanner scan) {
        String[] input = scan.nextLine().split(", ");
        List<String> arrList = new ArrayList<>();
        for (String element : input) {
            arrList.add(element);
        }
        return arrList;
    }
}
