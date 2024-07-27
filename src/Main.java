import escenario.Mundo;
import hud.GameHud;

public class Main {
    public static void main(String[] args) {

        System.out.println("Lone Way a computer game by isrev\n");
        GameHud gameHud = new GameHud();
        Mundo mundo = new Mundo();
        mundo.setDescripcionMundo("Te encuentras en medio de un claro, paras para descansar antes de reanudar el viaje");
        System.out.println(mundo);

        while(true){
            switch (gameHud.tomarDecision()){
                case AVANZAR:
                    mundo = new Mundo();
                    System.out.println(mundo);
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