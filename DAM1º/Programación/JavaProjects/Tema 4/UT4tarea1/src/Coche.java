/**
 * @author Carlos Guaraca Nagua
 * @since 20/11/25 - 13:05
 */
public class Coche {

    static int cantidadCoches;

    String marca;
    String modelo;
    
    //Constructor sin marca, sin modelo
    public Coche() {
        marca = "desconocida";
        modelo = "desconocido";
        cantidadCoches++;
    }

    //Constructor con marca, sin modelo
    public Coche(String marca) {
        this.marca = marca;
        this.modelo = "no identificado";
        cantidadCoches++;
    }

    //Constructor con marca, con modelo
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        cantidadCoches++;
    }

    // Método de instancia (Arranque)
    public void arrancar() {
        System.out.println("El coche marca " + marca + " modelo " + modelo + " está arrancando");
    }

    // Método estático (Cantidad)
    public static int getCantidadCoches() {
        return cantidadCoches;
    }

    public static void main(String[] args) {

        Coche coche1 = new Coche();

        System.out.println("Coches creados: " + Coche.getCantidadCoches());

        Coche coche2 = new Coche("Seat");

        System.out.println("Coches creados: " + Coche.getCantidadCoches());

        Coche coche3 = new Coche("Toyota", "Corola");

        System.out.println("Coches creados: " + Coche.getCantidadCoches());

        coche1.arrancar();
        coche2.arrancar();
        coche3.arrancar();

    }

}