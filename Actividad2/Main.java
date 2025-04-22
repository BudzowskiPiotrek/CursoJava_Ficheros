package CursoJava_Ficheros.Actividad2;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String userHome = System.getProperty("user.home");
        String rutaEscritorio = userHome + "/Desktop/";

        System.out.println("Dime el nombre de archivo: ");
        String nombreFicheroActual = sn.nextLine();
        System.out.println("Dime el nombre de la carpeta: ");
        String nombreCarpetaActual = sn.nextLine();

        System.out.println("Dime el nuevo nombre de archivo: ");
        String nombreFicheroNuevo = sn.nextLine();

        File archivo = new File(rutaEscritorio + nombreCarpetaActual + "/" + nombreFicheroActual + ".txt");
        File nuevoArchivo = new File(rutaEscritorio + nombreCarpetaActual + "/" + nombreFicheroNuevo + ".txt");
        boolean renombrado = archivo.renameTo(nuevoArchivo);
        if (renombrado) {
            System.out.println("Exito");
        } else {
            System.out.println("no exito");
        }
        System.out.println("Dime el nuevonombre de la carpeta: ");
        String nombreCarpetaNuevo = sn.nextLine();

        File carpeta = new File(rutaEscritorio + nombreCarpetaActual);
        File nuevaCarpeta = new File(rutaEscritorio + nombreCarpetaNuevo);
        boolean renombrado2 = carpeta.renameTo(nuevaCarpeta);
        if (renombrado2) {
            System.out.println("Exito");
        } else {
            System.out.println("no exito");
        }
        sn.close(); // sino no esta verde!

    }
}
