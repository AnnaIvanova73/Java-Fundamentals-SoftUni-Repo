import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Task_1_StringManipulator_Group_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        StringBuilder changeString = new StringBuilder();
        changeString.append(input);

        String cmd = scan.nextLine();
        while (!"Done".equals(cmd)) {
            String[] tokens = cmd.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Change":
                    String current = tokens[1];
                    String replacement = tokens[2];
                    int index = changeString.indexOf(current);
                    if(index <0){
                        break;
                    }
                    while(index > -1){
                        changeString.setCharAt(index,replacement.charAt(0));
                        index = changeString.indexOf(current);
                    }
                    System.out.println(changeString);
                    break;
                case "Includes":
                    String currentString = tokens[1];
                    String toString = changeString.toString();
                    if(toString.contains(currentString)){
                        System.out.println("True");
                        break;
                    }
                    System.out.println("False");
                    break;
                case "End":
                    // да  дава ли true, ako string-a e po - дълъг
                    String includes = tokens[1];
                    int indexIncludes = changeString.lastIndexOf(includes);
                    int length = indexIncludes + includes.length();
                    if(length == changeString.length()){
                        System.out.println("True");
                        break;
                    }
                    System.out.println("False");
                    break;
                case "Uppercase":
                    String upperCase = changeString.toString().toUpperCase();
                    System.out.println(upperCase);
                    changeString.setLength(0);
                    changeString.append(upperCase);
                    break;
                case "FindIndex":
                    String find = tokens[1];
                    int findIndex = changeString.indexOf(find);
                    System.out.println(findIndex);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int lengthCut = Integer.parseInt(tokens[2]);
                    String substring = changeString.substring(startIndex, startIndex+lengthCut);
                    changeString.setLength(0);
                    changeString.append(substring);
                    System.out.println(substring);
                    break;
            }


            cmd = scan.nextLine();
        }


    }
}
