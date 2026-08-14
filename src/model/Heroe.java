package model;

import java.util.Arrays;
import java.util.ArrayList;

public class Heroe {
    private String nombre;
    private int vida;
    private int puntuacion;
    private int damage;
    private int[] posicion;
    private ArrayList<Item> inventario;

    public Heroe(String nombre) {
       this.nombre = nombre;
       this.vida = 300;
       this. puntuacion = 0;
       this.damage = 10;
       this.posicion = new int[2];
       this.inventario = new ArrayList<>(); 
    }
    
    public void info() {
       System.out.println("Nombre: " + this.nombre + 
               "\nPuntuacion: " + this.puntuacion + 
               "\nVida: " + this.vida +
               "\nPosicion Mapa: " + Arrays.toString(this.posicion)); 
    } 
}
