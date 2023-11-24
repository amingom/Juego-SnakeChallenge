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
- **Enemigos**.
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
    Interfaz_Pantalla_final <|-- Interfaz_juego_facil
    Interfaz_juego_facil <|-- Interfaz_Pantalla_final
    Interfaz_Niveles <|-- Interfaz_Pantalla_final

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
	- Point food;
	- int foodType;
	- int score; 
	- JLabel scoreLabel;
	- BufferedImage headImage;
	- BufferedImage bodyImage;
	- Point obstacle;
	- BufferedImage obstacleImage;
	- String animal;
        - long lastDirectionChangeTime; 
	- static final long tiempoMinimo;



    + void setScore(int _score)
    + int getScore()
    + void updateScoreLabel()
    + void updateScoreLabel()
    + void checkCollision()
    + void drawFoodImage(Graphics g, String imgPath)
    + void drawBodyImage(Graphics g, int x, int y)
    + void drawHeadImage(Graphics g, int x, int y)
    + void spawnFood()
    + void iniciarComponentes()
    + void draw(Graphics g)
    + void move()
    - void abrirNuevaInterfaz()


    }

    class Interfaz_Niveles{
       + void iniciarComponentes()
    }

    class Interfaz_Personalizar{
        static - String animal;

       + void iniciarComponentes()
       + String getAnimal()
       + static void setAnimal(String _animal)
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

     class Interfaz_Pantalla_final{
        - Interfaz_juego_facil puntos;


        + void iniciarComponentes()
     }


    


```

#### Interfaz de usuario

En la interfaz de usuario aparecerán cuatro botones, el primero de jugar, donde se
pasará a los tres modos de dificultad, el segundo botón pertenece cómo jugar, donde se
muestran las instrucciones de cómo jugar, el tercer botón sirve para personalizar la skin
de la serpiente y el cuarto es el botón de salir, para finalizar el juego.


**Pantalla Inicial**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1171145032158412861/image.png?ex=655b9cce&is=654927ce&hm=22dd7376a5a56399ca134348a1c64d6335a4383f089b9e9c7fb318866a3390d4&=)

**Pantalla de Niveles**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1163522767258398760/image.png?ex=653fe204&is=652d6d04&hm=4f8709773805420dbd7b68c391b10579f42b957cccf730f9e0d27b6e4d7afa5d&)


**Pantalla de Personalización**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1163522953590341722/image.png?ex=653fe231&is=652d6d31&hm=3259e88cf23c21f90e328d811e836cdfc424f8890702261b717d1cee8afe7c08&)


**Pantalla de Cómo Jugar**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1163522890042441728/image.png?ex=653fe222&is=652d6d22&hm=8e2046f2f04d3953e92e93569775c58dceac48ee1f75361edd4f26ba2e50a7c3&)


**Marcador y Tablero**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1176214816470351912/pixil-frame-0_1.png?ex=656e0e69&is=655b9969&hm=0e0e20d461ebeed00b1d9a791b40b3dbb9f7d70039eeb60d0eb81ce08ec8a7b2&=)

![alt text](https://cdn.discordapp.com/attachments/807178652042264596/1176121409999736912/pixil-frame-0_7.png?ex=656db76b&is=655b426b&hm=240acdc0838208d968b2bebb1df41dcae1422a083759e8a1652975eb42f7d369&)

**Personalización de la serpiente**


**Cobra**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1171136205354700981/cobra.png?ex=655b9496&is=65491f96&hm=34b27f165e6cd8570b7753ccb858dd570567add485d2557b619c98ed05c9dec1&)

**Pitón.**

![alt text](https://cdn.discordapp.com/attachments/1159130537831694397/1170875111197376542/piton.jpg?ex=655aa16c&is=65482c6c&hm=a0a31393de1f4aae8ff60a1d76c93e3e5ca9d1f4f8bba3aaeb1623b84be6cf11&)

**Víbora**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1171136377115643914/vibora.png?ex=655b94be&is=65491fbe&hm=afc943d30d697bdd1e86f0d41578d084b59009a781755241199ba378ab074333&)



**Cobra en el juego**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1175855554636288122/cabeza_cobra_derecha.png?ex=656cbfd2&is=655a4ad2&hm=de43ef62a4ce0386425e2215b82ae88cc82428d1cb9a0b192569d96420b170bd&)

![alt text](https://cdn.discordapp.com/attachments/807178652042264596/1175858479269953576/cobra_cabeza_izquierda_preview_rev_1.png?ex=656cc28b&is=655a4d8b&hm=feeb3d4c7072daba086e09e861aea5f617994b77e6d4da585c681bcfbc38549f&)

![alt text](https://cdn.discordapp.com/attachments/807178652042264596/1175858479538393098/cobra_cabeza_arriba_preview_rev_1.png?ex=656cc28b&is=655a4d8b&hm=6482a8d423ae8dca638d47a2a3b1c2db8396f4e7f54111664655fe948e0b7a53&)

![alt text](https://media.discordapp.net/attachments/807178652042264596/1175858479865532426/cobra_cabeza_abajo_preview_rev_1.png?ex=656cc28b&is=655a4d8b&hm=53a850ee824aa278fb1eaba9963f14f04ffbe181c0dcd8dad6fb315b5d3674fd&=)

**Pitón en el juego**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1175577503109230692/piton_cabeza_izquierda.png?ex=656bbcdd&is=655947dd&hm=080866df483ccbef970c4c04946dafb585536d2267146d2d701e277f6c954459&)

![alt text](https://cdn.discordapp.com/attachments/807178652042264596/1175857226762702918/piton_cabeza_arriba_preview_rev_1.png?ex=656cc161&is=655a4c61&hm=32763b1f6819b7ba2c959b56b669de6ee799e078d4c07f5cc198d6c05674f7b3&)

![alt text](https://cdn.discordapp.com/attachments/807178652042264596/1175857227094040606/piton_cabeza_abajo_preview_rev_1.png?ex=656cc161&is=655a4c61&hm=d46dcbe81be8cf07b828fb55a094e1b29eb4cdf37f03bfdd5c0176d04c36ba60&)

![alt text](https://cdn.discordapp.com/attachments/807178652042264596/1175857227387645983/piton_cabeza_derecha_preview_rev_1.png?ex=656cc161&is=655a4c61&hm=bd607a0603f557a131cc4d93fa5cb5f13938a5454559919b5df34521b5569f21&)

**Víbora en el juego**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1175575432813350963/vibora_cabexa_izquierda.png?ex=656bbaf0&is=655945f0&hm=afdd2d7bc9536bc0602aa7f3c132d5b90f5f921fe26b388ed53df92905050369&)

![alt text](https://cdn.discordapp.com/attachments/807178652042264596/1175856434903257158/vibora_cabeza_derecha_preview_rev_1.png?ex=656cc0a4&is=655a4ba4&hm=5f813b487369e947b4f57bbde0d0987a6827e5a75118806bc02a0a20d3731fea&)

![alt text](https://cdn.discordapp.com/attachments/807178652042264596/1175856694664900739/vibora_cabeza_abajo_preview_rev_1.png?ex=656cc0e2&is=655a4be2&hm=d4fcb647fd718066b4467a78d8f1b31c2c8614a1c7e80c5d9aa7d37f356e0dd9&)

![alt text](https://cdn.discordapp.com/attachments/807178652042264596/1175856849447301180/vibora_cabeza_arriba_preview_rev_1.png?ex=656cc107&is=655a4c07&hm=7a9a0ba8019c175ccf1582e31a37dcd677afb72d97963810dd7b23b14c1bbb73&)

**Comida**

**Manzana**

![alt text](https://media.discordapp.net/attachments/807178652042264596/1172560418649165854/apple.png?ex=6569fd7c&is=6557887c&hm=208ec42c43ae7b5d986f5771c06bac398acc5def5f9d6b346da72803de656b55&=&format=webp)

**Cereza**

![alt text](https://media.discordapp.net/attachments/807178652042264596/1172560418384912454/cherry.png?ex=6569fd7c&is=6557887c&hm=fdddc8047fb0fc7cdd9cd53270b9862ec7d7c86c4ba888c6b68ca0257b56436f&=&format=webp&width=676&height=676)

**Platano**

![alt text](https://media.discordapp.net/attachments/807178652042264596/1172560418049380445/banana.png?ex=6569fd7c&is=6557887c&hm=e8a015466f0d7e62b8256d236ccc2c8ecea32741fb8fd202c445f108d7a58b13&=&format=webp)

