package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;


import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private VistaAltaCliente VAC;
	private VistaBajaCliente VAB;
	private VistaModifCliente VMC;
	private VistaConsulCliente VCC;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 580, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		final JPanel panel = new JPanel();
		panel.setForeground(SystemColor.scrollbar);
		panel.setBounds(5, 37, 559, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnListarVales = new JButton("Listar vales");
		btnListarVales.setBounds(23, 84, 506, 28);
		panel.add(btnListarVales);
		
		JButton btnGenerarInforme = new JButton("Generar informe");
		btnGenerarInforme.setBounds(23, 50, 506, 28);
		panel.add(btnGenerarInforme);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(262, 15, 0, 2);
		panel.add(separator);
		
		JButton btnListarPagosPendientes = new JButton("Listar pagos pendientes");
		btnListarPagosPendientes.setBounds(23, 118, 506, 28);
		panel.add(btnListarPagosPendientes);
		
		JButton btnVerAlertas = new JButton("Ver alertas");
		btnVerAlertas.setBounds(23, 152, 506, 28);
		panel.add(btnVerAlertas);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 26, 559, 28);
		panel.add(separator_1);
		
		JLabel lblAtajosRpidos = new JLabel("Atajos r\u00E1pidos");
		lblAtajosRpidos.setBounds(24, 3, 125, 14);
		panel.add(lblAtajosRpidos);
		
		
		
		//Agrego Paneles del manu
		
	    //Baja Cliente
		VAB=new VistaBajaCliente();
		VAB.setBounds(0,40,580,500);
		VAB.setVisible(false);
		getContentPane().add(VAB);
		
		//Alta Cliente
		VAC=new VistaAltaCliente();
		VAC.setBounds(0,40,580,500);
		VAC.setVisible(false);
		contentPane.setLayout(null);
		getContentPane().add(VAC);
		
		//Modificaci�n cliente
		VMC=new VistaModifCliente();
		VMC.setBounds(0,40,580,500);
		VMC.setVisible(false);
		contentPane.setLayout(null);
		getContentPane().add(VMC);
		
		//Modificaci�n cliente
		VCC=new VistaConsulCliente();
		VCC.setBounds(0,40,580,500);
		VCC.setVisible(false);
		contentPane.setLayout(null);
		getContentPane().add(VCC);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(5, 5, 564, 21);
		contentPane.add(menuBar);
		
		JMenu mnGestinDeCliente = new JMenu("Gesti\u00F3n de cliente");
		mnGestinDeCliente.setBackground(UIManager.getColor("menu"));
		menuBar.add(mnGestinDeCliente);
		
		JMenuItem mntmAltaDeCliente = new JMenuItem("Alta de cliente");
		buttonGroup_1.add(mntmAltaDeCliente);
		mntmAltaDeCliente.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				VAC.setVisible(true);
				VAB.setVisible(false);
				VMC.setVisible(false);
				VCC.setVisible(false);
				panel.setVisible(false);
				
			}
		});
		mnGestinDeCliente.add(mntmAltaDeCliente);
		
		JMenuItem mntmBajaDeCliente = new JMenuItem("Baja de cliente");
		buttonGroup_1.add(mntmBajaDeCliente);
		mntmBajaDeCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				VAB.setVisible(true);
				VAC.setVisible(false);
				VMC.setVisible(false);
				VCC.setVisible(false);
				panel.setVisible(false);
			}
		});
		mnGestinDeCliente.add(mntmBajaDeCliente);
		
		JMenuItem mntmModificacinDeCliente = new JMenuItem("Modificaci\u00F3n de cliente");
		mntmModificacinDeCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				VMC.setVisible(true);
				VAC.setVisible(false);
				VAB.setVisible(false);
				VCC.setVisible(false);
				panel.setVisible(false);
			}
		});
		buttonGroup_1.add(mntmModificacinDeCliente);
		mnGestinDeCliente.add(mntmModificacinDeCliente);
		
		JMenuItem mntmConsultaDeCliente = new JMenuItem("Consulta de cliente");
		mntmConsultaDeCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				VCC.setVisible(true);
				VMC.setVisible(false);
				VAC.setVisible(false);
				VAB.setVisible(false);
				panel.setVisible(false);
			}
		});
		buttonGroup_1.add(mntmConsultaDeCliente);
		mnGestinDeCliente.add(mntmConsultaDeCliente);
		
		
		
	}

	
}
