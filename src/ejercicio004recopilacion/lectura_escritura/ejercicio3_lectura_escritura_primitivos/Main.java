package ejercicio004recopilacion.lectura_escritura.ejercicio3_lectura_escritura_primitivos;

import java.io.*;

/**
 * Clase principal que realiza la escritura y lectura de enteros (datos primitivos)
 * en un fichero en formato dat mediante {@link DataOutputStream} y {@link DataInputStream}.
 *
 * <p>
 *     <ul>
 *         <li>Define un array de edades.</li>
 *         <li>Escribe las edades del array en un archivo binario.</li>
 *         <li>Lee el contenido del fichero generado y muestra las edades por consola</li>
 *     </ul>
 * </p>
 * El archivo se guarda en la ruta:
 * <pre>src/ejercicio004recopilacion/lectura_escritura/ejercicio3_lectura_escritura_primitivos/resources/edades.dat</pre>
 *
 * @author Adrián Guerrero Martínez
 */
public class Main {

    /**
     * Metodo principal del programa que define las edades, las escribe en el fichero
     * binario y luego realiza la lectura de su contenido mostrándolo por consola.
     *
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {

        int[] edades = {18, 25, 30, 45, 60};

        File file = new File("src/ejercicio004recopilacion/lectura_escritura/ejercicio3_lectura_escritura_primitivos/resources/edades.dat");

        escritura(file, edades);
        lectura(file);
    }

    /**
     * Metodo que recibe el fichero en el que se guardarán los datos y un array
     * de edades para escribirlos en dicho fichero.
     *
     * @param file   Archivo en el que se guardarán los datos.
     * @param edades Array de edades que se desea almacenar.
     */
    public static void escritura(File file, int[] edades) {
        try {
            file.getParentFile().mkdirs();
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
                for (int edad : edades) {
                    dos.writeInt(edad);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de datos: " + e.getMessage());
        }
    }

    /**
     * Metodo que realiza la lectura de un fichero binario que contiene enteros y
     * los muestra por consola.
     * El metodo finaliza cuando alcanza el final del fichero.
     *
     * @param file Archivo binario que se va a leer.
     */
    public static void lectura(File file) {

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            int contador = 1;
            while (true) {
                System.out.printf("Edad(%d): %d\n", contador, dis.readInt());
                contador++;
            }
        } catch (EOFException e) {
            System.out.println("Final del fichero alcanzado");
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}