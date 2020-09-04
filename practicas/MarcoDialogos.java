package practicas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;





public class MarcoDialogos extends JFrame  {

	private LaminaBotones laminaTipo,laminaTipoMensaje,laminaMensaje,laminaTipoOpcion,laminaOpciones,laminaEntrada;
	
	private String cadenaMensaje="";
	private Icon iconMensaje= new ImageIcon("");
	private Object objetoMensaje=new Date();
	private Component componenteMensaje=new LaminaEjemplo();	//El componente que nos devuelve
	
	
	public MarcoDialogos() {//	Constructor
		setTitle("Prueba de dialogos");
		setBounds(500, 300, 600, 450);
		
		
	
		JPanel laminaCuadricula=new JPanel();	//Agregamos la lamina
			laminaCuadricula.setLayout(new GridLayout(2,3));//setiamos la ubicaicon (Fila,Columnas)
				add(laminaCuadricula);
				
				
		String [] primero= {"Mensaje","Confirmar","Opcion","Entrada"};
			laminaTipo=new LaminaBotones("Tipo", primero);
		
		laminaCuadricula.add(laminaTipo);        //Inyeccion al GridLayout	
		//Forma Simple de insertarla las 3 lineas anteriores
		laminaTipoMensaje=new LaminaBotones("Tipo Mensaje", new String[] {	//Directamente instancion el Array
				"ERROR_MESSAGE",
				"INFORMATION_MESSAGE",
				"QUESTION_MESSAGE",
				"PLAIN_MESSAGE"
		});
		laminaCuadricula.add(laminaTipoMensaje);	//Inyeccion al GridLayout
		//Forma Simple de insertarla las 3 lineas anteriores
		laminaMensaje =new LaminaBotones("Mensaje", new String[] {
			"Cadena",
			"Icono",
			"Componente",
			"Otros",
			"Object []"
		});
		laminaCuadricula.add(laminaMensaje);	//Inyeccion al GridLayout
		//Forma Simple de insertarla las 3 lineas anteriores
		laminaTipoOpcion =new LaminaBotones("Confirmar", new String []  {
				"DEFAULT_OPTION",
				"YES_NO_OPTION",
				"YES_NO_CANCEL_OPTION",
				"OK_CANCEL_OPTION"
		});
		laminaCuadricula.add(laminaTipoOpcion);		//Inyeccion al GridLayout
		//Forma Simple de insertarla las 3 lineas anteriores
		laminaOpciones =new LaminaBotones("Opcion",new String[] {
			"String[]",
			"Icon[]",
			"Object[]"
		});
		laminaCuadricula.add(laminaOpciones);		//Inyeccion al GridLayout
		//Forma Simple de insertarla las 3 lineas anteriores
		laminaEntrada=new LaminaBotones("Entrada", new String [] {
			"Campo de texto",	
			"Combo"
		});
		laminaCuadricula.add(laminaEntrada);		//Inyeccion al GridLayout
		
		
		
		//-----------------------------------------------------------
		//Construccion de lamina Inferior del Marco
		JPanel laminaMostrar=new JPanel();
			JButton botonMonstrar=new JButton("Mostrar");//Botones dentro de la lamina
				botonMonstrar.addActionListener(new AccionMostrar());//Lo Ponemos a la escucha
				laminaMostrar.add(botonMonstrar);	//Agregamos el Boton a la lamina
		
		
		
		
		
		
		//-----------------------------------------------------------
		setLayout(new BorderLayout());	//Disposicion del Marco BordeLayout
		
		//Inserciones a la lamina PRINCIPAL
		add(laminaCuadricula,BorderLayout.CENTER);//Agregamos el GridLayout al Marco en el Center
			add(laminaMostrar,BorderLayout.SOUTH);	//Agregamos la lamina inferior al Marco en el Sur
	}
	
	
	
	private class AccionMostrar implements ActionListener{//Clase Interna
		@Override
		public void actionPerformed(ActionEvent e) {
			
				//Ubicamos el Box correspondiente para determinar que opcion selecciono
				//laminatipo(la declaro global) es del tipo LAMINABOTONES, con lo cual tiene sus metodos
				System.out.println(laminaTipo.dameSeleccion());
					if(laminaTipo.dameSeleccion().equals("Mensaje")) {
						JOptionPane.showMessageDialog(MarcoDialogos.this, "Mensaje", "Titulo", 0);
					}else if(laminaTipo.dameSeleccion().equals("Confirmar")) {
						JOptionPane.showConfirmDialog(MarcoDialogos.this, "Mensajes","Titulo", 0);
					}else if(laminaTipo.dameSeleccion().equals("Opcion")) {
						JOptionPane.showOptionDialog(MarcoDialogos.this,"Mensaje","Titulo",0,0,null,null,null);
					}else if(laminaTipo.dameSeleccion().equals("Entrada")) {
						JOptionPane.showInputDialog(MarcoDialogos.this,"Mensaje","Titulo",0);
					}
				
			
		}
		
	}
	
		
	//-------------------------------------------------------PROPORCIONA EL MENSAJE--------------------------------
		//Metodo
		public Object dameMensaje() {
			String s= laminaMensaje.dameSeleccion();
			
			if(s.equals("Object[]")) {
				
				return   new Object[] {
					cadenaMensaje,
					componenteMensaje,
					objetoMensaje,
					iconMensaje
				};
			}else {
				return null;
			}
			
			
			
			//Para que no de Error un else que return NULL por si no entra en ninguna Opcion
		}
	
	
	
	//-------------------------------------------------------------------------------------------------------------
}

class LaminaEjemplo extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		//llamamos el metodo padre
	
		Graphics2D g2=(Graphics2D) g;	//Casteo para tranformarlo en Grpahic 2D el  G

									//Creamos el Rectangulo
		Rectangle2D rectangulo=new Rectangle2D.Double(0,0,getWidth(),getHeight());//simil Setbounds
		
		g2.setPaint(Color.yellow);	//Pintamos
		g2.fill(rectangulo);//Llenamos el objeto que deseamos
		
		
	}
}





