import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        enum OperadoresLogicos {
            SUMAR,
            RESTAR,
            MULTIPLICAR,
            DIVIDIR,
        }

        System.out.println("Introduce primer número");
        double num1 = sc.nextDouble();

        System.out.println("Introduce segundo número");
        double num2 = sc.nextDouble();

        sc.nextLine(); // Implemento una lectura de escaner de tipo linea para vaciar el bufer del
                       // teclado (Tema 2_pag 40 de la Presentación)

        System.out.println("Introduce la operación a realizar(SUMAR, RESTAR, MULTIPLICAR, DIVIDIR): ");
        String caso = sc.nextLine().toUpperCase();

        OperadoresLogicos operador = OperadoresLogicos.valueOf(caso); // Para cambiar el valor de la enumeración al
                                                                      // valor de la variable caso (String)

        switch (operador) {

            case SUMAR:

                System.out.println(num1 + num2);

                break;

            case RESTAR:

                System.out.println(num1 - num2);

                break;

            case MULTIPLICAR:

                System.out.println(num1 * num2);
                ;

                break;

            case DIVIDIR:

                System.out.println(num1 / num2);
                ;

                break;

            default:

                System.out.println("No es válido");

                break;

        }
        sc.close();

    }

}