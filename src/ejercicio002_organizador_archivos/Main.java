package ejercicio002_organizador_archivos;

import java.io.File;
import java.util.Scanner;

/**
 * Clase que organiza archivos según su extensión.
 * <p>
 * Este programa organiza los archivos contenidos en un directorio dado
 * automáticamente, moviéndolos a subcarpetas según su extensión.
 * Si un archivo no tiene extensión, se coloca en una carpeta llamada
 * {@otros}. </p>
 * <p>
 * Funcionalidades principales:
 * </p>
 * <ul>
 *     <li>Solicitar una ruta de carpeta al usuario.</li>
 *     <li>Verificar que la ruta es válida y es un directorio.</li>
 *     <li>Recorrer todos los archivos del directorio.</li>
 *     <li>Detectar su extensión y recolocarlos en las subcarpetas correspondientes.</li>
 * </ul>
 *
 * @author Adrián Guerrero Martínez
 * @version 1.0
 */
public class Main {

    /**
     * Metodo principal que inicia el programa.
     * <p>
     * Llama a {@link #solicitarRuta()} para obtener la ruta desde el usuario, luego,
     * llama a {@link #organizarDirectorios(File)} para organizar los archivos.
     * </p>
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        String ruta = solicitarRuta();
        organizarDirectorios(new File(ruta));
    }

    /**
     * Solicita al usuario la ruta absoluta de un directorio a organizar.
     *
     * @return String con la ruta introducida por el usuario.
     */
    public static String solicitarRuta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la ruta absoluta del directorio: ");
        String ruta = sc.nextLine();
        sc.close();
        return ruta;
    }

    /**
     * Metodo que obtiene la extensión de un archivo.
     * Si el archivo no tiene extensión, devuelve {@code null}.
     *
     * @param file Archivo del que se extrae la extensión.
     * @return Extensión del archivo en minúsculas o {@code null} si no tiene.
     */
    private static String extension(File file) {
        String[] fullName = file.getName().split("\\.");
        if (fullName.length > 1) {
            return fullName[fullName.length - 1].toLowerCase();
        } else {
            return null;
        }
    }

    /**
     * Organiza los archivos de un directorio según su extensión.
     * <p>
     * Para cada archivo:
     * </p>
     * <ul>
     *     <li>Se detecta su extensión.</li>
     *     <li>Se crea una subcarpeta con esa extensión, si no existe.</li>
     *     <li>El archivo se mueve a dicha carpeta.</li>
     *     <li>Si no tiene extensión, se mueve a la carpeta "otros".</li>
     * </ul>
     *
     * @param file Directorio que contiene los archivos a organizar.
     */
    public static void organizarDirectorios(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                String extension = extension(f);
                String folderName = (extension != null) ? extension : "otros";

                File targetDir = new File(file, folderName);
                if (!targetDir.exists()) {
                    targetDir.mkdirs();
                }
                File destinationFile = new File(targetDir, f.getName());
                boolean renameSuccess = f.renameTo(destinationFile);
                if (!renameSuccess) {
                    System.out.println("No se pudo mover el archivo: " + f.getName());
                }
            }
        }
        System.out.println("Proceso finalizado");
    }
}