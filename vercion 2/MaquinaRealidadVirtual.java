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
 * This class represents the behavior and properties of a virtual reality machine.
 */
public class MaquinaRealidadVirtual extends Maquina {
    private String tipoDeGafas;
    private String resolucionGafas;
    private double precioGafas;

    /**
     * Constructor to initialize a pre-configured Virtual Reality machine with default attributes.
     */
    public MaquinaRealidadVirtual() {
        super("Fibra de carbono", 250.0, 400.0, 200.0, 700.0, 32.0, 8, 3000.0);
        this.tipoDeGafas = "Gafas VR Pro";
        this.resolucionGafas = "4K";
        this.precioGafas = 500.0;
    }

    /**
     * This method returns a description of the virtual reality machine.
     *
     * @return A string describing the virtual reality machine.
     */
    @Override
    public String obtenerDescripcion() {
        return "Máquina de Realidad Virtual con gafas " + tipoDeGafas + 
               " y resolución " + resolucionGafas;
    }

    /**
     * This method checks if the category of a video game is valid for this machine.
     *
     * The valid categories for this machine are "realidad virtual" and "inmersivo".
     *
     * @param categoria The category of the video game.
     * @return True if the category is valid, false otherwise.
     */
    @Override
    public boolean categoriaValida(String categoria) {
        return categoria.equalsIgnoreCase("realidad virtual") || categoria.equalsIgnoreCase("inmersivo");
    }
}
