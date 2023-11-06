package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz_Piton extends JFrame {
	
	/**
     * Constructor de la clase que configura la interfaz "Piton".
     * Establece el tamano, titulo, posicion y otros aspectos de la ventana.
     */
	public Interfaz_Piton() {

		setSize(700,700);                                                               //ancho largo

		setTitle("Snake Challenge");                                                  //establecemos el titulo de la ventana	

		setLocationRelativeTo(null);                                                //establecemos la ventana en el centro de la pantalla

		this.getContentPane().setBackground(Color.green);                         //establecemos el color de la ventana

		iniciarComponentes();                                                   //Inicia los botones , imagenes...

		setDefaultCloseOperation(EXIT_ON_CLOSE);                              //hace que termine el programa al cerrar la ventana

	}
	
	/**
     * Inicializa los componentes visuales de la interfaz "Piton".
     * Crea un panel, etiquetas de texto, un boton de "Atras" y un boton de "Start".
     */
	void iniciarComponentes() {
		
		JPanel piton = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// Dibuja la imagen de fondo
				ImageIcon backgroundImage = new ImageIcon("piton.jpg");
				g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};
		piton.setLayout(null);
		getContentPane().add(piton);
		
		JLabel Info = new JLabel();   //creamos una etiqueta de texto		
		Info.setText("Información de la pitón:\n"
				+ "-Color: marrón.\n"
				+ "-Velocidad: normal.");   //establecemos el texto de la etiqueta
		Info.setText("<html>" + Info.getText().replaceAll("\n", "<br/>") + "</html>");
		Info.setBounds(50,50,318,300);
		Info.setHorizontalAlignment(SwingConstants.CENTER);   //centramos el texto en la etiqueta
		Info.setForeground(Color.WHITE);   //establecemos el color del texto
		Info.setOpaque(false);  // establecemos el poder pintar la etiqueta
		//etiqueta.setBackground(Color.black);  //cambiamos el color del fondo de la etiqueta
		Info.setFont(new Font("arial",0,23));  //establecemos la fuente del texto
		piton.add(Info);   //agregamos la etiqueta al panel
		
		JButton Atras = new JButton();                                         //creamos el boton
		Atras.setText("Atras");	                                              //establecemos texto al boton
		Atras.setBounds(50,600,150,40);                                      //tamaño y posicion del boton
		Atras.setEnabled(true);                                             //habilita o deshabilita el click		
		Atras.setForeground(Color.BLACK);                                  //color de las letras del boton
		Atras.setBackground(Color.WHITE);
		Atras.setFont(new Font("algerian",Font.BOLD,20));                //fuente de la letra del boton
		Atras.setOpaque(false);  										// establecemos el poder pintar la etiqueta
		Atras.setSelected(false);
		piton.add(Atras);
		Atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Personalizar ventanaPersonalizar = new Interfaz_Personalizar();
				ventanaPersonalizar.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Atras)).dispose();  //cierra la ventana

			}
		});
		piton.add(Atras);                                //agregamos la etiqueta al panel	
		
		JButton Start = new JButton();                                         //creamos el boton
		Start.setText("Start");	                                              //establecemos texto al boton
		Start.setBounds(490,600,150,40);                                      //tamaño y posicion del boton
		Start.setEnabled(true);                                             //habilita o deshabilita el click		
		Start.setForeground(Color.WHITE);                                  //color de las letras del boton
		Start.setBackground(Color.WHITE);
		Start.setFont(new Font("algerian",Font.BOLD,20));                //fuente de la letra del boton
		Start.setOpaque(false);  										// establecemos el poder pintar la etiqueta
		Start.setSelected(false);
		piton.add(Start);
		Start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_juego_facil ventanaJuego = new Interfaz_juego_facil();
				ventanaJuego.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Start)).dispose();  //cierra la ventana

			}
		});
		piton.add(Start);                                //agregamos la etiqueta al panel
 }		
}