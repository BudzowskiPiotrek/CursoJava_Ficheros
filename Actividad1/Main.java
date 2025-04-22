package CursoJava_Ficheros.Actividad1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Dime el nombre de archivo: ");
        String nombreFichero = sn.nextLine();
        System.out.println("Dime el nombre de la carpeta: ");
        String nombreCarpeta = sn.nextLine();
        String userHome = System.getProperty("user.home");
        String rutaEscritorio = userHome + "/Desktop/";

        File dir1 = new File(rutaEscritorio + nombreCarpeta);
        if (dir1.mkdir()) {
            System.out.println(nombreCarpeta + " creado con éxito.");
        } else {
            System.out.println("No se pudo crear " + nombreCarpeta);
        }

        File file = new File(rutaEscritorio + nombreCarpeta + "/" + nombreFichero + ".txt");
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
        sn.close(); // sino no esta verde!
    }
}
