import java.util.*;

public class December_7_Group_1_Task_3_InboxManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> register = new HashMap<>();

        String input = scan.nextLine();
        while(!"Statistics".equals(input)){
            String[] tokens = input.split("->");
            String command = tokens[0];
            String username = tokens[1];

            switch (command){
                case"Add":
                    if(register.containsKey(username)){
                        System.out.println(username + " is already registered");
                        break;
                    }
                    register.put(username,new ArrayList<>());
                    break;
                case"Send":
                    String email = tokens[2];
                    if(register.containsKey(username)){
                        register.get(username).add(email);
                    }
                    break;
                case"Delete":
                    if(!register.containsKey(username)){
                        System.out.println(username + " not found!");
                        break;
                    }
                    register.remove(username);
                    break;
            }
            input = scan.nextLine();
        }

        System.out.println("Users count: " + register.keySet().size());
        register.entrySet().stream().sorted((a,b)->{
            int comp = Integer.compare(b.getValue().size(),a.getValue().size());

            if(comp == 0){
                comp = a.getKey().compareTo(b.getKey());
            }
            return comp;
        }).forEach((u)->{
            System.out.println(u.getKey());
            u.getValue().forEach(e-> System.out.printf("- %s%n",e));
        });
    }
}
