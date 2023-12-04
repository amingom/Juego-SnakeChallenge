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

En la pantalla de juego irán apareciendo enemigos, los cuales aumentarán su frecuencia
dependiendo del nivel de dificultad. Chocar con los enemigos finalizará el juego.
- **Enemigos**.

Los jugadores irán obteniendo puntos al comer los distintos alimentos, el objetivo es
conseguir la mayor cantidad de puntos hasta perder. Se podrá ver la puntuación actual
en la pantalla en tiempo real.

#### __Esquema UML__

```mermaid

 classDiagram   
    abstract LoadingBar --|> Bar extends LoadingBar
    User_Interface <-- Bar extends LoadingBar
    User_Interface <--> Level_Interface
    User_Interface <--> How_To_Play_Interface
    Customization_Interface <--> Level_Interface
    Customization_Interface <--> Cobra_Interface
    Customization_Interface <--> Python_Interface
    Customization_Interface <--> Viper_Interface
    Cobra_Interface -->Game_Interfece
    Python_Interface --> Game_Interfece
    Viper_Interface--> Game_Interfece
    Game_Interfece <--> Defeat_Interface
    Game_Interfece <--> Victory_Interface
    Defeat_Interface --> Level_Interface
    Victory_Interface --> Level_Interface
    interfaceSpeed--|> abstract SpeedDecorator implements Speed
    interfaceSpeed--|> InitialSpeed implements Speed
    abstract SpeedDecorator implements Speed --|> SlowSpeed extends SpeedDecorator
    abstract SpeedDecorator implements Speed --|> MediumSpeed extends SpeedDecorator
    abstract SpeedDecorator implements Speed --|> FastSpeed extends SpeedDecorator
    interfaceSpeed-->Game_Interfece

   class User_Interface{ 
    +void components()
   }
 
    class How_To_Play_Interface{
        + void components()
    }

    class Game_Interfece{
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
	- LinkedList<Point> obstacles;
	- BufferedImage obstacleImage;
	- Customization_Interface animal;
    - long lastDirectionChangeTime; 
	- static final long minimunTime;
    - Level_Interface level; 
	- int speed;
	- int amountObstacles;
    - int appleEaten;
    - int cherryEaten;
    - int bananaEaten;

    
    + void setScore(int _score)
    + int getScore()
    + void components()
    + void spawnFood()
    + boolean obstacleAtPosition(Point position)
    + void spawnEnemy()
    - boolean isObstacleTooCloseToHead(Point obstaclePosition, int minDistance)
    + void draw(Graphics g)
    + void drawHeadImage(Graphics g, int x, int y)
    + void drawBodyImage(Graphics g, int x, int y)
    + void drawFoodImage(Graphics g, String imgPath)
    + void checkCollision()
    - void Defeat()
    - void Victory()
    + void move()
    - void updateFruits()
    - int getGrowthAmount() 
   
    }

    class Level_Interface{
        static private String level
       + void components()
       + String getLevel()
       + static void setLevel(String _level)
    }

    class Customization_Interface{
       static private String animal;
       + void components()
       + String getAnimal()
       + static void setAnimal(String _animal)
    }

     class Cobra_Interface{
        + void components()
     }

     class Python_Interface{
        + void components()
     }

     class Viper_Interface{
        + void components()
     }

     class Defeat_Interface{
       - Interfaz_Juego points
       + void components()
     }

     class Victory_Interface{
       - Interfaz_Juego points
       + void components()
     }

     class interface Speed{
       + int getSpeed()
     }

     class abstract SpeedDecorator implements Speed {
        - Animal snake;
        + AnimalDecorator(Animal slowAnimal)
        + int getVelocidad()

     }

     class abstract LoadingBar{

        + abstract void charge();
        + abstract void completeCharge();

     }

     class Bar extends LoadingBar {

    - JProgressBar progressBar;
    - Timer timer;
    - int progress;
    - JFrame frame;

    + Bar() 
    + void charge()
    + void completeCharge()      
    }

    class FastSpeed extends SpeedDecorator{
        + FastSpeed(Animal snake)
        + int getSpeed()
    }

    class MediumSpeed extends SpeedDecorator{
       + MediumSpeed(Animal snake)
       + int getSpeed()
    }

    class SlowSpeed extends SpeedDecorator{
        + SlowSpeed(Animal snake)
        + int getSpeed()
    }

    class InitialSpeed implements Speed{
       + int getSpeed() 
    }     

```

#### Interfaz de usuario

En la interfaz de usuario aparecerán tres botones, el primero de "Play", donde se
pasará a los tres modos de dificultad, el segundo botón pertenece a "How to play", donde se
muestran las instrucciones de cómo jugar y el tercer boton es el botón de "Exit", para finalizar el juego.


**Barra de carga**

![alt text](https://cdn.discordapp.com/attachments/1155565182584627280/1180902485750198283/image.png?ex=657f1c24&is=656ca724&hm=c2f8f524af51eb23de9c8ba8af26ce34505b5afdaee5657af89ba0488d1bd6cb&)

**Pantalla Inicial**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1180903835963760660/image.png?ex=657f1d66&is=656ca866&hm=79377f711d4b86130891793fa25f76646addd2b05102c81c039cab6c1fd3ef08&=&format=webp&quality=lossless)

**Pantalla de Niveles**

En la interfaz de Niveles aparecerán tres botones, el primero botón corresponde con el nivel "Easy",el segundo botón con el nivel "Medium"
y el tercer botón con el nivel "Hard". Los tres botones tras presionar alguno de ellos, te llevarán a la interfaz de personalización.

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1180904798703337603/image.png?ex=657f1e4c&is=656ca94c&hm=22e9461cb1ebc0ce251f33165083e18297da09bc0c17a729394c7fdf5b4b5439&=&format=webp&quality=lossless)


**Pantalla de Personalización**

En la interfaz de Personalización aparecerán tres botones, el primero botón corresponde con la serpiente "Cobra",el segundo botón con la serpiente "Python"
y el tercer botón con la serpiente "Viper". Los tres botones tras presionar alguno de ellos, te llevarán a la interfaz de dicha serpiente mostrando una descripción
detallada de esta, además de tener dos botones, uno para empezar el juego y otro para volver atras para elegir otras serpientes.

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1180904883939971113/image.png?ex=657f1e60&is=656ca960&hm=1a8e395a7b8125fcdb7f4d0522d2309260697f1e2e8be596ac3d70c22670ef45&=&format=webp&quality=lossless)


**Pantalla de Cómo Jugar**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1181286868256571402/image.png?ex=65808220&is=656e0d20&hm=0fb3ea351f2ed5d8bc16c7acf5541946c56d882a5918a86e8b9faa2bca72bedc&=&format=webp&quality=lossless)


**Marcador y Tablero**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1180896455167332513/marcador.png?ex=657f1686&is=656ca186&hm=857dba9c097653609e999c9fc05680f08426178b0c63a0472348fb2a48d77a3d&=&format=webp&quality=lossless)

![alt text](https://cdn.discordapp.com/attachments/807178652042264596/1176121409999736912/pixil-frame-0_7.png?ex=656db76b&is=655b426b&hm=240acdc0838208d968b2bebb1df41dcae1422a083759e8a1652975eb42f7d369&)

**Personalización de la serpiente**

**Cobra**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1181286953115717652/image.png?ex=65808234&is=656e0d34&hm=797c428430436b307677a7cfba1ba1a4c4e71647cbb923bdbeff853a387c0852&=&format=webp&quality=lossless)

**Pitón.**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1181287022942494853/image.png?ex=65808245&is=656e0d45&hm=8d61233cac012c581de6c10ecf255d62c333e4d10fa7b5ecc95aa58caf0b871f&=&format=webp&quality=lossless)

**Víbora**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1180905375143317574/image.png?ex=657f1ed5&is=656ca9d5&hm=f02ef110edb01812cab326fc8119eb3e7f7d63c36354a611ee77e565768f8419&=&format=webp&quality=lossless)

**Derrota**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1180905559638167693/image.png?ex=657f1f01&is=656caa01&hm=54c3f8290fa044171db02e015fdfd907accd23fd721e1444c2164e1f0426fe21&=&format=webp&quality=lossless)

**Victoria**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1180906350927167548/image.png?ex=657f1fbe&is=656caabe&hm=91270e86e6b797f49b76fdcb965ad3e48afc715e6394812113f0fc69141430ab&=&format=webp&quality=lossless)


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

**Enemigo**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1179921152936775827/Enemy.png?ex=657b8a34&is=65691534&hm=a2f85219be937fcaa44d10b7b77631efcf07a0f02b121579bb32ab438301584c&=&format=webp&quality=lossless)

**Juego en accion**

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1180905505376456745/image.png?ex=657f1ef4&is=656ca9f4&hm=4b43028403242ce613cd9596c3751b609e21e0b65b344e10c65c1242de13c2e2&=&format=webp&quality=lossless)

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1180905753352089650/image.png?ex=657f1f2f&is=656caa2f&hm=354b6e67d16d79e97c67b820f4a60d14c1371300ca4d44a2a2d4a7702a28a248&=&format=webp&quality=lossless)

![alt text](https://media.discordapp.net/attachments/1155565182584627280/1180905920453152869/image.png?ex=657f1f57&is=656caa57&hm=94396631fbe700aa18f715030fec5ce54a74fa02fbcf9c1620548cb8820f34f0&=&format=webp&quality=lossless)




