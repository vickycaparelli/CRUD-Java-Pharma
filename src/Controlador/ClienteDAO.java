package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelo.Cliente;
import Controlador.Consultor;

public class ClienteDAO {
        public boolean existeCliente(Cliente c) throws SQLException{
        	boolean condicion= false;
        	//Para verificar cuento la cantidad de clientes con igual DNI si existealguna coincidencia es que COUNT >=1
        	//En el caso mencionado sedebrá devolver verdadero, en caso de que sea 0 no habrá coincidencias y el cliente se podrá crear
        	String sql = "SELECT COUNT(*) FROM Cliente WHERE DNI="+c.getDNI()+"";
        	Consultor con = new Consultor();
        	ResultSet resu =con.ejecutarSelect(sql);
        	if(resu.next()==true){
        		if (Integer.parseInt(resu.getString(1)) > 0) condicion=true;
			}
            return condicion;
        }
        
    
	public void altaCliente(Cliente c){
		String sql = "INSERT INTO cliente ( DNI, nombre, apellido,telefono, ultDispensacion) VALUES (" + c.getDNI() + ",'"+c.getNombre()+"','"+c.getApellido()+"','"+c.getTelefono()+"','"+c.getUltDispensacion()+"')";
		
		Consultor con = new Consultor();
		con.ejecutarInsert(sql);
	}
	
	public void bajaCliente(int DNI){ 
		//El delete lo acabo de hacer porque en el tp haciamos un update y lo poniamos como no activo, no lo borrabamos realmente de la base, asi que puede fallar
		String sql = "DELETE FROM cliente WHERE DNI ="+ DNI+"";
		
		Consultor con = new Consultor();
		con.ejecutarInsert(sql);
	}
	
	public void modificarCliente(String campo,String valor, int DNI){
		String sql = "UPDATE cliente SET "+campo+" = '"+valor+"' WHERE DNI = "+DNI;
		
		Consultor con = new Consultor();
		con.ejecutarInsert(sql);
	}
	
public Cliente obtenerCliente(int DNI){
		
  		ResultSet resu=null;
		Cliente cli = null;
		Consultor con=new Consultor();
		String sql="SELECT * FROM Cliente WHERE DNI ="+DNI+"";
		resu=con.ejecutarSelect(sql);
		try {
			if(resu.next()==true){
				cli=new Cliente(resu.getInt("DNI"),resu.getString("nombre"),resu.getString("apellido"),resu.getInt("telefono"),resu.getString("ultDispensacion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cli;
	}
	
/*public ArrayList<Cliente> obtenerCliente(String ape){
		
		ArrayList<Cliente>listaClientes=new ArrayList <Cliente>();
		Cliente cli = null;
		ResultSet resu=null;
		Consultor con=new Consultor();
		String sql="SELECT * FROM Cliente WHERE apellido='"+ape+"'";
		resu=con.ejecutarSelect(sql);
		try {
			while(resu.next()==true){
				cli=new Cliente(resu.getInt("DNI"),resu.getString("nombre"),resu.getString("apellido"),resu.getInt("telefono"),resu.getString("ultDispensacion"));
				System.out.println(cli.toString());
			    listaClientes.add(cli);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaClientes;
	}*/
	
}
