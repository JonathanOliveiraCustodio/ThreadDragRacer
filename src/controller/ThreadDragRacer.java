package controller;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class ThreadDragRacer extends Thread {

	private JLabel lblCarro;
	private String Nome;
	private JTextField txtVencedor;
	private JTextField txtPerdedor;
	private JButton btnIniciar;
	private JButton btnRecomecar;
	
	
	int CemMetros=100;
	int distanciaCorrida = 0;	
	int distanciaTotalCorrida;	
	private int DistanciaPercorrida=0;
	static int colocacao = 0;		
	final static int DistanciaCorrida = 500; // Distancia Total
	final static int VelocidadeMaxima = 50; // Velocidade Máxima 50m/s
	
	
	public ThreadDragRacer (JLabel lblCarro, String Nome,JTextField txtVencedor,
			JTextField txtPerdedor,JButton btnIniciar,JButton btnRecomecar) {
		this.lblCarro = lblCarro;
		this.Nome = Nome;
		this.txtVencedor=txtVencedor;
		this.txtPerdedor=txtPerdedor;
		this.btnIniciar=btnIniciar;
		this.btnRecomecar=btnRecomecar;
	}
	
	public void Limpar() {
		
		Rectangle dimensoes = lblCarro.getBounds();
		CemMetros=100;
		distanciaCorrida = 0;	
		distanciaTotalCorrida=0;	
		DistanciaPercorrida=0;
		colocacao = 0;	
		dimensoes.x=66;
		lblCarro.setBounds(dimensoes);
		txtPerdedor.setText("");
		txtVencedor.setText("");
		//btnIniciar.addActionListener(null);
		btnIniciar.setEnabled(true);
		btnRecomecar.setEnabled(false);
		
	}
	
	public void Colocacao () {
		colocacao++;
			System.out.println(Nome + " foi o " + colocacao + " ° colocado");			
		if(colocacao==1) {
			txtVencedor.setText(Nome);
		} else
			txtPerdedor.setText(Nome);
        //btnIniciar.setEnabled(true);
		btnRecomecar.setEnabled(true);
		//Limpar();
	}
	
	
	private void MoverCarro() {

		Rectangle dimensoes = lblCarro.getBounds();
		int VelocidadeAtual=0;
		btnIniciar.setEnabled(false);
			VelocidadeAtual = (int) (1 + Math.random() * VelocidadeMaxima);
			
			    	DistanciaPercorrida+=VelocidadeAtual;   	
			    	dimensoes.x += VelocidadeAtual;			
			    	lblCarro.setBounds(dimensoes);
			    //	System.out.println(Nome + " Distancia: "+ DistanciaPercorrida+"m");	
					try {
						Thread.sleep(80);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	}

	public void run () {
		while (DistanciaPercorrida < DistanciaCorrida) {
		 MoverCarro() ;
		}
		 Colocacao();	
		}
}
