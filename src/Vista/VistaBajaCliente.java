package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;

import Controlador.ClienteDAO;
import Modelo.Cliente;

import java.awt.Button;



public class VistaBajaCliente extends JPanel {
	//RESTRICCION DEPASSWORD, AGREGAR ALGO PARAQUELA CONTRANO SE VA CUANDO LA INGRESAS
	//AGREGAR RESTRICCIONES CON RESPECTO A LOS DATOS QUE SE PUEDEN INGRESAR
	
	private JTextField tfDni;
	private JTable tabla;
	private JScrollPane scrollPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public VistaBajaCliente() {
		final JPanel cPanel= new JPanel();
		cPanel.setBounds(0, 0, 0, 0);
		add(cPanel);
		
        setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 249, 551, 121);
		add(scrollPane);
		String []encabezados= new String[] {"Nombre","Apellido","DNI","Telefono", "Última fecha"};
		TableModel tablaModel = new DefaultTableModel(encabezados,0);
		tabla= new JTable();
		tabla.setColumnSelectionAllowed(true);
		tabla.setCellSelectionEnabled(true);
		scrollPane.setViewportView(tabla);
		tabla.setModel(tablaModel);
		tabla.setPreferredSize(new java.awt.Dimension(450,121));
		
		tfDni = new JTextField();
		tfDni.setBounds(41, 133, 192, 23);
	    add(tfDni);
		tfDni.setColumns(10);
		
		JLabel lblVerificacionDeDatos = new JLabel("Verificaci\u00F3n de datos");
		lblVerificacionDeDatos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVerificacionDeDatos.setBounds(19, 224, 168, 14);
		add(lblVerificacionDeDatos);
		
		JLabel lblBajaCliente = new JLabel("Baja Cliente");
		lblBajaCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBajaCliente.setBounds(19, 11, 72, 15);
		add(lblBajaCliente);
		
		
		final JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteDAO cliD= new ClienteDAO();
				limpiarTabla(tabla);
				if(cliD.obtenerCliente(Integer.parseInt(tfDni.getText()))!=null){
					cliD.bajaCliente(Integer.parseInt(tfDni.getText()));
					mostrarExito(cPanel);
				}else{
					mostrarError(cPanel, "No existe cliente con ese DNI");
				}
				
				
			}
		});
		btnConfirmar.setBounds(58, 389, 107, 23);
		add(btnConfirmar);
		
		JButton btnLimpiarCampos = new JButton("Limpiar campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnConfirmar.setEnabled(false);
				tfDni.setText("");
				limpiarTabla(tabla);
			}
		});
		btnLimpiarCampos.setBounds(217, 389, 146, 23);
		add(btnLimpiarCampos);
		
		JLabel lblDNI = new JLabel("Ingrese DNI del cliente a eliminar");
		lblDNI.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDNI.setBounds(41, 81, 202, 41);
		add(lblDNI);
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnConfirmar.setEnabled(true);
				ClienteDAO cliD= new ClienteDAO();
				limpiarTabla(tabla);
				if(isNumeric(tfDni.getText())){ //SI EL VALOR INGRESADO COMO DNI CONTIENE CARACTERES NO NUMERICOS DIRECTAMENTE NO LO BUSCO
					String passwd = JOptionPane.showInputDialog("Ingrese contraseña");
					if(passwd.equals("chocman")){
						if(cliD.obtenerCliente(Integer.parseInt(tfDni.getText()))!=null){
							llenarBusquedaCodigo(tabla,cliD.obtenerCliente(Integer.parseInt(tfDni.getText())));
						}else{
							mostrarError(cPanel, "No existen clientes que coincidan con el DNI ingresado");
						}
					}else{
						btnConfirmar.setEnabled(false);
						mostrarError(cPanel, "Contraseña incorrecta. solicite la misma a su supervisor.");
					}
					
				}else{
					mostrarError(cPanel, "Se han ingresado caracteres no válidos en el campo DNI. Verifique.");
				}
			}
		});
		btnEliminar.setBounds(274, 130, 107, 28);
		add(btnEliminar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 37, 577, 13);
		add(separator);
		
		JButton btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVolverAlMen.setBounds(407, 389, 120, 23);
		add(btnVolverAlMen);

	}
	public static void llenarBusquedaCodigo(JTable tabla, Cliente cli){
		Object [] fila = new Object [5];
		fila[0]=cli.getDNI();
		fila[1]=cli.getNombre();
		fila[2]=cli.getApellido();
		fila[3]=cli.getTelefono();
		fila[4]=cli.getUltDispensacion();	
		
	    ((DefaultTableModel)tabla.getModel()).addRow(fila);
    }
	
	public static void limpiarTabla(JTable tabla){
		int a=((DefaultTableModel)tabla.getModel()).getRowCount()-1;
		while(a>=0){
			((DefaultTableModel)tabla.getModel()).removeRow(a);
			a=a-1;
		}
	}
	public static void mostrarError(JPanel cPanel, String mensaje){
		JOptionPane.showMessageDialog(cPanel, mensaje, "OPERACION NO REALIZADA", JOptionPane.ERROR_MESSAGE);
	}
	public static void mostrarExito(JPanel cPanel){
		JOptionPane.showMessageDialog(cPanel, "Operación realizada con éxito", "OPERACION REALIZADA", JOptionPane.INFORMATION_MESSAGE);
	}
	public static boolean isNumeric(String cadena){
		//CONTROLO QUE EN EL CAMPO DNI NO SE INGRESEN LETRAS
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
}
