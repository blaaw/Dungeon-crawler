package model;

public class Sala {
    private Item item;
    private Enemigo enemigo;
    private String contenido;

    public Sala(int RANDOM) {
        switch (RANDOM) {
            case 1:
                this.item = new Item("Pocion", 0, 20);
                this.contenido = "Hay una Pocion en esta sala.";
                break;
            case 2:
                this.item = new Item("Espada", 5, 0);
                this.contenido = "Hay una Espada en esta sala.";
                break;
            case 3:
                this.enemigo = new Enemigo("Monstruo Oscuro");
                this.contenido = "Hay un enemigo en esta sala!";
                break;
            default:
                this.contenido = "Sala vacia...";
                break;
        }
    }

    public void getContenido() {
        System.out.println(this.contenido);
    }

    public Item getItem() {
        return this.item;
    }

    public Enemigo getEnemigo() {
        return this.enemigo;
    }

}
