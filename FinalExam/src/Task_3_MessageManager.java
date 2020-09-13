import java.util.*;

public class Task_3_MessageManager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int capacity = Integer.parseInt(scan.nextLine());


        Map<String, List<Integer>> records = new HashMap<>();

        String input = scan.nextLine();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("=");
            String command = tokens[0].trim();

            switch (command) {
                case "Add":
                    String username = tokens[1];
                    int sent = Integer.parseInt(tokens[2]);
                    int received = Integer.parseInt(tokens[3]);
                    if (!records.containsKey(username)) {
                        records.put(username, new ArrayList<>());
                        records.get(username).add(0, sent);
                        records.get(username).add(1, received);
                    }
                    break;
                case "Message":
                    String sender = tokens[1];
                    String receiver = tokens[2];

                    if (records.containsKey(sender) && records.containsKey(receiver)) {
                        String print = " reached the capacity!";

                        int senderSend = records.get(sender).get(0);
                        int senderReceivedCurr = records.get(sender).get(1);

                        int total = senderSend + senderReceivedCurr + 1;
                        if (total == capacity) {
                            records.remove(sender);
                            System.out.println(sender + print);
                        } else {
                            int updateSend = senderSend + 1;
                            records.get(sender).set(0, updateSend);
                        }

                        int receiverReceived = records.get(receiver).get(1);
                        int receiverSend = records.get(receiver).get(0);

                        int totalMsg = receiverReceived + receiverSend + 1;
                        if (totalMsg == capacity) {
                            records.remove(receiver);
                            System.out.println(receiver + print);
                        } else {
                            int updateReceive = receiverReceived + 1;
                            records.get(receiver).set(1, updateReceive);
                        }

                    }
                    break;
                case "Empty":
                    String conditionOrName = tokens[1];

                    if(records.containsKey(conditionOrName)){
                        records.remove(conditionOrName);
                        break;
                    }
                    records.clear();
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println("Users count: "+records.keySet().size());
        records
                .entrySet()
                .stream()
                .sorted((a,b)->{

                    int first = a.getValue().get(1);
                    int second = b.getValue().get(1);
                    int comp = second-first;
                    if(comp == 0){
                        comp = a.getKey().compareTo(b.getKey());
                    }
                    return comp;
                })
                .forEach(a->{
                    System.out.print(a.getKey() + " - ");
                    System.out.println(a.getValue().get(0) + a.getValue().get(1));
                });
    }
}
