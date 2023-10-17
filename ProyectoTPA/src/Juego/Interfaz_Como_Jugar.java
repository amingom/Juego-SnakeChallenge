package Juego;

/**
 * Esta clase representa la interfaz de "Como Jugar" en el juego Snake Challenge.
 * Proporciona informacion sobre las reglas y controles del juego.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz_Como_Jugar extends JFrame {
	
	/**
     * Constructor de la clase que configura la interfaz "Como Jugar".
     * Establece el tamaño, titulo, posicion y otros aspectos de la ventana.
     */
	public Interfaz_Como_Jugar() {

		setSize(700,700);                                                               //ancho largo

		setTitle("Snake Challenge");                                                  //establecemos el titulo de la ventana	

		setLocationRelativeTo(null);                                                //establecemos la ventana en el centro de la pantalla

		this.getContentPane().setBackground(Color.green);                         //establecemos el color de la ventana

		iniciarComponentes();                                                   //Inicia los botones , imagenes...

		setDefaultCloseOperation(EXIT_ON_CLOSE);                              //hace que termine el programa al cerrar la ventana

	}
	
	/**
     * Inicializa los componentes visuales de la interfaz "Como Jugar".
     * Crea un panel, etiquetas de texto y un botón de "Atras".
     */
	void iniciarComponentes() {

		JPanel ComoJugar = new JPanel();                                           // creacion de un panel		
		ComoJugar.setBackground(Color.LIGHT_GRAY);                                //establecemos el color del panel
		ComoJugar.setLayout(null);                                               //desactiva su diseño
		this.getContentPane().add(ComoJugar);                                   //agregamos el panel a la ventana

		JLabel Comojugar = new JLabel();                                      //creamos una etiqueta de texto		
		Comojugar.setText("Cómo jugar");                                     //establecemos el texto de la etiqueta
		Comojugar.setBounds(-60,20,800,100);
		Comojugar.setHorizontalAlignment(SwingConstants.CENTER);           //centramos el texto en la etiqueta
		Comojugar.setForeground(Color.BLACK);                             //establecemos el color del texto
		Comojugar.setOpaque(true);                                       // establecemos el poder pintar la etiqueta
		Comojugar.setBackground(Color.LIGHT_GRAY);                      //cambiamos el color del fondo de la etiqueta
		Comojugar.setFont(new Font("arial",Font.BOLD,50));             //establecemos la fuente del texto	
		ComoJugar.add(Comojugar);                                     //agregamos la etiqueta al panel

		JLabel Instrucciones = new JLabel();                                                                        //creamos una etiqueta de texto		
		Instrucciones.setText("El Snake Challenge es un juego que consiste en conseguir la mayor cantidad de puntos\n"
				+ " antes de terminar la partida.\n"
				+ " \nEl jugador debe dirigir a la serpiente hacia la comida esquivando todos los obstáculos y\n"
				+ " los bordes del mapa para que la partida no finalice.\n"
				+ " \nLos controles son las teclas w, a, s, d, que sirven para subir, derecha, abajo e izquierda\n"
				+ " respectivamente.\n"
				+ " \nLos puntos se conseguirán al alimentar a la serpiente y ésta a su vez irá creciendo.\n"
				+ " \nHay distintos tipos de alimentos que harán crecer de distinta manera a la serpiente y\n"
				+ " tendrán distinto valor de puntos.\n"
				+ " \nEl jugador podrá ver la puntuación en tiempo real a través del marcador en la parte \n"
				+ " superior de la pantalla.\n");       //establecemos el texto de la etiqueta

		Instrucciones.setText("<html>" + Instrucciones.getText().replaceAll("\n", "<br/>") + "</html>");
		Instrucciones.setBounds(-50,40,800,500);
		Instrucciones.setHorizontalAlignment(SwingConstants.CENTER);                  //centramos el texto en la etiqueta
		Instrucciones.setForeground(Color.BLACK);                                    //establecemos el color del texto
		Instrucciones.setOpaque(true);                                              // establecemos el poder pintar la etiqueta
		Instrucciones.setBackground(Color.LIGHT_GRAY);                             //cambiamos el color del fondo de la etiqueta
		Instrucciones.setFont(new Font("arial",Font.BOLD,15));                    //establecemos la fuente del texto	
		ComoJugar.add(Instrucciones);                                            //agregamos la etiqueta al panel

		JButton Atras = new JButton();                                         //creamos el boton
		Atras.setText("Atras");	                                              //establecemos texto al boton
		Atras.setBounds(50,600,150,40);                                      //tamaño y posicion del boton
		Atras.setEnabled(true);                                             //habilita o deshabilita el click		
		Atras.setForeground(Color.BLACK);                                  //color de las letras del boton
		Atras.setBackground(Color.WHITE);
		Atras.setFont(new Font("algerian",Font.BOLD,20));                //fuente de la letra del boton
		ComoJugar.add(Atras);
		Atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Usuario ventanaInicial = new Interfaz_Usuario();
				ventanaInicial.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Atras)).dispose();  //cierra la ventana

			}
		});
		ComoJugar.add(Atras);                                //agregamos la etiqueta al panel

	}

}
