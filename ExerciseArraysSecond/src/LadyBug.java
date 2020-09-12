import java.util.Scanner;

public class LadyBug {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scan.nextLine());
        int[] field = new int[fieldSize];

        String[] ladyBugsIndexes = scan.nextLine().split("\\s++");
        //int[] ladyBugs = new int[ladyBugsIndexes.length];

        for (int i = 0; i < ladyBugsIndexes.length ; i++) {
            int index = Integer.parseInt(ladyBugsIndexes[i]);
            if (index >= 0 && index < field.length) {
                field[index] = 1;
            }
        }


        String input = scan.nextLine();
        while (!"end".equals(input)){

            String[]commands = input.split("\\s+");
            int index = Integer.parseInt(commands[0]);
            String currentCommand = commands[1];
            int flyLength= Integer.parseInt(commands[2]);









        }












    }
}
