import java.util.Scanner;
/**
 * @author Carlos Guaraca Nagua
 * @since 27/11/2025-13:42
 */
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcion = 0 ;

        do{
            menu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    conversionPrimitivos(sc);
                    break;
                case 2:
                    constantesMinMax();
                    break;
                case 3:
                    conversionCadena();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
            
                default:
                    System.out.println("Error, introduce un número válido");
                    break;
            }


        } while (opcion!=4);
        sc.close();
    }

    /**
     * Presenta por pantalla las opciones disponibles del menú principal.
     */
    public static void menu () {
        System.out.println("\nMenú UT4Tarea2");
        System.out.println("1. Conversión entre primitivos y clases envoltorio");
        System.out.println("2. Uso de Constantes MIN_VALUE y MAX_VALUE");
        System.out.println("3. Conversiones a y desde Cadenas");
        System.out.println("4. Finalizar Programa");
        System.out.print("Selecciones una opción: ");
    }

    /**
     * Convierte valores primitivos a sus clases envoltorio usando el escáner dado.
     *
     * @param sc escáner compartido desde el que se leen los datos.
     */
    public static void conversionPrimitivos (Scanner sc) {
        System.out.print("Asigna valor a una variable int: ");
        int numero  = sc.nextInt();
        

        System.out.print("\nAsigna valor a una variable double (con ,): ");
        double decimal  = sc.nextDouble();
        

        System.out.print("\nAsigna valor a una variable char: ");
        char caracter = sc.next().charAt(0);
        sc.nextLine();

        Integer integernum = Integer.valueOf(numero);
        int intValue = integernum.intValue();

        Double doubleNum = Double.valueOf(decimal);
        double doubleValue = doubleNum.doubleValue();

        Character charCar = Character.valueOf(caracter);
        char charValue = charCar.charValue();

        System.out.println("\nResultados de conversión:");
        System.out.println("Integer -> " + intValue);
        System.out.println("Double  -> " + doubleValue);
        System.out.println("Character -> " + charValue);
    }

    /**
     * Muestra las constantes MIN_VALUE y MAX_VALUE de varios tipos numéricos.
     */
    public static void constantesMinMax() {
        System.out.println("\n--- Valores límites numéricos ---");
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);

        System.out.println("Long.MIN_VALUE = " + Long.MIN_VALUE);
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);

        System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE);
        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);
    }

    /**
     * Convierte una cadena numérica en Integer y en int para mostrar el resultado.
     */
    public static void conversionCadena() {
        String cadenanum = "123";

        Integer numeroentero = Integer.valueOf(cadenanum);

        int numeroPrimitivo = numeroentero.intValue();

        System.out.println("Integer -> " + numeroentero);
        System.out.println("int -> " + numeroPrimitivo);
    }
}
