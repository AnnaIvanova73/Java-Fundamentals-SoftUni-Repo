import java.util.Scanner;

public class Task_1_Username {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String selectedUsername = scan.nextLine();

        StringBuilder searchFit = new StringBuilder();
        searchFit.append(selectedUsername);

        String tryLogIn = scan.nextLine();
        while (!"Sign up".equals(tryLogIn)) {
            String[] tokens = tryLogIn.split("\\s+");
            String command = tokens[0];

            String additional;
            switch (command) {

                case "Case":
                    additional = tokens[1];
                    switch (additional) {
                        case "lower":
                            additional = searchFit.toString().toLowerCase();
                            System.out.println(additional);
                            searchFit.setLength(0);
                            searchFit.append(additional);
                            break;
                        case "upper":
                            additional = searchFit.toString().toUpperCase();
                            System.out.println(additional);
                            searchFit.setLength(0);
                            searchFit.append(additional);
                            break;
                    }
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]) + 1;
                    if (startIndex >= 0 && endIndex <= searchFit.length()) {
                        String originalValue = searchFit.toString();
                        String substring = searchFit.substring(startIndex, endIndex);
                        searchFit.setLength(0);
                        searchFit.append(substring).reverse();
                        System.out.println(searchFit);

                        searchFit.setLength(0);
                        searchFit.append(originalValue);
                    }
                    break;
                case "Cut":
                    String substring = tokens[1];
                    int indexSubstring = searchFit.indexOf(substring);
                    int count = 0;
                    while (indexSubstring >-1){
                        searchFit.delete(indexSubstring,indexSubstring+substring.length());
                        indexSubstring=searchFit.indexOf(substring);
                        count++;
                    }

                    if(count==0){
                        System.out.printf("The word %s doesn't contain %s.%n",searchFit,substring);
                    }else{
                        System.out.println(searchFit);
                    }
                    break;
                case "Replace":
                    String symbol = tokens[1];
                    int index = searchFit.indexOf(symbol);
                    while(index > -1){
                        searchFit.setCharAt(index,'*');
                        index=searchFit.indexOf(symbol);
                    }
                    System.out.println(searchFit);
                    break;
                case "Check":
                    char currSymbol = tokens[1].charAt(0);
                    String symbolToString = String.valueOf(currSymbol);
                    String currentUsername = searchFit.toString();
                    if(currentUsername.contains(symbolToString)){
                        System.out.println("Valid");
                    }else{
                        System.out.printf("Your username must contain %c.%n",currSymbol);
                    }
                    break;

            }
            tryLogIn = scan.nextLine();
        }
    }
}
