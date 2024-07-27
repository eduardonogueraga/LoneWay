package hud;

import java.util.Scanner;

public class GameHud {

    public enum Decisiones{
        AVANZAR, INTERACTUAR, INVENTARIO, INVALIDO
    }

    Scanner teclado = new Scanner(System.in);

    public void mostrarHUD() {
        System.out.println("W  [AVANZAR] | F [INTERACTUAR] | E  [INVENTARIO]");
    }
    public Decisiones tomarDecision(){
        mostrarHUD();
        switch (teclado.nextLine().toUpperCase()){
            case "W":
                System.out.println("Prosigues el viaje...\n");
                return Decisiones.AVANZAR;
            case "F":
                System.out.println("Interactuar\n");
                return Decisiones.INTERACTUAR;
            case "E":
                System.out.println("Inventario\n");
                System.out.println("|NOMBRE|   |TIPO|   |PESO|   |DESC|     |VALOR|");
                return Decisiones.INVENTARIO;
            default:
                System.out.println("Acción no valida");
                return Decisiones.INVALIDO;

        }
    }
}
