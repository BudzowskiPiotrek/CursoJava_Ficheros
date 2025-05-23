package CursoJava_Ficheros;

import java.io.File;
import java.io.IOException;

public class Arvhivos {
    public static void main(String[] args) {
        // localizamos la ruta de nuestro directorio principal
        String userHome = System.getProperty("user.home");
        // le añadimos /Desktop para obtener la ruta del escritorio
        String rutaEscritorio = userHome + "/Desktop/";
        // Crear un fichero en el escritorio y le indicamos la ruta más el nombre de
        // nuestro archivo
        File file = new File(rutaEscritorio + "nuevo_fichero.txt");

        // insertamos en el sistema de archivos
        try {
            if (file.createNewFile()) {
                System.out.println("Fichero creado exitosamente");
            } else {
                System.out.println("El fichero ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }
    }

}
