import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;


public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] enteros = {1, 2, 3, 4, 5};
        
        try {
            System.out.println("Introduce un entero divisor: ");
            int divisor = sc.nextInt();

            System.out.println("Introduce un entero posición: ");
            int posicion = sc.nextInt();

            int resultado = enteros[posicion] / divisor;
            System.out.println("El resultado es: " + resultado);

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException | InputMismatchException e ) {
            System.out.println("Error: " + e.getMessage());

            if (e instanceof ArithmeticException) {
                System.out.println("No se puede dividir por cero.");
            } else if (e instanceof ArrayIndexOutOfBoundsException) {
                System.out.println("La posición indicada esta fuera de límites.");
            } else if (e instanceof InputMismatchException) {
                System.out.println("Entrada inválida. Por favor, introduce un número entero.");
            }

        } finally {
            sc.close();
        }

    }
}