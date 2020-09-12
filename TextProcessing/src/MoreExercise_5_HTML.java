import java.util.Scanner;

public class MoreExercise_5_HTML {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String titleOfAnArticle = scan.nextLine();
        String contentArticle = scan.nextLine();

        String title = "h1";
        String content = "article";
        String comment = "div";

        printInHtmlFormat(titleOfAnArticle, title);
        printInHtmlFormat(contentArticle, content);

        String comments = scan.nextLine();

        while (!"end of comments".equals(comments)) {

            printInHtmlFormat(comments,comment);

            comments = scan.nextLine();
        }
    }

    private static void printInHtmlFormat(String titleOfAnArticle, String title) {
        System.out.printf("<%s>%n", title);
        System.out.printf("    %s%n", titleOfAnArticle);
        System.out.printf("</%s>%n", title);
    }
}
