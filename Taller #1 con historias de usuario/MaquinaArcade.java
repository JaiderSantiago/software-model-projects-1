
class MaquinaArcade extends Maquina {
    public MaquinaArcade() {
        super();
    }

    @Override
    public void mostrarTipoMaquina() {
        System.out.println("Tipo de máquina: Arcade");
    }

    @Override
    public String getNombreMaquina() {
        return "Arcade";
    }
}
