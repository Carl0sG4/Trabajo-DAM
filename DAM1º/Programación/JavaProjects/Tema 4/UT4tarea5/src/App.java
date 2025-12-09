import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Carlos Guaraca Nagua
 * @since 09/12/25 - 13:27
 * 
 */
public class App {
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
                        concatenarTexto(sc);
                        break;
                    case 2:
                        convertirMayus(sc);
                        break;
                    case 3:
                        convertirMin(sc);
                        break;
                    case 4:
                        obtenerLong(sc);
                        break;
                    case 5:
                        compararCad(sc);
                        break;
                    case 6:
                        verificarSubcadena(sc);
                        break;
                    case 7:
                        remplazarCaracter(sc);
                        break;
                    case 8:
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

        } while (opcion != 8);
        sc.close();
    }

    /**
     * Imprime en pantalla las opciones disponibles del ejercicio para que el
     * usuario elija qué operación realizar.
     */
    public static void menu() {
        System.out.println("\nMenú UT4Tarea5");
        System.out.println("1. Concatenar cadenas");
        System.out.println("2. Convertir carácteres en mayúscula");
        System.out.println("3. Convertir carácteres en minúscula");
        System.out.println("4. Obtener longitud de cadena");
        System.out.println("5. Comparar cadénas de texto");
        System.out.println("6. Verificar subcadena");
        System.out.println("7. Remplazar carácter");
        System.out.println("8. Finalizar Programa");
        System.out.print("Selecciones una opción: ");
    }

    public static void concatenarTexto(Scanner sc) {
        System.out.print("\nIntroduce la primera cadena: ");
        String cad1 = sc.nextLine();

        System.out.print("Introduce la segunda cadena: ");
        String cad2 = sc.nextLine();

        System.out.println("Palabra concatenada: " + cad1.concat(cad2));
    }

    public static void convertirMayus(Scanner sc) {
        System.out.print("Introduce la cadena de carácteres: ");
        String mayus = sc.nextLine();

        System.out.println("Cadena en mayúsculas: " + mayus.toUpperCase());
    }

    public static void convertirMin(Scanner sc) {
        System.out.print("Introduce la cadena de carácteres: ");
        String min = sc.nextLine();

        System.out.println("Cadena en minúscula: " + min.toLowerCase());
    }

    public static void obtenerLong(Scanner sc) {
        System.out.print("Introduce la cadena de carácteres: ");
        String tamaño = sc.nextLine();

        System.out.println("Longitud de cadena: " + tamaño.length());
    }

    public static void compararCad(Scanner sc) {
        System.out.print("Introduce la primera cadena: ");
        String cad1 = sc.nextLine();

        System.out.print("Introduce la segunda cadena: ");
        String cad2 = sc.nextLine();

        boolean comparacion = cad1.equalsIgnoreCase(cad2);

        if (!comparacion) {
            System.out.println("Las cadénas no son iguales");
        } else {
            System.out.println("Las cadénas son iguales");
        }
    }

    public static void verificarSubcadena(Scanner sc) {
        System.out.print("Introduce la cadena de carácteres: ");
        String cadena = sc.nextLine();

        System.out.print("Introduce el caracter especifico que quieres verificar: ");
        String caracter = sc.nextLine();

        boolean verificar = cadena.contains(caracter);

        if (!verificar) {
            System.out.println("La cadéna no contiene el carácter específico");
        } else {
            System.out.println("La cadéna contiene el carácter específico");
        }
    }

    public static void remplazarCaracter(Scanner sc) {
        System.out.print("Introduce la cadena de carácteres: ");
        String cadena = sc.nextLine();

        System.out.print("Introduce el carácter específico que quieres remplazar: ");
        String caracter = sc.nextLine();
        
        System.out.print("Introduce el carácter por el que quieres remplazar: ");
        String remplazar = sc.nextLine();

        System.out.println("Cadena remplazada: " + cadena.replace(caracter,remplazar));
    }

}