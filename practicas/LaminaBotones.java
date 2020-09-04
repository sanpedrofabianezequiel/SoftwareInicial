package practicas;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LaminaBotones extends JPanel {
	
	private ButtonGroup grupo;
	
	public LaminaBotones(String tituloR,String[] opciones) {//Recibe el titulo de los box, y los arrays de los RaddioButton
		
		setBorder(//Creamos un borde perteniciende a Jpanel Herdado
				BorderFactory.createTitledBorder(//Metodo para crear Bordes con titulo
						
						BorderFactory.createEtchedBorder(), //Tipo de border
						tituloR) //tipo de Border
				 ); 
		
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); //Indicamos la Distribucion BOXLAYOUT(ContenedorPadre,BoxLayout.Y_AXIS///X_AXIS)
		
		grupo=new ButtonGroup(); //Creamos nuestro grupo para RadiosButton
		
		for(int i=0;i<opciones.length;i++) {	//Recorremos el Arrays, para ver cuantas opciones recibimos
			
			
			JRadioButton bot=new JRadioButton(opciones[i]);//Construimos los botones aca, el text recibido en la posicion correspondiente
				
			//Aca setiamos el String del Action command para el getActionCommand()
			bot.setActionCommand(opciones[i]);//="Simili que un ActionListener"
			
			
			
			
			
			//--------------------------
			grupo.add(bot);//Agregamos el boton al Grupo			
			add(bot);//Agregamos el componente a la lamina
			bot.setSelected(i==0);//Setiamos la Seleccion Default, (EL primer elemento si existe, lo marca como Default)
		}
	
	}
	
	
	
	public String dameSeleccion() {//Metodo devulve el tipo seleccionado
									//ButtonGropu tiene un metodo que determina que sleccionamos
		
		//BUTTONGROUP tiene un metodo GETSELECTION() que devuelve un objeto del tipo BUTTONMODEL
		
	/*	//SON 2 PASOS Largos o la forma Larga
		//1 ="que numero selecciono" ="Almacenamos el RadioButton Seleccionado"
		ButtonModel seleccion= grupo.getSelection();	//grupo = tipo ButtonGorup //
		//2 convertimos esa seleccion en un String ya que queremos el contenido del string "Label"
		//string miString= seleccion.getActionCommand();
		String s=seleccion.getActionCommand();// =Almacenamos el String de la Accion Comando
		*/
		
		
		
		
		//Forma Simplificada
		return grupo.getSelection().getActionCommand();
									
	}
}
