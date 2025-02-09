package br.com.coti.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public static Connection getConnection() {

		Connection connection = null;

		try {

			connection = DriverManager.getConnection("jdbc:postgres://localhost:5437/agendadb", "admin", "admin");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

}
