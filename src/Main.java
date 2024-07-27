import hud.GameHud;
import partida.Partida;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lone Way a computer game by isrev\n");

        Partida partida = new Partida();
        partida.nuevoJuego();

        GameHud gameHud = new GameHud();

        while(partida.getEstadoPartida()){
            switch (gameHud.tomarDecision()){
                case AVANZAR:
                   partida.avanzarPartida();
                 break;
                case INTERACTUAR:
                    System.out.println("No hay interacción");
                    break;
                case INVENTARIO:
                    System.out.println("No");
                    break;
                default:
                    System.out.println("Accion no permitida");
                    break;
            }

        }
    }
}