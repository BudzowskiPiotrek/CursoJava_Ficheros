package CursoJava_Ficheros.Actividad8;

public class Estudiante {
    String nombre;
    String apellido;
    int edad;
    
    // EL CONSTRUCTOR.
    public Estudiante(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    // SETER DE NOMBRE.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // SETER DE APELLIDO.
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //SETES DE EDAD.
    public void setEdad(int edad) {
        this.edad = edad;
    }

    //GETER DE NOMBRE.
    public String getNombre() {
        return nombre;
    }

    //GETES DE APELLIDO.
    public String getApellido() {
        return apellido;
    }

    // GETER DE EDADA.
    public int getEdad() {
        return edad;
    }

    //METODO TO STRING.
    @Override
    public String toString() {
        return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
    }

}
