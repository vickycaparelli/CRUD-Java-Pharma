package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class VistaConsulCliente extends JPanel {
	private JTextField tfApeODni;
	private JTable tabla;
	private JScrollPane scrollPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public VistaConsulCliente() {
setLayout(null);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 137, 521, 233);
		add(scrollPane);
		String []encabezados= new String[] {"Nombre","Apellido","DNI","Telefono", "Última fecha"};
		TableModel tablaModel = new DefaultTableModel(encabezados,0);
		tabla= new JTable();
		tabla.setColumnSelectionAllowed(true);
		tabla.setCellSelectionEnabled(true);
		scrollPane.setViewportView(tabla);
		tabla.setModel(tablaModel);
		tabla.setPreferredSize(new java.awt.Dimension(450,200));
		
		tfApeODni = new JTextField();
		tfApeODni.setBounds(156, 92, 192, 23);
	    add(tfApeODni);
		tfApeODni.setColumns(10);
		
		JLabel lblConsultaCliente = new JLabel("Consulta de clientes");
		lblConsultaCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConsultaCliente.setBounds(20, 11, 146, 15);
		add(lblConsultaCliente);
		
		JButton btnLimpiarCampos = new JButton("Limpiar campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfApeODni.setText("");
				limpiarTabla(tabla);
			}
			
		});
		btnLimpiarCampos.setBounds(217, 389, 146, 23);
		add(btnLimpiarCampos);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAceptar.setBounds(58, 389, 92, 23);
		add(btnAceptar);
		
		JLabel lblBuscarPor = new JLabel("Filtrar por");
		lblBuscarPor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBuscarPor.setBounds(41, 51, 92, 41);
		add(lblBuscarPor);
		
		JRadioButton rdbtnDni = new JRadioButton("DNI");
		rdbtnDni.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonGroup.add(rdbtnDni);
		rdbtnDni.setBounds(41, 81, 109, 23);
		add(rdbtnDni);
		
		JRadioButton rdbtnApellido = new JRadioButton("Apellido");
		rdbtnApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonGroup.add(rdbtnApellido);
		rdbtnApellido.setBounds(41, 107, 109, 23);
		add(rdbtnApellido);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 43, 567, 8);
		add(separator);
		
		JButton btnVolverAlMen = new JButton("Volver al men\u00FA");
		btnVolverAlMen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnVolverAlMen.setBounds(407, 389, 120, 23);
		add(btnVolverAlMen);
		
		JButton btnListarTodos = new JButton("Listar ");
		btnListarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListarTodos.setBounds(358, 92, 107, 23);
		add(btnListarTodos);

	}
	public static void limpiarTabla(JTable tabla){
		int a=((DefaultTableModel)tabla.getModel()).getRowCount()-1;
		while(a>=0){
			((DefaultTableModel)tabla.getModel()).removeRow(a);
			a=a-1;
		}
	}

}
