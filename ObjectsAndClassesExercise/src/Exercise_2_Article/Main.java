package Exercise_2_Article;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");

        String title = input[0];
        String content = input[1];
        String author = input[2];

        Article article = new Article(title,content,author);
        int number = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < number; i++) {
            String[] tokens = scan.nextLine().split(": ");
            String cmd = tokens[0];
            switch (cmd){
                case"Edit":
                    article.setContent(tokens[1]);
                    break;
                case"ChangeAuthor":
                    article.setAuthor(tokens[1]);
                    break;
                case "Rename":
                    article.rename(tokens[1]);
                    break;

            }

        }
        System.out.println(article);
    }
}
