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
 * This class represents a video game with various attributes such as
 * name, creators, category, price, and release year.
 */
public class Videojuego {
    public String nombre;
    public String storytellingCreator;
    public String graphicsCreator;
    public String categoria;
    public double precio;
    public int anio;

    /**
     * Constructor to initialize a video game with specific attributes.
     *
     * @param nombre The name of the video game.
     * @param storytellingCreator The creator of the story in the game.
     * @param graphicsCreator The creator of the graphics in the game.
     * @param categoria The category of the video game.
     * @param precio The price of the video game.
     * @param anio The release year of the video game.
     */
    public Videojuego(String nombre, String storytellingCreator, String graphicsCreator, String categoria, double precio, int anio) {
        this.nombre = nombre;
        this.storytellingCreator = storytellingCreator;
        this.graphicsCreator = graphicsCreator;
        this.categoria = categoria;
        this.precio = precio;
        this.anio = anio;
    }
}
