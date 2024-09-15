import java.util.Scanner;

public class TiendaMaquinas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Maquina maquina = null;

        // Menú para seleccionar la máquina
        System.out.println("Seleccione el tipo de máquina que desea comprar:");
        System.out.println("1. Arcade");
        System.out.println("2. Consola");
        int opcionMaquina = scanner.nextInt();
        
        if (opcionMaquina == 1) {
            maquina = new MaquinaArcade();
        } else if (opcionMaquina == 2) {
            maquina = new MaquinaConsola();
        } else {
            System.out.println("Opción inválida.");
            return;
        }
        
        maquina.mostrarTipoMaquina();
        
        // Menú para seleccionar el material
        System.out.println("Seleccione el material de la máquina:");
        System.out.println("1. Madera");
        System.out.println("2. Aluminio");
        System.out.println("3. Fibra de carbono");
        int opcionMaterial = scanner.nextInt();
        
        switch (opcionMaterial) {
            case 1:
                maquina.seleccionarMaterial("Madera");
                break;
            case 2:
                maquina.seleccionarMaterial("Aluminio");
                break;
            case 3:
                maquina.seleccionarMaterial("Fibra de carbono");
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        // Mostrar juegos disponibles y agregar juegos por código
        boolean masJuegos = true;
        while (masJuegos) {
            maquina.mostrarJuegosDisponibles();
            System.out.println("Ingrese el código del juego que desea agregar (1-4):");
            int codigoJuego = scanner.nextInt();
            maquina.agregarJuegoPorCodigo(codigoJuego);
            
            System.out.println("¿Desea agregar más juegos? (1: Sí, 2: No)");
            int opcionAgregarJuegos = scanner.nextInt();
            if (opcionAgregarJuegos != 1) {
                masJuegos = false;
            }
        }

        // Finalizar compra
        System.out.println("Ingrese su nombre:");
        scanner.nextLine();  // Consumir el salto de línea
        String nombreCliente = scanner.nextLine();
        System.out.println("Ingrese su dirección de entrega:");
        String direccionEntrega = scanner.nextLine();

        Compra compra = new Compra(nombreCliente, direccionEntrega);
        compra.finalizarCompra(maquina, maquina.getJuegosAgregados());

        scanner.close();
    }
}
