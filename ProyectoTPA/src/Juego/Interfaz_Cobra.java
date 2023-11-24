package Juego;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * Esta clase representa la interfaz de "Cobra" en el juego Snake Challenge.
 * Proporciona informacion sobre la Cobra y sus habilidades.
 */

public class Interfaz_Cobra extends JFrame {

	/**
	 * Constructor de la clase que configura la interfaz "Cobra".
	 * Establece el tamano, titulo, posicion y otros aspectos de la ventana.
	 * @param animal Parametro que representa el tipo de animal.
	 */
	public Interfaz_Cobra(String animal) {

		setSize(600,600);                                                               //ancho largo

		setTitle("Snake Challenge");                                                  //establecemos el titulo de la ventana	

		setLocationRelativeTo(null);                                                //establecemos la ventana en el centro de la pantalla

		this.getContentPane().setBackground(Color.green);                         //establecemos el color de la ventana

		iniciarComponentes();                                                   //Inicia los botones , imagenes...

		setDefaultCloseOperation(EXIT_ON_CLOSE);                              //hace que termine el programa al cerrar la ventana

	}

	/**
	 * Inicializa los componentes visuales de la interfaz "Cobra".
	 * Crea un panel, etiquetas de texto, un boton de "Atras"y un boton de "Start".
	 */
	void iniciarComponentes() {

		JPanel cobra = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon backgroundImage = new ImageIcon("img\\cobra.jpg");
				g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};
		cobra.setLayout(null);
		getContentPane().add(cobra);

		JLabel Info = new JLabel();   //creamos una etiqueta de texto		
		Info.setText("Información de la cobra:\n"
				+ "-Color: negro.\n"
				+ "-Velocidad: rápida.");   //establecemos el texto de la etiqueta
		Info.setText("<html>" + Info.getText().replaceAll("\n", "<br/>") + "</html>");
		Info.setBounds(2,2,280,180);
		Info.setHorizontalAlignment(SwingConstants.CENTER);   //centramos el texto en la etiqueta
		Info.setForeground(Color.white);   //establecemos el color del texto
		Info.setOpaque(false);  // establecemos el poder pintar la etiqueta
		Info.setFont(new Font("arial",0,25));  //establecemos la fuente del texto
		cobra.add(Info);   //agregamos la etiqueta al panel

		JButton Atras = new JButton();                                         //creamos el boton
		Atras.setText("Atras");	                                              //establecemos texto al boton
		Atras.setBounds(10,510,150,40);                                      //tamaño y posicion del boton
		Atras.setEnabled(true);                                             //habilita o deshabilita el click		
		Atras.setForeground(Color.white);                                  //color de las letras del boton
		Atras.setBackground(Color.black);
		Atras.setFont(new Font("algerian",Font.BOLD,20));                //fuente de la letra del boton
		Atras.setFocusPainted(false);
		Atras.setOpaque(true); 										// establecemos el poder pintar la etiqueta
		Atras.setSelected(false);
		LineBorder borde_Atras_Cobra = new LineBorder(Color.black);   // colorea el borde del boton
		Atras.setBorder(borde_Atras_Cobra);
		Atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Personalizar ventanaPersonalizar = new Interfaz_Personalizar();
				ventanaPersonalizar.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Atras)).dispose();  //cierra la ventana

			}
		});
		cobra.add(Atras);                                //agregamos la etiqueta al panel

		JButton Start = new JButton();                                         //creamos el boton
		Start.setText("Start");	                                              //establecemos texto al boton
		Start.setBounds(425,510,150,40);                                      //tamaño y posicion del boton
		Start.setEnabled(true);                                             //habilita o deshabilita el click		
		Start.setForeground(Color.white);                                  //color de las letras del boton
		Start.setBackground(Color.black);
		Start.setFont(new Font("algerian",Font.BOLD,20));                //fuente de la letra del boton
		Start.setOpaque(true);  										// establecemos el poder pintar la etiqueta
		Start.setFocusPainted(false);
		Start.setSelected(false);
		LineBorder borde_Start_Cobra = new LineBorder(Color.black);   // colorea el borde del boton
		Start.setBorder(borde_Start_Cobra);
		Start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_juego_facil ventanaJuego = new Interfaz_juego_facil();
				ventanaJuego.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Start)).dispose();  //cierra la ventana

			}
		});
		cobra.add(Start);                                //agregamos la etiqueta al panel

	}		
}