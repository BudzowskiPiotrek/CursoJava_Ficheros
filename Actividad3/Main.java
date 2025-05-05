package CursoJava_Ficheros.Actividad3;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        String userHome = System.getProperty("user.home");
        String rutaEscritorio = userHome + "/Desktop/";

        System.out.println("Dime el nombre de la carpeta donde esta el archivo: ");
        String nombreCarpeta = sn.nextLine();
        System.out.println("Dime el nombre de archivo: ");
        String nombreFichero = sn.nextLine();

        File archivo = new File(rutaEscritorio + nombreCarpeta + "/" + nombreFichero + ".txt");
        boolean eliminado = archivo.delete();

        if (eliminado) {
            System.out.println("Exito");
        } else {
            System.out.println("no exito");
        }

        System.out.println("Quieres borrar tambien su carpeta\nSi");
        // HAHAHAHAH
        String respuesta = "Si";
        if (respuesta.equals("Si")) {
            File carpeta = new File(rutaEscritorio + nombreCarpeta);
            boolean eliminado2 = carpeta.delete();

            if (eliminado2) {
                System.out.println("Exito");
            } else {
                System.out.println("no exito");
            }
        }
        sn.close(); // sino no esta verde!
    }

}
