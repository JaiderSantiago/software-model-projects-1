/**
 * This file has class definition of a class for a simple machine store.
 * 
 * Author: Jaider Santiago Avila Robles <jsquimbaya@udistrital.edu.co>
 * 
 * This file is part of Taller #2.
 * 
 * Taller #2 is free software: you can redistribute it and/or 
 * modify it under the terms of the GNU General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version.
 * 
 * Taller #2 is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License 
 * along with Taller #2. If not, see <https://www.gnu.org/licenses/>. 
*/
/**
 * This class represents the behavior and properties of a racing machine.
 */
public class MaquinaCarreras extends Maquina {

    /**
     * Constructor to initialize a pre-configured Racing machine with default attributes.
     */
    public MaquinaCarreras() {
        super("Aluminio", 220.0, 350.0, 180.0, 600.0, 16.0, 6, 2200.0);
    }

    /**
     * This method returns a description of the racing machine.
     *
     * @return A string describing the racing machine.
     */
    @Override
    public String obtenerDescripcion() {
        return "Máquina de Carreras con capacidad para simulación de carreras de alta velocidad.";
    }

    /**
     * This method checks if the category of a video game is valid for this machine.
     *
     * The valid categories for this machine are "carreras" and "deportes".
     *
     * @param categoria The category of the video game.
     * @return True if the category is valid, false otherwise.
     */
    @Override
    public boolean categoriaValida(String categoria) {
        return categoria.equalsIgnoreCase("carreras") || categoria.equalsIgnoreCase("deportes");
    }
}
