import java.util.*;

public class Task_3_InboxManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> emailDatabaseByUser = new HashMap<>();


        String userData = scan.nextLine();
        while (!"Statistics".equals(userData)) {
            String[] tokens = userData.split("[->]+");
            String command = tokens[0].trim();
            String username = tokens[1].trim();
            switch (command) {
                case "Add":
                    if(emailDatabaseByUser.containsKey(username)){
                        System.out.printf("%s is already registered%n",username);
                    }else{
                        emailDatabaseByUser.put(username,new ArrayList<>());
                    }
                    break;
                case "Send":
                    String email = tokens[2];
                    emailDatabaseByUser.get(username).add(email);
                    break;
                case "Delete":
                    if(emailDatabaseByUser.containsKey(username)){
                        emailDatabaseByUser.remove(username);
                    }else{
                        System.out.printf("%s not found!%n",username);
                    }
                    break;
            }
            userData = scan.nextLine();
        }

        System.out.printf("Users count: %d%n",emailDatabaseByUser.keySet().size());

        emailDatabaseByUser
                .entrySet()
                .stream()
                .sorted((a,b)->{
                    int first = a.getValue().size();
                    int second = b.getValue().size();
                    int compare = second-first;
                    if(compare==0){
                       compare = a.getKey().compareTo(b.getKey());
                    }
                    return compare;
                })
                .forEach(a->{
                    System.out.println(a.getKey());
                    a.getValue()
                            .forEach(b -> System.out.printf("- %s%n",b));
                });
    }
}
