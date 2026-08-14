package model;

public class Item {
    private String nombre;
    private int damage;//daño aumentado a Heroe
    private int sanacion;//cuantos puntos de vida sana
    
    public Item(String n, int d, int s) {
        this.nombre = n;
        this.damage = d;
        this.sanacion = s;
    }

}
