import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_3_Man_O_WAR {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> pirateShip = getValues(scan);
        List<Integer> warship = getValues(scan);
        int maxHealth = Integer.parseInt(scan.nextLine());

        boolean hasAWinner = false;
        String input = scan.nextLine();
        search:
        while (!"Retire".equals(input)) {
            String[] tokens = input.split("\\s+");
            String commands = tokens[0];

            boolean isValid;
            int index;
            int damage;
            int damageDone;
            switch (commands) {
                case "Fire":
                    index = Integer.parseInt(tokens[1]);
                    damage = Integer.parseInt(tokens[2]);
                    isValid = checkExistence(index, warship);

                    if (!isValid) {
                        break;
                    }

                    int warshipSection = warship.get(index);
                    damageDone = warshipSection - damage;

                    if (damageDone <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        hasAWinner=true;
                        break search;
                    }

                    warship.set(index, damageDone);

                    break;
                case "Defend":
                    index = Integer.parseInt(tokens[1]);//startIndex indexesAreInclusive
                    int endIndex = Integer.parseInt(tokens[2]);
                    damage = Integer.parseInt(tokens[3]);

                    isValid = checkExistence(index, pirateShip);
                    boolean isSecondValid = checkExistence(endIndex, pirateShip);

                    if (!isValid || !isSecondValid) {
                        break;
                    }

                    for (int i = index; i <= endIndex; i++) {
                        int currentSection = pirateShip.get(i);
                          damageDone = currentSection - damage;

                        if (damageDone <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            hasAWinner=true;
                            break search;
                        }
                        pirateShip.set(i, damageDone);
                    }

                    break;
                case"Repair":
                    index=Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);
                    isValid=checkExistence(index,pirateShip);
                    if(!isValid){
                        break;
                    }
                    int conditionOFSection = pirateShip.get(index);
                    int afterRepair = conditionOFSection + health;
                    if(afterRepair > maxHealth){
                        afterRepair=maxHealth;
                    }
                    pirateShip.set(index,afterRepair);
                    break;

                case"Status":
                    double defineLowerHealth = maxHealth* 1.0 * 0.20;
                    int sectionInNeed = getSectionItLowHealth(defineLowerHealth,pirateShip);
                    System.out.printf("%d sections need repair.%n",sectionInNeed);
                    break;
            }
            input = scan.nextLine();
        }

        if(!hasAWinner){
            int pirateShipStatus = getStatus(pirateShip);
            int warshipStatus = getStatus(warship);
            System.out.println("Pirate ship status: " + pirateShipStatus);
            System.out.println("Warship status: " + warshipStatus);
        }
    }

    private static int getSectionItLowHealth(double defineLowerHealth, List<Integer> pirateShip) {
        int sum = 0;
        for (int i = 0; i < pirateShip.size() ; i++) {
            int currentSection = pirateShip.get(i);
            if(currentSection < defineLowerHealth){
                sum++;
            }
        }
        return sum;
    }

    private static int getStatus(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    private static boolean checkExistence(int index, List<Integer> list) {
        if (index >= 0 && index < list.size()) {
            return true;
        }
        return false;
    }

    private static List<Integer> getValues(Scanner scan) {
        String[] input = scan.nextLine().split(">");
        List<Integer> list = new ArrayList<>();
        for (String elements : input) {
            int element = Integer.parseInt(elements);
            list.add(element);
        }
        return list;
    }
}
