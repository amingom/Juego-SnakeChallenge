#  Snake Challenge
##  Autores: Diego Hernández García-Panadero y Álvaro Mingo Muñoz
========================================================

###  Descripción
El juego es una versión mejorada del juego Snake. Los jugadores manejarán una
serpiente hambrienta que come alimentos para crecer y acumular puntos.

La serpiente está en constante movimiento, se desplaza en busca de comida y cuanto
más coma, más crecerá.
En este juego se busca añadir diferentes tipos de alimentos, cada uno con un valor
distinto de puntos.
- **Manzana**. (1p)
- **Cereza**. (2p)
- **Plátano**. (3p)

En la pantalla de juego irán apareciendo obstáculos, los cuales aumentarán su frecuencia
dependiendo del nivel de dificultad.Chocar con alguno de estos obstaculos finalizará el juego.
- **Rocas**.
- **Muros**.

Los jugadores irán obteniendo puntos al comer los distintos alimentos, el objetivo es
conseguir la mayor cantidad de puntos hasta perder. Se podrá ver la puntuación actual
en la pantalla en tiempo real.

#### __Esquema UML__

```mermaid

classDiagram
    JUEGOSERPIENTE <|-- Food
    JUEGOSERPIENTE <|-- Obstacle
    JUEGOSERPIENTE <|-- Snake
    MANZANA--|> Food
    CEREZA --|> Food
    BANANA --|> Food
    ROCA --|> Obstacle
    MURO --|> Obstacle

    JUEGOSERPIENTE : -Snake snake
    JUEGOSERPIENTE : -LinkedList<Food>foods
    JUEGOSERPIENTE : -LinkedList<Obstacle>obstacles
    JUEGOSERPIENTE : -LinkedList<Food>foods
    JUEGOSERPIENTE : +SnakeGame()
    JUEGOSERPIENTE : +Void Start()
    JUEGOSERPIENTE: +Void checkCollisions()
    JUEGOSERPIENTE: +Void spawnFood()

    class Snake{
    - LinkedList<Point> body
    - Direction direction
    + void move()
    + Point calculateNewHead()
    + void setDirection()
    }
    class Food{
    - Point position;
    - int points;
    + void draw()
    + Object getLocation()
    }

    class MANZANA{
    - Point position;
    - int points;
    + void draw()
    + Object getLocation()
    }

      class CEREZA{
    - Point position;
    - int points;
    + void draw()
    + Object getLocation()
    }

      class BANANA{
    - Point position;
    - int points;
    + void draw()
    + Object getLocation()
    }

    class Obstacle{
      - Point position;
      + Point getPosition() 
      + void draw()
      + Object getLocation()
    }

        class ROCA{
      - Point position;
      + Point getPosition() 
      + void draw()
      + Object getLocation()
    }


        class MURO{
      - Point position;
      + Point getPosition() 
      + void draw()
      + Object getLocation()
    }
```

##### Interfaz de usuario

**Pantalla inicial**

Inline-style: 
![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1159827014056943726/Interfaz_Usuario.png?ex=65327014&is=651ffb14&hm=a07f02bfe6479d2d3478bab8061b62e685575866acbee8268320f27fd0c8a4dd&)


