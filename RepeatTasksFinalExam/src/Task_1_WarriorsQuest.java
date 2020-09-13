import java.util.Scanner;
public class Task_1_WarriorsQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String skillPerDecipher = scan.nextLine();
        //skillPerDecipher.replaceFirst()
        String input;
        while(!"For Azeroth".equals(input = scan.nextLine())){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){
                case"GladiatorStance":
                    System.out.println(skillPerDecipher = skillPerDecipher.toUpperCase());
                    break;
                case"DefensiveStance":
                    System.out.println(skillPerDecipher = skillPerDecipher.toLowerCase());
                    break;
                case"Dispel":
                    int indexDispel = Integer.parseInt(tokens[1]);
                    if(indexDispel< 0 || indexDispel >= skillPerDecipher.length()){
                        System.out.println("Dispel too weak.");
                        break;
                    }
                    char letter = tokens[2].charAt(0);
                    skillPerDecipher = getReplaced(indexDispel,letter,skillPerDecipher);
                    System.out.println("Success!");
                    break;
                case"Target":
                    String additionalCondition = tokens[1];
                    String substring = tokens[2];
                    if(additionalCondition.equals("Change")){
                        String secondSubstring = tokens[3];
                        skillPerDecipher = skillPerDecipher.replace(substring,secondSubstring);
                        System.out.println(skillPerDecipher);
                    }else if("Remove".equals(additionalCondition)){
                        skillPerDecipher = skillPerDecipher.replace(substring,"");
                        System.out.println(skillPerDecipher);
                    }else{
                        System.out.println("Command doesn't exist!");
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");
                    break;
            }
        }
    }

    private static String getReplaced(int indexDispel, char letter,String string) {
        StringBuilder assistant = new StringBuilder();
        assistant.append(string);
        assistant.setCharAt(indexDispel,letter);
        return assistant.toString();
    }
}
