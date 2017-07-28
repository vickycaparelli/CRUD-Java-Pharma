package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;



public class VistaModifCliente extends JPanel {
	
	private JTextField tfApeODNI;
	private JButton button;
    private JScrollPane scrollPane;
	private JTable tabla;
	private JRadioButton rdbtnDni;
	private JRadioButton rdbtnApellido;
	private JLabel lblBuscarClienteA;
	private JButton btnBuscar;
	private JLabel lblIngreseNuevoValor;
	private JTextField tfValorAModificar;
	private JButton btnVolverAlMen;
	private JSeparator separator;
	

	/**
	 * Create the panel.
	 */
	public VistaModifCliente() {
		setLayout(null);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 206, 452, 77);
		add(scrollPane);
		String []encabezados= new String[] {"Nombre","Apellido","DNI","Telefono", "Última fecha"};
		TableModel tablaModel = new DefaultTableModel(encabezados,0);
		tabla= new JTable();
		scrollPane.setViewportView(tabla);
		tabla.setModel(tablaModel);
		tabla.setPreferredSize(new java.awt.Dimension(450,121));
		
		JLabel lblNewLabel = new JLabel("Modificaci\u00F3n de cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 11, 191, 38);
		add(lblNewLabel);
		
		tfApeODNI = new JTextField();
		tfApeODNI.setBounds(132, 104, 206, 20);
		add(tfApeODNI);
		tfApeODNI.setColumns(10);
		
		button = new JButton("Guardar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		button.setBounds(26, 363, 113, 25);
		add(button);
		JButton btnCancelar = new JButton("Limpiar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfApeODNI.setText("");
				limpiarTabla(tabla);
			}
		});
		btnCancelar.setBounds(212, 363, 113, 25);
		add(btnCancelar);
		
		JLabel lblSeleccionDato = new JLabel("Seleccione dato del cliente a modificar");
		lblSeleccionDato.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeleccionDato.setBounds(29, 175, 259, 20);
		add(lblSeleccionDato);
		
		rdbtnDni = new JRadioButton("DNI");
		rdbtnDni.setBounds(29, 93, 109, 23);
		add(rdbtnDni);
		
		rdbtnApellido = new JRadioButton("Apellido");
		rdbtnApellido.setBounds(29, 119, 109, 23);
		add(rdbtnApellido);
		
		lblBuscarClienteA = new JLabel("Buscar cliente a modificar por:");
		lblBuscarClienteA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBuscarClienteA.setBounds(29, 72, 191, 14);
		add(lblBuscarClienteA);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passwd = JOptionPane.showInputDialog("Ingrese contraseña");
			}
		});
		btnBuscar.setBounds(362, 103, 89, 23);
		add(btnBuscar);
		
		lblIngreseNuevoValor = new JLabel("Ingrese nuevo valor");
		lblIngreseNuevoValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngreseNuevoValor.setBounds(26, 294, 133, 14);
		add(lblIngreseNuevoValor);
		
		tfValorAModificar = new JTextField();
		tfValorAModificar.setBounds(26, 316, 262, 25);
		add(tfValorAModificar);
		tfValorAModificar.setColumns(10);
		
		btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.setBounds(389, 364, 124, 23);
		add(btnVolverAlMen);
		
		separator = new JSeparator();
		separator.setBounds(0, 43, 580, 10);
		add(separator);
		
		

	}
	public static void limpiarTabla(JTable tabla){
		int a=((DefaultTableModel)tabla.getModel()).getRowCount()-1;
		while(a>=0){
			((DefaultTableModel)tabla.getModel()).removeRow(a);
			a=a-1;
		}
	}
	
}
