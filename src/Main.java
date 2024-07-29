import hud.GameHud;
import partida.Partida;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lone Way a computer game by isrev\n");
        Partida partida = new Partida();
        partida.nuevoJuego();

        while(partida.getEstadoPartida()){
            partida.situacionPartida();
        }
    }
}