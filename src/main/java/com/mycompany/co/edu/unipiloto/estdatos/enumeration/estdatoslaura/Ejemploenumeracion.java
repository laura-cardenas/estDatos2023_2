package com.mycompany.co.edu.unipiloto.estdatos.enumeration.estdatoslaura;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejemploenumeracion {

    public enum CategoriasProductos {
        CELULARES, COMPUTADOR, TELEVISORES
    }

    public enum EstadoOrden {
        ENVIADO, ENTREGADO
    }

    public static class Producto {
        private String nombre;
        private CategoriasProductos categoria;
        private double precio;
        private int cantidad; 

        public Producto(String nombre, CategoriasProductos categoria, double precio) {
            this.nombre = nombre;
            this.categoria = categoria;
            this.precio = precio;
            this.cantidad = 0;
        }

        public String getNombre() {
            return nombre;
        }

        public CategoriasProductos getCategoria() {
            return categoria;
        }

        public double getPrecio() {
            return precio;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public int getCantidad() {
            return cantidad;
        }
    }

    public static class Orden {
        private List<Producto> productos;
        private EstadoOrden estado;

        public Orden() {
            this.productos = new ArrayList<>();
            this.estado = EstadoOrden.ENVIADO;
        }

        public void addProduct(Producto producto, int cantidad) {
            producto.setCantidad(cantidad); 
            productos.add(producto);
        }

        public double calcularTotal() {
            double total = 0;
            for (Producto producto : productos) {
                total += producto.getPrecio() * producto.getCantidad();
            }
            return total;
        }

        public EstadoOrden getEstado() {
            return estado;
        }

        public void setEstado(EstadoOrden estado) {
            this.estado = estado;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Producto celular = new Producto("Celular", CategoriasProductos.CELULARES, 600000);
        Producto computadora = new Producto("Computadora", CategoriasProductos.COMPUTADOR, 1000000);
        Producto televisor = new Producto("Televisor", CategoriasProductos.TELEVISORES, 900000);

        Orden order1 = new Orden();

        System.out.print("Ingrese la cantidad de celulares que desea comprar: ");
        int celularCantidad = scanner.nextInt();
        order1.addProduct(celular, celularCantidad);

        System.out.print("Ingrese la cantidad de computadoras que desea comprar: ");
        int computadorCantidad = scanner.nextInt();
        order1.addProduct(computadora, computadorCantidad);

        System.out.print("Ingrese la cantidad de televisores que desea comprar: ");
        int televisorCantidad = scanner.nextInt();
        order1.addProduct(televisor, televisorCantidad);

        System.out.println("Detalle del pedido:");
        System.out.println("Productos:");
        for (Producto producto : order1.productos) {
            System.out.println("- " + producto.getNombre() + " (" + producto.getCategoria() + ") - Precio: $" + producto.getPrecio() + " - Cantidad: " + producto.getCantidad());
        }
        System.out.println("Total: $" + order1.calcularTotal());
        System.out.println("Estado actual: " + order1.getEstado());

        System.out.print("El pedido ha sido entregado? (Si/No): ");
        String EstadoEntrega = scanner.next().toLowerCase();
        boolean Entrega = EstadoEntrega.equals("sí") || EstadoEntrega.equals("si");

        if (Entrega) {
            order1.setEstado(EstadoOrden.ENTREGADO);
            System.out.println("Disfrute su pedido");
        }else {
            System.out.println("Pronto llegara tu pedido");
        }
        System.out.println("Nuevo estado: " + order1.getEstado());
    }
}
