package ejercicio004recopilacion.lectura_escritura.ejercicio4_lectura_escritura_objetos;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

/**
 * Clase que representa a una persona, definida por su nombre y su edad.
 * <p>
 * Esta clase implementa {@link Serializable} para permitir la escritura y lectura en
 * ficheros binarios mediante {@link ObjectOutputStream} y {@link ObjectInputStream}.
 * </p>
 *
 * @author Adrián Guerrero Martínez
 */
public class Persona implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int edad;

    /**
     * Constructor por defecto (no-args constructor)
     */
    public Persona() {
    }

    /**
     * Constructor con parámetros (all-args constructor)
     *
     * @param nombre Nombre de la persona.
     * @param edad   Edad de la persona.
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Devuelve el nombre de la persona.
     *
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre Nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la edad de la persona.
     *
     * @return Edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la persona.
     *
     * @param edad Edad de la persona.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Metodo que devuelve una cadena de texto formateada con los datos del
     * objeto Persona.
     *
     * @return Cadena con el nombre y la edad de la persona.
     */
    @Override
    public String toString() {
        return "Nombre=%s, Edad=%d".formatted(nombre, edad);
    }
}
