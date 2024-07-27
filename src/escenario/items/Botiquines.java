package escenario.items;

import static modelosCsv.Modelo.ModelosDatos.MEDICAMENTOS;
import static modelosCsv.Modelo.recuperarDatos;

public class Botiquines extends Item{
    float restauracionVida;
    float porcentajeAdiccion;

    public Botiquines() {
        String[] medicamentos = recuperarDatos(MEDICAMENTOS).split(";");
        this.valor = Float.parseFloat(medicamentos[0]);
        this.nombre = medicamentos[1];
        this.descripcion = medicamentos[2];
        this.restauracionVida =Float.parseFloat(medicamentos[3]);
        this.peso = Float.parseFloat(medicamentos[4]);
        this.porcentajeAdiccion = Float.parseFloat(medicamentos[5]);
    }

    public float getRestauracionVida() {
        return restauracionVida;
    }

    public void setRestauracionVida(float restauracionVida) {
        this.restauracionVida = restauracionVida;
    }

    public float getPorcentajeAdiccion() {
        return porcentajeAdiccion;
    }

    public void setPorcentajeAdiccion(float porcentajeAdiccion) {
        this.porcentajeAdiccion = porcentajeAdiccion;
    }

    @Override
    public String toString() {
        return "Botiquines{" +
                "restauracionVida=" + restauracionVida +
                ", porcentajeAdiccion=" + porcentajeAdiccion +
                ", valor=" + valor +
                ", peso=" + peso +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}


