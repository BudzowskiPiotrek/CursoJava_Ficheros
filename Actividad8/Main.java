package CursoJava_Ficheros.Actividad8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("CursoJava_Ficheros/Actividad8/Estudiante.java"))) {
            String linea;
            StringBuilder documentoNuevo = new StringBuilder();
            while ((linea = bufferedReader.readLine()) != null) {
                // SI LA LINEA NO TIENE "//" LA COPIA IGUAL
                if (!linea.contains("//")) {
                    documentoNuevo.append(linea + "\n");
                    // SI LA TENDRIA LA LOCALIZO Y LA COPIO HASTA EL "//"
                } else {
                    documentoNuevo.append(linea.substring(0, linea.indexOf("//"))+"\n");
                }
            }
            System.out.println(documentoNuevo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
