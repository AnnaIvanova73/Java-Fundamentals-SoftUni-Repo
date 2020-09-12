import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class asdfaf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

//        for (int i = 0; i < input.size(); i++) {
//            String element = input.get(i);
//            for (int j = 0; j < element.length(); j++) {
//                char symbol = element.charAt(j);
//                if (symbol == 32) {
//                    return;
//                }
//            }
//        }

        String command = scanner.nextLine();

        while (!"3:1".equals(command)) {
            String[] splitTheCommand = command.split("\\s+");

            switch (splitTheCommand[0]) {
                case "merge":

                    int startIndex = Integer.parseInt(splitTheCommand[1]);
                    int endIndex = Integer.parseInt(splitTheCommand[2]);

                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex > input.size() - 1) {
                        endIndex = input.size() - 1;
                    }
                    int counter = startIndex;

                    for (int i = startIndex; i < endIndex; i++) {
                        String concat = input.get(counter) + input.get(counter + 1);
                        input.set(counter, concat);
                        input.remove(counter + 1);
                    }
                    break;
                case "divide":
                    int index = Integer.parseInt(splitTheCommand[1]);
                    int partitions = Integer.parseInt(splitTheCommand[2]);

                    if (index >= 0 && index < input.size() && partitions >= 0 && partitions <= 100) {
                        String element = input.get(index);
                        List<String> newList = new ArrayList<>();

                        if (element.length() % partitions == 0) {
                            int portionLength = element.length() / partitions;
                            int count = 0;
                            for (int i = 0; i < partitions; i++) {
                                String concat = "";
                                for (int j = 0; j < portionLength; j++) {
                                    char symbol = element.charAt(count);
                                    concat += symbol;
                                    count++;
                                }
                                newList.add(concat);
                            }
                        } else {
                            int portionLength = element.length() / partitions;
                            int count = 0;
                            for (int i = 0; i < partitions; i++) {
                                String concat = "";

                                if (i == partitions - 1) {
                                    for (int j = count; j < element.length(); j++) {
                                        char symbol = element.charAt(count);
                                        concat += symbol;
                                        count++;
                                    }
                                } else {
                                    for (int j = 0; j < portionLength; j++) {
                                        char symbol = element.charAt(count);
                                        concat += symbol;
                                        count++;
                                    }
                                }
                                newList.add(concat);
                            }
                        }
                        input.remove(index);
                        input.addAll(index, newList);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        for (String item : input) {
            System.out.print(item + " ");
        }
    }
}
