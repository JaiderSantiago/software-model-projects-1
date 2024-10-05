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
 * This class represents the behavior and properties of a Dance Revolution machine.
 */
public class MaquinaDanceRevolution extends Maquina {
    private int dificultades;
    private int cardinalidadesFlecha;
    private double controlPrecio;

    /**
     * Constructor to initialize a pre-configured Dance Revolution machine with default attributes.
     */
    public MaquinaDanceRevolution() {
        super("Fibra de carbono", 200.0, 300.0, 150.0, 500.0, 16.0, 4, 2000.0);
        this.dificultades = 5;
        this.cardinalidadesFlecha = 8;
        this.controlPrecio = 50.0;
    }

    /**
     * This method returns a description of the Dance Revolution machine.
     *
     * @return A string describing the Dance Revolution machine.
     */
    @Override
    public String obtenerDescripcion() {
        return "Maquina Dance Revolution con dificultades: " + dificultades +
               ", cardinalidades de flecha: " + cardinalidadesFlecha + 
               ", precio del control: " + controlPrecio;
    }

    /**
     * This method checks if the category of a video game is valid for this machine.
     *
     * The valid categories for this machine are "baile" and "ritmo".
     *
     * @param categoria The category of the video game.
     * @return True if the category is valid, false otherwise.
     */
    @Override
    public boolean categoriaValida(String categoria) {
        return categoria.equalsIgnoreCase("baile") || categoria.equalsIgnoreCase("ritmo");
    }
}
