import java.util.*;
import java.util.stream.Collectors;
public class July_24_Task_1_Concert {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> bandAndMembers = new LinkedHashMap<>();
        Map<String, Integer> bandAndTime = new HashMap<>();
        String input = scan.nextLine();
        while (!"start of concert".equals(input)) {
            String[] tokens = input.split("; ");
            String bandName = tokens[1];

            if (!Character.isDigit(tokens[2].charAt(0))) {
                List<String> bandMembers = Arrays.stream(tokens[2].split(", ")).distinct().collect(Collectors.toList());
                if (!bandAndMembers.containsKey(bandName)) {
                    bandAndMembers.put(bandName, bandMembers);
                } else {
                    getMembers(bandAndMembers, bandMembers, bandName);
                }
            } else {
                int time = Integer.parseInt(tokens[2]);
                if (bandAndTime.containsKey(bandName)) {
                    int currentTime = bandAndTime.get(bandName);
                    int addTime = currentTime + time;
                    bandAndTime.put(bandName, addTime);
                } else {
                    bandAndTime.put(bandName, time);
                }
                if (!bandAndMembers.containsKey(bandName)) {
                    bandAndMembers.put(bandName, new ArrayList<>());
                }

            }
            input = scan.nextLine();
        }
        System.out.println("Total time: " + bandAndTime.values().stream().mapToInt(e -> e).sum());
        bandAndTime.entrySet().stream().sorted((a, b) -> {
            int comp = b.getValue().compareTo(a.getValue());
            if (comp == 0) {
                comp = a.getKey().compareTo(b.getKey());
            }
            return comp;
        }).forEach(a -> {
            System.out.println(a.getKey() + " -> " + a.getValue());
        });

        String currentBand = scan.nextLine();
        System.out.println(currentBand);
        bandAndMembers.get(currentBand).forEach(a -> System.out.println("=> " + a));
    }

    private static void getMembers(Map<String, List<String>> bandAndMembers, List<String> bandMembers, String string) {
        for (String currentMember : bandMembers) {
            if (!bandAndMembers.get(string).contains(currentMember)) {
                bandAndMembers.get(string).add(currentMember);
            }
        }
    }
}
