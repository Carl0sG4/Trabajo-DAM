import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese un número entero: ");
        int N = sc.nextInt();

        int a = 0, b = 1, i = 2;

        System.out.println("0"); 
        System.out.println("1");   

        do {
            int c = a + b; 
            System.out.println(c);
            a = b;
            b = c;
            i++;

        } while (i < N);


        sc.close();
    }
}