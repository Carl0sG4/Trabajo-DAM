import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.random.RandomGenerator;


/**
 * @author Carlos Guaraca Nagua
 * @since 10/12/25 - 17:27
 * 
 */
public class UT4Tarea7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            menu();
            try {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        numerosPseudoEnt(sc);
                        break;
                    case 2:
                        numerosPseudoDec(sc);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Error, introduce un número válido");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: introduce un valor numérico válido.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }

        } while (opcion != 3);
        sc.close();
    }

    /**
     * Imprime en pantalla las opciones disponibles del ejercicio para que el
     * usuario elija qué operación realizar.
     */
    public static void menu() {
        System.out.println("\nMenú UT4Tarea7");
        System.out.println("1. Generar números enteros pseudoaleatorios");
        System.out.println("2. Generar números decimales pseudoaleatorios");
        System.out.println("3. Finalizar Programa");
        System.out.print("\nSeleccione una opción: ");
    }

    public static void numerosPseudoEnt(Scanner sc) {
        RandomGenerator aleatorio = RandomGenerator.getDefault();

        System.out.print("Cantidad de números pseudoaleatorios: ");
        int cantidad = sc.nextInt();

        System.out.print("Valor límite para pseudoaleatorios deseado: ");
        int limite = sc.nextInt();

        if (limite <= 0) {
            System.out.println("El límite debe ser mayor que cero.");
            return;
        }
        
        for (int i = 0; i < cantidad; i++) {
            int numero = aleatorio.nextInt(limite);
            System.out.println(numero);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Pausa interrumpida");
            }
        }

    }

    public static void numerosPseudoDec(Scanner sc) {
        RandomGenerator aleatorio = RandomGenerator.getDefault();

        System.out.print("Cantidad de números pseudoaleatorios decimales: ");
        int cantidad = sc.nextInt();

        System.out.print("Valor límite superior (exclusivo) para los decimales: ");
        double limite = sc.nextDouble();

        if (limite <= 0) {
            System.out.println("El límite debe ser mayor que cero.");
            return;
        }

        for (int i = 0; i < cantidad; i++) {
            double numero = aleatorio.nextDouble(limite);
            System.out.println(numero);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Pausa interrumpida");
            }
        }
    }
}