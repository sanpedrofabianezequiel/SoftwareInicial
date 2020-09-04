package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TiposCuadrosDialogos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CuadroDialogos miMarco=new CuadroDialogos();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
class CuadroDialogos extends JFrame{
	public CuadroDialogos() {
		setBounds(500, 300, 400, 250);
		add(new LaminaCuadroDialogos());
	}
}

class LaminaCuadroDialogos extends JPanel{
	JButton boton1;
	JButton boton2;
	JButton boton3;
	public LaminaCuadroDialogos() {
		//Insert Component Type Button
		boton1=new JButton("boton 1");
		boton2=new JButton("boton 2");
		boton3=new JButton("boton 3");
		//AddEventListener
			boton1.addActionListener(new Acciones());
			boton2.addActionListener(new Acciones());
			boton3.addActionListener(new Acciones());
		
				add(boton1);
				add(boton2);
				add(boton3);
		
	}
	
	private class Acciones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==boton1) {
							//(Donde realizamos la accion,String Mensaje)
				JOptionPane.showMessageDialog(LaminaCuadroDialogos.this, "Mensaje Prueba");
			}else if(e.getSource()==boton2) {
				JOptionPane.showMessageDialog(LaminaCuadroDialogos.this, "Mensaje Prueba", "Avertencia", 0);
			}else if(e.getSource()==boton3) {
				//JOptionPane.showInputDialog("Introduce Nombre");
				//JOptionPane.showInputDialog(LaminaCuadroDialogos.this, "Introduce nombre", "Introduce datos",2);
				//JOptionPane.showConfirmDialog(LaminaCuadroDialogos.this, "Elegi Opcion","V COnfirmar",1);
																		//(entorno,string,titulo,type,type,icono,opciones[ARRAY de Objetos],Represnta el valor selecionado por defecto)
				JOptionPane.showOptionDialog(LaminaCuadroDialogos.this,"Opciones ", "San Pedro", 1, 1, null, null, null);
			}
		}
		
	}
}

