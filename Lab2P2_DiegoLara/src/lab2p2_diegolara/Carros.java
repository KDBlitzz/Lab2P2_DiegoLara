/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2_diegolara;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Carros {

    private String marca;
    private String modelo;
    private Color color;
    private double precio;
    private ArrayList<String> mejoras = new ArrayList();
    private int marcador;

    public Carros() {
    }

    public Carros(String marca, String modelo, Color color, double precio, int marcador) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
        this.marcador = marcador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<String> getMejoras() {
        return mejoras;
    }

    public void setMejoras(ArrayList<String> mejoras) {
        this.mejoras = mejoras;
    }

    public int isMarcador() {
        return marcador;
    }

    public void setMarcador(int marcador) {
        this.marcador = marcador;
    }

    @Override
    public String toString() {
        String cadenaFinal = "\nMarca: \n" + marca + "\n Modelo: \n" + modelo + "\n Color: \n" + color + "\n Precio: \n" + precio + "\n Marcador: \n" + marcador + "\n";

        if (mejoras.isEmpty()) {
            cadenaFinal += "\n No tiene mejoras";
        } else {
            for (String mejora : mejoras) {

                cadenaFinal += mejora;
            }
        }
        return cadenaFinal;
    }

}
