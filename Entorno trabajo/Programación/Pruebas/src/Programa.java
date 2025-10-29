import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce un número de mes: ");
        int mes= sc.nextInt();

            switch (mes) {

                case 12,1,2:

                    System.out.println("En este mes es inverno");

                    break;

                case 3,4,5:

                    System.out.println("En este mes es primavera");

                    break;

                case 6,7,8:

                    System.out.println("En este mes es verano");

                    break;

                case 9,10,11:

                    System.out.println("En este mes es otoño");

                    break;

                default:

                    System.out.println("Opción no válida. Por favor, intentelo de nuevo.");

                    break;


            }
            sc.close();

        }


    }


    