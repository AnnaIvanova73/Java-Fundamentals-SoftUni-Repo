package Exercise_4_Articles2_0;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Articles> articles = new ArrayList<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(", ");
            String title = input[0];
            String content = input[1];
            String author = input[2];
            Articles article = new Articles(title,content,author);
            articles.add(article);
        }
        String cmd = scan.nextLine();

        switch (cmd) {
            case "title":
                articles.sort((f, s) -> f.getTitle().compareTo(s.getTitle()));
                break;
            case "content":
                articles.sort((f, s) -> f.getContent().compareTo(s.getContent()));
                break;
            case "author":
                articles.sort((f, s) -> f.getAuthor().compareTo(s.getAuthor()));
                break;
        }

        for (Articles article : articles) {
            String element = article.toString();
            System.out.println(element);
            System.out.println();
        }
    }
}
