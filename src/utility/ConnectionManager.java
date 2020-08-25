package utility;

import java.sql.*;

import config.Configuration;

public class ConnectionManager {

	static Connection con;
	static String url;

	public static Connection getConnection() {

		try {
			// assuming "DataSource" is your DataSource name

			Class.forName(Configuration.driver);

			try {
				con = DriverManager.getConnection(Configuration.database_url, Configuration.username, Configuration.password);

			}

			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		catch (ClassNotFoundException e) {
			System.out.println(e);
		}

		return con;
	}
}