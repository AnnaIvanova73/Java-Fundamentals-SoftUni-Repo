import java.util.*;
public class Task_3_HeroRecruitment {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> spellBooks = new HashMap<>();
        String input = scan.nextLine();
        while(!"End".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String heroName = tokens[1];
            switch (command){
                case"Enroll":
                    if(!spellBooks.containsKey(heroName)){
                        spellBooks.put(heroName,new ArrayList<>());
                        break;
                    }
                    System.out.println(heroName + " is already enrolled.");
                    break;
                case"Learn":
                    String spellToLearn = tokens[2];
                    if(!spellBooks.containsKey(heroName)){
                        System.out.println(heroName + " doesn't exist.");
                        break;
                    }
                    if(spellBooks.get(heroName).contains(spellToLearn)){
                        System.out.println( heroName + " has already learnt " + spellToLearn + ".");
                        break;
                    }
                    spellBooks.get(heroName).add(spellToLearn);
                    break;
                case"Unlearn":
                    String spellToUnlearn = tokens[2];
                    if(!spellBooks.containsKey(heroName)){
                        System.out.println(heroName + " doesn't exist.");
                        break;
                    }
                    if(!spellBooks.get(heroName).contains(spellToUnlearn)){
                        System.out.println( heroName + " doesn't know " + spellToUnlearn + ".");
                        break;
                    }

                    spellBooks.get(heroName).remove(spellToUnlearn);
                    break;
            }
            input = scan.nextLine();
        }

        System.out.println("Heroes:");
        spellBooks.entrySet().stream().sorted((s1,s2) ->{
            int comp = s2.getValue().size() - s1.getValue().size();
            if(comp == 0){
                comp = s1.getKey().compareTo(s2.getKey());
            }
                return comp;
        }).forEach((h) ->{
            System.out.print("== "+ h.getKey() + ": ");
            System.out.println(String.join(", ",h.getValue()));
        });
    }
}
