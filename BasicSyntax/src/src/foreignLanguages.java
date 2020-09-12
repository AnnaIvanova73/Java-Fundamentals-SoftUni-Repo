import java.util.Scanner;

public class foreignLanguages {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String countryName = scan.nextLine();

        switch (countryName){

            case "England":
            case "USA":
                System.out.println("English");
                break;
            case "Mexico":
            case "Argentina":
            case "Spain":
                System.out.println("Spanish");
                break;
            default:
                System.out.println("unknown");
                break;

        }

    }
}
