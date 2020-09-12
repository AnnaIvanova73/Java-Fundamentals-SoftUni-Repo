import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_5_SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int entrances = Integer.parseInt(scan.nextLine());

        Map<String, String> registerUsers = new LinkedHashMap<>();
        for (int i = 0; i < entrances; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String command = tokens[0];
            String username = tokens[1];
            switch (command) {
                case "register":
                    String licenseNumber = tokens[2];
                    String registered = registerUsers.putIfAbsent(username, licenseNumber);
                    if (registered == null) {
                        System.out.println(String.format
                                ("%s registered %s successfully", username, licenseNumber));
                    } else {
                        String license = registerUsers.get(username);
                        System.out.println(String.format
                                ("ERROR: already registered with plate number %s", license));
                    }
                    break;
                case "unregister":
                    if (!registerUsers.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found%n", username);
                        break;
                    }
                    registerUsers.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                    break;
            }


        }
        registerUsers
                .forEach((k, v) -> {
                    System.out.println(String.format("%s => %s", k, v));
                });
    }
}
