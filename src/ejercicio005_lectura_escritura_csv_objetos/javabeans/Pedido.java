package ejercicio005_lectura_escritura_csv_objetos.javabeans;

import java.io.Serializable;

/**
 * Clase que representa el pedido realizado por un cliente.
 * El pedido queda identificado por el cliente que lo realiza, el número de
 * identificación del pedido, la cantidad del producto y el nombre del producto.
 *
 * @author Adrián Guerrero Martínez
 * @version 1.0
 */
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1500L;
    private int clienteId;
    private int id;
    private int cantidad;
    private String producto;

    /**
     * No-Args Constructor.
     * Constructor sin parámetros que inicializa un pedido con sus valores por defecto.
     */

    public Pedido() {
    }

    /**
     * All-Args Constructor.
     * Constructor con todos los parámetros.
     *
     * @param clienteId Número de identificación del cliente.
     * @param id        Número de identificación del pedido.
     * @param cantidad  Cantidad de productos del pedido.
     * @param producto  Nombre del producto.
     */
    public Pedido(int clienteId, int id, int cantidad, String producto) {
        this.clienteId = clienteId;
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    /**
     * Metodo getter que devuelve el número de identificación del pedido.
     *
     * @return Número de identificación del pedido.
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo setter que establece el número de identificación del pedido.
     *
     * @param id Número de identificación del pedido.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo getter que devuelve el número de identificación del cliente.
     *
     * @return Número de identificación del cliente.
     */
    public int getClienteId() {
        return clienteId;
    }

    /**
     * Metodo setter que establece el número de identificación del cliente.
     *
     * @param clienteId Número de identificación del cliente.
     */
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    /**
     * Metodo getter que devuelve la cantidad de productos del pedido.
     *
     * @return Cantidad de productos del pedido.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Metodo setter que establece la cantidad de productos del pedido.
     *
     * @param cantidad Cantidad de productos del pedido.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Metodo getter que devuelve el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getProducto() {
        return producto;
    }

    /**
     * Metodo setter que establece el nombre del producto.
     *
     * @param producto Nombre del producto.
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * Metodo que genera una cadena de texto formateada lista para ser
     * transferida a un documento .csv.
     *
     * @return Cadena de texto en formato: clienteId,id,cantidad,producto.
     */
    @Override
    public String toString() {
        return "%d,%d,%d,%s".formatted(clienteId, id, cantidad, producto);
    }
}