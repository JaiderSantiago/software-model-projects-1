/**
* This file contains the definition of a class for a simple machine store.
*
* Author: Jaider Santiago Avila Robles <jsquimbaya@udistrital.edu.co>
/**
* This file contains a simple command line interface (CLI) for machine store manipulation.
*
* This file is part of Taller #2.
*
* Taller #2 is free software: you can redistribute it and/or
* modify it under the terms of the GNU General Public License as published
* by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
*
* Taller #2 is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
* for details. *
* You should have received a copy of the GNU General Public License
* along with Workshop #2. If not, see <https://www.gnu.org/licenses/>.
*/
import java.util.List;
import java.util.Scanner;

/**
 * This is the main class that controls the flow of the program.
 *
 * It provides a menu for users to interact with the system, allowing them to
 * register machines, add or remove video games, and generate purchase invoices.
 */
public class Principal {

    /**
     * This is the main entry point of the program.
     *
     * It contains a loop to display the menu options and perform actions based on user input.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaquinaManager manager = MaquinaManager.getInstance();
        
        while (true) {
            System.out.println("Menú Principal");
            System.out.println("1. Agregar máquina preconfigurada");
            System.out.println("2. Mostrar todas las máquinas registradas");
            System.out.println("3. Buscar máquinas por filtros");
            System.out.println("4. Agregar videojuego a máquina registrada");
            System.out.println("5. Eliminar videojuego de máquina registrada");
            System.out.println("6. Generar factura y salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline character

            switch (opcion) {
                case 1:
                    agregarMaquinaPreconfigurada(scanner, manager);
                    break;
                case 2:
                    manager.mostrarMaquinas();
                    break;
                case 3:
                    buscarMaquinasPorFiltros(scanner, manager);
                    break;
                case 4:
                    agregarVideojuegoAMaquina(scanner, manager);
                    break;
                case 5:
                    eliminarVideojuegoDeMaquina(scanner, manager);
                    break;
                case 6:
                    generarFactura(scanner, manager);
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    /**
     * This method allows the user to add a pre-configured machine.
     *
     * It asks the user to choose a type of machine and allows customization of the material and color.
     *
     * @param scanner The scanner object to read user input.
     * @param manager The instance of MaquinaManager to handle machine registration.
     */
    private static void agregarMaquinaPreconfigurada(Scanner scanner, MaquinaManager manager) {
        System.out.println("Seleccione el tipo de máquina:");
        System.out.println("1. Dance Revolution");
        System.out.println("2. Arcade Clásico");
        System.out.println("3. Máquina de Tiro");
        System.out.println("4. Máquina de Carreras");
        System.out.println("5. Realidad Virtual");
        int tipoMaquina = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character

        Maquina nuevaMaquina = null;
        switch (tipoMaquina) {
            case 1:
                nuevaMaquina = new MaquinaDanceRevolution();
                break;
            case 2:
                nuevaMaquina = new MaquinaArcade();
                break;
            case 3:
                nuevaMaquina = new MaquinaTiro();
                break;
            case 4:
                nuevaMaquina = new MaquinaCarreras();
                break;
            case 5:
                nuevaMaquina = new MaquinaRealidadVirtual();
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        System.out.println("Seleccione el material de la máquina:");
        System.out.println("1. Madera");
        System.out.println("2. Aluminio");
        System.out.println("3. Fibra de carbono");
        int materialSeleccionado = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character

        switch (materialSeleccionado) {
            case 1:
                nuevaMaquina.personalizarMaterial("madera");
                break;
            case 2:
                nuevaMaquina.personalizarMaterial("aluminio");
                break;
            case 3:
                nuevaMaquina.personalizarMaterial("fibra de carbono");
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        System.out.println("Ingrese el color de la máquina:");
        String color = scanner.nextLine();
        nuevaMaquina.color = color;

        manager.registrarMaquina(nuevaMaquina);
        System.out.println("Máquina registrada con éxito.");
    }

    /**
     * This method allows the user to search machines by various filters.
     *
     * The user can filter by the number of video games, material type, or game name.
     *
     * @param scanner The scanner object to read user input.
     * @param manager The instance of MaquinaManager to retrieve machine information.
     */
    private static void buscarMaquinasPorFiltros(Scanner scanner, MaquinaManager manager) {
        System.out.println("Seleccione el filtro de búsqueda:");
        System.out.println("1. Por cantidad de videojuegos");
        System.out.println("2. Por tipo de material");
        System.out.println("3. Por nombre del videojuego");
        int filtro = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character

        switch (filtro) {
            case 1:
                System.out.println("Ingrese la cantidad mínima de videojuegos:");
                int minJuegos = scanner.nextInt();
                scanner.nextLine(); // Consumes the newline character
                for (Maquina maquina : manager.obtenerMaquinas()) {
                    if (maquina.videojuegos.size() >= minJuegos) {
                        maquina.mostrarDetalles();
                    }
                }
                break;
            case 2:
                System.out.println("Ingrese el material a buscar:");
                String materialBusqueda = scanner.nextLine();
                for (Maquina maquina : manager.obtenerMaquinas()) {
                    if (maquina.material.equalsIgnoreCase(materialBusqueda)) {
                        maquina.mostrarDetalles();
                    }
                }
                break;
            case 3:
                System.out.println("Ingrese el nombre del videojuego a buscar:");
                String nombreJuego = scanner.nextLine();
                for (Maquina maquina : manager.obtenerMaquinas()) {
                    for (Videojuego juego : maquina.videojuegos) {
                        if (juego.nombre.equalsIgnoreCase(nombreJuego)) {
                            maquina.mostrarDetalles();
                        }
                    }
                }
                break;
            default:
                System.out.println("Opción de filtro no válida.");
        }
    }

    /**
     * This method allows the user to add a video game to a registered machine.
     *
     * The user selects a machine and provides the details of the video game to be added.
     *
     * @param scanner The scanner object to read user input.
     * @param manager The instance of MaquinaManager to retrieve machine information.
     */
    private static void agregarVideojuegoAMaquina(Scanner scanner, MaquinaManager manager) {
        System.out.println("Seleccione la máquina a la que desea agregar un videojuego (ingrese el número):");
        List<Maquina> maquinas = manager.obtenerMaquinas();
        for (int i = 0; i < maquinas.size(); i++) {
            System.out.println((i + 1) + ". " + maquinas.get(i).obtenerDescripcion());
        }
        int maquinaSeleccionada = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character

        if (maquinaSeleccionada < 1 || maquinaSeleccionada > maquinas.size()) {
            System.out.println("Selección no válida.");
        } else {
            Maquina maquina = maquinas.get(maquinaSeleccionada - 1);

            System.out.println("Ingrese el nombre del videojuego:");
            String nombreJuego = scanner.nextLine();
            System.out.println("Ingrese el creador de la historia:");
            String storytellingCreator = scanner.nextLine();
            System.out.println("Ingrese el creador de los gráficos:");
            String graphicsCreator = scanner.nextLine();
            System.out.println("Ingrese la categoría del videojuego:");
            String categoria = scanner.nextLine();
            System.out.println("Ingrese el precio del videojuego:");
            double precio = scanner.nextDouble();
            System.out.println("Ingrese el año del videojuego:");
            int anio = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline character

            System.out.println("¿Es en alta definición? (s/n):");
            boolean altaDefinicion = scanner.nextLine().equalsIgnoreCase("s");

            Videojuego nuevoVideojuego = new Videojuego(nombreJuego, storytellingCreator, graphicsCreator, categoria, precio, anio);
            maquina.agregarVideojuego(nuevoVideojuego, altaDefinicion);
        }
    }

    /**
     * This method allows the user to remove a video game from a registered machine.
     *
     * The user selects a machine and chooses which video game to remove.
     *
     * @param scanner The scanner object to read user input.
     * @param manager The instance of MaquinaManager to retrieve machine information.
     */
    private static void eliminarVideojuegoDeMaquina(Scanner scanner, MaquinaManager manager) {
        System.out.println("Seleccione la máquina de la que desea eliminar un videojuego (ingrese el número):");
        List<Maquina> maquinas = manager.obtenerMaquinas();
        for (int i = 0; i < maquinas.size(); i++) {
            System.out.println((i + 1) + ". " + maquinas.get(i).obtenerDescripcion());
        }
        int maquinaSeleccionada = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character

        if (maquinaSeleccionada < 1 || maquinaSeleccionada > maquinas.size()) {
            System.out.println("Selección no válida.");
        } else {
            Maquina maquina = maquinas.get(maquinaSeleccionada - 1);

            if (maquina.videojuegos.isEmpty()) {
                System.out.println("No hay videojuegos para eliminar.");
            } else {
                System.out.println("Seleccione el videojuego a eliminar:");
                for (int i = 0; i < maquina.videojuegos.size(); i++) {
                    System.out.println((i + 1) + ". " + maquina.videojuegos.get(i).nombre);
                }
                int juegoSeleccionado = scanner.nextInt();
                scanner.nextLine(); // Consumes the newline character

                if (juegoSeleccionado < 1 || juegoSeleccionado > maquina.videojuegos.size()) {
                    System.out.println("Selección no válida.");
                } else {
                    Videojuego juegoAEliminar = maquina.videojuegos.get(juegoSeleccionado - 1);
                    maquina.eliminarVideojuego(juegoAEliminar);
                    System.out.println("Videojuego eliminado con éxito.");
                }
            }
        }
    }

    /**
     * This method generates an invoice and exits the program.
     *
     * The invoice contains the user's details and the machines and games they purchased.
     *
     * @param scanner The scanner object to read user input.
     * @param manager The instance of MaquinaManager to retrieve machine information.
     */
    private static void generarFactura(Scanner scanner, MaquinaManager manager) {
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su dirección:");
        String direccion = scanner.nextLine();

        System.out.println("Factura generada:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Máquinas y videojuegos adquiridos:");

        for (Maquina maquina : manager.obtenerMaquinas()) {
            System.out.println(maquina.obtenerDescripcion());
            for (Videojuego juego : maquina.videojuegos) {
                System.out.println(" - Videojuego: " + juego.nombre + " (" + juego.categoria + "), Precio: " + juego.precio);
            }
            System.out.println("Precio total de la máquina: " + maquina.precioBase);
        }
        System.out.println("Gracias por su compra!");
    }
}
