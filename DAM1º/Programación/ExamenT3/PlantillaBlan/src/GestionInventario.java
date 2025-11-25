import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.IllegalArgumentException;

/**
 * @author Carlos Guaraca Nagua
 * @since 25/11/2025 -- 13:05
 * 
 *        Programa que gestiona el inventario de Productos de un Almacén
 * 
 *        Contiene 5 métodos que devuelven resultados (Para las 5 opciones del
 *        menú)
 */
public class GestionInventario {
    /*
     * Creación de las variables que se va a utilizar en todo el código, tanto de
     * los productos en el inventario(comienza en 100), como productos
     * retirados(comienza en 0)
     */
    private static int producto = 100;
    private static int productoret = 0;

    /* Creación de una excepcion personalizada */
    public static class InventarioInvalidoException extends Exception {
        public InventarioInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    /* Código principal que muestra un menú con diferentes opciones */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ DEL INVENTARIO ---");
            System.out.println("1. Consultar productos");
            System.out.println("2. Añadir productos");
            System.out.println("3. Retirar productos");
            System.out.println("4. Mostrar estadísticas");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();// limpiar el final de línea
                switch (opcion) {
                    case 1:
                        inventario();
                        break;
                    case 2:
                        añadirProducto(sc);
                        break;
                    case 3:
                        retirarProducto(sc);
                        break;
                    case 4:
                        inventarioRetirado();
                        break;
                    case 5:
                        salidaPrograma();
                        break;

                    default:
                        System.out.println("Valor no válido. Intenta de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número válido o no tan alto.");
                sc.nextLine();// descartar entrada inválida
            }

        } while (opcion != 5);
        sc.close();
    }

    /* Método que muestra el stock actual del inventario */
    private static void inventario() {
        System.out.println("Hay en stock un total de " + producto + " productos.");

    }

    /* Método que añade productos al inventario */
    private static void añadirProducto(Scanner sc) {
        System.out.println("Cuantos productos deseas añadir: ");
        try {
            int prod = sc.nextInt();
            verificarPositivo(prod);
            producto += prod; // acumulamos los productos a añadir a los productos del stock
            System.out.println("Operación realizada con éxito");

        } catch (InventarioInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();// descartar entrada inválida
        }

    }

    /* Método que retira productos del inventario */
    private static void retirarProducto(Scanner sc) {
        System.out.println("Cuantos productos deseas retirar: ");
        try {
            int prod = sc.nextInt();
            verificarPositivo(prod);
            // verificamos que haya sufucientes productos en stock
            if (producto < prod) {
                throw new IllegalArgumentException("Stock insuficiente");
            } else {
                productoret += prod;// acumulamos los productos a retirar en una varible que guarde la información
                producto -= prod;// realizamos la retirada de productos
                System.out.println("Operación realizada con éxito");
            }

        } catch (InventarioInvalidoException | IllegalArgumentException e) {
            if (e instanceof InventarioInvalidoException) {
                System.out.println("Error: " + e.getMessage());
            } else if (e instanceof IllegalArgumentException) {
                System.out.println("Error: " + e.getMessage() + " No se puede completar la acción");
            }
            sc.nextLine();// descartar entrada inválida
        }
    }

    /* Método que muestra la cantidad de productos retirado del inventario */
    private static void inventarioRetirado() {
        System.out.println("Has retirado en total: " + productoret + " productos.");

    }

    /* Método muestra un mensaje para finalizar el programa */
    private static void salidaPrograma() {
        System.out.println("Saliendo del programa...");

    }

    /* Método que verifica si un número es positivo */
    private static void verificarPositivo(int prod) throws InventarioInvalidoException {
        // ejecuta la acción si la cantidad de productos a retirar o añadir es negativo
        if (prod < 0) {
            throw new InventarioInvalidoException("No se permite unidades negativas");
        }
    }
}
