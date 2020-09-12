import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int commandsCount = Integer.parseInt(scan.nextLine());

        List<String> names = new ArrayList<>();

        for (int i = 0; i < commandsCount; i++) {
            String[] cmdArg = scan.nextLine().split("\\s+");
            String name = cmdArg[0];
            String command = cmdArg[2];
            if ("going!".equals(command)) {
                if (names.contains(name)) {
                    System.out.printf("%s is already in the list!\n", name);
                } else {
                    names.add(name);
                }
            } else {
                if (!names.contains(name)) {
                    System.out.printf("%s is not in the list!\n", name);
                }else {
                    names.remove(name);
                }
            }


        }
        for (String current : names) {
            System.out.println(current);
        }

    }

}

