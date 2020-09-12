import java.util.Scanner;

public class LadyBugMartin {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scan.nextLine());

        String[] indexes = scan.nextLine().split(" ");

        int[] field = new int[fieldSize];


        for (int i = 0; i < indexes.length; i++) {//дължината е калинки
            int index = Integer.parseInt(indexes[i]);
            if (index >= 0 && index < field.length) {
                field[index] = 1;
            }
        }

        String command = scan.nextLine();

        while (!"end".equals(command)) {

            String[] cmdArguments = command.split(" ");
            int index = Integer.parseInt(cmdArguments[0]);// коя калинка,на кой индекс
            String cmd = cmdArguments[1];
            int flyLength = Integer.parseInt(cmdArguments[2]);

            if (index < 0 || index > field.length - 1 ||//ако не излети и няма какво да излети,чета нови команди
                    field[index] == 0) {//полето от индекс две няма калинка,няма какво да лети
                command = scan.nextLine();
                continue;
            }
            field[index] = 0;

            if ("right".equals(cmd)) {
                index += flyLength;
                while (index < field.length && field[index] == 1) {
                    index += flyLength;
                }
                if (index < field.length) {
                    field[index] = 1;
                }
            } else {
                index-=flyLength;
                while(index >= 0 && field[index] == 1){
                    index-=flyLength;
                }
                if(index>=0){
                    field[index]=1;
                }
            }

            command = scan.nextLine();
        }

        for (int ladyBug: field) {
            System.out.print(ladyBug + " ");
        }
    }
}
