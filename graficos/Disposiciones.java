package graficos;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Disposiciones {

	public static void main(String[] args) {
		
		MarcoCaja miMarco=new MarcoCaja();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}

}

class MarcoCaja extends JFrame{
	
	public MarcoCaja() {	//Constructor
		setTitle("Marco en la caja");
		setBounds(600, 350, 200, 200);
		//Creamos el texto
		JLabel rotulo1=new JLabel("Nombre");
			//Creamos el cuadro de TEXTO(tamaño)
			JTextField texto1=new JTextField(10);
			//Setieamos el tamaño maximo del cuadro de texto (Objeto Dimension)
			texto1.setMaximumSize(texto1.getPreferredSize());
				
				//Creamos una variable de tipo CAJA "Devuelve un objeto de tipo BOX"
				Box cajaH1=Box.createHorizontalBox();
				//Agregamos componentes al BOX
				cajaH1.add(rotulo1);
				//Creamos el espacio de separacion
				cajaH1.add(Box.createHorizontalStrut(10));
				cajaH1.add(texto1);
				
				//Creamos elementos para la box
				JLabel rotulo2=new JLabel("Contraseña");
					//Creamos el cuadro de TEXTO (tamaño)
					JTextField texto2=new JTextField(10);
					//Setemos para que redimensione sin problema
					texto2.setMaximumSize(texto2.getPreferredSize());
					
					//Creamos una variable de tipo CAJA "Devuelve un objeto de tipo BOX"
					Box cajaH2=Box.createHorizontalBox();
					cajaH2.add(rotulo2);
					//Creamos el espacio de separacion
					cajaH2.add(Box.createHorizontalStrut(10));
					cajaH2.add(texto2);
					
					//Creamos los elementos para el tercer BOX
					JButton boton1=new JButton("Ok");
					JButton boton2=new JButton("Cancelar");
					
						//Creamos una tercera caja
						Box cajaH3=Box.createHorizontalBox();
						cajaH3.add(boton1);
						//En vez de crear un espacio fijo de 10 px como antes, en este metodo creamos un espacio que puede REDIMENCIONARSE
						cajaH3.add(Box.createGlue());
						cajaH3.add(boton2);
						
						
						////////////////BOX VERTICAL "El boxVertical luego lo agregamos al MARCO"
						Box cajaVertical=Box.createVerticalBox();
						//Insetamos los box horizontal dentro del vertical
						cajaVertical.add(cajaH1);
						cajaVertical.add(cajaH2);
						cajaVertical.add(cajaH3);
						//Lo agregamos al Marco
						add(cajaVertical,BorderLayout.CENTER);
	}
	
	
	
}