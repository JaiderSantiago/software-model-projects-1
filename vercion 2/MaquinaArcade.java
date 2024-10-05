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

public class MaquinaArcade extends Maquina {

    /**
     * Constructor to initialize a pre-configured Arcade machine with default attributes.
     */
    public MaquinaArcade() {
        super("Aluminio", 150.0, 250.0, 100.0, 400.0, 8.0, 2, 1500.0);
    }

    /**
     * This method returns a description of the arcade machine.
     *
     * @return A string describing the arcade machine.
     */
    @Override
    public String obtenerDescripcion() {
        return "Maquina Arcade Clásico con funciones de vibración y grabación de sonido.";
    }

    /**
     * This method triggers the vibration function of the arcade machine.
     */
    public void hacerVibracion() {
        System.out.println("Haciendo vibración...");
    }

    /**
     * This method triggers a sound recording alert.
     */
    public void alertaDeGrabacionDeSonido() {
        System.out.println("Alerta: Grabación de sonido activada...");
    }

    /**
     * This method checks if the category of a video game is valid for this machine.
     *
     * The valid categories for this machine are "clásico" and "retro".
     *
     * @param categoria The category of the video game.
     * @return True if the category is valid, false otherwise.
     */
    @Override
    public boolean categoriaValida(String categoria) {
        return categoria.equalsIgnoreCase("clásico") || categoria.equalsIgnoreCase("retro");
    }
}
