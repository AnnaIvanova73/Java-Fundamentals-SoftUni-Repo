import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task_2_SeizeOfFire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> fires = getAll(scan);

        int amountOfWater = Integer.parseInt(scan.nextLine());
        int amountOfWaterStable = amountOfWater;

        double sumEffort = 0;
        if (amountOfWater > 0) {
            System.out.println("Cells:");
            for (int i = 0; i < fires.size() - 1; i += 2) {
                String typeFire = fires.get(i);
                int amplitude = Integer.parseInt(fires.get(i + 1));
                double currentEffort = amplitude * 0.25;

                switch (typeFire) {

                    case "High":

                        if (amplitude > 80 && amplitude < 126) {
                            if (amountOfWater >= amplitude) {
                                System.out.println("- " + amplitude);
                                amountOfWater -= amplitude;
                                sumEffort += currentEffort;
                            }
                        }
                        break;
                    case "Medium":

                        if (amplitude > 50 && amplitude < 81) {
                            if (amountOfWater >= amplitude) {
                                amountOfWater -= amplitude;
                                sumEffort += currentEffort;
                                System.out.println("- " + amplitude);
                            }
                        }
                        break;
                    case "Low":

                        if (amplitude > 0 && amplitude < 51) {
                            if (amountOfWater >= amplitude) {
                                amountOfWater -= amplitude;
                                sumEffort += currentEffort;
                                System.out.println("- " + amplitude);
                            }
                        }
                        break;

                }
            }
        }

        int totalFire = amountOfWaterStable - amountOfWater;
        System.out.printf("Effort: %.2f%n", sumEffort);
        System.out.printf("Total Fire: %d", totalFire);
    }


    private static List<String> getAll(Scanner scan) {
        String input = scan.nextLine();
        String replace = input.replaceAll("=", " ");
        String keepReplacing = replace.replaceAll("#", " ");
        String[] arr = keepReplacing.split("\\s+");
        List<String> list = new ArrayList<>();

        for (String currentElement : arr) {
            list.add(currentElement);
        }
        return list;
    }
}
