import java.util.Random;
import java.util.Scanner;

public class Exercise_1_AdvertisementMessage {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int countRandomMsg = Integer.parseInt(scan.nextLine());


            String[] phrases = new String[]{"Excellent product.", "Such a great product.",
                    "I always use that product.", "Best product of its category.",
                    "Exceptional product.", "I can’t live without this product."};
            String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.", "Makes miracles.",
                    " I am happy of the results!", "I cannot believe but now I feel awesome.",
                    "Try it yourself, I am very satisfied.", "I feel great!"};
            String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
            String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};


        Random message = new Random();
        for (int i = 0; i < countRandomMsg ; i++) {
            int phrasesIndex = message.nextInt(phrases.length);
            String phr = phrases[phrasesIndex];

           String event = events[message.nextInt(phrases.length)];
           String author = authors[message.nextInt(phrases.length)];
           String city = cities[message.nextInt(phrases.length)];
           System.out.printf("%s %s %s – %s.%n",phr,event,author,city);
        }
    }
}
