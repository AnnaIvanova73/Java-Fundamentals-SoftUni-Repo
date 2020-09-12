import java.util.*;

public class Lab_3_OddOccurrences {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        Map<String, Integer> counts = new LinkedHashMap<>();


        for (String element : input) {
            String insensitiveKey = element.toLowerCase();
            counts.putIfAbsent(insensitiveKey,0);
            counts.put(insensitiveKey,counts.get(insensitiveKey) + 1);

            //int value = counts.get(insensitiveKey);
            //counts.put(insensitiveKey,value+1);

//            if(counts.containsKey(element)){
//                counts.put(element, counts.get(element) + 1);
//            }else{
//                counts.put(element,1);
//            }
        }
        List <String> odd = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                if(entry.getValue() % 2 ==1){
                    odd.add(entry.getKey());
                }
        }
        for (int i = 0; i < odd.size()-1; i++) {
            System.out.print(odd.get(i) +", ");
        }
        if(odd.size()>0){
            System.out.println(odd.get(odd.size()-1));
        }
    }
}
