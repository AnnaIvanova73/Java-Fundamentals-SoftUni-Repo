import java.util.Scanner;

public class August_3_Group_2_Task_1_StringManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String string = scan.nextLine();

        String input;
        while(!(input = scan.nextLine()).equals("Done")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case"Change":
                    char currentChar = tokens[1].charAt(0);
                    char replacement = tokens[2].charAt(0);
                    System.out.println(string = string.replace(currentChar, replacement));
                    break;
                case"Includes":
                    String currentString = tokens[1];
                    if(string.contains(currentString)){
                        System.out.println("True");
                    }else{
                        System.out.println("False");
                    }
                    break;
                case"End":
                    String substring = tokens[1];
                    int indexOfSubstring =string.lastIndexOf(substring);
                    int lengthToMatch =substring.length() + indexOfSubstring;
                    if(lengthToMatch == string.length()){
                        System.out.println("True");
                        break;
                    }
                        System.out.println("False");
                    break;
                case"Uppercase":
                    System.out.println(string = string.toUpperCase());
                    break;
                case"FindIndex":
                    char currChar = tokens[1].charAt(0);
                    int indexChar = string.indexOf(currChar);
                    System.out.println(indexChar);
                    break;
                case"Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    System.out.println(string = string.substring(startIndex, startIndex + length));
                    break;

            }
        }
    }
}
