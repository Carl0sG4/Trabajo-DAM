import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa para registrar hasta tres temperaturas de forma cíclica
 * y ofrecer cálculos básicos (máximo, mínimo, media).
 *
 * Requisitos cumplidos:
 * - No usa arrays (solo tres variables double).
 * - Manejo de excepciones para entradas no válidas.
 * - Contiene al menos tres métodos que devuelven resultados.
 * - Documentación Javadoc en clase, campos y métodos.
 */
public class Temperaturas {

    /** Temperatura almacenada en la posición 1 (inicial 0). */
    private static double t1 = 0.0;
    /** Temperatura almacenada en la posición 2 (inicial 0). */
    private static double t2 = 0.0;
    /** Temperatura almacenada en la posición 3 (inicial 0). */
    private static double t3 = 0.0;

    /**
     * Índice cíclico (1,2,3) que indica qué temperatura se sobrescribe la próxima
     * vez.
     */
    private static int indice = 1;

    /**
     * Método principal con el menú interactivo.
     *
     * @param args argumentos de línea de comandos (no usados).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ DE TEMPERATURAS ---");
            System.out.println("1. Añadir nueva temperatura");
            System.out.println("2. Mostrar temperatura más alta");
            System.out.println("3. Mostrar temperatura más baja");
            System.out.println("4. Mostrar temperatura media");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar el final de línea
                switch (opcion) {
                    case 1:
                        agregarTemperatura(sc);
                        break;
                    case 2:
                        System.out.printf("La temperatura más alta es: %.2f%n", calcularMax());
                        break;
                    case 3:
                        System.out.printf("La temperatura más baja es: %.2f%n", calcularMin());
                        break;
                    case 4:
                        System.out.printf("La temperatura media es: %.2f%n", calcularMedia());
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un número entero para la opción.");
                sc.nextLine(); // descartar entrada inválida
            }
        } while (opcion != 5);

        sc.close();
    }

    /**
     * Lee una nueva temperatura desde el Scanner y la almacena de forma cíclica
     * en t1, t2 o t3 (1->2->3->1...).
     *
     * @param sc Scanner único para leer la entrada del usuario.
     */
    private static void agregarTemperatura(Scanner sc) {
        System.out.print("Introduce la temperatura: ");
        try {
            double nueva = sc.nextDouble();
            sc.nextLine(); // consumir newline

            switch (indice) {
                case 1:
                    t1 = nueva;
                    break;
                case 2:
                    t2 = nueva;
                    break;
                case 3:
                    t3 = nueva;
                    break;
                default:
                    // Protección por si índice tiene un valor inesperado
                    indice = 1;
                    t1 = nueva;
                    break;
            }

            indice++; // avanzar el índice
            if (indice > 3) { // reiniciar el ciclo
                indice = 1;
            }

            System.out.println("Temperatura guardada correctamente.");

        } catch (InputMismatchException e) {
            System.out.println("Error: introduce un número válido para la temperatura.");
            sc.nextLine(); // descartar entrada inválida
        }
    }

    /**
     * Calcula y devuelve la temperatura máxima entre las tres almacenadas.
     *
     * @return valor máximo (double).
     */
    private static double calcularMax() {
        return Math.max(t1, Math.max(t2, t3));
    }

    /**
     * Calcula y devuelve la temperatura mínima entre las tres almacenadas.
     *
     * @return valor mínimo (double).
     */
    private static double calcularMin() {
        return Math.min(t1, Math.min(t2, t3));
    }

    /**
     * Calcula y devuelve la temperatura media de las tres almacenadas.
     *
     * @return media (double).
     */
    private static double calcularMedia() {
        return (t1 + t2 + t3) / 3.0;
    }
}
