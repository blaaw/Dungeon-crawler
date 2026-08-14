---
date: 2026-08-14T16:33:54+02:00
modified: 2026-08-14T16:34:33+02:00
title: Dungeon Crawler Java
---

# Mini proyecto de repaso Java: Dungeon Crawler

## Contexto

Vas a desarrollar un pequeño videojuego de texto para consola en el que el jugador deberá explorar una mazmorra, enfrentarse a enemigos, recoger objetos y tratar de conseguir la mayor cantidad de puntos posible antes de morir.

El juego no tendrá interfaz gráfica. Toda la interacción se realizará mediante la consola.

El objetivo principal del proyecto no es hacer un juego complejo, sino utilizarlo como **repaso general de Java**, poniendo especial atención en **Java I/O y concurrencia**.

---

## 1. El juego

Al comenzar la partida, el jugador tendrá:

* Un nombre.
* Una cantidad de vida.
* Un inventario.
* Una puntuación.
* Una posición dentro de la mazmorra.

La mazmorra estará formada por diferentes salas. En cada sala pueden ocurrir diferentes eventos:

* Encontrar un enemigo.
* Encontrar un objeto.
* Encontrar oro.
* Encontrar una sala vacía.
* Encontrar algún evento especial.

El jugador podrá desplazarse entre las salas y decidir qué hacer en cada una.

No es necesario implementar un sistema gráfico ni un mapa visual complejo. Una representación sencilla mediante texto será suficiente.

---

## 2. Jugador, enemigos y objetos

El juego deberá tener diferentes tipos de entidades.

Como mínimo:

* `Player`
* `Enemy`
* `Item`
* Algún tipo de arma o poción.
* Al menos **dos tipos diferentes de enemigos**.

Los enemigos deberán tener características diferentes. Por ejemplo, uno puede hacer mucho daño pero tener poca vida, mientras que otro puede ser más resistente.

Piensa en qué comportamiento deberían compartir las entidades y qué comportamiento debería ser específico de cada una.

**Pista:** intenta que el diseño aproveche conceptos de **encapsulación, herencia, composición, interfaces y polimorfismo**, pero sin crear una jerarquía innecesariamente complicada.

---

## 3. Inventario

El jugador tendrá un inventario dinámico.

Deberá ser posible:

* Añadir objetos.
* Eliminar objetos.
* Consultar los objetos disponibles.
* Utilizar objetos.
* Mostrar el inventario por consola.

El jugador podrá tener varias unidades del mismo objeto.

Por ejemplo:

```text
POCIÓN DE VIDA x3
ESPADA DE HIERRO x1
MONEDA x17
```

**Pista:** este apartado debería ser una buena oportunidad para trabajar con `ArrayList` y, si encuentras una forma razonable de utilizarlo, con `HashMap`.

No intentes utilizar una colección únicamente porque "hay que utilizarla": piensa qué estructura representa mejor cada problema.

---

## 4. Combates

Cuando el jugador encuentre un enemigo comenzará un combate por turnos.

En cada turno el jugador podrá realizar alguna acción, por ejemplo:

```text
1. Atacar
2. Usar objeto
3. Huir
```

El enemigo responderá después de la acción del jugador.

El combate terminará cuando:

* El enemigo muera.
* El jugador muera.
* El jugador consiga escapar.

Al finalizar un combate, deberán actualizarse las estadísticas correspondientes.

**Pista:** intenta separar la lógica del combate de la lógica de entrada/salida por consola. Que una clase tenga que imprimir todo lo que ocurre puede ser cómodo al principio, pero puede complicar bastante el proyecto posteriormente.

---

# 5. Guardar y cargar partidas — Java I/O

El jugador deberá poder **guardar una partida y continuarla posteriormente**.

Como mínimo, la partida deberá conservar:

* Nombre del jugador.
* Vida.
* Puntuación.
* Posición.
* Inventario.
* Estado relevante de los enemigos.

El programa deberá permitir algo parecido a:

```text
1. Nueva partida
2. Cargar partida
3. Salir
```

Y durante la partida:

```text
1. Continuar
2. Guardar partida
3. Salir
```

El formato de almacenamiento queda a tu elección.

Puedes investigar qué opción encaja mejor entre:

* Ficheros de texto.
* Ficheros binarios.
* Serialización.
* Algún formato estructurado.

**Pista importante:** no te limites a conseguir que "funcione". Intenta que el programa gestione correctamente situaciones como:

* El archivo no existe.
* El archivo está vacío.
* El archivo está corrupto.
* No se tienen permisos para escribir.
* Se intenta cargar una partida incompatible con la versión actual.

También procura que los recursos utilizados para leer y escribir archivos se cierren correctamente.

---

# 6. Registro de eventos

El juego deberá mantener un registro de lo ocurrido durante la partida.

Por ejemplo:

```text
[12:31:04] El jugador entra en la sala 4.
[12:31:05] Aparece un Goblin.
[12:31:08] El jugador hace 12 de daño.
[12:31:09] El Goblin ataca al jugador.
[12:31:10] El Goblin ha muerto.
```

Este registro deberá escribirse en un archivo.

El objetivo es que puedas practicar la escritura de información en archivos **mientras el juego continúa funcionando**.

**Pista:** aquí empieza a aparecer un problema interesante: el hilo que ejecuta el juego no debería tener que quedarse esperando cada vez que se escribe algo en el archivo.

---

# 7. Concurrencia

El juego deberá utilizar varios hilos.

Como mínimo, deberá existir un sistema encargado de realizar alguna tarea de manera independiente al flujo principal del juego.

Por ejemplo:

### Guardado automático

Cada cierto tiempo, el juego realizará un guardado automático de la partida.

El jugador debería poder continuar jugando mientras este guardado ocurre.

### Registro de eventos

Los eventos producidos por el juego podrán enviarse a un sistema encargado de escribirlos en el archivo de log de manera independiente.

### Eventos de la mazmorra

Opcionalmente, puedes añadir eventos que ocurran aunque el jugador no esté realizando ninguna acción:

```text
Un mercader ha aparecido en la sala 3.

...

Un enemigo errante se ha movido por la mazmorra.

...

La puerta de la sala 7 se ha cerrado.
```

Estos eventos pueden servir para experimentar con tareas ejecutándose en segundo plano.

No es necesario implementar todos estos sistemas. **Dos sistemas concurrentes bien planteados son preferibles a cinco implementados de manera superficial.**

---

# 8. El problema de los datos compartidos

En algún momento del proyecto tendrás varios hilos que necesiten acceder al mismo estado.

Por ejemplo:

```text
Hilo principal
      ↓
   Player
      ↑
      │
Guardado automático
```

El jugador puede cambiar su vida, inventario o puntuación mientras otro hilo intenta guardar esos mismos datos.

Deberás plantearte:

* ¿Qué ocurre si dos hilos modifican el mismo dato?
* ¿Qué ocurre si un hilo está leyendo mientras otro modifica?
* ¿Qué partes del estado necesitan protección?
* ¿Dónde debería utilizarse sincronización?
* ¿Tiene sentido bloquear todo el objeto?
* ¿Hay alguna operación que deba ser atómica?

El objetivo no es utilizar `synchronized` en todas partes.

**Primero intenta encontrar una situación real de concurrencia y después decide cómo solucionarla.**

Puedes investigar conceptos como:

* `Thread`
* `Runnable`
* `ExecutorService`
* `synchronized`
* `Lock`
* `volatile`
* `ConcurrentHashMap`
* `AtomicInteger`

No es obligatorio utilizar todos ellos.

---

# 9. Estadísticas

Al terminar una partida, el juego deberá mostrar un resumen:

```text
========== PARTIDA TERMINADA ==========

Jugador: Aragorn

Enemigos derrotados: 12
Enemigos escapados: 3
Objetos encontrados: 18
Daño realizado: 342
Daño recibido: 210
Puntuación: 1.240

========================================
```

Puedes almacenar estadísticas adicionales si encuentras alguna que tenga sentido.

**Pista:** piensa qué estructura de datos utilizarías si quisieras registrar diferentes estadísticas identificadas por un nombre.

---

# 10. Requisitos técnicos

El proyecto deberá utilizar, como mínimo:

* Clases y objetos.
* Encapsulación.
* Herencia y/o interfaces.
* Polimorfismo.
* `ArrayList`.
* `HashMap`.
* Excepciones.
* Entrada por consola.
* Lectura y escritura de archivos.
* Al menos un sistema de guardado.
* Al menos un sistema de logging.
* Varios hilos.
* Algún mecanismo de sincronización o coordinación entre hilos.
* Una estructura de proyecto razonablemente organizada.

No es necesario utilizar frameworks externos.

---

# 11. Requisitos de diseño

No se busca que el proyecto tenga cientos de clases.

Sin embargo, intenta evitar una clase gigantesca como:

```text
Game.java
    ├── lee teclado
    ├── combate
    ├── crea enemigos
    ├── guarda partidas
    ├── carga partidas
    ├── escribe logs
    ├── gestiona inventario
    ├── controla hilos
    └── imprime absolutamente todo
```

Piensa qué responsabilidades pertenecen realmente a cada parte del programa.

El diseño final queda en tus manos.

---

# 12. Nivel de dificultad

El proyecto está pensado para alguien que ya conoce los fundamentos de Java y quiere **consolidarlos mediante un proyecto completo**, no para aprender cada concepto desde cero.

No se espera que conozcas de antemano todas las herramientas necesarias para resolverlo.

De hecho, parte del ejercicio consiste en encontrarte con problemas como:

> "Necesito guardar este objeto en un archivo. ¿Cuál es la mejor forma?"

o:

> "Tengo dos hilos accediendo a este `HashMap`. ¿Qué puede salir mal?"

o:

> "El guardado automático está leyendo el inventario mientras el jugador lo modifica."

Cuando aparezca uno de estos problemas, **investígalo y decide qué solución tiene más sentido**, en lugar de buscar simplemente una implementación que haga desaparecer el error.

---

# 13. Bonus

Si quieres ampliar el proyecto, puedes añadir:

* Diferentes niveles de dificultad.
* Más tipos de enemigos.
* Jefes.
* Armas con estadísticas.
* Experiencia y niveles.
* Tienda.
* NPCs.
* Mazmorras generadas aleatoriamente.
* Ranking de mejores partidas.
* Varias partidas guardadas.
* Guardado periódico configurable.
* Sistema de comandos.
* Eventos programados.
* Enemigos que actúan mediante sus propios hilos.
* Un sistema productor/consumidor para los eventos del juego.
* Tests unitarios.

Estos apartados son opcionales. **No añadas funcionalidades nuevas si antes no tienes bien resueltos el modelo de objetos, el I/O y la concurrencia.**

---

## Objetivo final

Al terminar deberías tener un pequeño videojuego de consola que puedas ejecutar desde cero, jugar, guardar, cerrar, volver a abrir y continuar.

Pero el verdadero objetivo del proyecto es que puedas mirar el código y reconocer:

> **"Aquí estoy aplicando OOP."**
> **"Aquí una `ArrayList` tiene sentido."**
> **"Aquí un `HashMap` simplifica el problema."**
> **"Aquí estoy leyendo/escribiendo información."**
> **"Aquí tengo un problema de concurrencia."**
> **"Aquí necesito coordinar dos hilos."**

No existe una única arquitectura correcta para resolverlo. Lo importante será que puedas **justificar las decisiones que tomes**.
