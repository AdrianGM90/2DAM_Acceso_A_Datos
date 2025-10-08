package ejercicio004recopilacion.lectura_escritura.ejercicio1_escritura_sencilla;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File resources = new File("src/ejercicios004/lectura_escritura/ejercicio1_escritura_sencilla/resources/");
        if (!resources.exists()) {
            resources.mkdirs();
        }

        String fileName = "src/ejercicios004/lectura_escritura/ejercicio1_escritura_sencilla/resources/paises.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            String[] paises = {"Spain", "UK", "Portugal", "France", "Germany" };
            for (String pais : paises) {
                bw.write(pais + "\n");
            }
            System.out.println("Escritura finalizada.");
        } catch (IOException e) {
            System.err.println("Error en la escritura del fichero: " + e.getMessage());
        }
    }
}