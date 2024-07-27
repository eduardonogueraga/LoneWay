package escenario.items;

import static modelosCsv.Modelo.ModelosDatos.VIVERES;
import static modelosCsv.Modelo.recuperarDatos;

public class Viveres extends Item {

    float restauracionHambre;
    float restauracionHidratacion;

    public Viveres() {
        String[] viveres = recuperarDatos(VIVERES).split(";");
        this.valor = Float.parseFloat(viveres[0]);
        this.nombre = viveres[1];
        this.descripcion = viveres[2];
        this.restauracionHambre = Float.parseFloat(viveres[3]);
        this.restauracionHidratacion = Float.parseFloat(viveres[4]);
        this.peso = Float.parseFloat(viveres[5]);
    }

    public float getrestauracionHambre() {
        return restauracionHambre;
    }

    public void setrestauracionHambre(float restauracionHambre) {
        this.restauracionHambre = restauracionHambre;
    }

    public float getRestauracionHidratacion() {
        return restauracionHidratacion;
    }

    public void setRestauracionHidratacion(float restauracionHidratacion) {
        this.restauracionHidratacion = restauracionHidratacion;
    }

    @Override
    public String toString() {
        return "Viveres{" +
                "restauracionHambre=" + restauracionHambre +
                ", restauracionHidratacion=" + restauracionHidratacion +
                ", valor=" + valor +
                ", peso=" + peso +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
