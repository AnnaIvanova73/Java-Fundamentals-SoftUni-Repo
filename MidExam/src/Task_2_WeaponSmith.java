import java.util.Scanner;

public class Task_2_WeaponSmith {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] parts = getParticles(scan);


        String craft = scan.nextLine();
        while (!"Done".equals(craft)) {
            String[] cmdArg = craft.split("\\s+");

            String arguments = cmdArg[1];
                int index;

            int positionToBe;
            boolean isValid;

            switch (arguments) {
                case "Left":
                    index = Integer.parseInt(cmdArg[2]);
                    positionToBe = index -1;
                    isValid = getValidation(positionToBe,parts);
                    if(isValid){
                        movePartLeft(index,positionToBe,parts);
                    }
                    break;
                case "Right":
                    index = Integer.parseInt(cmdArg[2]);
                    positionToBe = index + 1;
                    isValid = getValidation(positionToBe, parts);
                    if (isValid) {
                        movePartRight(index, positionToBe, parts);
                    }
                    break;
                case "Even":
                    printEven(parts);
                    break;
                case "Odd":
                    printOdd(parts);
                    break;
            }
            craft = scan.nextLine();
        }
        String weaponName = String.join("",parts);
        System.out.println("You crafted " + weaponName + "!");
    }

    private static void printOdd(String[] parts) {
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if(i % 2 != 0){
                System.out.print(part + " ");
            }
        }
        System.out.println();
    }

    private static void printEven(String[] parts) {
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if(i % 2 ==0){
                System.out.print(part + " ");
            }
        }
        System.out.println();
    }

    private static void movePartLeft(int index, int positionToBe, String[] parts) {
            String part = parts[index];
            String partTwo = parts[positionToBe];
            parts[index]=partTwo;
            parts[positionToBe] = part;

    }

    private static void movePartRight(int index, int positionToBe, String[] parts) {

        for (int i = index; i < positionToBe; i++) {
            String part = parts[i];
            String partTwo = parts[i + 1];
            parts[positionToBe] = part;
            parts[i]=partTwo;
        }

    }

    private static boolean getValidation(int index, String[] parts) {
        if (index >= 0 && index < parts.length) {
            return true;
        } else {
            return false;
        }
    }

    private static String[] getParticles(Scanner scan) {
        return scan.nextLine().split("\\|+");
    }
}
