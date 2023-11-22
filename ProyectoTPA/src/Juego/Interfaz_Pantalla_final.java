package Juego;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interfaz_Pantalla_final extends JFrame{
	private Interfaz_juego_facil puntos;
	
	public Interfaz_Pantalla_final(Interfaz_juego_facil puntos) {
		this.puntos = puntos;
		setSize(400,300);                                                               //ancho largo
		setTitle("Snake Challenge");                                                  //establecemos el titulo de la ventana	
		setLocationRelativeTo(null);                                                //establecemos la ventana en el centro de la pantalla
		this.getContentPane().setBackground(Color.green);                         //establecemos el color de la ventana
		iniciarComponentes();                                                   //Inicia los botones , imagenes...
		setDefaultCloseOperation(EXIT_ON_CLOSE);                              //hace que termine el programa al cerrar la ventana
	}
	
	void iniciarComponentes() {
		
		JPanel panel = new JPanel();    // creacion de un panel		
		panel.setBackground(Color.MAGENTA);  //establecemos el color del panel
		panel.setLayout(null);  //desactiva su dise単o
		this.getContentPane().add(panel);  //agregamos el panel a la ventana
		
		JLabel Mensaje = new JLabel();   //creamos una etiqueta de texto		
		Mensaje.setText("GAME OVER");
		Mensaje.setBounds(80,10,200,40);
		Mensaje.setHorizontalAlignment(SwingConstants.CENTER);   //centramos el texto en la etiqueta
		Mensaje.setForeground(Color.BLACK);   //establecemos el color del texto
		Mensaje.setOpaque(false);  // establecemos el poder pintar la etiqueta
		Mensaje.setFont(new Font("arial",0,30));  //establecemos la fuente del texto
		panel.add(Mensaje);   //agregamos la etiqueta al panel
		
		JLabel Puntuacion = new JLabel();   //creamos una etiqueta de texto		
		Puntuacion.setText("PUNTUACION : " + puntos.getScore());
		Puntuacion.setBounds(30,60,300,30);
		Puntuacion.setHorizontalAlignment(SwingConstants.CENTER);   //centramos el texto en la etiqueta
		Puntuacion.setForeground(Color.BLACK);   //establecemos el color del texto
		Puntuacion.setOpaque(false);  // establecemos el poder pintar la etiqueta
		Puntuacion.setFont(new Font("arial",0,30));  //establecemos la fuente del texto
		panel.add(Puntuacion);   //agregamos la etiqueta al panel
		
		JButton Salir = new JButton(); //creamos el boton
		Salir.setText("EXIT");	//establecemos texto al boton
		Salir.setBounds(2,218,100,30);  //tama単o y posicion del boton
		Salir.setEnabled(true);  //habilita o deshabilita el click		
		Salir.setForeground(Color.BLACK); //color de las letras del boton
		Salir.setBackground(Color.WHITE);
		Salir.setFont(new Font("algerian",Font.BOLD,20)); //fuente de la letra del boton
		Salir.setFocusPainted(false);

		//cierra la ventana principal
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {   
				System.exit(0);
			}
		});

		panel.add(Salir);	
		
		JButton Reiniciar = new JButton(); //creamos el boton
		Reiniciar.setText("PLAY AGAIN");	//establecemos texto al boton
		Reiniciar.setBounds(108,218,130,30);  //tama単o y posicion del boton
		Reiniciar.setEnabled(true);  //habilita o deshabilita el click		
		Reiniciar.setForeground(Color.BLACK); //color de las letras del boton
		Reiniciar.setBackground(Color.WHITE);
		Reiniciar.setFont(new Font("algerian",Font.BOLD,15)); //fuente de la letra del boton
		Reiniciar.setFocusPainted(false);

		Reiniciar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_juego_facil ventanafacil = new Interfaz_juego_facil();
				ventanafacil.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Reiniciar)).dispose();  //cierra la ventana

			}
		});

		panel.add(Reiniciar);	
		
		JButton Jugar_de_nuevo = new JButton(); //creamos el boton
		Jugar_de_nuevo.setText("SELECCION NIVEL");	//establecemos texto al boton
		Jugar_de_nuevo.setBounds(245,218,140,30);  //tama単o y posicion del boton
		Jugar_de_nuevo.setEnabled(true);  //habilita o deshabilita el click		
		Jugar_de_nuevo.setForeground(Color.BLACK); //color de las letras del boton
		Jugar_de_nuevo.setBackground(Color.WHITE);
		Jugar_de_nuevo.setFont(new Font("algerian",Font.BOLD,12)); //fuente de la letra del boton
		Jugar_de_nuevo.setFocusPainted(false);
		
		Jugar_de_nuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Niveles ventanaNiveles = new Interfaz_Niveles();
				ventanaNiveles.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Jugar_de_nuevo)).dispose();  //cierra la ventana

			}
		});
		
		panel.add(Jugar_de_nuevo);

	}
}