package Vista;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;

import Controlador.ClienteDAO;
import Modelo.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class VistaAltaCliente extends JPanel {
	//FALTAN RESOLVER RESTRICCIONESEN EL INGRESO DE DATOS
	private JTextField tfNom;
	private JTextField tfApe;
	private JTextField tfDNI;
	private JTextField tfTel;
	private JTextField tfUFecha;

	/**
	 * Create the panel.
	 */
	public VistaAltaCliente() {
		final JPanel cPanel= new JPanel();
		cPanel.setBounds(0, 0, 0, 0);
		add(cPanel);
		
		setLayout(null);
		
		JLabel lblIngreseDatosDel = new JLabel("Ingrese datos del cliente");
		lblIngreseDatosDel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseDatosDel.setBounds(20, 11, 159, 14);
		add(lblIngreseDatosDel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(31, 96, 46, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellido.setBounds(31, 148, 46, 14);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDni.setBounds(31, 196, 46, 14);
		add(lblDni);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setBounds(31, 250, 112, 14);
		add(lblTelefono);
		
		JLabel lblFechaDeltima = new JLabel("Fecha de \u00FAltima dispensaci\u00F3n");
		lblFechaDeltima.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaDeltima.setBounds(30, 297, 170, 14);
		add(lblFechaDeltima);
		
		tfNom = new JTextField();
		tfNom.setBounds(87, 93, 181, 20);
		add(tfNom);
		tfNom.setColumns(10);
		
		tfApe = new JTextField();
		tfApe.setColumns(10);
		tfApe.setBounds(87, 146, 181, 20);
		add(tfApe);
		
		tfDNI = new JTextField();
		tfDNI.setColumns(10);
		tfDNI.setBounds(87, 194, 181, 20);
		add(tfDNI);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(87, 248, 181, 20);
		add(tfTel);
		
		tfUFecha = new JTextField();
		tfUFecha.setColumns(10);
		tfUFecha.setBounds(197, 295, 181, 20);
		add(tfUFecha);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 43, 573, 2);
		add(separator);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteDAO cliD= new ClienteDAO();
				//Ni el DNI ni el telefono son campos opcionales (lo del telefono puede reveerse)
				if(tfDNI.getText().equals("") || tfTel.getText().equals("")){
					mostrarError(cPanel, "Operación no realizada, verifique que los datos ingreados sean correctos");
				}
				else{
					Cliente cli= new Cliente(Integer.parseInt(tfDNI.getText()),tfNom.getText(),tfApe.getText(),Integer.parseInt(tfTel.getText()),tfUFecha.getText());
					try {
						if(cliD.existeCliente(cli)==false){
						   cliD.altaCliente(cli);
						   mostrarExito(cPanel);
						}
						else{
							mostrarError(cPanel, "Operación no realizada, ya existe un cliente con el mismo DNI asociado");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				limpiarCampos(tfNom,tfApe,tfDNI,tfTel, tfUFecha);
			}
		});
		btnAceptar.setBounds(47, 374, 89, 23);
		add(btnAceptar);
		
		JButton btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btnVolverAlMen.setBounds(398, 374, 132, 23);
		add(btnVolverAlMen);
		
		JButton btnLimpiarCampos = new JButton("Limpiar campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCampos(tfNom,tfApe,tfDNI,tfTel, tfUFecha);	
			}
		});
		btnLimpiarCampos.setBounds(198, 374, 147, 23);
		add(btnLimpiarCampos);

	}
	
	public static void limpiarCampos(JTextField nom,JTextField ape, JTextField dni, JTextField tel, JTextField fecha){
		nom.setText("");
		ape.setText("");
		dni.setText("");
		tel.setText("");
		fecha.setText("");
	}
	
	public static void mostrarError(JPanel cPanel, String mensaje){
		JOptionPane.showMessageDialog(cPanel, mensaje, "OPERACION NO REALIZADA", JOptionPane.ERROR_MESSAGE);
	}
	public static void mostrarExito(JPanel cPanel){
		JOptionPane.showMessageDialog(cPanel, "Operación realizada con éxito", "OPERACION REALIZADA", JOptionPane.INFORMATION_MESSAGE);
	}
}
