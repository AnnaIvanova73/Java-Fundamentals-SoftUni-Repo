import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2_TasksPlanner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> tasks = getTasks(scan);
        String input = scan.nextLine();
        while (!"End".equals(input)) {

            String[] tokens = input.split("\\s+");

            int index = 0;
            boolean isValid;
            switch (tokens[0]) {
                case "Complete":
                    index = Integer.parseInt(tokens[1]);
                    isValid = checkExistence(tasks, index);
                    if (isValid) {
                        tasks.set(index, 0);
                    }
                    break;
                case "Change":
                    index = Integer.parseInt(tokens[1]);
                    int time = Integer.parseInt(tokens[2]);
                    isValid = checkExistence(tasks, index);
                    if (isValid) {
                        tasks.set(index,time);
                    }
                    break;
                case "Drop":
                    index = Integer.parseInt(tokens[1]);
                    isValid = checkExistence(tasks, index);
                    if(isValid){
                        tasks.set(index,-1);
                    }
                    break;
                case "Count":
                    String arg = tokens[1];
                    switch (arg){
                        case"Completed":
                            int completed = getCompleted(tasks);
                            System.out.println(completed);
                            break;
                        case"Incomplete":
                            int incomplete = getIncomplete(tasks);
                            System.out.println(incomplete);
                            break;
                        case"Dropped":
                            int dropped = getDropped(tasks);
                            System.out.println(dropped);
                            break;
                    }
                    break;
            }
            input = scan.nextLine();
        }
        List<Integer> integers = removeElementsList(tasks);
        for (Integer currentElement : integers) {
            System.out.print(currentElement + " ");
        }
    }

    private static List<Integer> removeElementsList(List<Integer> tasks) {
        for (int i = 0; i < tasks.size() ; i++) {
            int currentElement = tasks.get(i);
            if (currentElement < 1){
                tasks.remove(Integer.valueOf(currentElement));
                i--;
            }
        }
        return tasks;
    }

    private static int getDropped(List<Integer> tasks) {
        int dropped = 0;
        for (Integer currentTask : tasks) {
            if (currentTask < 0) {
                dropped++;
            }
        }
        return dropped;
    }
    private static int getIncomplete(List<Integer> tasks) {
        int incomplete = 0;

        for (Integer currentTask : tasks) {
            if (currentTask < 6 && currentTask > 0) {
                incomplete++;
            }
        }
        return incomplete;
    }

    private static int getCompleted(List<Integer> tasks) {
        int completed=0;
        for (Integer currentTask : tasks) {
            if (currentTask == 0) {
                completed++;
            }
        }
        return completed;
    }
    private static boolean checkExistence(List<Integer> tasks, int index) {
        if (index >= 0 && index < tasks.size()) {
            return true;
        }
        return false;
    }

    private static int completeTaskCountCompleted(List<Integer> tasks) {
        int completed = 0;
        for (Integer task : tasks) {
            int num = task;
            if (num == 0) {
                completed++;
                tasks.remove(num);
            }
        }
        return completed;
    }

    private static List<Integer> getTasks(Scanner scan) {
        String[] tokens = scan.nextLine().split("\\s+");
        List<Integer> myArray = new ArrayList<>();
        for (String token : tokens) {
            int currentElement = Integer.parseInt(token);
            myArray.add(currentElement);
        }
        return myArray;
    }
}
