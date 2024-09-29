// Example 6: LinearEquation.java
import java.util.Scanner;
public class LinearEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ax + b = 0
        System.out.println("Enter the coefficient of x: ");
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");       
        double b = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinite solutions.");
            }
            else {
                System.out.println("The equation has no solution.");
            }
        }
        else {
            double x = -b/a;
            System.out.println("The solution is x = " + x);
        }
    }
}