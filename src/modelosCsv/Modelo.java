package modelosCsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/*
* Clase encargada del tratamiento de los modelos de datos en ficheros CSV
*
* */

public class Modelo {
    public enum ModelosDatos{
        MUNDOS, VIVERES, ARMAS, ENEMIGOS
    }

    public static String recuperarDatos(ModelosDatos modelo){

        String linea = "";
        String nombreModelo = switch (modelo) {
            case MUNDOS -> "mundos";
            case VIVERES -> "viveres";
            case ARMAS -> "armas";
            default -> "";
        };

        String archivoCSV = "C:/Users/isrev/IdeaProjects/LoneWay/src/modelosCsv/"+nombreModelo+".csv";
        File archivo = new File(archivoCSV);

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            Random random = new Random();
            int numLineas = contarLineas(archivo);
            int lineaAleatoria = random.nextInt(numLineas);

            int lineaActual = 0;
            while ((linea = br.readLine()) != null) {
                if (lineaActual == lineaAleatoria) {
                    return linea;
                }
                lineaActual++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return linea;
    }

    public static int contarLineas(File archivo) {
        int numLineas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            while (br.readLine() != null) {
                numLineas++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numLineas;
    }


}
