import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número entero N: ");
        int N = sc.nextInt();

        int i= 1;

        while (i<N) {
            if (N / i == 0) {
                System.out.print("l");
            }
            else {
                System.out.print("k");
            }
            i++; 
        }
        sc.close();
    }
}
