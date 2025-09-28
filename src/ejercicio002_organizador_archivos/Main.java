package ejercicio002_organizador_archivos;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String ruta = solicitarRuta();
        organizarDirectorios(new File(ruta));
    }

    public static String solicitarRuta() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la ruta absoluta del directorio: ");
        String ruta = sc.nextLine();
        sc.close();
        return ruta;
    }

    private static String extension(File file) {
        String[] fullName = file.getName().split("\\.");
        if (fullName.length > 1) {
            return fullName[fullName.length - 1].toLowerCase();
        } else {
            return null;
        }
    }

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