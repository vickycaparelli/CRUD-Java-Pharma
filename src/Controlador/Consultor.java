package Controlador;

import java.sql.*;

public class Consultor {
    public void ejecutarInsert(String sql){ //En mi tp de objetos use el mismo metodo para el Insert y para Update por que las dos usan executeUpdate entonces es lo mismo
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/farmaciaExpres","root","1234"); //Aca van los datos de la base, el usuario y la contraseña
			
			Statement stm = con.createStatement();
			
			stm.executeUpdate(sql);
			
		}
		catch (SQLException se){
			System.out.println("Error de base de datos." + se.getMessage());
		}
		catch (Exception e){
			System.out.println("Error de Driver JDBC." + e.getMessage());	
		}
	}
	
	public ResultSet ejecutarSelect(String sql){
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/farmaciaExpres","root","1234"); //Acá tambien :P
			
			Statement stm = con.createStatement();
			
			rs = stm.executeQuery(sql);
		}
		catch (SQLException se){
			System.out.println("Error de base de datos." + se.getMessage());
		}
		catch (Exception e){
			System.out.println("Error de Driver JDBC." + e.getMessage());	
		}
		
		return rs;
	}
}
