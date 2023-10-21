/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2_diegolara;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Jugadores {

    private String nombre;
    private int cantidad;
    private ArrayList<Carros> listaCarros = new ArrayList();
    private int reputacion;
    private double dinero;

    public Jugadores() {
    }

    public Jugadores(String nombre, int reputacion, double dinero) {
        this.nombre = nombre;
        this.reputacion = reputacion;
        this.dinero = dinero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ArrayList<Carros> getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(ArrayList<Carros> listaCarros) {
        this.listaCarros = listaCarros;
    }

    public int getReputacion() {
        return reputacion;
    }

    public void setReputacion(int reputacion) {
        this.reputacion = reputacion;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n Cantidad de Carros: " + cantidad + "\n Reputación: " + reputacion + "\n Dinero en cuenta: " + dinero;
    }
}
