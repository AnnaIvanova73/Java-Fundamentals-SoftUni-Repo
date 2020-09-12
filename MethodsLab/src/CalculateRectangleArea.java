import java.util.Scanner;

public class CalculateRectangleArea {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double width = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());
        double area = areaRectangle(width,height);
        System.out.println(area);

    }
    public static double areaRectangle (double a,double b){
        double result = a * b;
        return result;
    }








}
