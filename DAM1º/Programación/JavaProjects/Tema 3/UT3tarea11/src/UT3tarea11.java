public class UT3tarea11 {

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
