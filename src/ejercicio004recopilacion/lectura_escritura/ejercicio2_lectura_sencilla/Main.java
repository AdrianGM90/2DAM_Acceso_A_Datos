package ejercicio004recopilacion.lectura_escritura.ejercicio2_lectura_sencilla;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String fileName = "src/ejercicios004/lectura_escritura/ejercicio1_escritura_sencilla/resources/paises.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error en la lectura del archivo: " + e.getMessage());
        }
    }
}