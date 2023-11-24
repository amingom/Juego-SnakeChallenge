package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Esta clase representa la interfaz de personalizacion de la serpiente en el juego Snake Challenge.
 * Permite al jugador elegir entre diferentes aspectos para la serpiente.
 */

public class Interfaz_Personalizar extends JFrame {
	
	static private String animal; // Almacena la serpiente seleccionada en la interfaz de personalización
	
	//Método para obtener el animal seleccionado
	public String getAnimal() {
		return animal;
	}
	
	//Método que permite establecer el valor de la variable animal
	public static void setAnimal(String _animal) {
		animal = _animal;
	}

	/**
	 * Constructor de la clase que configura la interfaz de personalizacion.
	 * Establece el tamano, titulo, posicion y otros aspectos de la ventana.
	 */
	public Interfaz_Personalizar() {

		setSize(600,600);                                             //ancho largo

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
		Personalizacion_Serpiente.setBounds(-115,20,800,100);
		Personalizacion_Serpiente.setHorizontalAlignment(SwingConstants.CENTER);    //centramos el texto en la etiqueta
		Personalizacion_Serpiente.setForeground(Color.BLACK);                      //establecemos el color del texto
		Personalizacion_Serpiente.setOpaque(true);                                // establecemos el poder pintar la etiqueta
		Personalizacion_Serpiente.setBackground(Color.cyan);                     //cambiamos el color del fondo de la etiqueta
		Personalizacion_Serpiente.setFont(new Font("arial",Font.BOLD,50));      //establecemos la fuente del texto	


		Personalizar.add(Personalizacion_Serpiente);                           //agregamos la etiqueta al panel


		JButton Cobra = new JButton();                                //creamos el boton
		Cobra.setText("Cobra");	                                     //establecemos texto al boton
		Cobra.setBounds(160,130,250,60);                            //tamaño y posicion del boton
		Cobra.setEnabled(true);                                    //habilita o deshabilita el click		
		Cobra.setForeground(Color.BLACK);                         //color de las letras del boton
		Cobra.setBackground(Color.WHITE);
		Cobra.setFont(new Font("algerian",Font.BOLD,40));       //fuente de la letra del boton
		Cobra.setFocusPainted(false);

		Cobra.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setAnimal("cobra");
				Interfaz_Cobra ventanaCobra = new Interfaz_Cobra(getAnimal());
				ventanaCobra.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Cobra)).dispose();  //cierra la ventana

			}
		});

		Personalizar.add(Cobra);

		JButton Piton = new JButton();                          //creamos el boton
		Piton.setText("Pitón");	                               //establecemos texto al boton
		Piton.setBounds(160,255,250,60);                      //tamaño y posicion del boton
		Piton.setEnabled(true);                              //habilita o deshabilita el click		
		Piton.setForeground(Color.BLACK);                   //color de las letras del boton
		Piton.setBackground(Color.WHITE);
		Piton.setFont(new Font("algerian",Font.BOLD,40)); //fuente de la letra del boton
		Piton.setFocusPainted(false);

		Piton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setAnimal("piton");
				Interfaz_Piton ventanaPiton = new Interfaz_Piton(getAnimal());
				ventanaPiton.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Piton)).dispose();  //cierra la ventana

			}
		});

		Personalizar.add(Piton);

		JButton Vibora = new JButton();                            //creamos el boton
		Vibora.setText("Víbora");	                               //establecemos texto al boton
		Vibora.setBounds(160,380,250,60);                        //tamaño y posicion del boton
		Vibora.setEnabled(true);                                //habilita o deshabilita el click		
		Vibora.setForeground(Color.BLACK);                     //color de las letras del boton
		Vibora.setBackground(Color.WHITE);
		Vibora.setFont(new Font("algerian",Font.BOLD,40));   //fuente de la letra del boton
		Vibora.setFocusPainted(false);

		Vibora.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setAnimal("vibora");
				Interfaz_Vibora ventanaVibora = new Interfaz_Vibora(getAnimal());
				ventanaVibora.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Vibora)).dispose();  //cierra la ventana

			}
		});

		Personalizar.add(Vibora);

		JButton Atras = new JButton();                              //creamos el boton
		Atras.setText("Atras");	                                   //establecemos texto al boton
		Atras.setBounds(10,510,150,40);                           //tamaño y posicion del boton
		Atras.setEnabled(true);                                  //habilita o deshabilita el click		
		Atras.setForeground(Color.BLACK);                       //color de las letras del boton
		Atras.setBackground(Color.WHITE);
		Atras.setFont(new Font("algerian",Font.BOLD,20));     //fuente de la letra del boton
		Atras.setFocusPainted(false);
		Atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Interfaz_Niveles ventanaInicial = new Interfaz_Niveles();
				ventanaInicial.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(Atras)).dispose();  //cierra la ventana

			}
		});
		Personalizar.add(Atras);
	}

}