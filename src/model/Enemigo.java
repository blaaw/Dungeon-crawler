package model;

public class Enemigo {
    private String nombre;
    private int vida;
    private int damage;
    
    public Enemigo(String nombre) {
       this.nombre = nombre;
       this.vida = (int) (Math.random() * 100 + 1); 
       this.damage = (int) (Math.random() * 20 + 1);
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDamage() {
        return this.damage;
    }
    
    public void info() {
        System.out.println("Nombre: " + getNombre() +
                "\nVida: " + getVida() + 
                "\nDaño: " + getDamage());
    }
}
