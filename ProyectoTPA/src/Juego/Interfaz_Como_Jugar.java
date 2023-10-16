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


public class Interfaz_Como_Jugar extends JFrame {
	
	public Interfaz_Como_Jugar() {
		
		setSize(700,700);                                                               //ancho largo
		
		setTitle("Snake Challenge");                                                  //establecemos el titulo de la ventana	
		 
		setLocationRelativeTo(null);                                                //establecemos la ventana en el centro de la pantalla
		
		this.getContentPane().setBackground(Color.green);                         //establecemos el color de la ventana
		
		iniciarComponentes();                                                   //Inicia los botones , imagenes...
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);                              //hace que termine el programa al cerrar la ventana

	  }
		void iniciarComponentes() {
			
			JPanel ComoJugar = new JPanel();                                           // creacion de un panel		
			ComoJugar.setBackground(Color.DARK_GRAY);                                 //establecemos el color del panel
			ComoJugar.setLayout(null);                                               //desactiva su diseño
			this.getContentPane().add(ComoJugar);                                   //agregamos el panel a la ventana
			
			JLabel Comojugar = new JLabel();                                      //creamos una etiqueta de texto		
			Comojugar.setText("Cómo jugar");                                     //establecemos el texto de la etiqueta
			Comojugar.setBounds(-60,20,800,100);
			Comojugar.setHorizontalAlignment(SwingConstants.CENTER);           //centramos el texto en la etiqueta
			Comojugar.setForeground(Color.BLACK);                             //establecemos el color del texto
			Comojugar.setOpaque(true);                                       // establecemos el poder pintar la etiqueta
			Comojugar.setBackground(Color.DARK_GRAY);                       //cambiamos el color del fondo de la etiqueta
			Comojugar.setFont(new Font("arial",Font.BOLD,50));             //establecemos la fuente del texto	
			ComoJugar.add(Comojugar);                                     //agregamos la etiqueta al panel
			
			
			
			JLabel Instrucciones = new JLabel();                                                                        //creamos una etiqueta de texto		
			Instrucciones.setText("Línea 111111111111111\n"
					+ "Línea 222222222222222222222222222\n"
					+ "Línea 333333333333333333333333333\n"
					+ "Línea 444444444444444444444444444\n"
					+ "Línea 555555555555555555555555555\n"
					+ "Línea 666666666666666666666666666\n"
					+ "Línea 777777777777777777777777777\n");                                                     //establecemos el texto de la etiqueta
			Instrucciones.setText("<html>" + Instrucciones.getText().replaceAll("\n", "<br/>") + "</html>");
			Instrucciones.setBounds(-60,100,800,200);
			Instrucciones.setHorizontalAlignment(SwingConstants.CENTER);                                        //centramos el texto en la etiqueta
			Instrucciones.setForeground(Color.BLACK);                                                          //establecemos el color del texto
			Instrucciones.setOpaque(true);                                                                    // establecemos el poder pintar la etiqueta
			Instrucciones.setBackground(Color.DARK_GRAY);                                                    //cambiamos el color del fondo de la etiqueta
			Instrucciones.setFont(new Font("arial",Font.BOLD,20));                                          //establecemos la fuente del texto	
			ComoJugar.add(Instrucciones);                                                                  //agregamos la etiqueta al panel
			
			
			JButton Atras = new JButton();                                         //creamos el boton
			Atras.setText("Atras");	                                              //establecemos texto al boton
			Atras.setBounds(50,600,150,40);                                      //tamaño y posicion del boton
			Atras.setEnabled(true);                                             //habilita o deshabilita el click		
			Atras.setForeground(Color.BLACK);                                  //color de las letras del boton
			Atras.setBackground(Color.DARK_GRAY);
			Atras.setFont(new Font("algerian",Font.BOLD,20));                //fuente de la letra del boton
			ComoJugar.add(Atras);
			Atras.addActionListener(new ActionListener() {
				
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            Interfaz_Usuario ventanaInicial = new Interfaz_Usuario();
		            ventanaInicial.setVisible(true);
		            
		        }
		    });
			ComoJugar.add(Atras);                                //agregamos la etiqueta al panel
			
					
		}

}
