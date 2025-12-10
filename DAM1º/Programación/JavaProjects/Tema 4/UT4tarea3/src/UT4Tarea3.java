import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Carlos Guaraca Nagua
 * @since 29/11/25 - 11:51
 * 
 */
public class UT4Tarea3 {
    /**
     * Punto de entrada del programa: muestra el menú, gestiona la opción elegida
     * por el usuario y cierra el escáner al terminar.
     */
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
                        rellenarArray(sc);
                        break;
                    case 2:
                        ordenarArray(sc);
                        break;
                    case 3:
                        buscarNumero(sc);
                        break;
                    case 4:
                        compararArray();
                        break;

                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Error, introduce un número válido");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: introduce un número del menú.");
                sc.nextLine();
            }

        } while (opcion != 5);
        sc.close();
    }

    /**
     * Imprime en pantalla las opciones disponibles del ejercicio para que el
     * usuario elija qué operación realizar.
     */
    public static void menu() {
        System.out.println("\nMenú UT4Tarea3");
        System.out.println("1. Rellena un Array: ");
        System.out.println("2. Ordenar un Array");
        System.out.println("3. Buscar en un Array");
        System.out.println("4. Coparar Arrays (No pide al usuario)");
        System.out.println("5. Finalizar Programa");
        System.out.print("Selecciones una opción: ");
    }

    /**
     * Pregunta el tamaño y un valor decimal y crea un array rellenado
     * íntegramente con ese mismo valor.
     *
     * @param sc escáner para leer los datos introducidos por el usuario
     */
    public static void rellenarArray(Scanner sc) {
        try {
            System.out.print("Escoga el tamaño del array: ");
            int tamaño = sc.nextInt();
            if (tamaño <= 0) {
                throw new IllegalArgumentException("El tamaño debe ser mayor que cero");
            }

            System.out.print("Escoga un valor decimal que quiere que se repita: ");
            double valor = sc.nextDouble();

            double[] numeros = new double[tamaño];

            Arrays.fill(numeros, valor);

            System.out.println("Array definido: " + Arrays.toString(numeros));
        } catch (InputMismatchException e) {
            System.out.println("Error: introduce números válidos.");
            sc.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        }
    }

    /**
     * Solicita cinco enteros, los guarda en un array, los ordena de menor a
     * mayor y muestra el resultado.
     *
     * @param sc escáner compartido con el resto de opciones del menú
     */
    public static void ordenarArray(Scanner sc) {
        try {
            System.out.print("Escoga el primer número entero: ");
            int num1 = sc.nextInt();

            System.out.print("Escoga el segundo número entero: ");
            int num2 = sc.nextInt();

            System.out.print("Escoga el tercero número entero: ");
            int num3 = sc.nextInt();

            System.out.print("Escoga el cuarto número entero: ");
            int num4 = sc.nextInt();

            System.out.print("Escoga el quinto número entero: ");
            int num5 = sc.nextInt();

            int[] ordenado = { num1, num2, num3, num4, num5 };

            Arrays.sort(ordenado);
            System.out.println("Array definido: " + Arrays.toString(ordenado));
        } catch (InputMismatchException e) {
            System.out.println("Error: debes introducir números enteros.");
            sc.nextLine();
        }
    }

    /**
     * Pide cinco enteros, los ordena y permite buscar un valor usando búsqueda
     * binaria, indicando si se encuentra o dónde se insertaría.
     *
     * @param sc escáner para capturar los números y el valor a buscar
     */
    public static void buscarNumero(Scanner sc) {
        try {
            System.out.print("Escoga el primer número entero: ");
            int num1 = sc.nextInt();

            System.out.print("Escoga el segundo número entero: ");
            int num2 = sc.nextInt();

            System.out.print("Escoga el tercero número entero: ");
            int num3 = sc.nextInt();

            System.out.print("Escoga el cuarto número entero: ");
            int num4 = sc.nextInt();

            System.out.print("Escoga el quinto número entero: ");
            int num5 = sc.nextInt();

            int[] ordenado = { num1, num2, num3, num4, num5 };

            Arrays.sort(ordenado);

            System.out.print("Que número desea buscar: ");
            int buscar = sc.nextInt();

            int indice = Arrays.binarySearch(ordenado, buscar);

            // Si la búsqueda devuelve un índice válido, lo encontró; si no, calculamos dónde debería ir.
            if (indice >= 0) {
                System.out.println("Numero encontrado" );
            } else {
                int puntoInsercion = -indice - 1;
                System.out.println("Numero no encontrado, si existiera, estaría en la posición " + puntoInsercion );
            }

            System.out.println(Arrays.toString(ordenado));
        } catch (InputMismatchException e) {
            System.out.println("Error: introduce solo números enteros.");
            sc.nextLine();
        }
    }

    /**
     * Compara dos arrays de cadenas predefinidos e informa si tienen el mismo
     * contenido en todas sus posiciones.
     */
    public static void compararArray() {
        String[] array1 = {"Ejemplo1","Ejemplo2","Ejemplo3","Ejemplo5"};
        String[] array2 = {"Ejemplo1","Ejemplo2","Ejemplo3","Ejemplo4"};

        boolean comparar = Arrays.equals(array1, array2);

        if(comparar == true) {
            System.out.println("Los arrays son iguales" );
        } else {
            System.out.println("Los arrays no son iguales");
        }
    }

}
