
class MaquinaConsola extends Maquina {
    public MaquinaConsola() {
        super();
    }

    @Override
    public void mostrarTipoMaquina() {
        System.out.println("Tipo de máquina: Consola");
    }

    @Override
    public String getNombreMaquina() {
        return "Consola";
    }
}
