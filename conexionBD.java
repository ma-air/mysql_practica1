package practica1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class conexionBD {
	String db_ = "";
	String login_ = "root";
	String password_ = "root";
	String url_ = "";

	// ESTABLECEMOS LA CONEXION CON LA BASE DE DATOS
	Connection connection_;

	public void conectar(String nombreBD, String login, String password) {
		try {

			db_ = nombreBD;
			login_ = login;
			password_ = password;
			url_ = "jdbc:mysql://localhost/" + db_;
			// ESTABLECEMOS LA CONEXION CON LA BASE DE DATOS
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection_ = DriverManager.getConnection(url_, login_, password_);

			if (connection_ != null) {
				System.out.println("Conexion establecida con la base de datos: " + db_);
			} else {
				System.err.println("SE HA PRODUCIDO UN ERROR");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void login() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduce nombre de la base de datos: ");
		String bd = entrada.next();
		System.out.print("Introduce login de mysql: ");
		String login = entrada.next();
		System.out.print("Introduce password de mysql: ");
		String password = entrada.next();
		conectar(bd, login, password);
	}

	public void consulta1() {
		try {
			Statement st_ = connection_.createStatement();
			String sql = "Select * from empleado";
			ResultSet resultado = st_.executeQuery(sql);
			String tabla = "";
			while (resultado.next()) {
				String nif = resultado.getString("nif");
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				String salario = resultado.getString("salario");
				tabla = nif + "   " + nombre + "  " + apellidos + "  " + salario;
				System.out.println(tabla);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void consulta2() {
		try {
			Statement st_ = connection_.createStatement();
			Scanner entrada = new Scanner(System.in);
			System.out.print("Busca el empleado por DNI: ");
			String dni = entrada.next();
			String sql = "Select * from empleado where nif like '" + dni +"'" ;
			ResultSet resultado = st_.executeQuery(sql);
			String tabla = "";
			while (resultado.next()) {
				String nif = resultado.getString("nif");
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				String salario = resultado.getString("salario");
				tabla = nif + "   " + nombre + "  " + apellidos + "  " + salario;
				System.out.println(tabla);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void consulta3() {
		try {
			Statement st_ = connection_.createStatement();
			Scanner entrada = new Scanner(System.in);
			System.out.print("Busca el empleado por Salario mayor de : ");
			Float salario = entrada.nextFloat();
			String sql = "Select * from empleado where salario>" + salario;
			ResultSet resultado = st_.executeQuery(sql);
			String tabla = "";
			while (resultado.next()) {
				String nif = resultado.getString("nif");
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				String salario1 = resultado.getString("salario");
				tabla = nif + "   " + nombre + "  " + apellidos + "  " + salario1;
				System.out.println(tabla);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void consulta4() {
		try {
			Statement st_ = connection_.createStatement();
			Scanner entrada = new Scanner(System.in);
			System.out.print("Busca el empleado por Salario menor o igual de : ");
			Float salario = entrada.nextFloat();
			String sql = "Select * from empleado where salario<=" + salario;
			ResultSet resultado = st_.executeQuery(sql);
			String tabla = "";
			while (resultado.next()) {
				String nif = resultado.getString("nif");
				String nombre = resultado.getString("nombre");
				String apellidos = resultado.getString("apellidos");
				String salario1 = resultado.getString("salario");
				tabla = nif + "   " + nombre + "  " + apellidos + "  " + salario1;
				System.out.println(tabla);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void cerrarConexion() {
		try {
			connection_.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
