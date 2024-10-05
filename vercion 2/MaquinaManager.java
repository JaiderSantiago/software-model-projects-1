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

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a Singleton responsible for managing the arcade machines.
 *
 * It ensures that only one instance of the manager exists and handles the
 * registration and retrieval of machines.
 */
public class MaquinaManager {
    private static MaquinaManager instance;
    private List<Maquina> maquinasRegistradas;

    /**
     * Private constructor to prevent instantiation of this class from outside.
     * Initializes the list of registered machines.
     */
    private MaquinaManager() {
        maquinasRegistradas = new ArrayList<>();
    }

    /**
     * This method returns the single instance of MaquinaManager (Singleton).
     * 
     * If the instance doesn't exist yet, it creates it.
     *
     * @return The single instance of MaquinaManager.
     */
    public static MaquinaManager getInstance() {
        if (instance == null) {
            instance = new MaquinaManager();
        }
        return instance;
    }

    /**
     * This method registers a new machine into the system.
     *
     * @param maquina The machine to be registered.
     */
    public void registrarMaquina(Maquina maquina) {
        maquinasRegistradas.add(maquina);
    }

    /**
     * This method returns the list of all registered machines.
     *
     * @return A list of registered machines.
     */
    public List<Maquina> obtenerMaquinas() {
        return maquinasRegistradas;
    }

    /**
     * This method displays details of all registered machines.
     */
    public void mostrarMaquinas() {
        if (maquinasRegistradas.isEmpty()) {
            System.out.println("No hay máquinas registradas.");
        } else {
            for (int i = 0; i < maquinasRegistradas.size(); i++) {
                System.out.println("Máquina #" + (i + 1));
                maquinasRegistradas.get(i).mostrarDetalles();
            }
        }
    }
}
