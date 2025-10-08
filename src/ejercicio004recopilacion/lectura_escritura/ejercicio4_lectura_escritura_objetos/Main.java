package ejercicio004recopilacion.lectura_escritura.ejercicio4_lectura_escritura_objetos;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase principal que ejecuta la escritura y lectura de objetos {@link Persona} en
 * un fichero binario mediante {@link ObjectOutputStream} y {@link ObjectInputStream}.
 * <p>
 * Este programa:
 * <ul>
 *     <li>Genera una lista de personas.</li>
 *     <li>Escribe los objetos en un archivo binario.</li>
 *     <li>Lee los objetos desde el archivo y los muestra por consola.</li>
 * </ul>
 * El archivo se guarda en la ruta:
 * <pre>src/ejercicio004recopilacion/lectura_escritura/ejercicio4_lectura_escritura_objetos/resources/personas.dat</pre>
 *
 * @author Adrián Guerrero Martínez
 * </p>
 *
 */
public class Main {

    /**
     * Metodo principal del programa que realiza la escritura y la lectura de los objetos
     * Persona desde un archivo binario.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        File file = new File("src/ejercicio004recopilacion/lectura_escritura/ejercicio4_lectura_escritura_objetos/resources/personas.dat");

        List<Persona> personas = cargarDatos();

        escrituraObjetos(file, personas);
        lecturaObjetos(file);
    }

    /**
     * Carga y devuelve una lista de objetos {@link Persona} con datos predefinidos.
     *
     * @return Lista de personas.
     */
    private static List<Persona> cargarDatos() {
        Persona p1 = new Persona("Mario", 25);
        Persona p2 = new Persona("Alicia", 28);
        Persona p3 = new Persona("Eva", 26);
        Persona p4 = new Persona("Justin", 22);
        Persona p5 = new Persona("Pierre", 31);

        List<Persona> personas = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));
        return personas;
    }

    /**
     * Metodo que realiza la escritura de una lista de objetos {@link Persona} en un
     * fichero binario.
     *
     * @param file     Fichero de destino.
     * @param personas Lista de persona a escribir.
     */
    public static void escrituraObjetos(File file, List<Persona> personas) {
        try {
            file.getParentFile().mkdirs();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                for (Persona persona : personas) {
                    oos.writeObject(persona);
                }
                System.out.println("Escritura finalizada. Fichero generado en: ejercicio004recopilacion/lectura_escritura/ejercicio4_lectura_escritura_objetos/resources");
            }
        } catch (FileNotFoundException e) {
            System.err.println("No existe el archivo: " + file.getName());
        } catch (IOException e) {
            System.err.println("Error en la escritura del archivo: " + e.getMessage());
        }
    }

    /**
     * Metodo que realiza la lectura de objetos {@link Persona} desde un fichero binario
     * y los muestra mediante la consola.
     * La lectura se realiza en bucle hasta que se alcanza el final del fichero.
     *
     * @param file Archivo en el que se realiza la lectura.
     */
    public static void lecturaObjetos(File file) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            int contador = 1;
            while (true) {
                Persona persona = (Persona) ois.readObject();
                System.out.printf("Persona(%d) -> %s%n", contador, persona.toString());
                contador++;
            }
        } catch (EOFException e) {
            System.out.println("Final del fichero alcanzado");
        } catch (ClassNotFoundException | IOException e) {
            System.err.println("Error en la lectura del archivo: " + e.getMessage());
        }
    }
}