import java.util.*;

public class Task_3_NikuldensMeals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int unlikeMealsCounter = 0;

        Map<String, List<String>> favouriteMeals = new HashMap<>();

        String input = scan.nextLine();
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("[- ]+");
            String commend = tokens[0];

            String guestName = tokens[1];
            String mealInQuestion =  tokens[2];
            switch (commend) {
                case "Like":
                    if(!favouriteMeals.containsKey(guestName)){
                        favouriteMeals.put(guestName,new ArrayList<>());
                        //todo moже да те счупи
                    }
                    if(!favouriteMeals.get(guestName).contains(mealInQuestion)){
                        favouriteMeals.get(guestName).add(mealInQuestion);
                        break;
                    }
                    break;
                case "Unlike":
                    if(!favouriteMeals.containsKey(guestName)){
                        System.out.printf("%s is not at the party.%n",guestName);
                        break;
                    }

                    if(!favouriteMeals.get(guestName).contains(mealInQuestion)){
                        System.out.printf("%s doesn't have the %s in his/her collection.%n",guestName,mealInQuestion);
                    }else{
                        favouriteMeals.get(guestName).remove(mealInQuestion);// мрепахвам стойността, removal by Object
                        System.out.printf("%s doesn't like the %s.%n",guestName,mealInQuestion);
                        unlikeMealsCounter+=1;
                    }
                    break;
            }

            input = scan.nextLine();
        }

        favouriteMeals
                .entrySet()
                .stream()
                .sorted((a,b)->{
                    int first = a.getValue().size();
                    int second = b.getValue().size();
                    int compare = Integer.compare(second,first);
                    if(compare==0){
                        compare = a.getKey().compareTo(b.getKey());
                    }
                    return compare;
                })
                .forEach(a ->{
                    System.out.print(a.getKey() + ": ");
                    System.out.println(String.join(", ",a.getValue()));
                });

        System.out.printf("Unliked meals: %d",unlikeMealsCounter);
    }
}
//int indexToRemove = favouriteMeals.get(guestName).indexOf(mealInQuestion);// намира на мап със стойност Лист индекса
// favouriteMeals.get(guestName).remove(indexToRemove);//направо мага индекса, removal by index