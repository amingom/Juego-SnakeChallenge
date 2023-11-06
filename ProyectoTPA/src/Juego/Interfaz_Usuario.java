package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Esta clase representa la interfaz de usuario principal del juego Snake Challenge.
 * Permite a los jugadores acceder a diferentes opciones, como jugar, aprender a jugar, personalizar y salir.
 */

public class Interfaz_Usuario extends JFrame {

	/**
	 * Constructor de la clase que configura la interfaz de usuario principal.
	 * Establece el tamaño, titulo, posicion y otros aspectos de la ventana.
	 */
	public Interfaz_Usuario() {

		setSize(700,700);  //ancho largo

		setTitle("Snake Challenge");  //establecemos el titulo de la ventana	

		setLocationRelativeTo(null);  //establecemos la ventana en el centro de la pantalla

		this.getContentPane().setBackground(Color.orange);//establecemos el color de la ventana

		iniciarComponentes(); //Inicia los botones , imagenes...

		setDefaultCloseOperation(EXIT_ON_CLOSE); //hace que termine el programa al cerrar la ventana		

	}

	/**
	 * Inicializa los componentes visuales de la interfaz de usuario principal.
	 * Crea un panel, etiquetas de texto y botones para diferentes opciones.
	 */
	void iniciarComponentes() {

		JPanel panel = new JPanel();    // creacion de un panel		
		panel.setBackground(Color.orange);  //establecemos el color del panel
		panel.setLayout(null);  //desactiva su diseño
		this.getContentPane().add(panel);  //agregamos el panel a la ventana

		// Etiqueta de texto (titulo del juego)

		JLabel TituloJuego = new JLabel();     //creamos una etiqueta de texto		
		TituloJuego.setText("SNAKE CHALLENGE");     //establecemos el texto de la etiqueta
		TituloJuego.setBounds(-60,20,800,100);
		TituloJuego.setHorizontalAlignment(SwingConstants.CENTER);   //centramos el texto en la etiqueta
		TituloJuego.setForeground(Color.BLACK);     //establecemos el color del texto
		TituloJuego.setOpaque(true);    // establecemos el poder pintar la etiqueta
		TituloJuego.setBackground(Color.orange);    //cambiamos el color del fondo de la etiqueta
		TituloJuego.setFont(new Font("arial",Font.BOLD,50));    //establecemos la fuente del texto	
		panel.add(TituloJuego);     //agregamos la etiqueta al panel

		// Botones de la pantalla inicial

		// Boton para Como jugar

		JButton ComoJugar = new JButton(); //creamos el boton
		ComoJugar.setText("Cómo jugar");	//establecemos texto al boton
		ComoJugar.setBounds(178,325,300,70);  //tamaño y posicion del boton
		ComoJugar.setEnabled(true);  //habilita o deshabilita el click		
		ComoJugar.setForeground(Color.BLACK); //color de las letras del boton
		ComoJugar.setBackground(Color.WHITE);
		ComoJugar.setFont(new Font("algerian",Font.BOLD,40)); //fuente de la letra del boton

		//  abre la ventana relacionada con las instrucciones del juego y cierra la ventana de inicio
		ComoJugar.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Como_Jugar ventanaComoJugar = new Interfaz_Como_Jugar();
				ventanaComoJugar.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(ComoJugar)).dispose();  //cierra la ventana
			}
		});
		panel.add(ComoJugar);

		// Boton para jugar

		JButton Jugar = new JButton(); //creamos el boton
		Jugar.setText("Jugar");	//establecemos texto al boton
		Jugar.setBounds(178,150,300,70);  //tamaño y posicion del boton
		Jugar.setEnabled(true);  //habilita o deshabilita el click		
		Jugar.setForeground(Color.BLACK); //color de las letras del boton
		Jugar.setBackground(Color.WHITE);
		Jugar.setFont(new Font("algerian",Font.BOLD,40)); //fuente de la letra del boton

		//  abre la ventana relacionada con los niveles del juego y cierra la ventana de inicio
		Jugar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Niveles ventanaNiveles = new Interfaz_Niveles();
				ventanaNiveles.setVisible(true);    
				((JFrame) SwingUtilities.getWindowAncestor(Jugar)).dispose();  //cierra la ventana
			}                      
		});		
		panel.add(Jugar);

		//Boton para salir

		JButton Salir = new JButton(); //creamos el boton
		Salir.setText("Salir");	//establecemos texto al boton
		Salir.setBounds(178,500,300,70);  //tamaño y posicion del boton
		Salir.setEnabled(true);  //habilita o deshabilita el click		
		Salir.setForeground(Color.BLACK); //color de las letras del boton
		Salir.setBackground(Color.WHITE);
		Salir.setFont(new Font("algerian",Font.BOLD,40)); //fuente de la letra del boton

		//cierra la ventana principal
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   
				System.exit(0);
			}
		});

		panel.add(Salir);			
	}
}