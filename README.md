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

**Pantalla de Niveles**

En la interfaz de Niveles aparecerán tres botones, el primer botón corresponde con el nivel "Easy", el segundo botón con el nivel "Medium"
y el tercer botón con el nivel "Hard". Los tres botones tras presionar alguno de ellos, te llevarán a la interfaz de personalización.

**Pantalla de Personalización**

En la interfaz de Personalización aparecerán tres botones, el primer botón corresponde con la serpiente "Cobra", el segundo botón con la serpiente "Python"
y el tercer botón con la serpiente "Viper". Los tres botones tras presionar alguno de ellos, te llevarán a la interfaz de dicha serpiente mostrando una descripción
detallada de esta, además de tener dos botones, uno para empezar el juego y otro para volver atrás para elegir otras serpientes.
