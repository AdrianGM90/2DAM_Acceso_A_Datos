package ejercicio005_lectura_escritura_csv_objetos.javabeans;

import java.io.*;

/**
 * Clase que representa un cliente definido por un número de identificación,
 * nombre y email.
 *
 * @author Adrián Guerrero Martínez
 * @version 1.0
 */
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1000L;
    private int id;
    private String nombre;
    private String email;

    /**
     * No-Args Constructor.
     * Constructor sin parámetros que inicializa un cliente con valores por defecto.
     */

    public Cliente() {
    }

    /**
     * All-Args Constructor.
     * Constructor con todos los parámetros.
     *
     * @param id     Identificador del cliente.
     * @param nombre Nombre del cliente.
     * @param email  Dirección de correo electrónico del cliente.
     */

    public Cliente(int id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    /**
     * Metodo getter que devuelve el número de identificación del cliente.
     *
     * @return Número de identificación del cliente.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo setter que establece el número de identificación del cliente.
     *
     * @param id Número de identificación del cliente.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo getter que devuelve el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo setter que establece el nombre del cliente.
     *
     * @param nombre Nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo getter que devuelve el correo electrónico del cliente.
     *
     * @return Correo electrónico del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo setter que establece el correo electrónico del cliente.
     *
     * @param email Correo electrónico del cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo que genera una cadena de texto formateada lista para ser
     * transferida a un documento .csv.
     *
     * @return Cadena de texto en formato: id,nombre,email.
     */
    @Override
    public String toString() {
        return "%d,%s,%s".formatted(id, nombre, email);
    }
}