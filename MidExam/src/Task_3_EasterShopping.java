import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_3_EasterShopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> storesLists = getMyStoresList(scan);

        int countOfCommands = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < countOfCommands; i++) {
            String[] cmdArgs = scan.nextLine().split("\\s+");
            String command = cmdArgs[0];
            String shop;
            boolean isValid;
            switch (command) {
                case "Include":
                    shop = cmdArgs[1];
                    storesLists.add(shop);
                    break;

                case "Visit":
                    shop = cmdArgs[1];
                    int countToRemove = Integer.parseInt(cmdArgs[2]);
                    if (countToRemove < 1 || countToRemove > storesLists.size()) {
                        break;
                    }
                    if (shop.equals("first")) {
                        int indexStartRemoving = countToRemove - 1;
                        for (int j = 0; j < countToRemove; j++) {
                            int indexToRemove = indexStartRemoving - j;
                            storesLists.remove(indexToRemove);
                        }
                    } else {
                        for (int j = 0; j < countToRemove; j++) {
                            int lastIndex = storesLists.size() - 1;
                            storesLists.remove(lastIndex);
                        }
                    }
                    break;
                case "Prefer":
                    int firstShop = Integer.parseInt(cmdArgs[1]);
                    int secondShop = Integer.parseInt(cmdArgs[2]);
                    isValid = checkExistence(firstShop, storesLists);
                    boolean isSecondValid = checkExistence(secondShop, storesLists);
                    if (isValid && isSecondValid) {
                        String shopOne = storesLists.get(firstShop);
                        String shopTwo = storesLists.get(secondShop);
                        shop= shopOne;
                        storesLists.set(firstShop, shopTwo);
                        storesLists.set(secondShop, shop);
                    }
                    break;
                case "Place":
                    shop=cmdArgs[1];
                    int index = Integer.parseInt(cmdArgs[2]);
                    isValid =checkExistence(index,storesLists);
                    if(isValid){
                        index+=1;
                        storesLists.add(index,shop);
                    }
                    break;
            }
        }
        System.out.println("Shops left:");
        for (int i = 0; i < storesLists.size()-1 ; i++) {
            System.out.print(storesLists.get(i) + " ");
        }
        if(storesLists.size() > 0){
            String last = storesLists.get(storesLists.size()-1);
            System.out.print(last);
        }
    }

    private static boolean checkExistence(int firstShop, List<String> storesLists) {
        if (firstShop >= 0 && firstShop < storesLists.size()) {
            return true;
        }
        return false;
    }

    private static List<String> getMyStoresList(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");
        List<String> list = new ArrayList<>();
        for (String elements : input) {
            list.add(elements);
        }
        return list;
    }
}
