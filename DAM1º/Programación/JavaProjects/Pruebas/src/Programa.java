import java.util.Scanner;

public class Programa {
    public static int leerEntero() {
        Scanner sc = new Scanner(System.in);
        int numero = 0; // Entero que Leeremos desde teclado.
        boolean fin = false;// Instrucción 1
        do {
            try {
                System.out.println("Introduce un entero: ");// Instrucción 2
                numero = sc.nextInt();
                fin = true;// Instrucción 3
                sc.nextLine();// Instrucción 4

            } catch (Exception e) {
                System.out.println("\nERROR: No has introducido un entero.");// Instrucción 5
                sc.nextLine();// Instrucción 6
            }
        } while (!fin);
        
        //sc.close();
        return numero;// Instrucción 8
    }

    public static void main(String[] args) {
        int suma = 0;
        int cantidadNumeros = leerEntero(); // Leer el número de iteraciones
        for (int i = 0; i < cantidadNumeros; i++) {
            System.out.println("Introduce un número a sumar: ");
            int numero = leerEntero();
            suma += numero;
        }
        System.out.println("La suma de los números es: " + suma);
    }

}