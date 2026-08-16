package model;

public class Item {
    private String nombre;
    private int damage;//daño aumentado a Heroe
    private int curacion;//cuantos puntos de vida sana
    
    public Item(String n, int d, int c) {
        this.nombre = n;
        this.damage = d;
        this.curacion = c;
    }
    
    public Item(String n) {
        this.nombre = n;
        this.damage = 0;
        this.curacion = 0;
    }

    public String getNombre() {
       return this.nombre; 
    }

    public int getDamage() {
       return this.damage; 
    }

    public int getCuracion() {
       return this.curacion; 
    }
    
    public void info() {
        System.out.println("Item: " + getNombre() +
                "\nDaño: " + getDamage() + 
                "\nPuntos de curación: " + getCuracion());
    }
}
