package view; 

import model.*;

public class Main {

    public static void main(String[] args) {
       Heroe s = new Heroe("Samson"); 
        s.info();
        System.out.println("--------------");
        s.addToInventario("Espada común",12,0);
        s.getInventario();
    }

}
