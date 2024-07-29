package hud;

import partida.Partida;
import java.util.Scanner;

public class GameHud {

    public enum Decisiones{
        AVANZAR, ADENTRARSE, INTERACTUAR, INVENTARIO, INVALIDO
    }

    Scanner teclado = new Scanner(System.in);

    public void mostrarHUD(Partida.EstadosPartida estado) {
        switch (estado){
            case INICIO_PARTIDA:
                System.out.println("W  [AVANZAR] | E  [INVENTARIO]");
                break;
            case ENTRANDO_CIUDAD:
                System.out.println("W  [EVITAR] | Q  [ADENTRARSE] | E  [INVENTARIO]");
                break;
            case SALIENDO_CIUDAD:
                System.out.println("W  [AVANZAR] | F [INTERACTUAR] | E  [INVENTARIO]");
                break;
            case FINAL_PARTIDA:
                System.out.println("W  [SALIR] ");
                break;
        }
    }
    public Decisiones tomarDecision(){
        switch (teclado.nextLine().toUpperCase()){
            case "W":
                return Decisiones.AVANZAR;
            case "Q":
                return Decisiones.ADENTRARSE;
            case "F":
                return Decisiones.INTERACTUAR;
            case "E":
                return Decisiones.INVENTARIO;
            default:
                return Decisiones.INVALIDO;

        }
    }
}
