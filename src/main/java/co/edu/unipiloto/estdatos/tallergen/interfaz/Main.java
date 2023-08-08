/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.unipiloto.estdatos.tallergen.interfaz;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import co.edu.unipiloto.estdatos.tallergen.mundo.Camisa;
import co.edu.unipiloto.estdatos.tallergen.mundo.Camisa.Marca;
import co.edu.unipiloto.estdatos.tallergen.mundo.Casilleros;
import co.edu.unipiloto.estdatos.tallergen.mundo.Celular;
import co.edu.unipiloto.estdatos.tallergen.mundo.Celular.Operador;
import co.edu.unipiloto.estdatos.tallergen.mundo.Computador;
import co.edu.unipiloto.estdatos.tallergen.mundo.Computador.SistemaOperativo;
import co.edu.unipiloto.estdatos.tallergen.mundo.Electronico.Gama;
import co.edu.unipiloto.estdatos.tallergen.mundo.Producto;

import co.edu.unipiloto.estdatos.tallergen.mundo.Vestuario.Talla;

/**
 *
 * @author USUARIO
 */
public class Main <T> {

    private BufferedReader br;
    private Casilleros casilleros;

    /**
     * Clase principal de la aplicación, incializa el mundo.
     *
     * @throws Exception
     */
    public Main() throws Exception {
        System.out.println("Hola Mundo");
        casilleros = new Casilleros();
        br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("<< Bienvenido al sistema de casilleros >>");
        menuInicial();
    }

    /**
     * Menú principal de la aplicación
     *
     * @throws Exception
     */
    public void menuInicial() throws Exception {
        String mensaje = "Presione el número de la "
                + "opción que desea elegir: \n - - - - - - - - - - - - - - - - - - - - -\n"
                + "[1] Ver el estado de los casilleros \n"
                + "[2] Agregar un producto a un casillero \n"
                + "[3] Sacar un producto de un casillero\n";
        System.out.print(mensaje);
        String op1 = br.readLine();

        switch (op1) {
            case "1":
                estadoCasilleros();
                break;
            case "2":
                agregarProducto();
                break;
            case "3":
                sacarProducto();
                break;

        }
    }

    /**
     * Menú que permite ver el estado de los casilleros
     *
     * @throws Exception
     */
    public void estadoCasilleros() throws Exception {
        System.out.println("* * * * * * * * * * * * * * * * ");
        System.out.println("\n<< Estado de los casilleros:>>");

        casilleros.verProductos();

        System.out.println("Presione intro para regresar");
        br.readLine();
        menuInicial();
    }

    /**
     * Menú que permite agregar un producto a los casilleros
     *
     * @throws Exception
     */
    public void agregarProducto() throws Exception {
        System.out.println("* * * * * * * * * * * * * * * * ");
        System.out.println("<< Agregar producto >>\n");
        String mensaje = "[1] Camisa\n"
                + "[2] Celular\n"
                + "[3] Computador\n";
        System.out.print(mensaje);
        String op2 = br.readLine();
        switch (op2) {
            case "1":
                agregarCamisa();
                break;
            case "2":
                agregarCelular();
                break;
            case "3":
                agregarComputador();
                break;

        }
    }

    /**
     * Menú para agregar un celular
     *
     * @throws Exception
     */
    public void agregarCelular() throws Exception {
        System.out.println("* * * * * * * * * * * * * * * * ");
        System.out.println("<< Agregar celular >>\n");
        System.out.println("¿Operador? ");

        Operador[] opers = Operador.values();

        for (int i = 0; i < opers.length; i++) {
            System.out.println("[" + (i + 1) + "] " + opers[i]);
        }

        int indice = Integer.parseInt(br.readLine());
        Operador operador = opers[indice - 1];

        System.out.println("¿Gama? ");

        Gama[] gamas = Gama.values();

        for (int i = 0; i < gamas.length; i++) {
            System.out.println("[" + (i + 1) + "] " + gamas[i]);
        }

        indice = Integer.parseInt(br.readLine());
        Gama gama = gamas[indice - 1];

        System.out.println("¿Precio?");
        double precio = Double.parseDouble(br.readLine().replace(",", "."));
        

        Producto celular = new Celular (gama, precio, operador);

        int respuesta = casilleros.almacenar(celular);

        if (respuesta != -1) {
            System.out.println("El celular ha sido almacenado en el casillero " + respuesta);
        } else {
            System.out.println("No hay casilleros disponibles para almacenar la compra");
        }
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(" ");
        menuInicial();
    }

    /**
     * Menú para agregar una camisa
     *
     * @throws Exception
     */
    public void agregarCamisa() throws Exception {
        System.out.println("* * * * * * * * * * * * * * * * ");
        System.out.println("<< Agregar camisa >>\n");
        System.out.println("¿Marca?");

        //TODO Modificar según la guía de laboratorio
        Marca[] marcaa= Marca.values();
        for (int i = 0; i < marcaa.length; i++) {
            System.out.println("["+ (i+1)+ "]"+ marcaa[i]);   
        }
        int indice = Integer.parseInt(br.readLine());
        Marca marca = marcaa[indice - 1];
        

        System.out.println("¿Talla?");

        Talla[] tallas = Talla.values();

        for (int i = 0; i < tallas.length; i++) {
            System.out.println("[" + (i + 1) + "] " + tallas[i]);
        }

        indice = Integer.parseInt(br.readLine());
        Talla talla = tallas[indice - 1];

        System.out.println("¿Precio?");
        double precio = Double.parseDouble(br.readLine().replaceAll(",", "."));

        Producto camisa = new Camisa(marca, talla, precio);

        int respuesta = casilleros.almacenar(camisa);

        if (respuesta != -1) {
            System.out.println("La camisa ha sido almacenada en el casillero " + respuesta);
        } else {
            System.out.println("No hay casilleros disponibles para almacenar la compra");
        }
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(" ");
        menuInicial();

    }

    /**
     * Menú para agregar un computador a los casilleros
     *
     * @throws Exception
     */
    public void agregarComputador() throws Exception {
        System.out.println("* * * * * * * * * * * * * * * * ");
        System.out.println("<< Agregar computador >>\n");
        System.out.println("¿Sistema Operativo? ");

        SistemaOperativo[] sisopers = SistemaOperativo.values();

        for (int i = 0; i < sisopers.length; i++) {
            System.out.println("[" + (i + 1) + "] " + sisopers[i]);
        }

        int indice = Integer.parseInt(br.readLine());
        SistemaOperativo sistemaOperativo = sisopers[indice - 1];

        System.out.println("¿Gama? ");

        Gama[] gamas = Gama.values();

        for (int i = 0; i < gamas.length; i++) {
            System.out.println("[" + (i + 1) + "] " + gamas[i]);
        }

        indice = Integer.parseInt(br.readLine());
        Gama gama = gamas[indice - 1];

        System.out.println("¿Precio?");
        double precio = Double.parseDouble(br.readLine().replace(",", "."));

        Producto computador = new Computador(gama, precio, sistemaOperativo);

        int respuesta = casilleros.almacenar(computador);

        if (respuesta != -1) {
            System.out.println("El computador ha sido almacenado en el casillero " + respuesta);
        } else {
            System.out.println("No hay casilleros disponibles para almacenar la compra");
        }
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(" ");
        menuInicial();
    }


    /**
     * Menú para sacar un producto de los casilleros
     *
     * @throws Exception
     */
    public void sacarProducto() throws Exception {
        System.out.println("* * * * * * * * * * * * * * * * ");
        System.out.println("<< Despachar producto >>\n");

        System.out.println("¿Número del casillero?");
        int num = Integer.parseInt(br.readLine());

        T producto = (T) casilleros.despachar(num);

        if (producto == null) {
            System.out.println("El casillero con número " + num + " no contiene ningún producto o el casillero no existe, revise el estado de los casilleros");
        } else {
            System.out.println("Se despachó el producto: " + producto.toString());
        }

        menuInicial();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            new Main();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
