package view; 

import model.*;

public class Main {

    public static void main(String[] args) {
       Heroe s = new Heroe("Samson"); 
        s.info();
        System.out.println("--------------");

        s.addToInventario("pañuelo");
        s.addToInventario("Espada",12,0);
        
        Item i = new Item("Libro Magico", 0, 4);
        s.addToInventario(i);
        s.getInventario();
    }

}
