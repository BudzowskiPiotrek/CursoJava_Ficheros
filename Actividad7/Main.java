package CursoJava_Ficheros.Actividad7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static File textoUno = new File("uno.txt");
    public static File textoDos = new File("dos.txt");
    public static File textoTres = new File("tres.txt");

    public static void main(String[] args) {
        inicialArchivo();
        rellenarArchivo("uno.txt", "1");
        rellenarArchivo("dos.txt", "2");
        crearArchivoConjunto();
    }
    

    // METODO PARA CREAR TERCER ARCHIVO Y MEZCLAR AMBOS ARCHIVOS
    private static void crearArchivoConjunto() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("uno.txt"));
            BufferedReader bufferedReaderDos = new BufferedReader(new FileReader("dos.txt"));
            FileWriter archivoTres = new FileWriter("tres.txt");

            String[] texto = new String[60];
            String linea;
            int i = 0;
            while ((linea = bufferedReader.readLine()) != null && i < 60) {
                texto[i] = linea;
                i += 2;
            }
            i = 1;
            while ((linea = bufferedReaderDos.readLine()) != null && i < 60) {
                texto[i] = linea;
                i += 2;
            }
            for (int j = 0; j < texto.length; j++) {
                archivoTres.write(texto[j] + "\n");
            }

            bufferedReader.close();
            bufferedReaderDos.close();
            archivoTres.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO PARA RELLENAR ARCHIVO DE 20 LINEAS DE NUMERO QUE PIDES AL ARCHIVO QUE
    // PIDES
    private static void rellenarArchivo(String nombre, String numero) {
        try {
            FileWriter archivo = new FileWriter(nombre);
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    archivo.write(numero); // EN CASO DE QUERRER INGRESAR EL NUMERO HAY QUE HACER VALUEOFSTRING
                }
                archivo.write("\n");
            }
            archivo.close();  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO PARA INICIALIZAR EL ARCHIVO
    private static void inicialArchivo() {
        try {

            if (textoUno.exists() && textoDos.exists() && textoTres.exists()) {
                System.out.println("Los archivos ya existen.");
            }
            if (!textoUno.exists()) {
                System.out.println("El archivo Uno no existe, se creará uno nuevo.");
                textoUno.createNewFile();
            }
            if (!textoDos.exists()) {
                System.out.println("El archivo Dos no existe, se creará uno nuevo.");
                textoDos.createNewFile();
            }
            if (!textoTres.exists()) {
                System.out.println("El archivo Uno no existe, se creará uno nuevo.");
                textoTres.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
