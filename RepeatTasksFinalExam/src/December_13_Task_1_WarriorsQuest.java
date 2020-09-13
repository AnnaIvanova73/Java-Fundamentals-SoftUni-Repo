import java.util.Scanner;

public class  December_13_Task_1_WarriorsQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String skill = scan.nextLine();

        String cmdArg = scan.nextLine();
        while (!"For Azeroth".equals(cmdArg)) {
            String[] tokens = cmdArg.split("\\s+");
            String commands = tokens[0];

            switch (commands) {

                case "GladiatorStance":
                    skill = skill.toUpperCase();
                    System.out.println(skill);
                    break;
                case "DefensiveStance":
                    skill = skill.toLowerCase();
                    System.out.println(skill);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(tokens[1].trim());
                    if (!isValidIndex(index, skill)) {
                        System.out.println("Dispel too weak.");
                        break;
                    }
                    char replacement = tokens[2].charAt(0);
                    skill = replaceLetters(skill, index, replacement);
                    System.out.println("Success!");
                    break;
                case "Target":
                    String additionalCondition = tokens[1];
                    String substring = tokens[2];

                    if ("Change".equals(additionalCondition)) {
                        String secondSubstring = tokens[3];

                        skill = skill.replace(substring, secondSubstring);
                        System.out.println(skill);
                    } else if ("Remove".equals(additionalCondition)) {
                        skill = skill.replace(substring, "");
                        System.out.println(skill);
                    } else {
                        System.out.println("Command doesn't exist!");
                    }
                    break;

                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }

            cmdArg = scan.nextLine();
        }
    }
    private static String replaceLetters(String skill, int index, char replacement) {
        StringBuilder builder = new StringBuilder();
        builder.append(skill);
        builder.setCharAt(index, replacement);

        return builder.toString();

    }

    private static boolean isValidIndex(int index, String skill) {
        return index >= 0 && index < skill.length();
    }
}
