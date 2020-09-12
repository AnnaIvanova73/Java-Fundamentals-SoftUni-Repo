import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2_FriendListMaintenance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> friendsList = getFrineds(scan);

        int countBlackListed = 0;
        int countOfLostNames = 0;
        String input = scan.nextLine();
        while (!"Report".equals(input)) {
            String[] tokens = input.split("\\s+");
            String cmdArgs = tokens[0];

            switch (cmdArgs) {

                case "Blacklist": {
                    String friendName = tokens[1];
                    if (friendsList.contains(friendName)) {
                        int index = friendsList.indexOf(friendName);
                        friendsList.set(index, "Blacklisted");
                        countBlackListed++;
                        System.out.printf("%s was blacklisted.\n", friendName);
                    } else {
                        System.out.printf("%s was not found.\n", friendName);
                    }
                    break;
                }

                case "Error": {
                    int index = Integer.parseInt(tokens[1]);
                    boolean isValid = checkIndex(index, friendsList);
                    if (isValid) {
                        String friendName = friendsList.get(index);
                        if (!"Blacklisted".equals(friendName) && !"Lost".equals(friendName)) {

                            friendsList.set(index, "Lost");
                            countOfLostNames++;
                            System.out.println(friendName + " was lost due to an error.");
                        }
                    }
                    break;
                }

                case "Change": {
                    int index = Integer.parseInt(tokens[1]);
                    boolean isValid = checkIndex(index, friendsList);

                    if (isValid) {
                        String oldName = friendsList.get(index);
                        String newName = tokens[2];
                        friendsList.set(index, newName);
                        System.out.printf("%s changed his username to %s.\n", oldName, newName);
                    }
                    break;
                }
            }

            input = scan.nextLine();
        }

        System.out.printf("Blacklisted names: %d\n", countBlackListed);
        System.out.printf("Lost names: %d\n", countOfLostNames);
        for (int i = 0; i < friendsList.size() - 1; i++) {
            System.out.print(friendsList.get(i) + " ");
        }
        if (friendsList.size() > 0) {
            System.out.println(friendsList.get(friendsList.size() - 1));
        }

    }

    private static boolean checkIndex(int index, List<String> lost) {
        if (index >= 0 && index < lost.size()) {
            return true;
        }
        return false;
    }

    private static List<String> getFrineds(Scanner scan) {
        String[] input = scan.nextLine().split(", ");
        List<String> array = new ArrayList<>();

        for (String elements : input) {
            array.add(elements);
        }
        return array;
    }
}
