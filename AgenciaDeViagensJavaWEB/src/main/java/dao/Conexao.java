package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "senhadificil123";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenciajavaweb";
	public static Connection createConnectionToMYSQL() throws Exception{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Encontrado!");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		try {

			Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			System.out.println("Conectado!");
			return connection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			return null;
		}

	}
}
