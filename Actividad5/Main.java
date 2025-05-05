package CursoJava_Ficheros.Actividad5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static File archivo = new File("ejemplo.dat");

    public static void main(String[] args) {
        iniciarArchivo();
        boolean flag = true;
        while (flag) {
            menu();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO QUE COMPRUEBA SI ARCHIVO EXISTE, SINO LO CREA
    private static void iniciarArchivo() {
        if (archivo.exists()) {
            System.out.println("El archivo ya existe, vamos a agregar más personas.");
        } else {
            System.out.println("El archivo no existe, se creará uno nuevo.");
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // MENU PRINCIPAL CON EL TEXTO
    private static void menu() {
        System.out.println("--- Bienvenido en el Menu ---");
        System.out.println("Pulsa 1 : Cargar datos");
        System.out.println("Pulsa 2 : Leer datos");
        System.out.println("Pulsa 3 : Mostrar a solo mayores de edad");
        System.out.println("Pulsa 4 : Numero de personas registrados");
        System.out.println("Pulsa 5 : Modificar datos");
        int opcion;
        try {
            opcion = Integer.parseInt(br.readLine());
            menuSwitch(opcion);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO DE SWITCH PARA ELEGIR ENTRE TODOS METODOS
    private static void menuSwitch(int opcion) {
        switch (opcion) {
            case 1:
                try {
                    cargarDatos();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                leerDatos();
                break;
            case 3:
                imprimirMayores();
                break;
            case 4:
                contador();
                break;
            case 5:
                modificador();
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
    }

    // METODO PARA INTRODUCIR LOS DATOS
    private static void cargarDatos() throws IOException {
        FileWriter miArchivo = new FileWriter("ejemplo.dat", true);

        System.out.print("Dime tu DNI: ");
        String dni = br.readLine();
        System.out.print("Dime tu nombre: ");
        String nombre = br.readLine();
        System.out.print("Dime tu apellido: ");
        String apellido = br.readLine();
        System.out.print("Dime tu edad: ");
        String edad = br.readLine();
        if (!edad.matches("\\d+")) {
            System.out.println("Edad solo digitos");
            return;
        }

        miArchivo.write(dni + " " + nombre + " " + apellido + " " + edad + "\n");
        miArchivo.close();
        System.out.println("Los datos han sido guardados en el archivo.");
    }

    // METODO PARA LEER DATOS
    private static void leerDatos() {
        try {
            FileReader fileReader = new FileReader("ejemplo.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;
            System.out.println("Contenido del archivo:");

            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    // METODO PARA LER DATOS SOLO MAYORES DE EDAD
    private static void imprimirMayores() {
        FileReader fileReader;
        try {
            fileReader = new FileReader("ejemplo.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea = null;
            System.out.println("Contenido del archivo:");

            try {
                while ((linea = bufferedReader.readLine()) != null) {
                    String[] prueba = linea.split(" ");
                    if (prueba.length == 4 && Integer.parseInt(prueba[3]) >= 18) {
                        System.out.println(linea);
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // METODO PARA OBTENER CONTADOR
    private static void contador() {
        int contador = 0;
        try {
            FileReader fileReader = new FileReader("ejemplo.dat");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                contador++;
            }
            System.out.println("Numero de registros: " + contador);
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    /* SUGERENCIA DE CHATGTP OTRA FORMA DE HACERLO
     * private static void contador() {
     * int contador = 0;
     * try (BufferedReader bufferedReader = new BufferedReader(new
     * FileReader(archivo))) {
     * while (bufferedReader.readLine() != null) {
     * contador++;
     * }
     * System.out.println("Número de registros: " + contador);
     * } catch (IOException e) {
     * System.out.println("Error al contar registros.");
     * }
     * }
     */

    // METODO PARA MODIFICAR
    private static void modificador() {
        try {
            System.out.print("Introduce el DNI: ");
            String dniBuscado = br.readLine();

            BufferedReader lector = new BufferedReader(new FileReader(archivo));
            StringBuilder nuevoContenido = new StringBuilder();
            boolean encontrado = false;

            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datos = linea.split(" ");
                if (datos.length == 4 && datos[0].equalsIgnoreCase(dniBuscado)) {
                    System.out.println("Registro encontrado: " + linea);

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = br.readLine();
                    System.out.print("Nuevo apellido: ");
                    String nuevoApellido = br.readLine();
                    System.out.print("Nueva edad: ");
                    String nuevaEdad = br.readLine();

                    if (!nuevaEdad.matches("\\d+")) {
                        System.out.println("Edad solo digitos.");
                        lector.close();
                        return;
                    }

                    nuevoContenido.append(dniBuscado).append(" ")
                            .append(nuevoNombre).append(" ")
                            .append(nuevoApellido).append(" ")
                            .append(nuevaEdad).append("\n");
                    encontrado = true;
                } else {
                    nuevoContenido.append(linea).append("\n");
                }
            }
            lector.close();

            if (encontrado) {
                FileWriter escritor = new FileWriter(archivo);
                escritor.write(nuevoContenido.toString());
                escritor.close();
                System.out.println("Datos modificados correctamente.");
            } else {
                System.out.println("DNI no encontrado.");
            }

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
