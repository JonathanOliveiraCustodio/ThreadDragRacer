package view;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.DragRacerController;
import controller.ThreadDragRacer;

import javax.swing.JTextField;


public class TelaDragRacer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnIniciar = new JButton("Iniciar");
	private JButton btnRecomecar = new JButton("Reiniciar");
	private JLabel lblCarro1 = new JLabel("");
	private JLabel lblCarro2 = new JLabel("");
	private String Nome1="Carro 1";
	private String Nome2="Carro 2";
	private JTextField txtVencedor;
	private JTextField txtPerdedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDragRacer frame = new TelaDragRacer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaDragRacer() {
		setTitle("Drag Racer");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("_____________________________________________________________________");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 99, 702, 49);
		contentPane.add(lblNewLabel);
		
		lblCarro1.setBounds(31, 23, 133, 100);
		contentPane.add(lblCarro1);
		ImageIcon imgCarro1 = new ImageIcon("lamborghini1.png");
		lblCarro1.setIcon(imgCarro1);
		
	
		lblCarro2.setBounds(31, 134, 133, 100);
		contentPane.add(lblCarro2);
		ImageIcon imgCarro2 = new ImageIcon("lamborghini1.png");
		lblCarro2.setIcon(imgCarro2);
		
		btnIniciar.setBounds(219, 366, 133, 32);
		contentPane.add(btnIniciar);
		
		JLabel lblBandeira = new JLabel("");
		lblBandeira.setBounds(703, 83, 79, 100);
		contentPane.add(lblBandeira);
		ImageIcon imgCarro3= new ImageIcon("Bandeira.png");
		lblBandeira.setIcon(imgCarro3);
		
		JLabel lblVencedor = new JLabel("Vencedor :");
		lblVencedor.setBounds(266, 278, 66, 14);
		contentPane.add(lblVencedor);
		
		JLabel lblPerdedor = new JLabel("Perdedor :");
		lblPerdedor.setBounds(266, 319, 66, 14);
		contentPane.add(lblPerdedor);
		
		txtVencedor = new JTextField();
		txtVencedor.setEditable(false);
		txtVencedor.setBounds(342, 275, 164, 20);
		contentPane.add(txtVencedor);
		txtVencedor.setColumns(10);
		
		txtPerdedor = new JTextField();
		txtPerdedor.setEditable(false);
		txtPerdedor.setBounds(342, 316, 164, 20);
		contentPane.add(txtPerdedor);
		txtPerdedor.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("<html>C<br>A<br>R<br>R<br>O<br><br>2</html>");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(10, 134, 23, 117);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblcarro = new JLabel("<html>C<br>A<br>R<br>R<br>O<br><br>1</html>");
		lblcarro.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblcarro.setToolTipText("");
		lblcarro.setBounds(10, 0, 23, 117);
		contentPane.add(lblcarro);
		
		
		btnRecomecar.setEnabled(false);
		btnRecomecar.setBounds(415, 366, 133, 32);
		contentPane.add(btnRecomecar);
		
		
		btnIniciar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent args0) {
				DragRacerController Randomizar = new DragRacerController(lblCarro1,
						lblCarro2,Nome1,Nome2,txtVencedor,txtPerdedor,btnIniciar,btnRecomecar);
				Randomizar.actionPerformed(null);	

			}

		});
		
		btnRecomecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
				ThreadDragRacer Limpar1 = new ThreadDragRacer(lblCarro1, Nome1, txtPerdedor, txtVencedor, btnIniciar, btnRecomecar);
				ThreadDragRacer Limpar2 = new ThreadDragRacer(lblCarro2, Nome2, txtPerdedor, txtVencedor, btnIniciar, btnRecomecar);
				Limpar1.Limpar();
				Limpar2.Limpar();
			}

		});
	
		
		
		
	}
}
