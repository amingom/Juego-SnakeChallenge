package Juego;

/**
 * Esta clase representa la interfaz de personalizacion de la serpiente en el juego Snake Challenge.
 * Permite al jugador elegir entre diferentes aspectos para la serpiente.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz_Personalizar extends JFrame {

	/**
     * Constructor de la clase que configura la interfaz de personalizacion.
     * Establece el tamaño, titulo, posicion y otros aspectos de la ventana.
     */
	public Interfaz_Personalizar() {

		setSize(700,700);                                             //ancho largo

		setTitle("Snake Challenge");                                //establecemos el titulo de la ventana	

		setLocationRelativeTo(null);                              //establecemos la ventana en el centro de la pantalla

		this.getContentPane().setBackground(Color.cyan);        //establecemos el color de la ventana

		iniciarComponentes();                                 //Inicia los botones , imagenes...

		setDefaultCloseOperation(EXIT_ON_CLOSE);            //hace que termine el programa al cerrar la ventana				

	}

	/**
     * Inicializa los componentes visuales de la interfaz de personalizacion.
     * Crea un panel, etiquetas de texto y botones para diferentes aspectos de la serpiente.
     */
	void iniciarComponentes() {

		JPanel Personalizar = new JPanel();                              // creacion de un panel		
		Personalizar.setBackground(Color.cyan);                        //establecemos el color del panel
		Personalizar.setLayout(null);                                  //desactiva su diseño
		this.getContentPane().add(Personalizar);                      //agregamos el panel a la ventana

		JLabel Personalizacion_Serpiente = new JLabel();                               //creamos una etiqueta de texto		
		Personalizacion_Serpiente.setText("PERSONALIZAR");                            //establecemos el texto de la etiqueta
		Personalizacion_Serpiente.setBounds(-60,20,800,100);
		Personalizacion_Serpiente.setHorizontalAlignment(SwingConstants.CENTER);    //centramos el texto en la etiqueta
		Personalizacion_Serpiente.setForeground(Color.BLACK);                      //establecemos el color del texto
		Personalizacion_Serpiente.setOpaque(true);                                // establecemos el poder pintar la etiqueta
		Personalizacion_Serpiente.setBackground(Color.cyan);                     //cambiamos el color del fondo de la etiqueta
		Personalizacion_Serpiente.setFont(new Font("arial",Font.BOLD,50));      //establecemos la fuente del texto	
		Personalizar.add(Personalizacion_Serpiente);                           //agregamos la etiqueta al panel

		JButton Facil = new JButton();                                //creamos el boton
		Facil.setText("Cobra");	                                     //establecemos texto al boton
		Facil.setBounds(178,150,300,70);                            //tamaño y posicion del boton
		Facil.setEnabled(true);                                    //habilita o deshabilita el click		
		Facil.setForeground(Color.BLACK);                         //color de las letras del boton
		Facil.setBackground(Color.WHITE);
		Facil.setFont(new Font("algerian",Font.BOLD,40));       //fuente de la letra del boton
		Personalizar.add(Facil);

		JButton Medio = new JButton();                          //creamos el boton
		Medio.setText("Piton");	                               //establecemos texto al boton
		Medio.setBounds(178,300,300,70);                      //tamaño y posicion del boton
		Medio.setEnabled(true);                              //habilita o deshabilita el click		
		Medio.setForeground(Color.BLACK);                   //color de las letras del boton
		Medio.setBackground(Color.WHITE);
		Medio.setFont(new Font("algerian",Font.BOLD,40)); //fuente de la letra del boton
		Personalizar.add(Medio);

		JButton Dificil = new JButton();                            //creamos el boton
		Dificil.setText("Vibora");	                               //establecemos texto al boton
		Dificil.setBounds(178,450,300,70);                        //tamaño y posicion del boton
		Dificil.setEnabled(true);                                //habilita o deshabilita el click		
		Dificil.setForeground(Color.BLACK);                     //color de las letras del boton
		Dificil.setBackground(Color.WHITE);
		Dificil.setFont(new Font("algerian",Font.BOLD,40));   //fuente de la letra del boton
		Personalizar.add(Dificil);

		JButton Atras = new JButton();                              //creamos el boton
		Atras.setText("Atras");	                                   //establecemos texto al boton
		Atras.setBounds(50,600,150,40);                           //tamaño y posicion del boton
		Atras.setEnabled(true);                                  //habilita o deshabilita el click		
		Atras.setForeground(Color.BLACK);                       //color de las letras del boton
		Atras.setBackground(Color.WHITE);
		Atras.setFont(new Font("algerian",Font.BOLD,20));     //fuente de la letra del boton
		Personalizar.add(Atras);
		Atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Usuario ventanaInicial = new Interfaz_Usuario();
				ventanaInicial.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Atras)).dispose();  //cierra la ventana

			}
		});
		Personalizar.add(Atras);
	}

}