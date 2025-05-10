package CursoJava_Ficheros.Actividad6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        crearArchivo();
        meterDatos();
        leerDatos();
    }

    // METODO QUE CREA EL ARCHIVO Y LO COMPRUEBA
    private static void crearArchivo() {
        File archivoPrimos = new File("primos.dat");
        if (archivoPrimos.exists()) {
            System.out.println("El archivo ya existe");
        } else {
            System.out.println("El archivo no existe, se creará uno nuevo.");
            try {
                archivoPrimos.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // METODO QUE INGRESA LOS DATOS AL ARCHIVO
    private static void meterDatos() {
        try {
            FileWriter miArchivo = new FileWriter("primos.dat");
            for (int i = 2; i <= 500; i++) {
                boolean esPrimo = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        esPrimo = false;
                    }
                }
                if (esPrimo) {
                    miArchivo.write(i + " ");
                }
            }
            miArchivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerDatos() {
        try {
            FileReader fileReader = new FileReader("primos.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;
            System.out.println("Contenido del archivo:");

            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
