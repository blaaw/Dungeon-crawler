Aqui será donde documente todo el prograso del juego. Vamos a hacer esto poco a poco y sin miedo al exito!  Empezamos con una repo vacia y vamos a implementar el juegador/heroe.

Voy a hacer todo (o al menos la gran mayoria) en vi+tmux y la terminal. Así practico toda la sintaxsis de java, los comandos de java y javac y también de paso larpeo al maximo jajaja.

Voy a empezar con el modelo MCV para separar funciones y de momento tengo claro:

---

## MODELOS:
    - Heroe
    - Mazmorra
    - Sala
    - Item
    - Enemigo
    - Batalla

### Heroe
    - nombre : string
    - vida : int
    - inventario : ArrayList de Item
    - puntuacion : int
    - posicion-mazmorra : Array int (posiciones matriz (0,1))
    - daño : int

### Mazmorra
    - mapa : matriz de Sala (5x5 por ejemplo) 

### Sala
    sala puede tener un Enemigo o un Item. Esto se hará en el constructor de forma aleatoria.
    - Enemigo : Enemigo
    - Item : Item

### Item 
    - nombre
    - daño que aumenta al Heroe
    - vida que sana al heroe

## CONTROLADORES:

### Controla movimiento de jugador en la mazmorra
    - moverHeroe(casilla-deseada) 
        heroe.setPosicion(casilla-deseada)

    - checkearEvento(casilla-deseada)
        si hay enemigo, empieza Batalla(heroe, enemigo)
            si el return es huir moverHeroe(siguiente-casilla)
        si hay item, decirlo y dar opcion de cogerlo o no

i think i could fuse these methods with Mazmorra, sisi. 
### Controla Batalla
    - turno : int
    - Batalla(heroe, enemigo)
        return quien ganó o huir

---

para compilar y correr los archivos usa:

```bash
 javac -d bin @files/sources.txt
 java -cp bin view.Main
```
antes de compilar, en el caso de crear mas archivos, usa el siguiente comando para poblar el archivo files/sources.txt con todas las rutas de archivos.java:

```bash
find src -name "*.java" > files/sources.txt
```
lo cual dara de siguiente resultado (ejemplo):
src/model/Heroe.java
src/model/Item.java
src/view/Main.java

