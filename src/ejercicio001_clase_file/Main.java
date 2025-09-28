package ejercicio001_clase_file;

import java.io.File;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Clase que permite al usuario explorar un directorio.
 * <p>
 * El programa solicita al usuario la ruta de un directorio para listar los
 * archivos y subdirectorios contenidos en él, indicando:
 * <ul>
 *     <li>Si es un archivo o un directorio.</li>
 *     <li>La fecha de la última modificación.</li>
 *     <li>El tamaño en bytes (únicamente si es un archivo).</li>
 * </ul>
 * <p>
 * El formato de fecha utilizado es: {@code yyyy-MM-dd HH:mm:ss}.
 *
 * @author Adrián Guerrero Martínez
 * @version 1.0
 */
public class Main {

    /**
     * Metodo principal que inicia la ejecución del programa.
     *
     * <p>
     * Se emplea {@link Scanner} para leer la ruta del directorio introducida por
     * el usuario y {@link File} para acceder al contenido del directorio.
     * Se utilizan también {@link DateTimeFormatter} y {@link Instant} para formatear
     * la fecha de última modificación.
     * </p>
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la ruta a escanear:");
        String path = sc.nextLine();

        File[] archivos = new File(path).listFiles();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        try {
            for (File item : archivos) {
                String modifyDate = formatter.format(Instant.ofEpochMilli(item.lastModified()));
                if (item.isFile()) {
                    System.out.printf("[ARCHIVO] %s (%d bytes) - Última modificación: %s%n",
                            item.getName(), item.length(), modifyDate);
                } else {
                    System.out.printf("[DIRECTORIO] %s - Última modificación: %s%n",
                            item.getName(), modifyDate);
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}