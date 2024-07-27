package partida;

import escenario.Mundo;
import escenario.items.Item;

public class Partida {

    boolean estadoPartida;

    public Partida() {
        this.estadoPartida = true;
    }

    public boolean getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(boolean estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    public void nuevoJuego(){
        System.out.println("Te encuentras en medio de un claro, paras para descansar antes de reanudar el viaje");
        //Mundo inicial con items concretos TODO
    }

    public void avanzarPartida(){

        //Cargar nuevo mundo
        Mundo mundo = new Mundo();
        System.out.println(mundo);

        //Listar items
        if(!mundo.getItemsMundo().isEmpty()){
            System.out.println("Encuentras los siguentes bienes:");
            for (int i = 0; i < mundo.getItemsMundo().size(); i++) {
                Item item = mundo.getItemsMundo().get(i);
                System.out.println("\t-"+item.getNombre());
            }
        }else {
            System.out.println("No encuentras nada");
        }
    }

}
