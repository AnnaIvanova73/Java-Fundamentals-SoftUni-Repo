import java.util.*;

public class December_7_Group_2_Task_3_Nikuldensmeals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Map<String, List<String>> likedMeals = new HashMap<>();
        int unlikedMeals = 0;

        String input = scan.nextLine();
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("-");
            String commands = tokens[0];
            String guest = tokens[1];
            String meal = tokens[2];
            switch (commands) {
                case "Like":
                    if (!likedMeals.containsKey(guest)) {
                        likedMeals.put(guest, new ArrayList<>());
                        likedMeals.get(guest).add(meal);
                        break;
                    }
                    if (!likedMeals.get(guest).contains(meal)) {
                        likedMeals.get(guest).add(meal);
                    }
                    break;
                case "Unlike":
                    if (!likedMeals.containsKey(guest)) {
                        System.out.println(guest + " is not at the party.");
                        break;
                    }
                    if (!likedMeals.get(guest).contains(meal)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", guest, meal);
                        break;
                    }
                    likedMeals.get(guest).remove(meal);
                    System.out.printf("%s doesn't like the %s.%n", guest, meal);
                    unlikedMeals++;
                    break;
            }


            input = scan.nextLine();
        }
        likedMeals.entrySet().stream().sorted((a,b)->{
            int comp = Integer.compare(b.getValue().size(),a.getValue().size());
            if(comp == 0){
                comp = a.getKey().compareTo(b.getKey());
            }
            return comp;
        }).forEach((a)->{
            System.out.print(a.getKey() + ": ");
            System.out.println(String.join(", ",a.getValue()));
        });
        System.out.println("Unliked meals: " + unlikedMeals);
    }
}
