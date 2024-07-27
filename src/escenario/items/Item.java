package escenario.items;

public class Item {
  float valor;
  float peso;
  String nombre;
  String descripcion;

    public Item() {}

    public Item(float valor, String descripcion, String nombre, float peso) {
        this.valor = valor;
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.peso = peso;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
