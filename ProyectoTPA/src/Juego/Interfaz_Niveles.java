package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Esta clase representa la interfaz de seleccion de niveles en el juego Snake Challenge.
 * Permite al jugador elegir entre diferentes niveles de dificultad.
 */

public class Interfaz_Niveles extends JFrame{
	
	static private String nivel;
	
	//Método para obtener el nivel seleccionado
		public String getNivel() {
			return nivel;
		}
		
		//Método que permite establecer el valor de la variable nivel
		public static void setNivel(String _nivel) {
			nivel = _nivel;
		}

	/**
	 * Constructor de la clase que configura la interfaz de seleccion de niveles.
	 * Establece el tamaño, titulo, posicion y otros aspectos de la ventana.
	 */
	public Interfaz_Niveles() {

		setSize(600,600);                                                       //ancho largo

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
		JLabel Niveles = new JLabel();                                 //creamos una etiqueta de texto		
		Niveles.setText("NIVELES");                                   //establecemos el texto de la etiqueta
		Niveles.setBounds(-115,20,800,100);
		Niveles.setHorizontalAlignment(SwingConstants.CENTER);      //centramos el texto en la etiqueta
		Niveles.setForeground(Color.BLACK);            	        //establecemos el color del texto
		Niveles.setOpaque(true);   							   // establecemos el poder pintar la etiqueta
		Niveles.setBackground(Color.green);                      //cambiamos el color del fondo de la etiqueta
		Niveles.setFont(new Font("arial",Font.BOLD,50));        //establecemos la fuente del texto	
		niveles.add(Niveles);                                  //agregamos la etiqueta al panel

		JButton Facil = new JButton();  							//creamos el boton
		Facil.setText("Facil");								       //establecemos texto al boton
		Facil.setBounds(160,130,250,60);  						  //tamaño y posicion del boton
		Facil.setEnabled(true);  								 //habilita o deshabilita el click		
		Facil.setForeground(Color.BLACK); 						//color de las letras del boton
		Facil.setBackground(Color.WHITE);					   //color del boton
		Facil.setFont(new Font("algerian",Font.BOLD,40)); 	  //fuente de la letra del boton
		Facil.setFocusPainted(false);

		//  abre la ventana relacionada con la personalización de las serpientes y cierra la ventana de inicio
		Facil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setNivel("facil");
				Interfaz_Personalizar ventanaNiveles = new Interfaz_Personalizar();
				ventanaNiveles.setVisible(true);    
				((JFrame) SwingUtilities.getWindowAncestor(Facil)).dispose();  //cierra la ventana
			}                      
		});		
		niveles.add(Facil);

		JButton Medio = new JButton(); 							    //creamos el boton
		Medio.setText("Medio");									   //establecemos texto al boton
		Medio.setBounds(160,255,250,60);  						  //tamaño y posicion del boton
		Medio.setEnabled(true);  								 //habilita o deshabilita el click		
		Medio.setForeground(Color.BLACK); 						//color de las letras del boton
		Medio.setBackground(Color.WHITE); 					   //color del boton
		Medio.setFont(new Font("algerian",Font.BOLD,40));     //fuente de la letra del boton
		Medio.setFocusPainted(false);

		//  abre la ventana relacionada con la personalización de las serpientes y cierra la ventana de inicio
		Medio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setNivel("medio");
				Interfaz_Personalizar ventanaPersonalizacion = new Interfaz_Personalizar();
				ventanaPersonalizacion.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Medio)).dispose();  //cierra la ventana

			}
		});

		niveles.add(Medio);

		JButton Dificil = new JButton(); 							//creamos el boton
		Dificil.setText("Dificil");								   //establecemos texto al boton
		Dificil.setBounds(160,380,250,60); 						  //tamaño y posicion del boton
		Dificil.setEnabled(true);  								 //habilita o deshabilita el click		
		Dificil.setForeground(Color.BLACK); 					//color de las letras del boton
		Dificil.setBackground(Color.WHITE); 				   //color del boton
		Dificil.setFont(new Font("algerian",Font.BOLD,40));   //fuente de la letra del boton
		Dificil.setFocusPainted(false);

		//  abre la ventana relacionada con la personalización de las serpientes y cierra la ventana de inicio
		Dificil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setNivel("dificil");
				Interfaz_Personalizar ventanaPersonalizacion = new Interfaz_Personalizar();
				ventanaPersonalizacion.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Dificil)).dispose();  //cierra la ventana

			}
		});

		niveles.add(Dificil);

		JButton Atras = new JButton(); 							   //creamos el boton
		Atras.setText("Atras");									  //establecemos texto al boton
		Atras.setBounds(10,510,150,40); 						 //tamaño y posicion del boton
		Atras.setEnabled(true);  								//habilita o deshabilita el click		
		Atras.setForeground(Color.BLACK); 					   //color de las letras del boton
		Atras.setBackground(Color.WHITE);				      //color del boton
		Atras.setFont(new Font("algerian",Font.BOLD,20));    //fuente de la letra del boton
		Atras.setFocusPainted(false);
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
