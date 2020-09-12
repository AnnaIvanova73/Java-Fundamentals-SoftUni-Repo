import java.util.Scanner;

public class Exercise_3_ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        int extensionIndex = input.lastIndexOf(".");
        String extension = input.substring(extensionIndex+1);

        int nameIndex = input.lastIndexOf("\\");
        String name = input.substring(nameIndex+1,extensionIndex);

        System.out.println("File name: " + name);
        System.out.println("File extension: " + extension);
    }
}
