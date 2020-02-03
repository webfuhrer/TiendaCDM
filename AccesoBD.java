package paquetetienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccesoBD {
	private static Connection conexion=null;
	private static Statement stmt=null;
	public static void inicializarBD()
	{
	    try {
	        conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda",
	                "root", "");
	        stmt= conexion.createStatement();
	    } catch (SQLException ex) {
	        Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
	public static ArrayList<Producto> recuperarProductos() {
		inicializarBD();
		ArrayList<Producto> lista_productos=new ArrayList();
		String query="SELECT * FROM t_productos";
		try {
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				int id=rs.getInt("id");
				String nombre=rs.getString("nombre");
				float precio=rs.getFloat("precio");
				Producto p=new Producto(id, nombre, precio);
				lista_productos.add(p);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_productos;
	}

}
