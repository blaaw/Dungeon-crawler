package view; 

import model.*;

public class Main {

    public static void main(String[] args) {
       Heroe s = new Heroe("Samson"); 
        s.info();
        System.out.println("--------------");
        s.addToInventario("Espada común",2,0);
        s.getInventario();

        System.out.println("===================");

       Sala sala0 = new Sala(0);
       Sala sala1 = new Sala(1);
       Sala sala2 = new Sala(2);
       Sala sala3 = new Sala(3);
       
       sala0.getContenido();
       sala1.getContenido();
       sala2.getContenido();
       sala3.getContenido();
       
       System.out.println("Info Salas:");
       sala1.getItem().info();
       sala3.getEnemigo().info();
    }

}
