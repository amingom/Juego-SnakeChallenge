package Juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Interfaz_Usuario extends JFrame {
	
	public Interfaz_Usuario() {
		
		setSize(700,700);  //ancho largo
		
		setTitle("Snake Challenge");  //establecemos el titulo de la ventana	
		
		setLocationRelativeTo(null);  //establecemos la ventana en el centro de la pantalla
		
		this.getContentPane().setBackground(Color.orange);//establecemos el color de la ventana
		
		iniciarComponentes(); //Inicia los botones , imagenes...
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); //hace que termine el programa al cerrar la ventana		
		
	}


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
		ComoJugar.setBounds(178,275,300,70);  //tamaño y posicion del boton
		ComoJugar.setEnabled(true);  //habilita o deshabilita el click		
		ComoJugar.setForeground(Color.BLACK); //color de las letras del boton
		ComoJugar.setBackground(Color.WHITE);
		ComoJugar.setFont(new Font("algerian",Font.BOLD,40)); //fuente de la letra del boton
		ComoJugar.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
                Interfaz_Como_Jugar ventanaComoJugar = new Interfaz_Como_Jugar();
                ventanaComoJugar.setVisible(true);
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
		Jugar.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
                Interfaz_Niveles ventanaNiveles = new Interfaz_Niveles();
                ventanaNiveles.setVisible(true);
            }
        });
		panel.add(Jugar);
		
		
		
		
		
		// Boton para Personalizar
		
		JButton Personalizar = new JButton(); //creamos el boton
		Personalizar.setText("Personalizar");	//establecemos texto al boton
		Personalizar.setBounds(178,400,300,70);  //tamaño y posicion del boton
		Personalizar.setEnabled(true);  //habilita o deshabilita el click		
		Personalizar.setForeground(Color.BLACK); //color de las letras del boton
		Personalizar.setBackground(Color.WHITE);
		Personalizar.setFont(new Font("algerian",Font.BOLD,35)); //fuente de la letra del boton				
		Personalizar.addActionListener(new ActionListener() {
			
            @Override
            public void actionPerformed(ActionEvent e) {
                Interfaz_Personalizar ventanaPersonalizacion = new Interfaz_Personalizar();
                ventanaPersonalizacion.setVisible(true);
                
            }
        });
		
		
		panel.add(Personalizar);
		
		
		//Boton para salir
		
		JButton Salir = new JButton(); //creamos el boton
		Salir.setText("Salir");	//establecemos texto al boton
		Salir.setBounds(178,525,300,70);  //tamaño y posicion del boton
		Salir.setEnabled(true);  //habilita o deshabilita el click		
		Salir.setForeground(Color.BLACK); //color de las letras del boton
		Salir.setBackground(Color.WHITE);
		Salir.setFont(new Font("algerian",Font.BOLD,40)); //fuente de la letra del boton
		Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cerrar la ventana secundaria
            	System.exit(0);
            }
        });
		
		panel.add(Salir);
		
				
	}
	

}
