import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final String contraseña = "ABCD";
        int i = 0; 
        boolean correcto = false;

        do {
            System.out.print("Introduce la contraseña: ");
            String intento = sc.nextLine();


            if (intento.equals(contraseña)) {
                System.out.println("Contraseña válida");
                correcto = true;
            } else {
                System.out.println("Contraseña inválida");
                i++;
            }

        } while (i<3 && !correcto);

        if (!correcto) {
            System.out.println("Has superado el número máximo de intentos.");
        }
        
        sc.close();
    }
}