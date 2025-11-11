public class Programa {
    public static void main(String[] args) {

        int totalIteraciones= recorrerBucle(1, 10, 5, 8);

        System.out.println("Número total de iteraciónes: " + totalIteraciones);

    }

    public static int recorrerBucle(int inicio, int terminar, int excepcion, int finalizar) {

        int contador = 0;

        for (int i = inicio; i <= terminar; i++) {

            if (i == excepcion) {
                continue;
            }

            if (i == finalizar) {
                break;
            }

            System.out.println("Índice actual: " + i);

            contador++;

        }

        return contador;

    }

}
