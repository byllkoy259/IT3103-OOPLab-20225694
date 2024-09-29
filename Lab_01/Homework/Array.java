// Ex 6.5
import java.util.Arrays;
import java.util.Scanner;
public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("n = ");
        int n = scanner.nextInt();

        int[] myArray = new int[n];

        System.out.println("Enter array numbers: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            myArray[i] = scanner.nextInt();
        }

        System.out.println("Initial Array: " + Arrays.toString(myArray));

        Arrays.sort(myArray);
        System.out.println("Sorted Array: " + Arrays.toString(myArray));

        int sum = 0;
        for (int num : myArray) {
            sum += num;
        }

        double average = (double) sum / myArray.length;

        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);
        
        scanner.close();
    }
}