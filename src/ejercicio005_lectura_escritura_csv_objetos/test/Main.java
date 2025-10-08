package ejercicio005_lectura_escritura_csv_objetos.test;

import ejercicio005_lectura_escritura_csv_objetos.javabeans.Cliente;
import ejercicio005_lectura_escritura_csv_objetos.javabeans.Pedido;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal del proyecto.
 * Contiene metodos de carga de clientes y pedidos y metodos de lectura y escritura
 * de ficheros en formato .csv y .dat.
 *
 * @author Adrián Guerrero Martínez.
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        // Carga de datos
        List<Cliente> clientes = new ArrayList<>(cargarClientes());
        List<Pedido> pedidos = new ArrayList<>(cargarPedidos());

        // Metodos de escritura de ficheros .csv
        escrituraCSVPedidos(pedidos);
        escrituraCSVClientes(clientes);

        // Metodos de escritura de ficheros .dat
        escrituraObjetosClientes(clientes);
        escrituraObjetosPedidos(pedidos);

    }

    /**
     * Metodo que devuelve una colección de clientes lista para ser utilizada
     * en el metodo main().
     *
     * @return Colección de clientes.
     */
    public static List<Cliente> cargarClientes() {
        Cliente cliente1 = new Cliente(1, "Laura Arroyo", "laura.arroyo@hotmail.com");
        Cliente cliente2 = new Cliente(2, "José Jiménez", "jose.jimenez@hotmail.com");
        Cliente cliente3 = new Cliente(3, "Carlos Tudela", "carlos.tudela@gmail.com");
        Cliente cliente4 = new Cliente(4, "Camila Rivera", "camilla.rivera@gmail.com");
        Cliente cliente5 = new Cliente(5, "Alicia Martínez", "alicia.martinez@hotmail.com");

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);
        return clientes;
    }

    /**
     * Metodo que devuelve una colección de pedidos lista para ser utilizada
     * en el metodo main().
     *
     * @return Colección de pedidos.
     */
    public static List<Pedido> cargarPedidos() {
        Pedido pedido1 = new Pedido(1, 1000, 1, "Smartphone X100");
        Pedido pedido2 = new Pedido(2, 1100, 2, "Auriculares Bluetooth Pro");
        Pedido pedido3 = new Pedido(3, 1200, 1, "Smartwatch serie 5");
        Pedido pedido4 = new Pedido(4, 1300, 2, "Cargador portátil 10.000 mAh");
        Pedido pedido5 = new Pedido(5, 1400, 1, "Altavoz inteligente");

        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(pedido1);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
        pedidos.add(pedido4);
        pedidos.add(pedido5);
        return pedidos;
    }

    /**
     * Metodo que comprueba la existencia del directorio "src/documents".
     * Si no existe el directorio, lo genera de nuevo.
     */
    private static void comprobarDirectorio() {
        File directory = new File("src/documents");
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    /**
     * Metodo que comprueba la existencia del fichero introducido.
     *
     * @param file Fichero del que comprobar su existencia.
     * @return {@code true} si el fichero existe, {@code false} en caso contrario.
     */
    private static boolean comprobarFichero(File file) {
        if (!file.exists()) {
            System.err.printf("El fichero %s no existe%n", file.getName());
            return false;
        }
        return true;
    }

    /**
     * Metodo que recibe una colección de clientes y los hace persistir en el
     * fichero "clientes.csv".
     *
     * @param clientes Colección de clientes a persistir en el fichero "clientes.csv".
     */
    public static void escrituraCSVClientes(List<Cliente> clientes) {

        comprobarDirectorio();

        File file = new File("src/documents/clientes.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error en la creación del archivo \"clientes.csv\"");
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("id,nombre,email");
            bw.newLine();
            for (Cliente cliente : clientes) {
                bw.write(cliente.toString());
                bw.newLine();
            }
            System.out.printf("Escritura finalizada. %nDocumento \"%s\" generado en la ruta: src/documents/clientes.csv%n", file.getName());
        } catch (IOException e) {
            System.err.println("Error en la escritura: " + e.getMessage());
        }
    }

    /**
     * Metodo que recibe una colección de pedidos y los hace persistir en el
     * fichero "pedidos.csv".
     *
     * @param pedidos Colección de pedidos a persistir en el fichero "pedidos.csv".
     */
    public static void escrituraCSVPedidos(List<Pedido> pedidos) {

        comprobarDirectorio();

        File file = new File("src/documents/pedidos.csv");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error en la creación del archivo \"pedidos.csv\"%n");
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("ClienteId,id,cantidad,producto");
            bw.newLine();
            for (Pedido pedido : pedidos) {
                bw.write(pedido.toString());
                bw.newLine();
            }
            System.out.printf("Escritura finalizada. %nDocumento \"%s\" generado en la ruta: src/documents/pedidos.csv%n", file.getName());
        } catch (IOException e) {
            System.err.println("Error en la escritura: " + e.getMessage());
        }
    }

    /**
     * Metodo que recibe una colección de clientes y los hace persistir en forma de
     * datos binarios en el fichero "clientes.dat".
     *
     * @param clientes Colección de clientes a persistir en el fichero "clientes.dat".
     */
    public static void escrituraObjetosClientes(List<Cliente> clientes) {

        comprobarDirectorio();

        File file = new File("src/documents/clientes.dat");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error en la creación del archivo \"clientes.dat\"");
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Cliente cliente : clientes) {
                oos.writeObject(cliente);
            }
            System.out.printf("Escritura finalizada. %nDocumento \"%s\" generado en la ruta: src/documents/clientes.dat%n", file.getName());
        } catch (IOException e) {
            System.err.println("Error en la escritura: " + e.getMessage());
        }
    }

    /**
     * Metodo que recibe una colección de pedidos y los hace persistir en forma de
     * datos binarios en el fichero "pedidos.dat".
     *
     * @param pedidos Colección de pedidos a persistir en el fichero "pedidos.dat".
     */
    public static void escrituraObjetosPedidos(List<Pedido> pedidos) {

        comprobarDirectorio();

        File file = new File("src/documents/pedidos.dat");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("Error en la creación del archivo \"pedidos.dat\"");
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Pedido pedido : pedidos) {
                oos.writeObject(pedido);
            }
            System.out.printf("Escritura finalizada. %nDocumento \"%s\" generado en la ruta: src/documents/pedidos.dat%n", file.getName());
        } catch (IOException e) {
            System.err.println("Error en la escritura: " + e.getMessage());
        }
    }

    /**
     * Metodo que recibe la ruta de un fichero en formato de texto plano e imprime
     * su información en consola.
     *
     * @param path Ruta de un fichero de texto plano.
     */
    public static void lecturaCSV(String path) {

        File file = new File(path);
        if (!file.exists()) {
            System.err.println("La ruta introducida no existe: " + path);
        } else {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Error en la lectura del fichero .csv: " + e.getMessage());
            }
        }
    }

    /**
     * Metodo que imprime en la consola los datos del fichero binario clientes.dat.
     */
    public static void lecturaObjetosClientes() {

        File file = new File("src/documents/clientes.dat");

        if (comprobarFichero(file)) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                while (true) {
                    System.out.println((Cliente) ois.readObject());
                }
            } catch (EOFException e) {
                System.out.println("Se ha alcanzado el final del fichero");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error en la lectura del fichero "
                        + file.getName() + ": " + e.getMessage());
            }
        }
    }

    /**
     * Metodo que imprime en la consola los datos del fichero binario pedidos.dat.
     */
    public static void lecturaObjetosPedidos() {

        File file = new File("src/documents/pedidos.dat");
        if (comprobarFichero(file)) {

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                while (true) {
                    System.out.println((Pedido) ois.readObject());
                }
            } catch (EOFException e) {
                System.out.println("Se ha alcanzado el final del fichero");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error en la lectura del fichero "
                        + file.getName() + ": " + e.getMessage());
            }
        }
    }
}