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

    public String getNombre() {
        return this.nombre;
    }

    public int getVida() {
        return this.vida;
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getPosicion() {
        return Arrays.toString(this.posicion);
    }

    public void getInventario() {
        for (Item item : this.inventario) {
            item.info();
            System.out.println();
        }
        
    }
    
    public void addToInventario(String item, int damage, int curacion) {
        this.inventario.add(new Item(item,damage,curacion));
    }

    public void addToInventario(String item) {
        this.inventario.add(new Item(item));
    }

    public void addToInventario(Item item) {
        this.inventario.add(item);
    }

    public void info() {
       System.out.println("Nombre: " + getNombre() + 
               "\nPuntuacion: " + getPuntuacion() + 
               "\nVida: " + getVida() +
               "\nDaño: " + getDamage() +
               "\nPosicion Mapa: " + getPosicion()); 
    } 
}
