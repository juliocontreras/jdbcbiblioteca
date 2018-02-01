package curso.mysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;

public class Consultar {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/biblioteca", "root", ""); 
		
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from libros");
		while(rs.next()) {
			
		System.out.println("Titulo " + rs.getString(2));
		System.out.println("Autor " + rs.getString(3));
		System.out.println("Precio " + rs.getFloat(4));
		System.out.println("Fecha " + rs.getDate(5));
	}
		
		int insertar = st.executeUpdate("insert into libros(titulo, autor, precio, fecha) values ('Libro Nuevo 2', 'Pedro', 25, '2010-02-07')");
		System.out.println("Fila insertada " + insertar);
		
		CallableStatement cstmt = (CallableStatement) conn.prepareCall("{call listalibrosautor(?)}");
		
		cstmt.setString(1, "Pedro");
		
		ResultSet rs3 = cstmt.executeQuery();
		
		while(rs3.next()) {
			
			System.out.println("Autor: " + rs3.getString(3));
			
		}
		
		
	}
	
	
}
