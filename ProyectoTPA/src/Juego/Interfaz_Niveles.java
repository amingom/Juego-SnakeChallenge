package Juego;

/**
 * Esta clase representa la interfaz de seleccion de niveles en el juego Snake Challenge.
 * Permite al jugador elegir entre diferentes niveles de dificultad.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz_Niveles extends JFrame{


    /**
     * Constructor de la clase que configura la interfaz de seleccion de niveles.
     * Establece el tamaño, titulo, posicion y otros aspectos de la ventana.
     */
	public Interfaz_Niveles() {

		setSize(700,700);                                                       //ancho largo

		setTitle("Snake Challenge");                                          //establecemos el titulo de la ventana	

		setLocationRelativeTo(null); 									    //establecemos la ventana en el centro de la pantalla

		this.getContentPane().setBackground(Color.green);				  //establecemos el color de la ventana

		iniciarComponentes(); 											//Inicia los botones , imagenes...

		setDefaultCloseOperation(EXIT_ON_CLOSE);					  //hace que termine el programa al cerrar la ventana

	}
	
	/**
     * Inicializa los componentes visuales de la interfaz de seleccion de niveles.
     * Crea un panel, etiquetas de texto y botones para diferentes niveles de dificultad.
     */
	void iniciarComponentes() {

		JPanel niveles = new JPanel();    									// creacion de un panel		
		niveles.setBackground(Color.green); 							   //establecemos el color del panel
		niveles.setLayout(null);  										  //desactiva su diseño
		this.getContentPane().add(niveles);                              //agregamos el panel a la ventana
		JLabel Niveles1 = new JLabel();                                 //creamos una etiqueta de texto		
		Niveles1.setText("NIVELES");                                   //establecemos el texto de la etiqueta
		Niveles1.setBounds(-60,20,800,100);
		Niveles1.setHorizontalAlignment(SwingConstants.CENTER);      //centramos el texto en la etiqueta
		Niveles1.setForeground(Color.BLACK);            	        //establecemos el color del texto
		Niveles1.setOpaque(true);   							   // establecemos el poder pintar la etiqueta
		Niveles1.setBackground(Color.green);                      //cambiamos el color del fondo de la etiqueta
		Niveles1.setFont(new Font("arial",Font.BOLD,50));        //establecemos la fuente del texto	
		niveles.add(Niveles1);                                  //agregamos la etiqueta al panel

		JButton Facil = new JButton();  							//creamos el boton
		Facil.setText("Facil");								       //establecemos texto al boton
		Facil.setBounds(178,150,300,70);  						  //tamaño y posicion del boton
		Facil.setEnabled(true);  								 //habilita o deshabilita el click		
		Facil.setForeground(Color.BLACK); 						//color de las letras del boton
		Facil.setBackground(Color.WHITE);					   //color del boton
		Facil.setFont(new Font("algerian",Font.BOLD,40)); 	  //fuente de la letra del boton
		Facil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_juego_facil ventanaJuegoFacil = new Interfaz_juego_facil();
				ventanaJuegoFacil.setVisible(true);
			}
		});
		niveles.add(Facil);

		JButton Medio = new JButton(); 							    //creamos el boton
		Medio.setText("Medio");									   //establecemos texto al boton
		Medio.setBounds(178,300,300,70);  						  //tamaño y posicion del boton
		Medio.setEnabled(true);  								 //habilita o deshabilita el click		
		Medio.setForeground(Color.BLACK); 						//color de las letras del boton
		Medio.setBackground(Color.WHITE); 					   //color del boton
		Medio.setFont(new Font("algerian",Font.BOLD,40));     //fuente de la letra del boton
		niveles.add(Medio);

		JButton Dificil = new JButton(); 							//creamos el boton
		Dificil.setText("Dificil");								   //establecemos texto al boton
		Dificil.setBounds(178,450,300,70); 						  //tamaño y posicion del boton
		Dificil.setEnabled(true);  								 //habilita o deshabilita el click		
		Dificil.setForeground(Color.BLACK); 					//color de las letras del boton
		Dificil.setBackground(Color.WHITE); 				   //color del boton
		Dificil.setFont(new Font("algerian",Font.BOLD,40));   //fuente de la letra del boton
		niveles.add(Dificil);

		JButton Atras = new JButton(); 							   //creamos el boton
		Atras.setText("Atras");									  //establecemos texto al boton
		Atras.setBounds(50,600,150,40); 						 //tamaño y posicion del boton
		Atras.setEnabled(true);  								//habilita o deshabilita el click		
		Atras.setForeground(Color.BLACK); 					   //color de las letras del boton
		Atras.setBackground(Color.WHITE);				      //color del boton
		Atras.setFont(new Font("algerian",Font.BOLD,20));    //fuente de la letra del boton
		niveles.add(Atras);
		Atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Usuario ventanaInicial = new Interfaz_Usuario();
				ventanaInicial.setVisible(true); 
				((JFrame) SwingUtilities.getWindowAncestor(Atras)).dispose();  //cierra la ventana
			}
		});
		niveles.add(Atras);
	}
}
