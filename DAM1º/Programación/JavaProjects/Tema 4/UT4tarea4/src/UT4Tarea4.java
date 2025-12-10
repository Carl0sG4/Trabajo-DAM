import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Carlos Guaraca Nagua
 * @since 04/12/25 - 11:53
 * 
 */
public class UT4Tarea4 {
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
                        calcularAbsoluto(sc);
                        break;
                    case 2:
                        redondearNumero(sc);
                        break;
                    case 3:
                        elevarPotencia(sc);
                        break;
                    case 4:
                        calcularRaiz(sc);
                        break;
                    case 5:
                        calcularSeno(sc);
                        break;
                    case 6:
                        truncaNumero(sc);
                        break;
                    case 7:
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
            }

        } while (opcion != 7);
        sc.close();
    }

    /**
     * Imprime en pantalla las opciones disponibles del ejercicio para que el
     * usuario elija qué operación realizar.
     */
    public static void menu() {
        System.out.println("\nMenú UT4Tarea4");
        System.out.println("1. Calcular absoluto");
        System.out.println("2. Redondear número entero");
        System.out.println("3. Elevar número a una potencia");
        System.out.println("4. Calcular raíz cuadrada");
        System.out.println("5. Calcular seno de ángulo");
        System.out.println("6. Truncar número");
        System.out.println("7. Finalizar Programa");
        System.out.print("Selecciones una opción: ");
    }

    public static void calcularAbsoluto(Scanner sc) {
        try {
            System.out.println("Inserta un número decimal para calcular el absoluto: ");
            double decimal = sc.nextDouble();

            double absoluto = Math.abs(decimal);
            System.out.println("Número absoluto: " + absoluto);
        } catch (InputMismatchException e) {
            System.out.println("Error: introduce un número decimal válido.");
            sc.nextLine();
        }
    }

    public static void redondearNumero(Scanner sc) {
        try {
            System.out.println("Inserta un número decimál para poder redondearlo: ");
            double decimal = sc.nextDouble();

            long redondeado = Math.round(decimal);
            System.out.println("Número redondeado: " + redondeado);
        } catch (InputMismatchException e) {
            System.out.println("Error: introduce un número decimal válido.");
            sc.nextLine();
        }
    }

    public static void elevarPotencia(Scanner sc) {
        try {
            System.out.println("Inserta un número decimal para poder elevarlo: ");
            double base = sc.nextDouble();

            System.out.println("A qué número desea elevarlo: ");
            double exponente = sc.nextDouble();

            if (base == 0 && exponente <= 0) {
                throw new IllegalArgumentException(
                        "No se puede elevar 0 a exponentes negativos ni a 0, el resultado es indeterminado.");
            }

            double numeroElevado = Math.pow(base, exponente);
            System.out.println("Número elevado: " + numeroElevado);
        } catch (InputMismatchException e) {
            System.out.println("Error: introduce números enteros válidos.");
            sc.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void calcularRaiz(Scanner sc) {
        try {
            System.out.println("Inserta un número decimal para poder calcular la raíz cuadrada: ");
            double decimal = sc.nextDouble();

            if (decimal < 0) {
                throw new IllegalArgumentException("No es posible calcular la raíz cuadrada de un número negativo.");
            }

            double raiz = Math.sqrt(decimal);
            System.out.println("Raíz cuadrada: " + raiz);
        } catch (InputMismatchException e) {
            System.out.println("Error: introduce un número decimal válido.");
            sc.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void calcularSeno(Scanner sc) {
        try {
            System.out.println("Inserta un ángulo en decimal para poder calcular su seno (radianes): ");
            double angulo = sc.nextDouble();

            double seno = Math.sin(angulo);
            System.out.println("Seno: " + seno);
        } catch (InputMismatchException e) {
            System.out.println("Error: introduce un ángulo válido en radianes.");
            sc.nextLine();
        }
    }

    public static void truncaNumero(Scanner sc) {
        try {
            System.out.println("Inserta un número decimal para poder truncarlo: ");
            double decimal = sc.nextDouble();

            double redondeaAbajo = Math.floor(decimal);
            double redondeaArriba = Math.ceil(decimal);

            System.out.println("Truncar número para positivos: " + redondeaAbajo);
            System.out.println("Truncar número para negativos: " + redondeaArriba);
        } catch (InputMismatchException e) {
            System.out.println("Error: introduce un número decimal válido.");
            sc.nextLine();
        }
    }


}
