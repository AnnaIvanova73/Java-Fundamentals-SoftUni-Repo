import java.util.*;

public class April_14_Tech_Task_2_PracticeSessions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> records = new HashMap<>();
        String input = scan.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    String road = tokens[1];
                    String racer = tokens[2];
                    if (!records.containsKey(road)) {
                        records.put(road, new ArrayList<>());
                        records.get(road).add(racer);
                        break;
                    }
                    records.get(road).add(racer);
                    break;
                case "Move":
                    String currentRoad = tokens[1];
                    String racerToMove = tokens[2];
                    String nextRoad = tokens[3];
                    if (!records.get(currentRoad).contains(racerToMove)) {
                        break;
                    }
                    records.get(nextRoad).add(racerToMove);
                    records.get(currentRoad).remove(racerToMove);
                    break;
                case "Close":
                    String roadPerClose = tokens[1];
                    records.remove(roadPerClose);
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Practice sessions:");
        records.entrySet().stream().sorted((r1,r2)->{
            int comp = r2.getValue().size() - r1.getValue().size();
            if(comp == 0){
               comp =  r1.getKey().compareTo(r2.getKey());
            }
            return comp;
        }).forEach(r->{
            System.out.println(r.getKey());
            r.getValue().forEach(racer -> System.out.println("++" + racer));
        });
    }
}
