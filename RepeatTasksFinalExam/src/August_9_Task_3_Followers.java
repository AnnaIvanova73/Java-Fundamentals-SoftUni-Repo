import java.util.*;

public class August_9_Task_3_Followers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<Integer>> followersActivity = new HashMap<>();
        String input;
        while(!(input = scan.nextLine()).equals("Log out")){
            String[] tokens = input.split(":");
            String command = tokens[0].trim();
            String username = tokens[1].trim();

            switch (command){
                case"New follower":
                    if(!followersActivity.containsKey(username)){
                        followersActivity.put(username,new ArrayList<>());
                        followersActivity.get(username).add(0,0);//likes
                        followersActivity.get(username).add(1,0);//comments
                    }
                    break;
                case"Like":
                    int newLikes = Integer.parseInt(tokens[2].trim());
                    int indexLikes = 0;
                    setLikesOrComments(followersActivity, username, newLikes,indexLikes);
                break;
                case"Comment":
                    int commentAmount = 1;
                    int indexComment = 1;
                    setLikesOrComments(followersActivity,username,commentAmount,indexComment);
                    break;
                case"Blocked":
                    if(!followersActivity.containsKey(username)){
                        System.out.println( username + " doesn't exist.");
                        break;
                    }
                    followersActivity.remove(username);
                    break;
            }
        }

        System.out.println(followersActivity.keySet().size() + " followers");
        followersActivity.entrySet().stream().sorted((a,b)->{
            int comp = Integer.compare(b.getValue().get(0),a.getValue().get(0));
            if(comp == 0){
                comp = a.getKey().compareTo(b.getKey());
            }
            return comp;
        }).forEach((f) ->{
            System.out.print(f.getKey() + ": ");
            System.out.println(f.getValue().get(0) + f.getValue().get(1));
        });
    }

    private static void setLikesOrComments(Map<String, List<Integer>> followersActivity, String username, int activity,int index) {
        if(!followersActivity.containsKey(username)){
            followersActivity.put(username, new ArrayList<>());
            if(index == 1){
                followersActivity.get(username).add(0,0);
                followersActivity.get(username).add(index,activity);
            }else{
                followersActivity.get(username).add(index,activity);
                followersActivity.get(username).add(1,0);
            }
            return;
        }
        int currentLikes = followersActivity.get(username).get(index);
        currentLikes+=activity;
        followersActivity.get(username).set(index,currentLikes);
    }
}
