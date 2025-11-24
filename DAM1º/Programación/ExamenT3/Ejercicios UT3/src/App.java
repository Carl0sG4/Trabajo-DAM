//Tarea 12

import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * @author Carlos Guaraca Nagua
 * @since 19/11/25 - 13:37
 *        Programa para registrar hasta tres temperaturas de forma cíclica  *        y ofrecer cálculos básicos (máximo, mínimo, media).
 *        Requisitos cumplidos:
 *        - No usa arrays (solo tres variables double).
 *        - Manejo de excepciones para entradas no válidas.
 *        - Contiene al menos tres métodos que devuelven resultados.  *        - Documentación Javadoc en clase, campos y métodos.
 */
public class App {
    /** Creación de las temperaturas al principio del código */     private static double temp1 = 0.0;
    private static double temp2 = 0.0;
    private static double temp3 = 0.0;
    /** Índice cíclico (indíca qué temperatura se sobrescribe) */     private static int indice = 1;
    /**
     * Método principal con el menú interactivo.      */
    public static void main(String[] args) {        
    Scanner sc = new Scanner(System.in);         int opcion = 0;        do {
            System.out.println("\n--- MENÚ DE TEMPERATURAS ---");
            System.out.println("1. Añadir nueva temperatura");
            System.out.println("2. Mostrar temperatura más alta");
            System.out.println("3. Mostrar temperatura más baja");
            System.out.println("4. Mostrar temperatura media");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            try {
                opcion = sc.nextInt();
                sc.nextLine();// limpiar el final de línea
                switch (opcion) {
                    case 1:
                        agregarTemperatura(sc);
                        break;
                    case 2:
                        System.out.printf("La temperatura más alta es: %.2f%n", calcularMax());                         break;
                    case 3:
                        System.out.printf("La temperatura más baja es:  %.2f%n", calcularMin());                         break;
                    case 4:
                        System.out.printf("La temperatura media es:  %.2f%n", calcularMedia());                         break;
                    case 5:
                        System.out.println("Saliendo del programa...");                         break;                    default:
                        System.out.println("Valor no válido. Intenta de nuevo");                         break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un valor entero");                 sc.nextLine();// descartar entrada inválida
            }
        } while (opcion != 5);
        sc.close();
    }
    /**
     * Lee una nueva temperatura desde el Scanner y la almacena de forma cíclica      * en t1, t2 o t3 (1->2->3->1...).
     *
     * @param sc Scanner único para leer la entrada del usuario.
     */
    private static void agregarTemperatura(Scanner sc) {         System.out.print("Introduce la temperatura(decimal con ´,´): ");         try {
            double temp = sc.nextDouble();             sc.nextLine();
            switch (indice) {                 case 1:                     temp1 = temp;                    break;
                case 2:
                    temp2 = temp;
                    break;
                case 3:
                    temp3 = temp;
                    break;
            }
            indice++;
            if (indice > 3) {
                indice = 1;// Reiniciar cíclo
            }
            System.out.println("Temperatura guardada automáticamente");
        } catch (InputMismatchException e) {
            System.out.println("Error: introduce un valor válido para la temperatura");             sc.nextLine();// descartar entrada inválida
        }
    }
    /**
     * Calcula y devuelve la temperatura máxima entre las tres almacenadas.      *
     * @return valor máximo (double).
     */
    private static double calcularMax() {
        return Math.max(temp1, Math.max(temp2, temp3));    }
    /**
     * Calcula y devuelve la temperatura mínima entre las tres almacenadas.      *
     * @return valor mínimo (double).
     */
    private static double calcularMin() {
        return Math.min(temp1, Math.min(temp2, temp3));
    }
    /**
     * Calcula y devuelve la temperatura media de las tres almacenadas.      *
     * @return media (double).
     */
    private static double calcularMedia() {         return (temp1 + temp2 + temp3) / 3.0;     }
}

//Tarea 11

public class App {

    public static class LimiteCompraExcedidoException extends Exception {
        public LimiteCompraExcedidoException(String mensaje) {
            super(mensaje);
        }
    }

    public static void main(String[] args) {

        double valor = 1100;

        try {
            realizarCompra(valor);
        } catch (LimiteCompraExcedidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void realizarCompra(double valor) throws LimiteCompraExcedidoException {
        if (valor > 1000) {
            throw new LimiteCompraExcedidoException("No se permite realizar compras superiores a 1000 euros.");
        } else {
            System.out.println("La compra ha sido realizada con éxito.");
        }
    }
}

//Tarea 10

import java.util.Scanner;

public class App {
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

//Tarea 8

import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 * @author Carlos Guaraca Nagua
 * @since 3 de noviembre de 2025
 */

public class App {
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

//Tarea 7

public class App {
    public static void main(String[] args) {
        int totalIteraciones= recorrerBucle(1, 10, 5, 8);
         System.out.println("Número  total  de  iteraciónes:  "  + totalIteraciones);
    }
    public  static  int  recorrerBucle(int  inicio,  int  terminar,  int excepcion, int finalizar) {
        int contador = 0;
        for (int i = inicio; i <= terminar; i++) {
            if (i == excepcion) {
                continue;
            }
            if (i == finalizar) {
                break;
            }
            System.out.println("Índice actual: " + i);             contador++;
        }
        return contador;     }
}