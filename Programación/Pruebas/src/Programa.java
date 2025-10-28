import java.util.Scanner;


public class Programa {

public static void main(String[]args){

    Scanner sc = new Scanner(System.in);


    System.out.println("Introduce la cantidad en euros: ");

    double euro = sc.nextDouble();


    double dolar = euro * 1.18 ;


    System.out.println("Tu cantidad en dólares es: " + dolar);


sc.close();


}

}


