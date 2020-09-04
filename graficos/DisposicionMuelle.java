package graficos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class DisposicionMuelle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			MarcoMuelle miMarco=new MarcoMuelle();
			miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}

}

class MarcoMuelle extends JFrame{
	public MarcoMuelle() {
		setTitle("Marco Muelle");
		setBounds(300, 400, 1000, 350);
		add(new LaminaMuelle());
		setVisible(true);
	}
}

class LaminaMuelle extends JPanel{
	public LaminaMuelle(){
		JButton boton1=new JButton("Boton 1");
		JButton boton2=new JButton("Boton 2");
		JButton boton3=new JButton("Boton 3");
		
		//Establecemos la disposicion tipo MUELLE con la clase SRPINGLAYOUT
		SpringLayout milayout=new SpringLayout();
			//Setiamos la disposicion de la lamina de tipo SPRINGLAYOUT
			setLayout(milayout);
		
		
		add(boton1);
		add(boton2);
		add(boton3);
	
		//Construimos el Muelle con la clase SPRING. con el metodo statico CONSTANT
		Spring miMuelle=Spring.constant(2, 10, 100);
		//Muelle Rigido
		Spring muelleRigido=Spring.constant(10);
			//Colocamos el muelle ENTRE los botones
				//Debemos usar el metodo PUTCONSTRAINT de la clase SPRINGLAYOUT
				//Usamos la Instancia creada del tipo SPRINGLAYOUT
				milayout.putConstraint(
						SpringLayout.WEST,//BordeIzquierdo del Primer COMPONENTE
						boton1, //Componente al que estoy trabajando
						miMuelle, //Muelle que voy a utilizar
						SpringLayout.WEST,//Borde izquierdo de "THis" que es el contenedor, en este caso la lamina es decir"DESTINO"
						this);	//El contenedor es mi lamina
				
				milayout.putConstraint(
						SpringLayout.WEST,//BordeIzquierdo del segundo COMPONENTE
						boton2, //Componente al que estoy trabajando
						miMuelle, //Muelle que voy a utilizar
						SpringLayout.EAST,//Borde izquierdo en este caso boton1 es decir"DESTINO"
						boton1);	//El contenedor es mi lamina
				
				milayout.putConstraint(SpringLayout.WEST, boton3, muelleRigido, SpringLayout.EAST, boton2);//A este le pongo un muelle RIGIDO
				milayout.putConstraint(SpringLayout.EAST, this, miMuelle, SpringLayout.EAST, boton3); 

	}
}







