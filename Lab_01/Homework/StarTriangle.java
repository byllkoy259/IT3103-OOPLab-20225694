// Ex 6.3
import java.util.Scanner;
public class StarTriangle{
    public static void main(String[] args){
        Scanner star = new Scanner(System.in);

        // chieu cao tam giac
        System.out.print("n = ");
        int n = star.nextInt();

        // duyet tung dong
        for (int i = 1; i <= n; i++) {

            // tinh so luong khoang trang
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }

            // tinh va in so luong sao
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
        
        // chuyen dong sau khi in
        System.out.println();
        }

    star.close();
    }
}