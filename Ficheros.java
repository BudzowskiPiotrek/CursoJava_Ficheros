package CursoJava_Ficheros;

import java.io.File;

public class Ficheros {
    public static void main(String[] args) {
        // Ejemplo de mkdir(): crea solo si el directorio padre ya existe
        File dir1 = new File("directorioSimple");
        if (dir1.mkdir()) {
            System.out.println("directorioSimple creado con éxito.");
        } else {
            System.out.println("No se pudo crear directorioSimple.");
        }

        // Ejemplo de mkdir(): fallará si los directorios intermedios no existen
        File dir2 = new File("padre/hijo");
        if (dir2.mkdir()) {
            System.out.println("padre/hijo creado con éxito con mkdir().");
        } else {
            System.out.println("mkdir() falló al crear padre/hijo (faltan directorios intermedios).");
        }

        // Ejemplo de mkdirs(): crea todos los directorios intermedios necesarios
        File dir3 = new File("padre/hijo/nieto");
        if (dir3.mkdirs()) {
            System.out.println("padre/hijo/nieto creado con éxito con mkdirs().");
        } else {
            System.out.println("No se pudo crear padre/hijo/nieto con mkdirs().");
        }
    }

}
