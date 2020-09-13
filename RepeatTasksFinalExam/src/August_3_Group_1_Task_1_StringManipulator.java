import java.util.Scanner;
public class August_3_Group_1_Task_1_StringManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String string = scan.nextLine();

        String input;
        while(!"End".equals(input=scan.nextLine())){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){

                case"Translate":
                    char currentChar = tokens[1].charAt(0);
                    char currentReplacement = tokens[2].charAt(0);
                    System.out.println(string = string.replace(currentChar, currentReplacement));
                    break;
                case"Includes":
                    String currentString = tokens[1];
                    if(!string.contains(currentString)){
                        System.out.println("False");
                        break;
                    }
                    System.out.println("True");
                    break;
                case"Start":
                    String stringStart = tokens[1];
                    int indexStartIndex = string.indexOf(stringStart);
                    if(indexStartIndex == 0){
                        System.out.println("True");
                        break;
                    }
                    System.out.println("False");
                    break;
                case"Lowercase":
                    System.out.println(string = string.toLowerCase());
                    break;
                case"FindIndex":
                    char currChar = tokens[1].charAt(0);
                    int lastIndex = string.lastIndexOf(currChar);
                    System.out.println(lastIndex);
                    break;
                case"Remove":
                    int indexStart = Integer.parseInt(tokens[1]);
                    int countSymbols = Integer.parseInt(tokens[2]);
                    String substring = string.substring(indexStart,indexStart + countSymbols);
                    string = string.replace(substring,"");
                    System.out.println(string);
                    break;

            }
        }
    }
}
