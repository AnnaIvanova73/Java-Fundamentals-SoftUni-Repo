import java.util.*;

public class Exercise_9_ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, ArrayList<String>> forceBook = new TreeMap<>();

        String input = scan.nextLine();
        while (!"Lumpawaroo".equals(input)) {
            String[] tokens;
            String side;
            String person;
            if (input.contains("|")) {
                tokens = input.split("\\|");
                side = tokens[0].trim();
                person = tokens[1].trim();
                String check = giveSide(side,person,forceBook);
                if(check == null){
                    add(side, person, forceBook);
                }
            } else {
                tokens = input.split("->");
                person = tokens[0].trim();
                side = tokens[1].trim();

                String changeSides = giveSide(side, person, forceBook);
                String sides = "";

                if (changeSides != null) {

                    if (changeSides.equals("Darker") && !side.equals(changeSides)) {
                        sides = side;
                        forceBook.get(changeSides).remove(person);
                        add(side, person, forceBook);
                    } else {
                        sides = side;
                        forceBook.get(changeSides).remove(person);
                        add(side, person, forceBook);
                    }
                } else {
                    sides = side;
                    add(side, person, forceBook);
                }
                System.out.printf("%s joins the %s side!%n", person, sides);
            }

            input = scan.nextLine();
        }
        forceBook
                .entrySet()
                .stream()
                .filter(p -> p.getValue().size() > 0)
                .sorted(Map.Entry.<String, ArrayList<String>>comparingByValue(Comparator.comparingInt(ArrayList::size)).reversed())
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());
                    s.getValue()
                            .stream()
                            .sorted(String::compareTo)
                            .forEach(person -> System.out.printf("! %s%n", person));
                });

    }

    private static String giveSide(String side, String person, Map<String, ArrayList<String>> forceBook) {
        for (Map.Entry<String, ArrayList<String>> entry : forceBook.entrySet()) {
            ArrayList<String> currValue = entry.getValue();
            if (currValue.contains(person)) {
                return entry.getKey();
            }
        }
        return null;
    }

    private static void add(String str1, String str2, Map<String, ArrayList<String>> map) {
        map.putIfAbsent(str1, new ArrayList<>());
        map.get(str1).add(str2);
    }

}
