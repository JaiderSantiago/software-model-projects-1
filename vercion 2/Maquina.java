/**
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrital.edu.co>
 * 
 * This file is part of Workshop 2.
 * 
 * Workshop 2 is free software: you can redistribute it and/or 
 * modify it under the terms of the GNU General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version.
 * 
 * Workshop 2 is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License 
 * along with Workshop 2. If not, see <https://www.gnu.org/licenses/>. 
*/
import java.util.ArrayList;
import java.util.List;

/**
* This abstract class represents the behavior and properties of a video game machine.
* All predefined machine types will extend this class.
*/
abstract class Maquina {
    protected String material;
    protected double dimensiones;
    protected double peso;
    protected double potencia;
    protected double consumo;
    protected double memoria;
    protected int procesadores;
    protected double precioBase;
    protected List<Videojuego> videojuegos;
    protected String color;

    /**
     * Constructor for creating a machine with specific attributes.
     *
     * @param material The material of the machine.
     * @param dimensiones The dimensions of the machine.
     * @param peso The weight of the machine.
     * @param potencia The power capacity of the machine.
     * @param consumo The energy consumption of the machine.
     * @param memoria The memory capacity of the machine.
     * @param procesadores The number of processors in the machine.
     * @param precioBase The base price of the machine.
     */
    public Maquina(String material, double dimensiones, double peso, double potencia, double consumo, double memoria, int procesadores, double precioBase) {
        this.material = material;
        this.dimensiones = dimensiones;
        this.peso = peso;
        this.potencia = potencia;
        this.consumo = consumo;
        this.memoria = memoria;
        this.procesadores = procesadores;
        this.precioBase = precioBase;
        this.videojuegos = new ArrayList<>();
    }

    /**
     * This method customizes the material of the machine and adjusts
     * its attributes based on the selected material.
     *
     * @param material The new material for the machine.
     */
    public void personalizarMaterial(String material) {
        this.material = material;
        switch(material.toLowerCase()) {
            case "madera":
                this.peso *= 1.10;
                this.precioBase *= 0.95;
                this.consumo *= 1.15;
                break;
            case "aluminio":
                this.peso *= 0.95;
                this.precioBase *= 1.10;
                break;
            case "fibra de carbono":
                this.peso *= 0.85;
                this.precioBase *= 1.20;
                this.consumo *= 0.90;
                break;
            default:
                System.out.println("Material no válido.");
                break;
        }
    }

    /**
     * This method adds a video game to the machine.
     *
     * It verifies if the video game category is valid for the machine
     * and increases the machine's price by the video game's price.
     *
     * @param juego The video game to be added.
     * @param altaDefinicion Whether the game is in high definition.
     */
    public void agregarVideojuego(Videojuego juego, boolean altaDefinicion) {
        if (categoriaValida(juego.categoria)) {
            if (altaDefinicion) {
                juego.precio *= 1.10; // Increase price by 10% for high definition
            }
            this.videojuegos.add(juego);
            this.precioBase += juego.precio;
        } else {
            System.out.println("El videojuego no pertenece a la categoría válida para esta máquina.");
        }
    }

    /**
     * This method removes a video game from the machine.
     *
     * It decreases the machine's price by the price of the removed game.
     *
     * @param juego The video game to be removed.
     */
    public void eliminarVideojuego(Videojuego juego) {
        this.videojuegos.remove(juego);
        this.precioBase -= juego.precio;
    }

    /**
     * Abstract method to verify if a video game's category is valid for the machine.
     *
     * @param categoria The category of the video game.
     * @return True if the category is valid, false otherwise.
     */
    public abstract boolean categoriaValida(String categoria);

    /**
     * This method displays the machine's details including its attributes and added games.
     */
    public void mostrarDetalles() {
        System.out.println("Descripción: " + obtenerDescripcion());
        System.out.println("Material: " + material);
        System.out.println("Dimensiones: " + dimensiones);
        System.out.println("Peso: " + peso);
        System.out.println("Color: " + color);
        System.out.println("Potencia: " + potencia);
        System.out.println("Consumo: " + consumo);
        System.out.println("Memoria: " + memoria);
        System.out.println("Procesadores: " + procesadores);
        System.out.println("Precio Base: " + precioBase);
        System.out.println("Videojuegos:");
        for (Videojuego juego : videojuegos) {
            System.out.println(" - " + juego.nombre + " (" + juego.categoria + ")");
        }
    }

    /**
     * Abstract method to get a description of the machine.
     * This will be implemented by each specific machine type.
     *
     * @return A string description of the machine.
     */
    public abstract String obtenerDescripcion();
}

