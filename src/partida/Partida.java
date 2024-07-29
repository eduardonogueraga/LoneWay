package partida;

import escenario.Mundo;
import escenario.items.Item;
import hud.GameHud;

import static partida.Partida.EstadosPartida.*;

/*
* TODO
* Kilometros entre ciudades
* Mas comida = mas Km a recorrer
* En funcion de la peligrosidad del emplazamiento interesara o no
*
* La capacidad de hacer KM depende del porcentaje de hidratacion y comida + la resistencia del personaje
*
* */

public class Partida {

    public enum EstadosPartida{
        INICIO_PARTIDA, ENTRANDO_CIUDAD, VIAJANDO, SALIENDO_CIUDAD, FINAL_PARTIDA
    }
    boolean estadoPartida;
    Mundo mundoActual;
    EstadosPartida estadoActual = INICIO_PARTIDA;
    GameHud gameHud = new GameHud();

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
        System.out.println("Prosigues el viaje...\n");
        //Cargar nuevo mundo
        mundoActual = new Mundo();
        System.out.println(mundoActual);
        System.out.println("¿Te adrentras en este lugar?");
    }

    public void adentrarseEnMundo(){
        System.out.println("Te adrentras en el lugar...\n");

        //Listar items
        if(!mundoActual.getItemsMundo().isEmpty()){
            System.out.println("Encuentras los siguentes bienes:");
            for (int i = 0; i < mundoActual.getItemsMundo().size(); i++) {
                Item item = mundoActual.getItemsMundo().get(i);
                System.out.println("\t-"+item.getNombre());
            }
        }else {
            System.out.println("No encuentras nada");
        }
    }

    public void situacionPartida(){
        //Maquina de estado para decisiones
        switch (estadoActual){
            case INICIO_PARTIDA:
                gameHud.mostrarHUD(INICIO_PARTIDA);
                switch (gameHud.tomarDecision()){
                    case AVANZAR:
                        estadoActual = ENTRANDO_CIUDAD;
                        this.avanzarPartida();
                        break;
                    case INVENTARIO:
                        System.out.println("No hay inventario");
                        break;
                    default:
                        System.out.println("Accion no permitida");
                        break;
                }
                break;
            case ENTRANDO_CIUDAD:
                gameHud.mostrarHUD(EstadosPartida.ENTRANDO_CIUDAD);
                switch (gameHud.tomarDecision()){
                    case AVANZAR:
                        this.avanzarPartida();
                        break;
                    case ADENTRARSE:
                        estadoActual = SALIENDO_CIUDAD;
                        this.adentrarseEnMundo();
                        break;
                    case INVENTARIO:
                        System.out.println("No hay inventario");
                        break;
                    default:
                        System.out.println("Accion no permitida");
                        break;
                }
                break;
            case SALIENDO_CIUDAD:
                gameHud.mostrarHUD(EstadosPartida.SALIENDO_CIUDAD);
                switch (gameHud.tomarDecision()){
                    case AVANZAR:
                        estadoActual = ENTRANDO_CIUDAD;
                        this.avanzarPartida();
                        break;
                    case INTERACTUAR:
                        System.out.println("No hay interacción");
                        break;
                    case INVENTARIO:
                        System.out.println("No hay inventario");
                        break;
                    default:
                        System.out.println("Accion no permitida");
                        break;
                }
                break;
            case FINAL_PARTIDA:
                gameHud.mostrarHUD(EstadosPartida.FINAL_PARTIDA);
                switch (gameHud.tomarDecision()){
                    case AVANZAR:
                        this.avanzarPartida();
                        break;
                    default:
                        System.out.println("Accion no permitida");
                        break;
                }
                break;
        }

    }

}
