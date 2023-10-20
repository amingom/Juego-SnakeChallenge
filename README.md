#  Snake Challenge
## Desarrolladores:
- Diego Hernández García-Panadero. 
- Álvaro Mingo Muñoz.

###  Descripción
El juego es una versión mejorada del juego Snake. Los jugadores manejarán una
serpiente hambrienta que come alimentos para crecer y acumular puntos.hola

La serpiente está en constante movimiento, se desplaza en busca de comida y cuanto
más coma, más crecerá.
En este juego se busca añadir diferentes tipos de alimentos, cada uno con un valor
distinto de puntos.
- **Manzana**. (1p)
- **Cereza**. (2p)
- **Plátano**. (3p)

En la pantalla de juego irán apareciendo obstáculos, los cuales aumentarán su frecuencia
dependiendo del nivel de dificultad. Chocar con alguno de estos obstáculos finalizará el juego.
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
    JUEGOSERPIENTE <|-- Interfaz_Usuario
    JUEGOSERPIENTE <|-- Interfaz_Como_Jugar
    JUEGOSERPIENTE <|-- Interfaz_juego_facil
    JUEGOSERPIENTE <|-- Interfaz_Niveles
    JUEGOSERPIENTE <|-- Interfaz_Personalizar
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

   class Interfaz_Usuario{ 
    +void iniciarComponentes()
   }
 

    class Interfaz_Como_Jugar{
        + void iniciarComponentes()
    }


    class Interfaz_juego_facil{
    - JPanel gamePanel;
    - LinkedList<Point> snake;
    - Timer timer;
    - int direction;
    + void iniciarComponentes()
    + void draw()
    + void move()


    }

    class Interfaz_Niveles{
       + void iniciarComponentes()
    }

      class Interfaz_Personalizar{
       + void iniciarComponentes()
    }

```

#### Interfaz de usuario

En la interfaz de usuario aparecerán cuatro botones, el primero de jugar, donde se
pasará a los tres modos de dificultad, el segundo botón pertenece cómo jugar, donde se
muestran las instrucciones de cómo jugar, el tercer botón sirve para personalizar la skin
de la serpiente y el cuarto es el botón de salir, para finalizar el juego.


**Pantalla Inicial.**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1163522723784441980/image.png?ex=653fe1fa&is=652d6cfa&hm=c5122c48605ef8b9f7f2e79e3e75f737c8660ed699145fe0269c00286d5f617a&)

**Pantalla de Niveles**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1163522767258398760/image.png?ex=653fe204&is=652d6d04&hm=4f8709773805420dbd7b68c391b10579f42b957cccf730f9e0d27b6e4d7afa5d&)


**Pantalla de Personalización**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1163522953590341722/image.png?ex=653fe231&is=652d6d31&hm=3259e88cf23c21f90e328d811e836cdfc424f8890702261b717d1cee8afe7c08&)


**Pantalla de Cómo Jugar**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1163522890042441728/image.png?ex=653fe222&is=652d6d22&hm=8e2046f2f04d3953e92e93569775c58dceac48ee1f75361edd4f26ba2e50a7c3&)


**Marcador y Tablero.**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1162155862111047710/image.png?ex=653ae8fd&is=652873fd&hm=47213d759133f3cea613afac45ac06b4d070ee0e3b5f7e4f76a9ad5ebf82ae06&)

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1160891183246090320/image.png?ex=65364f2a&is=6523da2a&hm=146db4d04415454f520c7e7c8e678871539bd7d31f2886d9eb27c0286f253af9&)

**Personalización de la serpiente.**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1162155529745989723/image.png?ex=653ae8ae&is=652873ae&hm=01a85eea248d3f839e091049215ccb200170b3721384898301bdc29f250f517c&)




