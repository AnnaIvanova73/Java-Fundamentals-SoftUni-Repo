import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Others_Code_Bankin_ManOWar {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        String[] pirateShip = scanner.nextLine().split(">");

        List<Integer> pirateSections = new ArrayList<>();



        for (int i = 0; i < pirateShip.length; i++) {

            int section = Integer.parseInt(pirateShip[i]);

            pirateSections.add(section);

        }



        String[] warship = scanner.nextLine().split(">");

        List<Integer> warshipSections = new ArrayList<>();



        for (int i = 0; i < warship.length; i++) {

            int section = Integer.parseInt(warship[i]);

            warshipSections.add(section);

        }



        int maxHealth = Integer.parseInt(scanner.nextLine());



        String command = scanner.nextLine();



        while (!command.equals("Retire")) {

            String[] commandParts = command.split(" ");

            String commandName = commandParts[0];



            switch (commandName) {

                case "Fire":

                    int sectionIndex = Integer.parseInt(commandParts[1]);

                    int damage = Integer.parseInt(commandParts[2]);



                    if (sectionIndex < 0 || sectionIndex >= warshipSections.size()) {

                        break;

                    }



                    Integer sectionHealth = warshipSections.get(sectionIndex);

                    sectionHealth -= damage;



                    if (sectionHealth <= 0) {

                        System.out.println("You won! The enemy ship has sunken.");

                        return;

                    }



                    warshipSections.set(sectionIndex, sectionHealth);

                    break;

                case "Defend":

                    int startIndex = Integer.parseInt(commandParts[1]);

                    int endIndex = Integer.parseInt(commandParts[2]);

                    int damageDealt = Integer.parseInt(commandParts[3]);



                    if (startIndex < 0 || startIndex >= pirateSections.size()) {

                        break;

                    }

                    if (endIndex < 0 || endIndex >= pirateSections.size()) {

                        break;

                    }



                    for (int i = startIndex; i <= endIndex; i++) {

                        int health = pirateSections.get(i);

                        health -= damageDealt;



                        if (health <= 0) {

                            System.out.println("You lost! The pirate ship has sunken.");

                            return;

                        }



                        pirateSections.set(i, health);

                    }



                    break;

                case "Repair":

                    int index = Integer.parseInt(commandParts[1]);

                    int repairHealth = Integer.parseInt(commandParts[2]);



                    if (index < 0 || index >= pirateSections.size()) {

                        break;

                    }



                    Integer section = pirateSections.get(index);

                    section += repairHealth;



                    if (section > maxHealth) {

                        section = maxHealth;

                    }



                    pirateSections.set(index, section);

                    break;

                case "Status":

                    int count = 0;

                    double threshold = maxHealth * 0.2;

                    for (Integer pirateSection : pirateSections) {

                        if (pirateSection < threshold) {

                            count++;

                        }

                    }



                    System.out.println(count + " sections need repair.");

                    break;

            }



            command = scanner.nextLine();

        }



        int pirateSum = 0;



        for (Integer pirateSection : pirateSections) {

            pirateSum += pirateSection;

        }



        int warshipSum = warshipSections.stream().mapToInt(a -> a).sum();



        System.out.println("Pirate ship status: " + pirateSum);

        System.out.println("Warship status: " + warshipSum);

    }

}

