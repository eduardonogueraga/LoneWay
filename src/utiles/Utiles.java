package utiles;

public class Utiles {

    public static String formatearTextoConSaltosDeLinea(String texto, int palabrasPorLinea) {
        String[] palabras = texto.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < palabras.length; i++) {
            sb.append(palabras[i]).append(" ");

            // Agregar un salto de línea cada `palabrasPorLinea` palabras
            if ((i + 1) % palabrasPorLinea == 0) {
                sb.append("\n");
            }
        }
        // Convertir el StringBuilder a String y eliminar cualquier espacio en blanco al final
        return sb.toString().trim();
    }

}
