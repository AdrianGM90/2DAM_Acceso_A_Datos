package ejercicio001;

import java.io.File;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
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