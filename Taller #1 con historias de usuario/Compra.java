
import java.util.ArrayList;

public class Compra {
    private String nombreCliente;
    private String direccionEntrega;
    
    public Compra(String nombreCliente, String direccionEntrega) {
        this.nombreCliente = nombreCliente;
        this.direccionEntrega = direccionEntrega;
    }

    public void finalizarCompra(Maquina maquina, ArrayList<Juego> juegosAgregados) {
        System.out.println("Compra finalizada para: " + nombreCliente);
        System.out.println("Máquina comprada: " + maquina.getNombreMaquina());
        System.out.println("Juegos comprados:");
        for (Juego juego : juegosAgregados) {
            System.out.println("- " + juego.getNombre());
        }
        System.out.println("La máquina será enviada a: " + direccionEntrega);
    }
}
