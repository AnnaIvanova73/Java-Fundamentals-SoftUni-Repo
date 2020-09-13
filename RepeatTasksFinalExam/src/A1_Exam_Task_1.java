import java.util.Scanner;

public class A1_Exam_Task_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String givenString = scan.nextLine();

        String input = scan.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "TakeOdd":
                    givenString = gedOdd(givenString);
                    System.out.println(givenString);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    int lastIndex = startIndex+length;
                    givenString = remove(startIndex,lastIndex,givenString);
                    System.out.println(givenString);
                    break;
                case "Substitute":
                    String current = tokens[1];
                    String replacement = tokens[2];
                    if(!givenString.contains(current)){
                        System.out.println("Nothing to replace!");
                        break;
                    }
                    System.out.println(givenString = givenString.replace(current, replacement));
                    break;
            }

            input = scan.nextLine();
        }

        System.out.println("Your password is: " + givenString);
    }

    private static String remove(int startIndex, int lastIndex, String givenString) {
        StringBuilder assist = new StringBuilder();
        assist.append(givenString);
        assist.delete(startIndex,lastIndex);
        return assist.toString();
    }

    private static String gedOdd(String givenString) {
        StringBuilder assist = new StringBuilder();

        for (int i = 0; i < givenString.length() ; i++) {
            char ch = givenString.charAt(i);
            if(i % 2 != 0){
                assist.append(ch);
            }
        }
        return assist.toString();
    }
}
