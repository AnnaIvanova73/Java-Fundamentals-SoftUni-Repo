import java.util.*;

public class Tech_Task_2_PracticeSessions {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> registerRoads = new HashMap<>();

        String inputData = scan.nextLine();
        while (!"END".equals(inputData)) {
            String[] tokens = inputData.split("->");
            String command = tokens[0];
            String road = tokens[1];

            String racer;
            switch (command) {
                case "Add":
                    racer = tokens[2];
                    if(!registerRoads.containsKey(road)){
                        registerRoads.put(road,new ArrayList<>());
                        registerRoads.get(road).add(racer);
                    }else{
                        registerRoads.get(road).add(racer);
                    }
                    break;
                case "Move":
                    racer = tokens[2];
                    String nextRoad = tokens[3];
                    if(registerRoads.get(road).remove(racer)){
                        registerRoads.get(nextRoad).add(racer);
                    }
                    break;
                case "Close":
                    registerRoads.remove(road);
                    break;
            }
            inputData = scan.nextLine();
        }
        System.out.println("Practice sessions:");
        registerRoads.entrySet().stream().sorted((a,b)->{
            int comp = b.getValue().size() - a.getValue().size();
            if(comp==0){
                comp=a.getKey().compareTo(b.getKey());
            }
            return comp;
        }).forEach((r)->{
            System.out.println(r.getKey());
            r.getValue().forEach(racer-> System.out.println("++"+racer));
        });
    }
}
