import java.util.*;
public class August_3_Group_1_Task_3_MessagesManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int capacity = Integer.parseInt(scan.nextLine());
        Map<String, List<Integer>> messages = new HashMap<>();
        String input;
        while (!"Statistics".equals(input = scan.nextLine())) {
            String[] tokens = input.split("=");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "Add":
                    if (!messages.containsKey(username)) {
                        int sent = Integer.parseInt(tokens[2]);
                        int received = Integer.parseInt(tokens[3]);
                        messages.put(username, new ArrayList<>());
                        messages.get(username).add(0, sent);
                        messages.get(username).add(1, received);
                        break;
                    }
                    break;
                case "Message":
                    String receiver = tokens[2];
                    if (!messages.containsKey(username) || !messages.containsKey(receiver)) {
                        break;
                    }
                    checkAndDistributeMessages(capacity, username, receiver, messages);
                    break;
                case "Empty":
                    if (username.equals("All")) {
                        messages.clear();
                        break;
                    }
                    messages.remove(username);
                    break;
            }
        }
        System.out.println("Users count: " + messages.keySet().size());

        messages.entrySet().stream().sorted((a,b) ->{
            int compare = Integer.compare(b.getValue().get(1),a.getValue().get(1));
            if( compare == 0){
                compare = a.getKey().compareTo(b.getKey());
            }
            return compare;
        }).forEach(p -> System.out.println(p.getKey() + " - " + (p.getValue().get(0) + p.getValue().get(1))));

    }

    private static void checkAndDistributeMessages(int capacity, String username, String receiver, Map<String, List<Integer>> messages) {
        int senderMessages = messages.get(username).get(0);
        senderMessages += 1;
        int total = senderMessages + messages.get(username).get(1);
        if (total == capacity) {
            System.out.println(username + " reached the capacity!");
            messages.remove(username);
        } else {
            messages.get(username).set(0, senderMessages);
        }

        int receiverReceivedMessages = messages.get(receiver).get(1);
        receiverReceivedMessages += 1;
        total = receiverReceivedMessages + messages.get(receiver).get(0);
        if (total == capacity) {
            System.out.println(receiver + " reached the capacity!");
            messages.remove(receiver);
        } else {
            messages.get(receiver).set(1, receiverReceivedMessages);
        }
    }
}
