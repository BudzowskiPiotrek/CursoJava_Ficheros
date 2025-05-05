package CursoJava_Ficheros.Actividad4;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Creador múltiple de carpetas\n");

            System.out.println("Dime el nombre de la carpeta padre a crear: ");
            String padreName = sc.next();

            System.out.println("Dime el nombre de la carpeta hija: ");
            String hijoName = sc.next();

            File hijo = new File(padreName + "/" + hijoName);

            if (hijo.mkdirs()) {
                System.out.println("Carpetas creadas exitosamente");
            } else {
                System.out.println("No se han podido crear las carpetas");
            }
            sc.close();
        }
    }
}