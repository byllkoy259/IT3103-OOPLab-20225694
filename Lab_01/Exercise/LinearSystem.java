// Example 6: LinearSystem.java
import java.util.Scanner;
public class LinearSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a11x1 + a12x2 = b1a21x1 + a22x2 = b2
        System.out.print("Enter a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Enter a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Enter a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Enter a22: ");
        double a22 = scanner.nextDouble();

        System.out.print("Enter b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Enter b2: ");
        double b2 = scanner.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D == 0) {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinite solutions.");
            } 
            else {
                System.out.println("The system has no solution.");
            }
        } 
        else {
            double x = D1 / D;
            double y = D2 / D;
            System.out.println("The solution is x = " + x + ", y = " + y);
        }
    }
}