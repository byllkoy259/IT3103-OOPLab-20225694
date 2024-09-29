// Example 6: SeconddegreeEquation.java
import java.util.Scanner;
public class SeconddegreeEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the second-degree equation: ");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("This is not a second-degree equation.");
        } 
        else {
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("x1 = " + x1 + ", x2 = " + x2);
            } 
            else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("Double solution x = " + x);
            } 
            else {
                System.out.println("The equation has no solution.");
            }
        }

        scanner.close();
    }
}