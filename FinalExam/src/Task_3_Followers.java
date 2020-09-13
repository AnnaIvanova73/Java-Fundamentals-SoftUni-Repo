import java.util.*;

public class Task_3_Followers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Map<String, List<Integer>> interactionFollowers = new HashMap<>();

        String socialMedia = scan.nextLine();
        while (!"Log out".equals(socialMedia)) {
            String[] tokens = socialMedia.split(":");
            String command = tokens[0].trim();
            String username = tokens[1].trim();
            switch (command) {
                case "New follower":
                    if(!interactionFollowers.containsKey(username)){
                        interactionFollowers.put(username, new ArrayList<>());
                        interactionFollowers.get(username).add(0, 0);
                        interactionFollowers.get(username).add(1, 0);
                        break;
                    }

                    break;
                case "Like":
                    int countLike = Integer.parseInt(tokens[2].trim());
                    if (!interactionFollowers.containsKey(username)) {
                        interactionFollowers.put(username, new ArrayList<>());
                        interactionFollowers.get(username).add(0, countLike);
                        interactionFollowers.get(username).add(1, 0);
                    } else {
                        int updateValue = interactionFollowers.get(username).get(0);
                        updateValue += countLike;
                        interactionFollowers.get(username).set(0, updateValue);
                    }
                    break;
                case "Comment":
                    int comment = 1;
                    if (!interactionFollowers.containsKey(username)) {
                        interactionFollowers.put(username, new ArrayList<>());
                        interactionFollowers.get(username).add(0, 0);
                        interactionFollowers.get(username).add(1, comment);

                    } else {
                        int updateValue = interactionFollowers.get(username).get(1);
                        updateValue += 1;
                        interactionFollowers.get(username).set(1, updateValue);
                    }
                    break;
                case "Blocked":
                    if (!interactionFollowers.containsKey(username)) {
                        System.out.println(username + " doesn't exist.");
                    } else {
                        interactionFollowers.remove(username);
                    }
                    break;
            }
            socialMedia = scan.nextLine();
        }

        System.out.println(interactionFollowers.keySet().size() + " followers");

        interactionFollowers.entrySet().stream()
                .sorted((a, b) -> {
                    //String currentKey = a.getKey();
                    int first = a.getValue().get(0);
                    int second = b.getValue().get(0);
                 int comp = Integer.compare(second,first);
                    if (comp == 0) {
                        comp = a.getKey().compareTo(b.getKey());
                    }
                    return comp;
                })
                .forEach((a) -> {
                    System.out.printf("%s: ", a.getKey());
                    System.out.printf("%d%n", a.getValue().get(0) + a.getValue().get(1));
                });


    }
}

