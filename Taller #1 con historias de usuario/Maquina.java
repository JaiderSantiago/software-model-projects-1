

import java.util.ArrayList;

abstract class Maquina {
    private String material;
    private ArrayList<Juego> juegosDisponibles;
    private ArrayList<Juego> juegosAgregados;

    public Maquina() {
        this.juegosDisponibles = new ArrayList<>();
        this.juegosAgregados = new ArrayList<>();
        juegosDisponibles.add(new Juego("Pac-Man", 1));
        juegosDisponibles.add(new Juego("Space Invaders", 2));
        juegosDisponibles.add(new Juego("Street Fighter", 3));
        juegosDisponibles.add(new Juego("Mortal Kombat", 4));
    }

    public void seleccionarMaterial(String material) {
        this.material = material;
        System.out.println("Material seleccionado: " + material);
    }

    public void mostrarJuegosDisponibles() {
        System.out.println("Juegos disponibles para agregar:");
        for (Juego juego : juegosDisponibles) {
            System.out.println(juego.getCodigo() + ": " + juego.getNombre());
        }
    }

    public void agregarJuegoPorCodigo(int codigo) {
        Juego juegoSeleccionado = null;
        for (Juego juego : juegosDisponibles) {
            if (juego.getCodigo() == codigo) {
                juegoSeleccionado = juego;
                break;
            }
        }
        
        if (juegoSeleccionado != null && !juegosAgregados.contains(juegoSeleccionado)) {
            juegosAgregados.add(juegoSeleccionado);
            System.out.println("Juego agregado: " + juegoSeleccionado.getNombre());
        } else {
            System.out.println("El juego ya fue agregado o el código es inválido.");
        }
    }

    public ArrayList<Juego> getJuegosAgregados() {
        return juegosAgregados;
    }

    public abstract void mostrarTipoMaquina();

    // Método abstracto para obtener el nombre de la máquina
    public abstract String getNombreMaquina();
}

