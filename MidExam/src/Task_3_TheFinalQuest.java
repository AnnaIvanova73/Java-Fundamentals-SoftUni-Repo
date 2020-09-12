import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task_3_TheFinalQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> riddle = getInput(scan);

        String commands = scan.nextLine();
        while (!"Stop".equals(commands)) {
            String[] tokens = commands.split("\\s+");
            boolean isValid;
            String firstCommand = tokens[0];
            switch (firstCommand) {

                case "Delete":
                    int indexRemove = Integer.parseInt(tokens[1]);
                    indexRemove += 1;
                    isValid = checkExistance(indexRemove, riddle);
                    if (isValid) {
                        riddle.remove(indexRemove);
                    }
                    break;
                case "Swap":
                    String firstWord = tokens[1];
                    String secondWord = tokens[2];
                    boolean hasWord = riddle.contains(firstWord);
                    boolean hasWordTwo = riddle.contains(secondWord);
                    if (hasWord && hasWordTwo) {
                        swapWords (firstWord,secondWord,riddle);
                    }
                    break;
                case "Put":
                    String word = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    index-=1;
                    if (index >= 0 && index <= riddle.size()){
                        riddle.add(index,word);
                    }
                    break;
                case"Sort":
                    Collections.sort(riddle);
                    Collections.reverse(riddle);
                    break;
                case "Replace":
                    String wordOne = tokens[1];
                    String wordTwo = tokens[2];
                    boolean hasElement = riddle.contains(wordTwo);
                    if(hasElement){
                        int wordIndex = riddle.indexOf(wordTwo);
                        riddle.set(wordIndex,wordOne);
                    }
                    break;
            }
            commands = scan.nextLine();
        }

        for (String currentElement : riddle) {
            System.out.print(currentElement + " ");
        }
    }

    private static void swapWords(String firstWord, String secondWord, List<String> riddle) {
        String swap = secondWord;
        int indexSecond = riddle.indexOf(secondWord);
        int indexFirst = riddle.indexOf(firstWord);
        riddle.set(indexSecond, firstWord);
        riddle.set(indexFirst, swap);
    }

    private static boolean checkExistance(int indexRemove, List<String> list) {
        if (indexRemove >= 0 && indexRemove < list.size()) {
            return true;
        }
        return false;
    }

    private static List<String> getInput(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");

        List<String> elements = new ArrayList<>();
        for (String currentElement : input) {
            elements.add(currentElement);
        }
        return elements;
    }
}
