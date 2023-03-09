package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DragRacerController implements ActionListener {

	private JLabel lblCarro1;
	private JLabel lblCarro2;
	private String Nome1;
	private String Nome2;
	private JTextField txtVencedor;
	private JTextField txtPerdedor;
	private JButton btnIniciar;
	private JButton btnRecomecar;


	public DragRacerController(JLabel lblCarro1, JLabel lblCarro2, String Nome1, 
		String Nome2,JTextField txtVencedor,JTextField txtPerdedor,JButton btnIniciar,JButton btnRecomecar) {
		this.lblCarro1 = lblCarro1;
		this.lblCarro2 = lblCarro2;
		this.Nome1 = Nome1;
		this.Nome2 = Nome2;
		this.txtVencedor=txtVencedor;
		this.txtPerdedor=txtPerdedor;
		this.btnIniciar=btnIniciar;
		this.btnRecomecar=btnRecomecar;
	}

	
	
	private  void chamaThreads() {

		Thread t1 = new ThreadDragRacer(lblCarro1,Nome1,txtVencedor,txtPerdedor,btnIniciar,btnRecomecar);
		Thread t2 = new ThreadDragRacer(lblCarro2,Nome2,txtVencedor,txtPerdedor,btnIniciar,btnRecomecar);
		
			t1.start();
			t2.start();
 	}
	

	public void actionPerformed(ActionEvent arg0) {
		chamaThreads();

	}

}
