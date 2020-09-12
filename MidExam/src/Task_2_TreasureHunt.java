import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2_TreasureHunt {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> treasureChest = getLoot(scan);

        String input = scan.nextLine();
        while (!"Yohoho!".equals(input)) {
            String[] tokens = input.split("\\s+");
            String cmdArg = tokens[0];
            int index;
            switch (cmdArg) {
                case "Loot":
                    getLootAdditional(tokens, treasureChest);
                    break;
                case "Drop":
                    index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < treasureChest.size()) {
                        String currentLoot = treasureChest.get(index);
                        treasureChest.remove(index);
                        treasureChest.add(currentLoot);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    printAndRemove(treasureChest, count);
                    break;
            }


            input = scan.nextLine();
        }

        if (treasureChest.size() > 0) {
            double sum = 0;
            double totalLoot = treasureChest.size();
            for (String elementsLoot : treasureChest) {
                double lengthElement = elementsLoot.length();
                sum += lengthElement;
            }
            sum/=totalLoot;
            System.out.printf("Average treasure gain: %.2f pirate credits.",sum);
        }else{
            System.out.println("Failed treasure hunt.");
        }

    }

    private static void printAndRemove(List<String> treasureChest, int count) {
        List<String> temp = new ArrayList<>();
        int index1;
        if (count < treasureChest.size()) {
            index1 = treasureChest.size() - count;
            for (int i = index1; i < treasureChest.size(); i++) {
                String element = treasureChest.get(i);
                temp.add(element);
                treasureChest.remove(i);
                i--;
            }
        } else {
            for (int i = 0; i < treasureChest.size(); i++) {
                String currentLoot = treasureChest.get(i);
                temp.add(currentLoot);
                treasureChest.remove(i);
                i--;
            }
        }
        System.out.println(String.join(", ", temp));
    }

    private static void getLootAdditional(String[] tokens, List<String> treasureChest) {

        for (int i = 1; i < tokens.length; i++) {
            String currentElement = tokens[i];
            if (!treasureChest.contains(currentElement)) {
                treasureChest.add(0, currentElement);
            }
        }
    }

    private static List<String> getLoot(Scanner scan) {
        String[] input = scan.nextLine().split("\\|+");
        List<String> list = new ArrayList<>();
        for (String elements : input) {
            list.add(elements);
        }
        return list;
    }
}
