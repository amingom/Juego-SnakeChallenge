#  Snake Challenge
## Desarrolladores:
- Diego Hernández García-Panadero. 
- Álvaro Mingo Muñoz.

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
dependiendo del nivel de dificultad. Chocar con alguno de estos obstáculos finalizará el juego.
- **Rocas**.
- **Muros**.

Los jugadores irán obteniendo puntos al comer los distintos alimentos, el objetivo es
conseguir la mayor cantidad de puntos hasta perder. Se podrá ver la puntuación actual
en la pantalla en tiempo real.

#### __Esquema UML__

```mermaid

classDiagram
    JUEGOSERPIENTE <|-- Interfaz_Usuario
    Interfaz_Usuario <|-- Interfaz_Como_Jugar
    Interfaz_Cobra <|-- Interfaz_juego_facil
    Interfaz_Piton <|-- Interfaz_juego_facil
    Interfaz_Vibora <|-- Interfaz_juego_facil
    Interfaz_Usuario <|-- Interfaz_Niveles
    Interfaz_Niveles <|-- Interfaz_Personalizar
    Interfaz_Personalizar <|-- Interfaz_Cobra
    Interfaz_Personalizar <|-- Interfaz_Piton
    Interfaz_Personalizar <|-- Interfaz_Vibora


    JUEGOSERPIENTE : -Snake snake
    JUEGOSERPIENTE : -LinkedList<Food>foods
    JUEGOSERPIENTE : -LinkedList<Obstacle>obstacles
    JUEGOSERPIENTE : -LinkedList<Food>foods
    JUEGOSERPIENTE : +SnakeGame()
    JUEGOSERPIENTE : +Void Start()
    JUEGOSERPIENTE: +Void checkCollisions()
    JUEGOSERPIENTE: +Void spawnFood()

    

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
    - private Point food;
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

     class Interfaz_Cobra{
        + void iniciarComponentes()
     }

     class Interfaz_Piton{
        + void iniciarComponentes()
     }

     class Interfaz_Vibora{
        + void iniciarComponentes()
     }

```

#### Interfaz de usuario

En la interfaz de usuario aparecerán cuatro botones, el primero de jugar, donde se
pasará a los tres modos de dificultad, el segundo botón pertenece cómo jugar, donde se
muestran las instrucciones de cómo jugar, el tercer botón sirve para personalizar la skin
de la serpiente y el cuarto es el botón de salir, para finalizar el juego.


**Pantalla Inicial.**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1171145032158412861/image.png?ex=655b9cce&is=654927ce&hm=22dd7376a5a56399ca134348a1c64d6335a4383f089b9e9c7fb318866a3390d4&=)

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


**Cobra.**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1171136205354700981/cobra.png?ex=655b9496&is=65491f96&hm=34b27f165e6cd8570b7753ccb858dd570567add485d2557b619c98ed05c9dec1&)

**Pitón.**
![alt text](https://cdn.discordapp.com/attachments/1159130537831694397/1170875111197376542/piton.jpg?ex=655aa16c&is=65482c6c&hm=a0a31393de1f4aae8ff60a1d76c93e3e5ca9d1f4f8bba3aaeb1623b84be6cf11&)

**Víbora.**
![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1171136377115643914/vibora.png?ex=655b94be&is=65491fbe&hm=afc943d30d697bdd1e86f0d41578d084b59009a781755241199ba378ab074333&)



