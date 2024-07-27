package escenario;

import escenario.items.Item;
import escenario.items.Viveres;

import java.util.ArrayList;

import static modelosCsv.Modelo.ModelosDatos.MUNDOS;
import static modelosCsv.Modelo.recuperarDatos;
import static utiles.Utiles.formatearTextoConSaltosDeLinea;

public class Mundo {

    String descripcionMundo;
    float peligrosidadMundo;
    int valorItems; //Calidad de los item encontrados
    int abundanciaItem; //Num items posibles
    static int mundoAnterior; //TODO implementar que no se repitan mundos

    ArrayList<Item> itemsMundo = new ArrayList<>();

    public Mundo() {
        String[] caracteristicasMundo = recuperarDatos(MUNDOS).split(";");
        this.peligrosidadMundo = Float.parseFloat(caracteristicasMundo[0]);
        this.descripcionMundo = caracteristicasMundo[1].replace('"', ' ').trim(); //quito los "
        this.abundanciaItem = Integer.parseInt(caracteristicasMundo[2]);
        this.valorItems = Integer.parseInt(caracteristicasMundo[3]);

        generarItemsMundo();
    }

    public String getDescripcionMundo() {
        return descripcionMundo;
    }

    public void setDescripcionMundo(String descripcionMundo) {
        this.descripcionMundo = descripcionMundo;
    }

    public float getPeligrosidadMundo() {
        return peligrosidadMundo;
    }

    public void setPeligrosidadMundo(float peligrosidadMundo) {
        this.peligrosidadMundo = peligrosidadMundo;
    }

    public int getValorItems() {
        return valorItems;
    }

    public void setValorItems(int valorItems) {
        this.valorItems = valorItems;
    }

    public int getAbundanciaItem() {
        return abundanciaItem;
    }

    public void setAbundanciaItem(int abundanciaItem) {
        this.abundanciaItem = abundanciaItem;
    }

    public static int getMundoAnterior() {
        return mundoAnterior;
    }

    public static void setMundoAnterior(int mundoAnterior) {
        Mundo.mundoAnterior = mundoAnterior;
    }

    public void generarItemsMundo(){
        for (int i=0; i<this.getAbundanciaItem(); i++){
            Viveres comida = new Viveres();
            itemsMundo.add(comida);
        }
    }

    @Override
    public String toString() {
        char primeraLetra = getDescripcionMundo().toLowerCase().charAt(0);
        return "Llegas a "
                + formatearTextoConSaltosDeLinea(primeraLetra + descripcionMundo.substring(1), 20)
                + "\n";
    }

}
