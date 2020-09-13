import java.sql.SQLOutput;
import java.util.Scanner;

public class Task_1_WarriorsQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String skill = scan.nextLine();

        StringBuilder progress = new StringBuilder();
        progress.append(skill);

        String input = scan.nextLine();
        while (!"For Azeroth".equals(input)) {
            String[] tokens = input.split("\\s+");
            String commands = tokens[0];
            String output = "";

            switch (commands) {
                case "GladiatorStance": {
                    output = progress.toString().toUpperCase();
                    System.out.println(output);
                    progress.setLength(0);
                    progress.append(output);
                }
                break;
                case "DefensiveStance":
                    output = progress.toString().toLowerCase();
                    System.out.println(output);
                    progress.setLength(0);
                    progress.append(output);
                    break;
                case "Dispel":
                    int dispelIndex = Integer.parseInt(tokens[1]);
                    String letter = tokens[2];
                    if (!isValidate(dispelIndex) || dispelIndex >= progress.length()) {
                        System.out.println("Dispel too weak.");
                        break;
                    }
                    progress.setCharAt(dispelIndex, letter.charAt(0));
                    System.out.println("Success!");
                    break;
                case "Target":
                    String cmd = tokens[1];

                    switch (cmd) {
                        case "Change":
                            String substring = tokens[2];
                            int indexSub = progress.indexOf(substring);
                            int countReplace = 0;
                            while (isValidate(indexSub)) {
                                String current = tokens[3];
                                progress.replace(indexSub, indexSub + substring.length(), current);
                                indexSub = progress.indexOf(substring);
                                countReplace++;
                            }
                            printResult(progress, countReplace);
                            break;
                        case "Remove":
                            String remove = tokens[2];
                            int indexRmv = progress.indexOf(remove);
                            int count = 0;
                            while (isValidate(indexRmv)) {
                                progress.delete(indexRmv, indexRmv + remove.length());
                                indexRmv = progress.indexOf(remove);
                                count++;
                            }
                            printResult(progress, count);

                            break;
                        default:
                            System.out.println("Command doesn't exist!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }


            input = scan.nextLine();
        }

    }

    private static void printResult(StringBuilder progress, int count) {
        if (count == 0) {
            System.out.println("Command doesn't exist!");
        } else {
            System.out.println(progress);
        }
    }

    private static boolean isValidate(int dispelIndex) {
        if (dispelIndex < 0) {
            return false;
        }
        return true;
    }
}
