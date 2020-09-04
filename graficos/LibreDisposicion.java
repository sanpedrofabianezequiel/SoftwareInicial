package graficos;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LibreDisposicion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoLibre mimarco=new MarcoLibre();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class MarcoLibre extends JFrame {
	public MarcoLibre() {
		setTitle("Disposiciones libres");
		setBounds(450, 350, 600, 400);
		add(new LaminaLibre());
		setVisible(true);
	}
}

class LaminaLibre extends JPanel{
	public LaminaLibre() {
		//Indicamos a la lamina la disposicion en NULL
		//setLayout(null);//Seteo
		setLayout(new EnColumnas());
		//Agregamos componentes
		JButton boton1=new JButton("Boton 1");
			/*Asignamos la posicion*/
			//boton1.setBounds(450,50, 100, 25);
		//Agregamos el componente  a la lamina
	//	add(boton1);
		
		
		JLabel nombre=new JLabel("Nombre:");
		JTextField cNombre=new JTextField();	//Aca iria la el tamaño, PERO NO ES necesario con un setLyaot NULL ya que en el setbound seteo el tamañao
		
			//nombre.setBounds(20, 20, 80, 40);
			//cNombre.setBounds(100, 35, 100, 20);
		JLabel edad=new JLabel("Edad:");
		JTextField edad1=new JTextField();
		
		add(nombre);
		add(cNombre);
		add(edad);
		add(edad1);
	}
}



//Esta clase crea nuestras disposiciones
//Clase para aliniar con mis preferencias, instanciamos la INTERFAZ layoutManager
class EnColumnas implements LayoutManager{
	
	//Si quisiera darle una ubicacion especifica podria usar //int ancho=miContenedor.getWidth();, y jugar con la variable X teniendo en cuenta el ANCHO del componente
	
	private int x=20;
	private int y=20;
	
	@Override
	public void addLayoutComponent(String name, Component comp) {
	
		
	}

	@Override
	public void removeLayoutComponent(Component comp) {
		
		
	}

	@Override
	public Dimension preferredLayoutSize(Container parent) {
		
		return null;
	}

	@Override
	public Dimension minimumLayoutSize(Container parent) {
		
		return null;
	}

	@Override
	public void layoutContainer(Container miContenedor) {
		//Nos Permite especificar un CONTENEDOR donde ubicar los ELEMENTOS
		//miContenedor= al contenedor donde yo voy a ubicar mis ELEMENTOS
		int contador=0; //Para saber cuantos elementos llevamos agregados en concretro
			//Ele elemento del tipo Container tiene un metodo GETCOMPONENTCOUNT
		int n=miContenedor.getComponentCount(); //cuantos componentes agregamos al contenedor
		
		
		//Recorremos los componentes totales ingresados
		for(int i=0;i<n;i++) {//Evaluamos los componentes
			contador++;//
			//COMPONENT mivar= (Variable Del tipo Container).GETCOMPONENTE(INT)
			Component c=miContenedor.getComponent(i);//evaluamos que el Componente I, si es button/text/etc
						
			c.setBounds(x, y, 100, 20);//Setiamos el elemento en un lugar en concreto
			
			x += 100;//Incrementamos X e Y para que no se superPongan
			
			//Aca usamos la variable contador, para determinar si terminamos una FILA/ROW
			if(contador%2==0) {//Si es PAR!
				x = 20;	//Para que la X vuelva a la posicion Inicial
				y += 40;
			}
		}
	}
	
}



