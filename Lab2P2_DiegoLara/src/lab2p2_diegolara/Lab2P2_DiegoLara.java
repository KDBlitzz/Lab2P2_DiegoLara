/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2p2_diegolara;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JColorChooser;

/**
 *
 * @author diego
 */
public class Lab2P2_DiegoLara {

    public static Scanner cinq = new Scanner(System.in);
    public static Scanner nLine = new Scanner(System.in);
    public static Scanner cordes = new Scanner(System.in);
    public static ArrayList<Carros> carrosGenerales = new ArrayList();
    public static ArrayList<Jugadores> jugadores = new ArrayList();
    public static int marcador = 0;

    public static void main(String[] args) {
        boolean menu = true;
        while (menu) {
            System.out.println("Bienvenido a Need For Speed");
            System.out.println("1. Agregar Carros");
            System.out.println("2. Listar Carros");
            System.out.println("3. Eliminar Carros");
            System.out.println("4. Agregar Jugadores");
            System.out.println("5. Listar Jugadores");
            System.out.println("6. Eliminar Jugadores");
            System.out.println("7. Modificar Jugadores");
            System.out.println("8. Compra y Venta de Carros");
            System.out.println("9. Tunear Carro");
            System.out.println("10. Salir");
            int option = cinq.nextInt();
            switch (option) {
                case 1 -> {
                    AgregarCarro();
                }
                case 2 -> {
                    mostrarJugadorPorID();
                    System.out.println("¿Qué jugador va a elegir?\n Ingrese la posicion: ");
                    int posJ = cinq.nextInt() - 1;
                    for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                        System.out.println("Carro: " + jugadores.get(posJ).getListaCarros().indexOf(listaCarro) + 1 + " " + listaCarro);
                    }
                }
                case 3 -> {
                    mostrarCarroporID();
                    System.out.println("¿Qué carro desea eliminar?\n Ingrese la posicion: ");
                    int eliminarC = cinq.nextInt();
                    carrosGenerales.remove(eliminarC - 1);
                    System.out.println("Se ha eliminado el carro exitosamente");
                }
                case 4 -> {
                    AgregarJugador();
                }
                case 5 -> {
                    if (!jugadores.isEmpty()) {

                        ListarJugadores();
                    } else {
                        System.out.println("No hay jugadores");
                    }
                }
                case 6 -> {
                    if (!jugadores.isEmpty()) {
                        mostrarJugadorPorID();
                        System.out.println("¿Qué jugador desea eliminar?\n Ingrese la posicion: ");
                        int eliminar = cinq.nextInt();

                        jugadores.remove(eliminar - 1);
                        System.out.println("Se ha eliminado el jugador exitosamente");
                    } else {
                        System.out.println("No hay jugadores");
                    }
                }
                case 7 -> {
                    if (!jugadores.isEmpty()) {
                        ModificarJugadores();
                    } else {
                        System.out.println("No hay jugadores");
                    }
                }
                case 8 -> {
                    boolean subM = true;
                    int cont = 0;
                    if (!jugadores.isEmpty()) {
                        while (subM) {

                            System.out.println("1. Comprar Carros");
                            System.out.println("2. Vender Carros");
                            System.out.println("3. Salir");
                            int mini = cinq.nextInt();
                            switch (mini) {
                                case 1 -> {
                                    mostrarJugadorPorID();
                                    System.out.println("¿Qué jugador va a comprar?\n Ingrese la posicion: ");
                                    int posJ = cinq.nextInt() - 1;
                                    mostrarCarroporID();
                                    System.out.println("Ingrese la posicion del carro que desea comprar: ");
                                    int posC = cinq.nextInt() - 1;

                                    if (carrosGenerales.isEmpty()) {
                                        System.out.println("No hay carros en este momento");
                                        break;
                                    }
                                    if (jugadores.get(posJ).getDinero() < carrosGenerales.get(posC).getPrecio()) {
                                        System.out.println("No tienes suficiente dinero para el carro");
                                    } else {

                                        jugadores.get(posJ).getListaCarros().add(carrosGenerales.get(posC));

                                        cont++;
                                        jugadores.get(posJ).setCantidad(cont);
                                        jugadores.get(posJ).setDinero(jugadores.get(posJ).getDinero() - carrosGenerales.get(posC).getPrecio());
                                        System.out.println("Carro comprado exitosamente");
                                        carrosGenerales.remove(posC);
                                    }
                                }
                                case 2 -> {
                                    mostrarJugadorPorID();
                                    System.out.println("¿Qué jugador vendera su carro?\n Ingrese la posicion: ");
                                    int posJ = cinq.nextInt() - 1;
                                    if (posJ >= 0 && posJ < jugadores.size()) {
                                        for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                                            System.out.println("Carro: " + jugadores.get(posJ).getListaCarros().indexOf(listaCarro));
                                        }
                                    }

                                    System.out.println("¿Qué carro va a vender?: ");
                                    int posC = cinq.nextInt() - 1;
                                    cont--;
                                    jugadores.get(posJ).setCantidad(cont);
                                    double precioV = jugadores.get(posJ).getListaCarros().get(posC).getPrecio();
                                    jugadores.get(posJ).setDinero(jugadores.get(posJ).getDinero() + precioV);
                                    carrosGenerales.add(jugadores.get(posJ).getListaCarros().get(posC));
                                    jugadores.get(posJ).getListaCarros().remove(posC);

                                    System.out.println("Ha vendido exitosamente");
                                }
                                case 3 -> {
                                    subM = false;
                                }
                            }

                        }
                    } else {
                        System.out.println("No hay jugadores");
                    }
                }
                case 9 -> {
                    if (marcador == 1) {
                        mostrarJugadorPorID();
                        System.out.println("¿Qué jugador tuneara su carro?\n Ingrese la posicion: ");
                        int posJ = cinq.nextInt() - 1;
                        System.out.println("Spoiler - 3500\n"
                                + "Side Skirts - 1800\n"
                                + "Front Bumper - 2000\n"
                                + "Back Bumper - 1500\n");
                        String agencia = nLine.nextLine().toLowerCase();
                        if (posJ >= 0 && posJ < jugadores.size()) {
                            for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                                System.out.println("Carro: " + jugadores.get(posJ).getListaCarros().indexOf(listaCarro) + " " + listaCarro);
                            }
                        }

                        System.out.println("¿Qué carro va a tunear?: ");
                        int posC = cinq.nextInt() - 1;
                        if (agencia.equals("spoiler")) {
                            for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                                listaCarro.getMejoras().add("Spoiler");

                            }
                            jugadores.get(posJ).setDinero(jugadores.get(posJ).getDinero() - 3500);
                        } else if (agencia.equals("side skirts")) {
                            for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                                listaCarro.getMejoras().add("side skirts");

                            }
                            jugadores.get(posJ).setDinero(jugadores.get(posJ).getDinero() - 1800);
                        } else if (agencia.equals("front bumper")) {
                            for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                                listaCarro.getMejoras().add("front bumper");

                            }
                            jugadores.get(posJ).setDinero(jugadores.get(posJ).getDinero() - 2000);
                        } else if (agencia.equals("back bumper")) {
                            for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                                listaCarro.getMejoras().add("back bumper");

                            }
                            jugadores.get(posJ).setDinero(jugadores.get(posJ).getDinero() - 1500);
                        }
                        break;

                    } else if (marcador == 2) {
                        mostrarJugadorPorID();
                        System.out.println("¿Qué jugador tuneara su carro?\n Ingrese la posicion: ");
                        int posJ = cinq.nextInt() - 1;

                        System.out.println("Spoiler - 3500\n"
                                + "Side Skirts - 1800\n"
                                + "Front Bumper - 2000\n"
                                + "Back Bumper - 1500\n"
                                + "Super Builds - 8800\n");

                        String reconstruido = nLine.nextLine().toLowerCase();
                        if (posJ >= 0 && posJ < jugadores.size()) {
                            for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                                System.out.println("Carro: " + jugadores.get(posJ).getListaCarros().indexOf(listaCarro) + " " + listaCarro);
                            }

                        }

                        System.out.println("¿Qué carro va a tunear?: ");
                        int posC = cinq.nextInt() - 1;
                        if (reconstruido.equals("spoiler")) {
                            for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                                listaCarro.getMejoras().add("spoiler");

                            }
                            jugadores.get(posJ).setDinero(jugadores.get(posJ).getDinero() - 3500);
                        } else if (reconstruido.equals("side skirts")) {
                            for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                                listaCarro.getMejoras().add("side skirts");

                            }
                            jugadores.get(posJ).setDinero(jugadores.get(posJ).getDinero() - 1800);
                        } else if (reconstruido.equals("front bumper")) {
                            for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                                listaCarro.getMejoras().add("front bumper");
                            }

                            jugadores.get(posJ).setDinero(jugadores.get(posJ).getDinero() - 2000);
                        } else if (reconstruido.equals("back bumper")) {
                            for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                                listaCarro.getMejoras().add("back bumper");

                            }
                            jugadores.get(posJ).setDinero(jugadores.get(posJ).getDinero() - 1500);
                        } else if (reconstruido.equals("super builds")) {
                            for (Carros listaCarro : jugadores.get(posJ).getListaCarros()) {
                                listaCarro.getMejoras().add("super builds");

                            }
                            jugadores.get(posJ).setDinero(jugadores.get(posJ).getDinero() - 8800);
                        }
                        break;
                    }
                }
                case 10 -> {
                    System.out.println("Ha salido del juego");
                    menu = false;
                }
                default -> {
                    System.out.println("Opcion Invalida");
                }
            }
        }
    }

    public static void AgregarCarro() {
        System.out.println("Ingrese la marca: ");
        String marca = cordes.next();
        System.out.println("Ingrese el modelo: ");
        String modelo = cordes.next();
        System.out.println("Ingrese el precio del carro: ");
        double precio = cinq.nextDouble();
        while (precio < 0) {
            System.out.println("Favor ingrese un numero valido: ");
            precio = cinq.nextDouble();
        }
        Color color = JColorChooser.showDialog(null, "Escoja el color que desee", Color.RED);
        System.out.println("Ingrese el marcador del carro \n [1/Agencia 2/Reconstruido]: ");
        marcador = cinq.nextInt();

        carrosGenerales.add(new Carros(marca, modelo, color, precio, marcador));
    }

    public static void AgregarJugador() {
        System.out.println("Ingrese el nombre del jugador: ");
        String nombre = cordes.next();
        System.out.println("Ingrese los puntos de reputación del jugador: ");
        int puntos = cinq.nextInt();
        while (puntos < 0) {
            System.out.println("Favor ingrese un numero mayor o igual que 0");
            puntos = cinq.nextInt();
        }
        System.out.println("Ingrese el dinero del jugador: ");
        double dinero = cinq.nextDouble();
        while (dinero < 0) {
            System.out.println("Favor ingrese un numero valido: ");
            dinero = cinq.nextDouble();
        }
        jugadores.add(new Jugadores(nombre, puntos, dinero));
        System.out.println("Se agrego un jugador exitosamente");
    }

    public static void ListarJugadores() {
        for (Jugadores jugador : jugadores) {
            System.out.println("Jugador " + ((jugadores.indexOf(jugador)) + 1));
            System.out.println(jugador);
        }
    }

    public static void ModificarJugadores() {
        boolean modi = true;
        int id = 0;
        mostrarJugadorPorID();
        System.out.println("Ingrese la posicion del jugador que desea modificar: ");
        id = cinq.nextInt();
        while (modi) {
            System.out.println("¿Que desea modificar? \n"
                    + "1. Nombre del jugador\n"
                    + "2. Reputacion del jugador\n"
                    + "3. Dinero del jugador\n"
                    + "4. Salir");
            int op = cinq.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.println("Ingrese el nuevo nombre de jugador: ");
                    String nombre = nLine.nextLine();
                    jugadores.get(id - 1).setNombre(nombre);
                }
                case 2 -> {
                    System.out.println("Ingrese la nueva reputacion del jugador: ");
                    int reputacion = cinq.nextInt();
                    jugadores.get(id - 1).setReputacion(reputacion);
                }
                case 3 -> {
                    System.out.println("Ingrese el nuevo saldo del jugador: ");
                    double dinero = cinq.nextDouble();
                    jugadores.get(id - 1).setDinero(dinero);
                }
                case 4 -> {
                    modi = false;
                    System.out.println("Ha salido del modificar");
                }
            }
        }
    }

    public static void mostrarJugadorPorID() {
        for (Jugadores jugador : jugadores) {
            System.out.println("Jugador " + ((jugadores.indexOf(jugador)) + 1) + ": " + jugador.getNombre());
        }
    }

    public static void mostrarCarroporID() {
        for (Carros carros : carrosGenerales) {
            System.out.println("Carros " + ((carrosGenerales.indexOf(carros)) + 1));
        }
    }

}
